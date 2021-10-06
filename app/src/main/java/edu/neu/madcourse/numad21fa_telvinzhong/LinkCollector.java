package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity implements Dialogue.DialogueListener {
    RecyclerView linkCollector;
    ArrayList <String> names;
    ArrayList <String> urls;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        linkCollector = findViewById(R.id.linkCollector);
        names = new ArrayList<String>();
        urls = new ArrayList<String>();

        MyAdapter myAdapter = new MyAdapter(this, names, urls);
        linkCollector.setAdapter(myAdapter);
        linkCollector.setLayoutManager(new LinearLayoutManager(this));

        addButton = (FloatingActionButton)  findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
//                int pos = 0;
//                String newName = "test1";
//                String newUrl = "www.google.com";
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, new InputFragment()).commit();
//
//
//                names.add(pos, newName);
//                urls.add(pos, newUrl);
//                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.linkCollector),
//                        "New item added.", Snackbar.LENGTH_SHORT);
//                mySnackbar.show();
//                myAdapter.notifyItemInserted(pos);
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

    public void openDialog() {
        Dialogue dialogue = new Dialogue();
        dialogue.show(getSupportFragmentManager(), "test string");
    }

    @Override
    public void applyTexts(String name, String url) {
        names.add(name);
        urls.add(url);
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.linkCollector),
                "New item added.", Snackbar.LENGTH_SHORT);
        mySnackbar.show();
        MyAdapter myAdapter = new MyAdapter(this, names, urls);
        myAdapter.notifyItemInserted(name.length());
    }
}