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
import android.widget.TextView;

import static com.example.akshay.teproject.R.string.app_name;

public class SVITMission extends AppCompatActivity {
    Toolbar mission_tool;
    NavigationView mission_navi;
    DrawerLayout mission_drawer;
    ActionBarDrawerToggle mission_abdt;
    Intent i;
    TextView ClgNameMission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svit__mission);

        mission_tool = findViewById(R.id.mission_toolbar);
        mission_navi = findViewById(R.id.mission_navigation);
        mission_drawer = findViewById(R.id.mission_drawer);
        setSupportActionBar(mission_tool);
        ClgNameMission = findViewById(R.id.clgNameMission_id);
        ClgNameMission.setSelected(true);
        mission_abdt = new ActionBarDrawerToggle(this,mission_drawer,mission_tool,app_name,app_name);
        mission_drawer.addDrawerListener(mission_abdt);
        mission_abdt.syncState();
        mission_navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_screen:
                        i = new Intent(SVITMission.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.department:
                        i = new Intent(SVITMission.this,Departments.class);
                        startActivity(i);
                        break;
                    case R.id.registration:
                        i = new Intent(SVITMission.this,Registration.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        i = new Intent(SVITMission.this,AboutUs.class);
                        startActivity(i);
                        break;
                    case R.id.reach_us:
                        i = new Intent(SVITMission.this,ReachUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(SVITMission.this,LoginPage.class);
                        startActivity(i);
                        break;

                }

                return false;
            }
        });

    }
}
