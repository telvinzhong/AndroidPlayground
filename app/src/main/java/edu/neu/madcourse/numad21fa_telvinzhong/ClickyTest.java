package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyTest extends AppCompatActivity {
    TextView lastClick = (TextView)findViewById(R.id.lastClick);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky_test);

        lastClick.setText("-");

        Button A = (Button)findViewById(R.id.button2);
        A.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // whenever the button is pressed down
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lastClick.setText("A");
                    // Change back to -
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lastClick.setText("-");
                }
                return true;
            }
        });
    }
}