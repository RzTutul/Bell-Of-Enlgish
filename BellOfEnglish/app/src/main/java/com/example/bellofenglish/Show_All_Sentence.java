package com.example.bellofenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

public class Show_All_Sentence extends AppCompatActivity {
    ListView listView;
    TextToSpeech mTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__all__sentence);


        listView = findViewById(R.id.listItemID);

        final String[] AboutYouSelfSentences = getResources().getStringArray(R.array.aboutyourself);
        final String[] GeneralQuestionSentences = getResources().getStringArray(R.array.general_talk);
        final String[] introductionConversion = getResources().getStringArray(R.array.introductionConversion);
        final String[] gettingHelp = getResources().getStringArray(R.array.gettingHelp);
        final String[] advice = getResources().getStringArray(R.array.advice);
        final String[] airport = getResources().getStringArray(R.array.airport);
        final String[] restaurant = getResources().getStringArray(R.array.restaurant);
        final String[] chatText = getResources().getStringArray(R.array.chatText);
        final  String[] wishAndPray = getResources().getStringArray(R.array.wishAndPray);
        final  String[] traveling = getResources().getStringArray(R.array.wishAndPray);
        final  String[] timeAndDate = getResources().getStringArray(R.array.timeAndDate);
        final  String[] love = getResources().getStringArray(R.array.love);




        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String text = bundle.getString("key");

            if (text.equals("AboutYourSelf")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, AboutYouSelfSentences);
                listView.setAdapter(adapter);
            } else if (text.equals("GeneralQuestion")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, GeneralQuestionSentences);
                listView.setAdapter(adapter);
            } else if (text.equals("introductionConversion")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, introductionConversion);
                listView.setAdapter(adapter);
            } else if (text.equals("gettingHelp")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, gettingHelp);
                listView.setAdapter(adapter);
            } else if (text.equals("advice")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, advice);
                listView.setAdapter(adapter);
            } else if (text.equals("airport")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, airport);
                listView.setAdapter(adapter);
            } else if (text.equals("restaurant")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, restaurant);
                listView.setAdapter(adapter);
            } else if (text.equals("chatText")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, chatText);
                listView.setAdapter(adapter);
            } else if (text.equals("wishAndPray")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, wishAndPray);
                listView.setAdapter(adapter);
            } else if (text.equals("traveling")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, traveling);
                listView.setAdapter(adapter);
            } else if (text.equals("timeAndDate")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, timeAndDate);
                listView.setAdapter(adapter);
            } else if (text.equals("love")) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, love);
                listView.setAdapter(adapter);
            }




            mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {


                    if (status == TextToSpeech.SUCCESS) {

                        int result = mTTS.setLanguage(Locale.ENGLISH);

                        if (result == TextToSpeech.LANG_MISSING_DATA
                                || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Log.e("TTS", "Language not supported");
                        } else {
                            listView.setEnabled(true);
                        }
                    } else {
                        Log.e("TTS", "Initialization failed");
                    }
                }


            });


        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mTTS.speak(AboutYouSelfSentences[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(GeneralQuestionSentences[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(introductionConversion[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(gettingHelp[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(advice[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(airport[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(restaurant[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(chatText[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(wishAndPray[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(traveling[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(timeAndDate[position], TextToSpeech.QUEUE_FLUSH, null);
                mTTS.speak(love[position], TextToSpeech.QUEUE_FLUSH, null);



            }


        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            Intent intent = new Intent(Show_All_Sentence.this,MainDashboard.class);
            startActivity(intent);
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
