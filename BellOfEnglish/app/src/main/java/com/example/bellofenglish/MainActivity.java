package com.example.bellofenglish;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    TextView textView;
    Button settingBtn;
    TextToSpeech mTTS;
    String text =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///Hide Action bar
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        layout = findViewById(R.id.wallpaperID);
        textView = findViewById(R.id.SentenceID);
        settingBtn = findViewById(R.id.setinngID);

        ///Generate Random Value for change random text
        Random random = new Random();
        final int value = random.nextInt(8);


        ///Generate Random Value for change  wallpaper

        Random random1 = new Random();
        final int value1 = random1.nextInt(22);



        final String[] sentences = getResources().getStringArray(R.array.general_talk);
        final String[] AboutYouSelfSentences = getResources().getStringArray(R.array.aboutyourself);
        final String[] GeneralQuestionSentences = getResources().getStringArray(R.array.general_talk);
        final String[] introductionConversion = getResources().getStringArray(R.array.introductionConversion);
        final String[] gettingHelp = getResources().getStringArray(R.array.gettingHelp);
        final String[] advice = getResources().getStringArray(R.array.advice);
        final String[] airport = getResources().getStringArray(R.array.airport);
        final String[] restaurant = getResources().getStringArray(R.array.restaurant);
        final String[] chatText = getResources().getStringArray(R.array.chatText);
       /* final String[] wishAndPray = getResources().getStringArray(R.array.wishAndPray);
        final String[] traveling = getResources().getStringArray(R.array.wishAndPray);
        final String[] timeAndDate = getResources().getStringArray(R.array.timeAndDate);
        final String[] love = getResources().getStringArray(R.array.love);
        final String[] Presentation = getResources().getStringArray(R.array.presentation);
        final String[] phonecall = getResources().getStringArray(R.array.phoneConversion);
        final String[] shoppingConversion = getResources().getStringArray(R.array.shoppingConversion);
        final String[] CommonExprssion = getResources().getStringArray(R.array.commonExpression);
        final String[] Direction = getResources().getStringArray(R.array.askingDirection);
        final String[] TalkToStarnger = getResources().getStringArray(R.array.talktostranger);
*/


        int[] flag = {R.drawable.wallpaper0, R.drawable.wallpaper1, R.drawable.wallpaper1,
                R.drawable.wallpaper3, R.drawable.wallpaper4, R.drawable.wallpaper5,
                R.drawable.wallpaper2, R.drawable.wallpaper7, R.drawable.wallpaper8,
                R.drawable.wallpaper9,
                R.drawable.wallpaper10, R.drawable.wallpaper11, R.drawable.wallpaper12,
                R.drawable.wallpaper13, R.drawable.wallpaper14, R.drawable.wallpaper15,
                R.drawable.wallpaper16, R.drawable.wallpaper17, R.drawable.wallpaper18,
                R.drawable.wallpaper19, R.drawable.wallpaper20, R.drawable.wallpaper21,
                R.drawable.wallpaper22};


        ///Set random wallpaper everytime activity open
        layout = findViewById(R.id.wallpaperID);
        layout.setBackgroundResource(flag[value1]);
        makeFullScreen();


        if (value == 0) {
           text = sentences[value1].trim();
            textView.setText(text);

        } else if (value == 1) {
            text = AboutYouSelfSentences[value1].trim();
            textView.setText(text);
        } else if (value == 2) {
            text = GeneralQuestionSentences[value1].trim();
            textView.setText(text);
        } else if (value == 3) {
            text = introductionConversion[value1].trim();
            textView.setText(text);
        } else if (value == 4) {
             text = gettingHelp[value1].trim();
            textView.setText(text);
        } else if (value == 5) {
            text = advice[value1].trim();
            textView.setText(text);
        } else if (value == 6) {
             text = airport[value1].trim();
            textView.setText(text);
        } else if (value == 7) {
            text = restaurant[value1].trim();
            textView.setText(text);
        } else if (value == 8) {
           text = chatText[value1].trim();
            textView.setText(text);
        }



        ///Offline text to Speech
        mTTS =  new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if (status == TextToSpeech.SUCCESS) {

                    int result = mTTS.setLanguage(Locale.US);

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



        ///Main for ScreenLock
        ///For Show screenlook Activity

    //>>>> ///Inter_connected>>>LockScreenReceiver,LockScreenService

        startService(new Intent(this, LockScreenService.class));


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Setting.class);
                startActivity(intent);
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
        this.finish();
        android.os.Process.killProcess(android.os.Process.myPid());

    }

}
