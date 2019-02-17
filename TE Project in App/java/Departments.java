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
import android.view.View;
import android.widget.Button;

import static com.example.akshay.teproject.R.string.app_name;

public class Departments extends AppCompatActivity
{
    Toolbar depart_tool;
    NavigationView dept_navi;
    DrawerLayout depart_drawer;
    ActionBarDrawerToggle depart_abdt;
    Intent i;
    View v;

    Button fe,comp,IT,chem,elect,entc,mech,mba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        fe = findViewById(R.id.fe_button);
        comp = findViewById(R.id.computer_button);
        IT = findViewById(R.id.it_button);
        chem = findViewById(R.id.chemical_button);
        elect = findViewById(R.id.electrical_button);
        entc = findViewById(R.id.etc_button);
        mech = findViewById(R.id.mech_button);
        mba = findViewById(R.id.mba_button);

        depart_tool = findViewById(R.id.dept_toolbar);
        dept_navi = findViewById(R.id.dept_navigation);
        depart_drawer = findViewById(R.id.dept_drawer);
        setSupportActionBar(depart_tool);
        depart_abdt = new ActionBarDrawerToggle(this,depart_drawer,depart_tool,app_name,app_name);
        depart_drawer.addDrawerListener(depart_abdt);
        depart_abdt.syncState();
        dept_navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_screen:
                        i = new Intent(Departments.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.registration:
                        i = new Intent(Departments.this,Registration.class);
                        startActivity(i);
                        break;
                    case R.id.mission:
                        i = new Intent(Departments.this,SVITMission.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        i = new Intent(Departments.this,AboutUs.class);
                        startActivity(i);
                        break;
                    case R.id.reach_us:
                        i = new Intent(Departments.this,ReachUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(Departments.this,LoginPage.class);
                        startActivity(i);
                        break;

                }

                return false;
            }
        });
    }

    public void showDept(View v) {

        switch (v.getId())
        {
            case R.id.fe_button:
                i = new Intent(Departments.this,FirstYear.class);
                startActivity(i);
                break;
            case R.id.computer_button:
                i = new Intent(Departments.this,Computer.class);
                startActivity(i);
                break;
            case R.id.it_button:
                i = new Intent(Departments.this,IT.class);
                startActivity(i);
                break;
            case R.id.chemical_button:
                i = new Intent(Departments.this,Chemical.class);
                startActivity(i);
                break;
            case R.id.electrical_button:
                i = new Intent(Departments.this,Electrical.class);
                startActivity(i);
                break;
            case R.id.etc_button:
                i = new Intent(Departments.this,E_TC.class);
                startActivity(i);
                break;
            case R.id.mech_button:
                i = new Intent(Departments.this,Mechanical.class);
                startActivity(i);
                break;
            case R.id.mba_button:
                i = new Intent(Departments.this,MBA.class);
                startActivity(i);
                break;

        }

    }
}
