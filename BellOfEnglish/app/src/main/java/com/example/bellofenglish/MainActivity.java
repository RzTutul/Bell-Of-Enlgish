package com.example.bellofenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    TextView textView;
    TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        layout =findViewById(R.id.wallpaperID);
        textView = findViewById(R.id.SentenceID);

        Random random = new Random();
        final int value = random.nextInt(22);

        final String[] sentences = getResources().getStringArray(R.array.general_talk);


        int[] flag = {R.drawable.wallpaper0, R.drawable.wallpaper1, R.drawable.wallpaper1,
                R.drawable.wallpaper3,R.drawable.wallpaper4,R.drawable.wallpaper5,
                R.drawable.wallpaper2,R.drawable.wallpaper7,R.drawable.wallpaper8,
                R.drawable.wallpaper9,
                R.drawable.wallpaper10,R.drawable.wallpaper11,R.drawable.wallpaper12,
                R.drawable.wallpaper13,R.drawable.wallpaper14,R.drawable.wallpaper15,
                R.drawable.wallpaper16,R.drawable.wallpaper17,R.drawable.wallpaper18,
                R.drawable.wallpaper19,R.drawable.wallpaper20,R.drawable.wallpaper21,
                R.drawable.wallpaper22};








        String text = sentences[value].trim();
        textView.setText(text);


        mTTS =  new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if (status == TextToSpeech.SUCCESS) {

                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                    else {
                        textView.setEnabled(true);
                    }
                }

                else {
                    Log.e("TTS", "Initialization failed");
                }
            }


        });

        layout =findViewById(R.id.wallpaperID);
        layout.setBackgroundResource(flag[value]);
        makeFullScreen();
        startService(new Intent(this, LockScreenService.class));

        textView.setOnClickListener(new View.OnClickListener() {
            String text = sentences[value];
            @Override
            public void onClick(View v) {
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }



    //ScreenLockWallpaper

    public void makeFullScreen() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT < 19) { //View.SYSTEM_UI_FLAG_IMMERSIVE is only on API 19+
            this.getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        } else {
            this.getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE);
        }
    }

    @Override
    public void onBackPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
        return; //Do nothing!
    }

    public void unlockScreen(View view) {
        //Instead of using finish(), this totally destroys the process
        android.os.Process.killProcess(android.os.Process.myPid());

    }

}
