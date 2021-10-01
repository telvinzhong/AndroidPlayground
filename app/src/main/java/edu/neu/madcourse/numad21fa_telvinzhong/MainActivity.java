package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showUserInfo(View view) {
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }

    public void ClickGame(View view) {
        Intent intent = new Intent(this, ClickyTest.class);
        startActivity(intent);
    }

    public void LinkCollector(View view) {
        Intent intent = new Intent(this, LinkCollector.class);
        startActivity(intent);
    }
}