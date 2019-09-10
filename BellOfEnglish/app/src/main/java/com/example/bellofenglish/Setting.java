package com.example.bellofenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class Setting extends AppCompatActivity implements View.OnClickListener {


    Button savebtn,show;
    public static String MY_PREFS_NAME= "nameOfSharedPreferences";
    Switch simpleSwitch,ReminderSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportActionBar().setTitle("Setting");

        simpleSwitch = (Switch) findViewById(R.id.simpleSwitch); // initiate Switch
        ReminderSwitch = (Switch) findViewById(R.id.remindersSwitch); // initiate Switch


        ///Store switch State for >>> Sentence notification
        SharedPreferences sharedPrefs = getSharedPreferences("com.example.xyz", MODE_PRIVATE);
        simpleSwitch.setChecked(sharedPrefs.getBoolean("NameOfThingToSave", true));

        ///Store switch State for >> Remainder notification
        SharedPreferences sharedPrefs1 = getSharedPreferences("com.example.xyz1", MODE_PRIVATE);
        ReminderSwitch.setChecked(sharedPrefs1.getBoolean("NameOfThingToSave1", true));


        simpleSwitch.setTextOn("On");
        simpleSwitch.setTextOff("Off");

        ReminderSwitch.setTextOn("On");
        ReminderSwitch.setTextOff("Off");


        savebtn = findViewById(R.id.savebutton);
        savebtn.setOnClickListener(this);



        }

        ///This function will Reminder Notification
    ///Inter_connetion this function >>>AlarmNotificiton>>>MyService>BootReceiver

        private void startAlarm(boolean isNotification, boolean isRepeat) {
            AlarmManager manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent myIntent;
            PendingIntent pendingIntent;

            // SET TIME HERE
            Calendar calendar= Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,22);
            calendar.set(Calendar.MINUTE,00);


            myIntent = new Intent(Setting.this,AlarmNotificationReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this,0,myIntent,0);

            if(!isRepeat)
                manager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+3000,pendingIntent);
            else
                manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,pendingIntent);
        }


    @Override
    public void onClick(View view) {
        if (view.getId() ==R.id.savebutton)
        {

            if (simpleSwitch.isChecked())
            {
                ///it enable Show lock screen Sentence if Switch is On
                PackageManager pm = getPackageManager();
                pm.setComponentEnabledSetting(new ComponentName(this, com.example.bellofenglish.MainActivity.class),
                        PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
               // Toast.makeText(Setting.this,"ON",Toast.LENGTH_LONG).show();

                SharedPreferences.Editor editor = getSharedPreferences("com.example.xyz", MODE_PRIVATE).edit();
                editor.putBoolean("NameOfThingToSave", true);
                editor.commit();
            }
            else
            {
                ///It disable lock screen Activity if switch is on
                simpleSwitch.setChecked(false);
                PackageManager pm = getPackageManager();
                pm.setComponentEnabledSetting(new ComponentName(this, com.example.bellofenglish.MainActivity.class),
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
               // Toast.makeText(Setting.this,"OFF",Toast.LENGTH_LONG).show();

                SharedPreferences.Editor editor = getSharedPreferences("com.example.xyz", MODE_PRIVATE).edit();
                editor.putBoolean("NameOfThingToSave", false);
                editor.commit();
            }

           if (ReminderSwitch.isChecked())
            {
                startAlarm(true,true);
                SharedPreferences.Editor editor = getSharedPreferences("com.example.xyz1", MODE_PRIVATE).edit();
                editor.putBoolean("NameOfThingToSave1", true);
                editor.commit();
            }
            else
            {
                startAlarm(false,false);
                SharedPreferences.Editor editor = getSharedPreferences("com.example.xyz1", MODE_PRIVATE).edit();
                editor.putBoolean("NameOfThingToSave1", false);
                editor.commit();
            }

            Toast.makeText(Setting.this,"Saved",Toast.LENGTH_SHORT).show();

        }
    }


}
