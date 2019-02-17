package com.example.akshay.teproject;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.akshay.teproject.R.string.app_name;

public class MainActivity extends AppCompatActivity {

    TextView clgName;
    Toolbar tbar;
    NavigationView navi;
    DrawerLayout dl;
    ActionBarDrawerToggle  abdt;
    Intent i;

    ImageButton facebook,googlePlus,twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        facebook = findViewById(R.id.facebook_id);
        googlePlus = findViewById(R.id.google_id);
        twitter = findViewById(R.id.twitter_id);
        clgName = findViewById(R.id.clgName_id);
        clgName.setSelected(true);
        tbar = findViewById(R.id.toolbar_id);
        navi = findViewById(R.id.navigation_id);
        dl = findViewById(R.id.drawer);
        setSupportActionBar(tbar);
        abdt = new ActionBarDrawerToggle(this,dl,tbar,app_name,app_name);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.department:
                        i = new Intent(MainActivity.this,Departments.class);
                        startActivity(i);
                        break;
                    case R.id.registration:
                        i = new Intent(MainActivity.this,Registration.class);
                        startActivity(i);
                        break;
                    case R.id.mission:
                        i = new Intent(MainActivity.this,SVITMission.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        i = new Intent(MainActivity.this,AboutUs.class);
                        startActivity(i);
                        break;
                    case R.id.reach_us:
                        i = new Intent(MainActivity.this,ReachUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(MainActivity.this,LoginPage.class);
                        startActivity(i);
                        break;

                }

                return false;
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fb_url = "https://www.facebook.com/SVITSinnar/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(fb_url));
                startActivity(i);
            }
        });

        googlePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String googlePlus_url = "https://plus.google.com/u/0/110571980129784584868";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(googlePlus_url));
                startActivity(i);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String twitter_url ="https://twitter.com/SVIT_sinnar";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(twitter_url));
                startActivity(i);
            }
        });




    }
}
