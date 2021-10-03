package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity {
    RecyclerView linkCollector;
    ArrayList names;
    ArrayList urls;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        linkCollector = findViewById(R.id.linkCollector);
        ArrayList names = new ArrayList();
        ArrayList urls = new ArrayList();

        MyAdapter myAdapter = new MyAdapter(this, names, urls);
        linkCollector.setAdapter(myAdapter);
        linkCollector.setLayoutManager(new LinearLayoutManager(this));

        addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = 0;
                String newName = "test1";
                String newUrl = "www.google.com";

                getSupportFragmentManager().beginTransaction().replace(R.id.container, new InputFragment()).commit();


                names.add(pos, newName);
                urls.add(pos, newUrl);
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.linkCollector),
                        "New item added.", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
                myAdapter.notifyItemInserted(pos);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.linkCollector),
                        "Item deleted.", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
                int position = viewHolder.getLayoutPosition();
                names.remove(position);
                urls.remove(position);

                myAdapter.notifyItemRemoved(position);

            }
        });
        itemTouchHelper.attachToRecyclerView(linkCollector);
    }


}