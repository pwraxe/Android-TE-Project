package com.example.akshay.teproject;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import static com.example.akshay.teproject.R.string.app_name;

public class AboutUs extends AppCompatActivity {
    Toolbar about_tool;
    NavigationView about_navi;
    DrawerLayout about_drawer;
    ActionBarDrawerToggle about_abdt;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        about_tool = findViewById(R.id.about_toolbar);
        about_navi = findViewById(R.id.about_navigation);
        about_drawer = findViewById(R.id.about_drawer);
        setSupportActionBar(about_tool);
        about_abdt = new ActionBarDrawerToggle(this,about_drawer,about_tool,app_name,app_name);
        about_drawer.addDrawerListener(about_abdt);
        about_abdt.syncState();
        about_navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_screen:
                        i = new Intent(AboutUs.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.department:
                        i = new Intent(AboutUs.this,Departments.class);
                        startActivity(i);
                        break;
                    case R.id.registration:
                        i = new Intent(AboutUs.this,Registration.class);
                        startActivity(i);
                        break;
                    case R.id.mission:
                        i = new Intent(AboutUs.this,SVITMission.class);
                        startActivity(i);
                        break;
                    case R.id.reach_us:
                        i = new Intent(AboutUs.this,ReachUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(AboutUs.this,LoginPage.class);
                        startActivity(i);
                        break;

                }

                return false;
            }
        });

    }
}
