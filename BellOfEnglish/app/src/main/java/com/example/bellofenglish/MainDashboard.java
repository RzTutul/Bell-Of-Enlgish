package com.example.bellofenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;


import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MenuItem;
import android.view.View;



import com.google.android.material.navigation.NavigationView;

public class MainDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    private CardView aboutYourSelf, GeneralQuestion,ConversionCard,GettingHelpCard,AdviceCard,AirplaneCard,
            RestuarantCard,ChatCard,WishCard,TravelCard,TimeDateCard,LoveCard,
            presentationCard,phonecallCard,ShoppingCard,CommonExpressionCard,DirectionCard,TalkStarngerCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);


        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/thinfont.otf");
        SpannableStringBuilder SS = new SpannableStringBuilder("DashBoard");
        SS.setSpan (new CustomTypefaceSpan("", font2), 0, SS.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        getSupportActionBar().setTitle(SS);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red)));


        mdrawerLayout = findViewById(R.id.navigation);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mtoggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);
        mdrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        aboutYourSelf = findViewById(R.id.aboutYourselfID);
        GeneralQuestion = findViewById(R.id.GeneralQuestionID);
        ConversionCard = findViewById(R.id.ConversionID);
        GettingHelpCard = findViewById(R.id.GettingHelpID);
        AdviceCard = findViewById(R.id.AdviceID);
        AirplaneCard = findViewById(R.id.AirportConversationID);
        RestuarantCard = findViewById(R.id.ResturantID);
        ChatCard = findViewById(R.id.ChatingID);
        WishCard = findViewById(R.id.WishPrayID);
        TravelCard = findViewById(R.id.TravellingID);
        TimeDateCard = findViewById(R.id.TimeDateID);
        LoveCard = findViewById(R.id.LoveAfficationID);
        presentationCard = findViewById(R.id.PresentationID);
        phonecallCard = findViewById(R.id.phonecallID);
        ShoppingCard = findViewById(R.id.ShoppingID);
        CommonExpressionCard = findViewById(R.id.commonExprssionID);
        DirectionCard = findViewById(R.id.DirectionID);
        TalkStarngerCard = findViewById(R.id.TalkStrangerID);


        aboutYourSelf.setOnClickListener(this);
        GeneralQuestion.setOnClickListener(this);
        ConversionCard.setOnClickListener(this);
        GettingHelpCard.setOnClickListener(this);
        AdviceCard.setOnClickListener(this);
        AirplaneCard.setOnClickListener(this);
        RestuarantCard.setOnClickListener(this);
        ChatCard.setOnClickListener(this);
        WishCard.setOnClickListener(this);
        TravelCard.setOnClickListener(this);
        TimeDateCard.setOnClickListener(this);
        LoveCard.setOnClickListener(this);
        presentationCard.setOnClickListener(this);
        phonecallCard.setOnClickListener(this);
        ShoppingCard.setOnClickListener(this);
        CommonExpressionCard.setOnClickListener(this);
        DirectionCard.setOnClickListener(this);
        TalkStarngerCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.aboutYourselfID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "About YourSelf");
                startActivity(intent);
                break;
            }
            case R.id.GeneralQuestionID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "General Question");
                startActivity(intent);
                break;
            }
            case R.id.ConversionID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Introduction Conversion");
                startActivity(intent);
                break;
            }

            case R.id.GettingHelpID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Getting Help");
                startActivity(intent);
                break;
            }

            case R.id.AdviceID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Advice");
                startActivity(intent);
                break;
            }
            case R.id.AirportConversationID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Airport");
                startActivity(intent);
                break;
            }

            case R.id.ResturantID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Restaurant");
                startActivity(intent);
                break;
            }
            case R.id.ChatingID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Chat Text");
                startActivity(intent);
                break;
            }
            case R.id.WishPrayID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Wish&Pray");
                startActivity(intent);
                break;
            }
            case R.id.TravellingID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Traveling");
                startActivity(intent);
                break;
            }
            case R.id.TimeDateID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Time&Date");
                startActivity(intent);
                break;
            }
            case R.id.LoveAfficationID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Love");
                startActivity(intent);
                break;
            }
            case R.id.PresentationID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Presentation");
                startActivity(intent);
                break;
            }
            case R.id.phonecallID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Phone Call");
                startActivity(intent);
                break;
            }
            case R.id.ShoppingID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Shopping Conversation");
                startActivity(intent);
                break;
            }
  case R.id.commonExprssionID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Common Expression");
                startActivity(intent);
                break;
            }
  case R.id.DirectionID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Direction");
                startActivity(intent);
                break;
            }
  case R.id.TalkStrangerID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "Talk To Stranger");
                startActivity(intent);
                break;
            }


        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mtoggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.Home) {
            Intent intent = new Intent(MainDashboard.this, MainDashboard.class);

            startActivity(intent);
        } else if (menuItem.getItemId() == R.id.screenID) {
            PackageManager pm = getPackageManager();
            pm.setComponentEnabledSetting(new ComponentName(this, com.example.bellofenglish.MainActivity.class),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

            Intent intent = new Intent(MainDashboard.this, MainActivity.class);

            startActivity(intent);
        } else if (menuItem.getItemId() == R.id.setting) {

            //Enable This Activity if it was disable

            Intent intent = new Intent(MainDashboard.this, Setting.class);
            startActivity(intent);
        }



        else if (menuItem.getItemId() == R.id.ShareID) {
            Intent intent = new Intent((Intent.ACTION_SEND));
            intent.setType("text/plain");
            String subject = "Andriod Tutorial";
            String Body = "This is best apps ever for Andriod Tutorials. Download from this link http://rztutultechtunes.blogspot.com";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, Body);

            startActivity(Intent.createChooser(intent, "Share with"));
        }

        return false;
    }

}
