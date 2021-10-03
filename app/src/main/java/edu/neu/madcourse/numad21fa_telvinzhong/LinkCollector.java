package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

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
                names.add(pos, "test1");
                urls.add(pos, "www.google.com");
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.linkCollector),
                        "New item added.", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
                myAdapter.notifyItemInserted(pos);
            }
        });


    }


}