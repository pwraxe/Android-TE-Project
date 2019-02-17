
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.akshay.teproject.R.string.app_name;

public class ReachUs extends AppCompatActivity {
    Toolbar reachUs_toolbar;
    NavigationView reachUs_navi;
    DrawerLayout reachUs_drawer;
    ActionBarDrawerToggle reachUs_abdt;
    Intent i;
    DatabaseHelper helper = new DatabaseHelper(this);
    EditText fname,lname,mobileNo,emailid,cmmnt;
    Button submit;
    Spinner day,month,year;

    String Fname,Lname,Mobile,Email,DAY,MONTH,YEAR,ToDay,Comments;

    String DisplayDay[] = {"DD","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String DisplayMonths[] ={"MM","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String DisplayYear[] = {"YYYY","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003",  "2004",  "2005",  "2006",  "2007",  "2008",  "2009",  "2010",  "2011",  "2012",  "2013",  "2014",  "2015",  "2016",  "2017",  "2018",  "2019",  "2020",  "2021",  "2022",  "2023",  "2024",  "2025",  "2026",  "2027",  "2028",  "2029",  "2030"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reach_us);

        fname = findViewById(R.id.contact_fname_id);
        lname = findViewById(R.id.contact_lname_id);
        mobileNo = findViewById(R.id.contact_mobile_id);
        emailid = findViewById(R.id.contact_email_id);

        cmmnt = findViewById(R.id.contact_comment_id);
        submit = findViewById(R.id.submitButton);

        day = findViewById(R.id.contact_day_id);
        month = findViewById(R.id.contact_month_id);
        year = findViewById(R.id.contact_year_id);




        reachUs_toolbar = findViewById(R.id.reach_toolbar);
        reachUs_navi = findViewById(R.id.reach_navigation);
        reachUs_drawer = findViewById(R.id.reach_drawer);
        setSupportActionBar(reachUs_toolbar);
        reachUs_abdt = new ActionBarDrawerToggle(this,reachUs_drawer,reachUs_toolbar,app_name,app_name);
        reachUs_drawer.addDrawerListener(reachUs_abdt);
        reachUs_abdt.syncState();
        reachUs_navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_screen:
                        i = new Intent(ReachUs.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.department:
                        i = new Intent(ReachUs.this,Departments.class);
                        startActivity(i);
                        break;
                    case R.id.registration:
                        i = new Intent(ReachUs.this,Registration.class);
                        startActivity(i);
                        break;
                    case R.id.mission:
                        i = new Intent(ReachUs.this,SVITMission.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        i = new Intent(ReachUs.this,AboutUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(ReachUs.this,LoginPage.class);
                        startActivity(i);
                        break;

                }

                return false;
            }
        });

        ArrayAdapter<String> TdayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayDay);
        day.setAdapter(TdayAdapter);

        ArrayAdapter<String> TDayMonthAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayMonths);
        month.setAdapter(TDayMonthAdapter);

        ArrayAdapter<String> TdayYearAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayYear);
        year.setAdapter(TdayYearAdapter);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fname = fname.getText().toString();
                Lname = lname.getText().toString();
                Mobile = mobileNo.getText().toString();
                Email = emailid.getText().toString();
                ToDay = getToday();
                Comments = cmmnt.getText().toString();

               if(Fname.equals("") || Lname.equals("") || Mobile.equals("") || Email.equals("")  || DAY.equals("DD") || MONTH.equals("MM") || YEAR.equals("YYYY") || Comments.equals(""))
                   Toast.makeText(ReachUs.this,"Please Fill All the Fields",Toast.LENGTH_SHORT).show();
               else
               {
                   boolean isInsert = helper.insertEnquiry(Fname,Lname,Mobile,Email,ToDay,Comments);     //comment removed
                   if(isInsert == true) {
                       Toast.makeText(ReachUs.this, "Your response has been recorded", Toast.LENGTH_SHORT).show();
                       fname.setText("");
                       lname.setText("");
                       mobileNo.setText("");
                       emailid.setText("");
                       Comments.equals("");
                   }
                   else
                       Toast.makeText(ReachUs.this,"Something went wrong",Toast.LENGTH_SHORT).show();
               }



            }
        });

    }

    public String getToday()
    {
        DAY = day.getSelectedItem().toString();
        MONTH = month.getSelectedItem().toString();
        YEAR = year.getSelectedItem().toString();
        return DAY+" "+MONTH+" "+YEAR;
    }
}
