package com.example.bellofenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;

import java.util.Calendar;

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

        SharedPreferences prefs = getSharedPreferences("prefs2", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart2", true);

        if (firstStart) {
            showStartDialog();
        }

    }

    private void showStartDialog() {

        startService(new Intent(this, LockScreenService.class));
        startAlarm(true,true);

        SharedPreferences prefs = getSharedPreferences("prefs2", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart2", false);
        editor.apply();
    }
    public void doWOrk()
    {


        for (progress=1;progress<2;progress=progress+1) {
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


    private void startAlarm(boolean isNotification, boolean isRepeat) {
        AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent myIntent;
        PendingIntent pendingIntent;

        // SET TIME HERE
        Calendar calendar= Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,22);
        calendar.set(Calendar.MINUTE,00);


        myIntent = new Intent(WelcomeScreen.this,AlarmNotificationReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,0);

        if(!isRepeat)
            manager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000,pendingIntent);
        else
            manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
    }

}