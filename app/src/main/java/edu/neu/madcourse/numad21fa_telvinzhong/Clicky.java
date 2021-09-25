package edu.neu.madcourse.numad21fa_telvinzhong;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MotionEvent;
import android.view.View;

import androidx.navigation.NavController;

import android.widget.Button;
import android.widget.TextView;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import edu.neu.madcourse.numad21fa_telvinzhong.databinding.ActivityClickyBinding;

public class Clicky extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityClickyBinding binding;

    TextView lastClick = (TextView)findViewById(R.id.lastClick);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityClickyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
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

                }
                return true;
            }
        });

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_clicky);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



//    @Override
//    public boolean onSupportNavigateUp() {
////        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_clicky);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}