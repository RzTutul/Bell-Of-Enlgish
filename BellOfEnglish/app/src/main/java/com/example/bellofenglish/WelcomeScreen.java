package com.example.bellofenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class WelcomeScreen extends AppCompatActivity {
    private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_welcome_screen);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                doWOrk();
                StartApp();
            }

        });
        thread.start();
    }

    public void doWOrk()
    {


        for (progress=1;progress<=2;progress=progress+1) {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void StartApp()
    {
        Intent intent = new Intent(WelcomeScreen.this,MainDashboard.class);
        startActivity(intent);
        finish();
    }
}