package com.example.vwsc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView jaljivanlogo, sarkarlogo;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jaljivanlogo = findViewById(R.id.logoID);
        sarkarlogo = findViewById(R.id.sarkarlogo);
        textView = findViewById(R.id.text);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        jaljivanlogo.startAnimation(anim);
        sarkarlogo.startAnimation(anim);
        Thread timer = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                    startActivity(intent);
                    finish();
                    super.run();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();

    }
}