package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyTest extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky_test);

        // lastClick needs to be in onCreate
        TextView lastClick = (TextView)findViewById(R.id.lastClick);
        lastClick.setText("Pressed: -");

        Button A = (Button)findViewById(R.id.button2);
        A.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // whenever the button is pressed down
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lastClick.setText("Pressed: A");
                    // Change back to -
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lastClick.setText("Pressed: -");
                }
                return true;
            }
        });

        Button C = (Button)findViewById(R.id.button5);
        C.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // whenever the button is pressed down
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lastClick.setText("Pressed: C");
                    // Change back to -
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lastClick.setText("Pressed: -");
                }
                return true;
            }
        });

        Button B = (Button)findViewById(R.id.button4);
        B.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // whenever the button is pressed down
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lastClick.setText("Pressed: B");
                    // Change back to -
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lastClick.setText("Pressed: -");
                }
                return true;
            }
        });

        Button D = (Button)findViewById(R.id.button6);
        D.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // whenever the button is pressed down
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lastClick.setText("Pressed: D");
                    // Change back to -
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lastClick.setText("Pressed: -");
                }
                return true;
            }
        });

        Button E = (Button)findViewById(R.id.button7);
        E.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // whenever the button is pressed down
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lastClick.setText("Pressed: E");
                    // Change back to -
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lastClick.setText("Pressed: -");
                }
                return true;
            }
        });

        Button F = (Button)findViewById(R.id.button8);
        F.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // whenever the button is pressed down
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lastClick.setText("Pressed: F");
                    // Change back to -
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lastClick.setText("Pressed: -");
                }
                return true;
            }
        });
    }
}