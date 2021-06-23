package com.example.stopwatch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int second = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTimer();
    }

    public void startBtn(View view) {
        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        running = true;
    }

    public void stopBtn(View view) {
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        running = false;
    }

    public void resetBtn(View view) {
        Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show();
        running = false;
        second = 0;
    }

    public void runTimer(){
        final TextView textView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = second/3600;
                int minutes = (second%3600)/60;
                int seconds = second%60;

                @SuppressLint("DefaultLocale")
                String time = String.format("%d:%02d:%02d",hours,minutes,seconds);
                textView.setText(time);

                if (running){
                    second++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}