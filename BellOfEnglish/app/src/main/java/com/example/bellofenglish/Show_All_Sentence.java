package com.example.bellofenglish;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Locale;

public class Show_All_Sentence extends AppCompatActivity {
    ListView listView;
    TextToSpeech mTTS;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__all__sentence);

        ///Add Back Button at Action bar..
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ///for Offline text to speech

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {

                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                    else {
                        listView.setEnabled(true);
                    }
                }
                else {
                    Log.e("TTS", "Initialization failed");
                }
            }


        });

        ///Show only one time Diloag >>>For Sentence SOUND
        SharedPreferences prefs = getSharedPreferences("prefs1", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart1", true);

        if (firstStart) {
            showStartDialog();
        }

        ///Receive Pass Value from MainDashBoard Activity

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            text = bundle.getString("key");
        }

        ///Change font style Of Action Bar

        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/thinfont.otf");
        SpannableStringBuilder SS = new SpannableStringBuilder(text);
        SS.setSpan (new CustomTypefaceSpan("", font2), 0, SS.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        getSupportActionBar().setTitle(SS);

        ///Change Color of Actionbar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red)));


        listView = findViewById(R.id.listItemID);

        final String[] AboutYouSelfSentences = getResources().getStringArray(R.array.aboutyourself);
        final String[] GeneralQuestionSentences = getResources().getStringArray(R.array.general_talk);
        final String[] introductionConversion = getResources().getStringArray(R.array.introductionConversion);
        final String[] gettingHelp = getResources().getStringArray(R.array.gettingHelp);
        final String[] advice = getResources().getStringArray(R.array.advice);
        final String[] airport = getResources().getStringArray(R.array.airport);
        final String[] restaurant = getResources().getStringArray(R.array.restaurant);
        final String[] chatText = getResources().getStringArray(R.array.chatText);
        final String[] wishAndPray = getResources().getStringArray(R.array.wishAndPray);
        final String[] traveling = getResources().getStringArray(R.array.wishAndPray);
        final String[] timeAndDate = getResources().getStringArray(R.array.timeAndDate);
        final String[] love = getResources().getStringArray(R.array.love);
        final String[] Presentation = getResources().getStringArray(R.array.presentation);
        final String[] phonecall = getResources().getStringArray(R.array.phoneConversion);
        final String[] shoppingConversion = getResources().getStringArray(R.array.shoppingConversion);
        final String[] CommonExprssion = getResources().getStringArray(R.array.commonExpression);
        final String[] Direction = getResources().getStringArray(R.array.askingDirection);
        final String[] TalkToStarnger = getResources().getStringArray(R.array.talktostranger);





            if (text.equals("About YourSelf")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, AboutYouSelfSentences);
                listView.setAdapter(adapter);
            } else if (text.equals("General Question")) {
                
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, GeneralQuestionSentences);
                listView.setAdapter(adapter);
            } else if (text.equals("Introduction Conversion")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, introductionConversion);
                listView.setAdapter(adapter);
            } else if (text.equals("Getting Help")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, gettingHelp);
                listView.setAdapter(adapter);
            } else if (text.equals("Advice")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, advice);
                listView.setAdapter(adapter);
            } else if (text.equals("Airport")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, airport);
                listView.setAdapter(adapter);
            } else if (text.equals("Restaurant")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, restaurant);
                listView.setAdapter(adapter);
            } else if (text.equals("Chat Text")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, chatText);
                listView.setAdapter(adapter);
            } else if (text.equals("Wish&Pray")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, wishAndPray);
                listView.setAdapter(adapter);
            } else if (text.equals("Traveling")) {
               
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, traveling);
                listView.setAdapter(adapter);
            } else if (text.equals("Time&Date")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, timeAndDate);
                listView.setAdapter(adapter);
            } else if (text.equals("Love")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, love);
                listView.setAdapter(adapter);
            } else if (text.equals("Presentation")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, Presentation);
                listView.setAdapter(adapter);
            } else if (text.equals("Phone Call")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, phonecall);
                listView.setAdapter(adapter);
            } else if (text.equals("Shopping Conversation")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, shoppingConversion);
                listView.setAdapter(adapter);
            } else if (text.equals("Common Expression")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, CommonExprssion);
                listView.setAdapter(adapter);
            } else if (text.equals("Direction")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, Direction);
                listView.setAdapter(adapter);
            } else if (text.equals("Talk To Stranger")) {

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show_All_Sentence.this, R.layout.simple_layout_view, R.id.simpleTextViewID, TalkToStarnger);
                listView.setAdapter(adapter);
            }






        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (text.equals("About YourSelf")) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        mTTS.speak(AboutYouSelfSentences[position], TextToSpeech.QUEUE_FLUSH, null,null);
                    }
                    else {
                        mTTS.speak(AboutYouSelfSentences[position], TextToSpeech.QUEUE_FLUSH, null);
                    }

                   // mTTS.speak(AboutYouSelfSentences[position], TextToSpeech.QUEUE_FLUSH, null);
                }
                else if (text.equals("General Question")) {
                    mTTS.speak(GeneralQuestionSentences[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Introduction Conversion")) {
                    mTTS.speak(introductionConversion[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Getting Help")) {
                    mTTS.speak(gettingHelp[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Advice")) {
                    mTTS.speak(advice[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Airport")) {
                    mTTS.speak(airport[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Restaurant")) {
                    mTTS.speak(restaurant[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Chat Text")) {
                    mTTS.speak(chatText[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Wish&Pray")) {
                    mTTS.speak(wishAndPray[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Traveling")) {
                    mTTS.speak(traveling[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Time&Date")) {
                    mTTS.speak(timeAndDate[position], TextToSpeech.QUEUE_FLUSH, null);
                } else if (text.equals("Love")) {
                    mTTS.speak(love[position], TextToSpeech.QUEUE_FLUSH, null);

                } else if (text.equals("Presentation")) {
                    mTTS.speak(Presentation[position], TextToSpeech.QUEUE_FLUSH, null);

                } else if (text.equals("Phone Call")) {
                    mTTS.speak(phonecall[position], TextToSpeech.QUEUE_FLUSH, null);

                } else if (text.equals("Shopping Conversation")) {
                    mTTS.speak(shoppingConversion[position], TextToSpeech.QUEUE_FLUSH, null);

                } else if (text.equals("Common Expression")) {
                    mTTS.speak(CommonExprssion[position], TextToSpeech.QUEUE_FLUSH, null);

                } else if (text.equals("Direction")) {
                    mTTS.speak(Direction[position], TextToSpeech.QUEUE_FLUSH, null);

                }else if (text.equals("Talk To Stranger")) {
                    mTTS.speak(TalkToStarnger[position], TextToSpeech.QUEUE_FLUSH, null);

                }


            }


        });
    }
    private void showStartDialog() {
        new AlertDialog.Builder(this).setIcon(R.drawable.soundicon1)
                .setTitle("For Sound")
                .setMessage("Tap On Sentence for English Sound")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

        SharedPreferences prefs = getSharedPreferences("prefs1", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart1", false);
        editor.apply();
    }

    ///For Back button at action bar

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

    ///if Press back button than speak will close instantly
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }
}
