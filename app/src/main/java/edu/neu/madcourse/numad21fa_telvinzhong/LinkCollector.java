package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LinkCollector extends AppCompatActivity {
    RecyclerView linkCollector;
    String names[], urls[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        linkCollector = findViewById(R.id.linkCollector);
        names = getResources().getStringArray(R.array.names);
        urls = getResources().getStringArray(R.array.urls);

        MyAdapter myAdapter = new MyAdapter(this, names, urls);
        linkCollector.setAdapter(myAdapter);
        linkCollector.setLayoutManager(new LinearLayoutManager(this));

    }


}