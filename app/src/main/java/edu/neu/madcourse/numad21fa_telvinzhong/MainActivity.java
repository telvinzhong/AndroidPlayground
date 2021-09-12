package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Telvin Zhong telvinzhong@gmail.com", Toast.LENGTH_LONG);
        toast.show();
    }
}