package com.example.akshay.teproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.akshay.teproject.R.string.app_name;

public class Registration extends AppCompatActivity
{
    EditText DisplayData_mobile_edit;

    Toolbar regis_tool;
    NavigationView regis_navi;
    DrawerLayout regis_drawer;
    ActionBarDrawerToggle regis_abdt;
    Intent i;
    DatabaseHelper helper = new DatabaseHelper(this);
    String Fname,Mname,Lname,Email,Branch,day,month,year,BirthDay,Today,Mobile;

    EditText fname_edit,mname_edit,lname_edit,email_edit,mobile_edit;
    Spinner Bday,BMonth,Byear,TDay,Tmonth,Tyear,dept;
    Button register,display,update;

    String branch[] = {"Select Branch","Aeronautical Engineering","Agricultural engineering","Biochemical engineering",
            "Chemical Engineering","Civil Engineering","Computer Engineering","E & TC Engineering",
            "Electrical engineering","Information Technology Engineering","Mechanical Engineering",
            "Metallurgical Engineering"};


    String DisplayDay[] = {"DD","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String DisplayMonths[] ={"MM","January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String DisplayYear[] = {"YYYY","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003",  "2004",  "2005",  "2006",  "2007",  "2008",  "2009",  "2010",  "2011",  "2012",  "2013",  "2014",  "2015",  "2016",  "2017",  "2018",  "2019",  "2020",  "2021",  "2022",  "2023",  "2024",  "2025",  "2026",  "2027",  "2028",  "2029",  "2030",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fname_edit  = findViewById(R.id.fname_id);
        mname_edit = findViewById(R.id.mname_id);
        lname_edit = findViewById(R.id.lname_id);
        email_edit = findViewById(R.id.email_id);
        mobile_edit = findViewById(R.id.mobile_id);


        Bday = findViewById(R.id.DOB_spinnerForDay_id);
        BMonth = findViewById(R.id.DOB_spinnerForMonth_id);
        Byear = findViewById(R.id.DOB_spinnerForYear_id);

        TDay = findViewById(R.id.TD_spinnerForDay_id);
        Tmonth = findViewById(R.id.TD_spinnerForMonth_id);
        Tyear = findViewById(R.id.TD_spinnerForYear_id);

        register = findViewById(R.id.register_button);
        display = findViewById(R.id.displayData_button);
        dept = findViewById(R.id.branch_id);
        update  =findViewById(R.id.update_button);

        regis_tool = findViewById(R.id.registration_toolbar);
        regis_navi = findViewById(R.id.registration_navigation);
        regis_drawer = findViewById(R.id.registration_drawer);
        setSupportActionBar(regis_tool);
        regis_abdt = new ActionBarDrawerToggle(Registration.this,regis_drawer,regis_tool,app_name,app_name);
        regis_drawer.addDrawerListener(regis_abdt);
        regis_abdt.syncState();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStudentData();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            DisplayData_mobile_edit = v.findViewById(R.id.display_data_mobile_id);
            AlertDialog.Builder dialog = new AlertDialog.Builder(Registration.this);
            dialog.setTitle("Enter Mobile No : ");
            DisplayData_mobile_edit =  new EditText(getApplicationContext());
            DisplayData_mobile_edit.setHint("Enter Register Mobile No");
            DisplayData_mobile_edit.setInputType(InputType.TYPE_CLASS_NUMBER);
            dialog.setView(DisplayData_mobile_edit);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Long getEditMobi = Long.parseLong(DisplayData_mobile_edit.getText().toString());
                    displayData(getEditMobi);
                }
            });
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            dialog.show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Registration.this);
                builder.setTitle("Note : ");
                builder.setMessage("Please Make sure you enter correct Registered Mobile Number, Otherwise your data will not update.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        updateData();
                    }
                });
                builder.setNegativeButton("Let me Checked", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });


        regis_navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_screen:
                        i = new Intent(Registration.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.department:
                        i = new Intent(Registration.this,Departments.class);
                        startActivity(i);
                        break;
                    case R.id.mission:
                        i = new Intent(Registration.this,SVITMission.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        i = new Intent(Registration.this,AboutUs.class);
                        startActivity(i);
                        break;
                    case R.id.reach_us:
                        i = new Intent(Registration.this,ReachUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(Registration.this,LoginPage.class);
                        startActivity(i);
                        break;

                }

                return false;
            }
        });

        ArrayAdapter<String> branchAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,branch);
        dept.setAdapter(branchAdapter);

        ArrayAdapter<String> BdayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayDay);
        Bday.setAdapter(BdayAdapter);

        ArrayAdapter<String> BMonthAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayMonths);
        BMonth.setAdapter(BMonthAdapter);

        ArrayAdapter<String> BYearAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayYear);
        Byear.setAdapter(BYearAdapter);

        ArrayAdapter<String> TdayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayDay);
        TDay.setAdapter(TdayAdapter);

        ArrayAdapter<String> TDayMonthAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayMonths);
        Tmonth.setAdapter(TDayMonthAdapter);

        ArrayAdapter<String> TdayYearAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,DisplayYear);
        Tyear.setAdapter(TdayYearAdapter);



    }

    public void getStudentData()
    {
        Fname = fname_edit.getText().toString();
        Mname = mname_edit.getText().toString();
        Lname = lname_edit.getText().toString();
        Email = email_edit.getText().toString();

        Mobile = mobile_edit.getText().toString();
        Branch = dept.getSelectedItem().toString();
        BirthDay = getBirthDay();
        Today = getToday();
        if(Fname.equals("") || Mname.equals("") || Lname.equals("") || Email.equals("") ||
                dept.getSelectedItem().equals("Select Branch") || BirthDay.equals("DD MM YYYY") ||
                Today.equals("DD MM YYYY") || Bday.getSelectedItem().toString().equals("DD") ||
                BMonth.getSelectedItem().toString().equals("MM") || Byear.getSelectedItem().toString().equals("YYYY") ||
                TDay.getSelectedItem().toString().equals("DD") || Tmonth.getSelectedItem().toString().equals("MM") || Tyear.getSelectedItem().toString().equals("YYYY"))
            Toast.makeText(Registration.this,"Please Fill all the Fields",Toast.LENGTH_SHORT).show();
        else
        {
            boolean isDataInserted = helper.insertData(Fname,Mname,Lname,Email,Mobile,Branch,BirthDay,Today);
            if(isDataInserted == true) {
                Toast.makeText(this, "Data Successfully Inserted", Toast.LENGTH_SHORT).show();
                fname_edit.setText("");
                mname_edit.setText("");
                lname_edit.setText("");
                email_edit.setText("");
                mobile_edit.setText("");


            }
            else
                Toast.makeText(this,"Something went Wrong",Toast.LENGTH_SHORT).show();
        }


    }


    public String getBirthDay()
    {
        day = Bday.getSelectedItem().toString();
        month = BMonth.getSelectedItem().toString();
        year = Byear.getSelectedItem().toString();

        return day+" "+month+" "+year;
    }

    public String getToday()
    {
        day = TDay.getSelectedItem().toString();
        month = Tmonth.getSelectedItem().toString();
        year = Tyear.getSelectedItem().toString();

        return day+" "+month+" "+year;
    }

    public void displayData(Long MobileNo)
    {
        Cursor c = helper.getSpecificData(MobileNo);
        if(c.getCount() == 0)
        {
            showMessage("Error","No Record Found");
        }
        StringBuffer bf = new StringBuffer();
        while (c.moveToNext())
        {
            bf.append("First Name : "+c.getString(0)+"\n");
            bf.append("Fathers Name : "+c.getString(1)+"\n");
            bf.append("Last Name : "+c.getString(2)+"\n");
            bf.append("Email ID : "+c.getString(3)+"\n");
            bf.append("Mobile No : "+c.getString(4)+"\n");
            bf.append("Branch : "+c.getString(5)+"\n");
            bf.append("Birth Date : "+c.getString(6)+"\n");
            bf.append("Registered Date : "+c.getString(7)+"\n");
            bf.append("\n___________________________________\n\n");
        }
        showMessage("Data",bf.toString());
    }
    public void showMessage(String title,String msg)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true).setTitle(title).setMessage(msg).show();

    }

    public void updateData()
    {
        Fname = fname_edit.getText().toString();
        Mname = mname_edit.getText().toString();
        Lname = lname_edit.getText().toString();
        Email = email_edit.getText().toString();

        Mobile = mobile_edit.getText().toString();
        Branch = dept.getSelectedItem().toString();
        BirthDay = getBirthDay();
        Today = getToday();


        boolean isUpdate = helper.updateAllData(Fname,Mname,Lname,Email,Mobile,Branch,BirthDay,Today);
        if(isUpdate == true)
            Toast.makeText(this,"Data Successfully Updated",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Sorry, Your mobile not register with us!",Toast.LENGTH_SHORT).show();
    }




}
