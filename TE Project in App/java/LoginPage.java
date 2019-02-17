package com.example.akshay.teproject;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.akshay.teproject.R.string.app_name;

public class LoginPage extends AppCompatActivity {
    Toolbar login_tool;
    NavigationView login_navi;
    DrawerLayout login_drawer;
    ActionBarDrawerToggle login_abdt;
    Intent i;
    CardView adminCard;
    String adminID,adminPass;
    public static boolean isLogin = false;

    EditText adminUsername,adminPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login_tool = findViewById(R.id.login_toolbar);
        login_navi = findViewById(R.id.login_navigation);
        login_drawer = findViewById(R.id.login_drawer);

        adminCard = findViewById(R.id.admin_card_id);
        adminUsername = findViewById(R.id.admin_id);
        adminPassword = findViewById(R.id.admin_password);

        adminCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder build = new AlertDialog.Builder(LoginPage.this);
                build.setTitle("Admin Login Portal");
                build.setView(R.layout.admin_verify_portal);

                View view = LoginPage.this.getLayoutInflater().inflate(R.layout.admin_verify_portal,null);
                adminUsername = view.findViewById(R.id.admin_id);
                adminPassword = view.findViewById(R.id.admin_password);
                adminUsername.setHint("Enter ID as : admin");
                adminPassword.setHint("Enter Password as : online");
                build.setView(view);


                build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                build.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        adminID = adminUsername.getText().toString();
                        adminPass = adminPassword.getText().toString();
                        if (adminID.equals("admin") && adminPass.equals("online"))
                        {

                            Intent i = new Intent(LoginPage.this,AdminAccessPage.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(LoginPage.this,"Invalid ID and Password,Admin",Toast.LENGTH_SHORT).show();
                    }
                });
                build.show();
            }
        });

        setSupportActionBar(login_tool);
        login_abdt = new ActionBarDrawerToggle(this,login_drawer,login_tool,app_name,app_name);
        login_drawer.addDrawerListener(login_abdt);
        login_abdt.syncState();
        login_navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_screen:
                        i = new Intent(LoginPage.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.department:
                        i = new Intent(LoginPage.this,Departments.class);
                        startActivity(i);
                        break;
                    case R.id.registration:
                        i = new Intent(LoginPage.this,Registration.class);
                        startActivity(i);
                        break;
                    case R.id.mission:
                        i = new Intent(LoginPage.this,SVITMission.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        i = new Intent(LoginPage.this,AboutUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(LoginPage.this,ReachUs.class);
                        startActivity(i);
                        break;

                }

                return false;
            }
        });

    }
}
