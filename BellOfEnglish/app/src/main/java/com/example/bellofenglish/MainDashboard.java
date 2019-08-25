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
    private CardView aboutYourSelf, GeneralQuestion;
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



        aboutYourSelf.setOnClickListener(this);
        GeneralQuestion.setOnClickListener(this);

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
