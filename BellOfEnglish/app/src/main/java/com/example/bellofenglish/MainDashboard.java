package com.example.bellofenglish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    private CardView aboutYourSelf, GeneralQuestion,ConversionCard,GettingHelpCard,AdviceCard,AirplaneCard,
            RestuarantCard,ChatCard,WishCard,TravelCard,TimeDateCard,LoveCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);


        setTitle("Main DashBoard");
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



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.aboutYourselfID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "AboutYourSelf");
                startActivity(intent);
                break;
            }
            case R.id.GeneralQuestionID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "GeneralQuestion");
                startActivity(intent);
                break;
            }
            case R.id.ConversionID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "introductionConversion");
                startActivity(intent);
                break;
            }

            case R.id.GettingHelpID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "gettingHelp");
                startActivity(intent);
                break;
            }

            case R.id.AdviceID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "advice");
                startActivity(intent);
                break;
            }
            case R.id.AirportConversationID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "airport");
                startActivity(intent);
                break;
            }

            case R.id.ResturantID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "restaurant");
                startActivity(intent);
                break;
            }
            case R.id.ChatingID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "chatText");
                startActivity(intent);
                break;
            }
            case R.id.WishPrayID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "wishAndPray");
                startActivity(intent);
                break;
            }
            case R.id.TravellingID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "traveling");
                startActivity(intent);
                break;
            }
            case R.id.TimeDateID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "timeAndDate");
                startActivity(intent);
                break;
            }
   case R.id.LoveAfficationID: {
                Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);
                intent.putExtra("key", "love");
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
            Intent intent = new Intent(MainDashboard.this, MainActivity.class);

            startActivity(intent);
        } else if (menuItem.getItemId() == R.id.setting) {
            Intent intent = new Intent(MainDashboard.this, Show_All_Sentence.class);

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
