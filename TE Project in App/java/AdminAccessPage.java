package com.example.akshay.teproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.akshay.teproject.R.string.app_name;

public class AdminAccessPage extends AppCompatActivity {

    Toolbar admin_tool;
    NavigationView admin_navi;
    DrawerLayout admin_drawer;
    ActionBarDrawerToggle admin_abdt;
    Intent i;
    DatabaseHelper helper = new DatabaseHelper(this);


    CardView displayData,deleteData,enquiryData;
    EditText DisplayData_mobile_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_access_page);

        admin_tool = findViewById(R.id.admin_toolbar);
        admin_navi = findViewById(R.id.admin_navigation);
        admin_drawer = findViewById(R.id.admin_drawer);

        displayData = findViewById(R.id.displayAllData_id);
        deleteData = findViewById(R.id.delete_id);
        enquiryData = findViewById(R.id.enquiry_id);

        enquiryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllEnquiryData();
            }
        });

        displayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getAllStudentData();
            }
        });

        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayData_mobile_edit = v.findViewById(R.id.display_data_mobile_id);
                AlertDialog.Builder dialog = new AlertDialog.Builder(AdminAccessPage.this);
                dialog.setTitle("Enter Mobile No : ");
                DisplayData_mobile_edit =  new EditText(getApplicationContext());
                DisplayData_mobile_edit.setHint("Enter Register Mobile No");
                DisplayData_mobile_edit.setInputType(InputType.TYPE_CLASS_NUMBER);
                dialog.setView(DisplayData_mobile_edit);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String getEditMobi = DisplayData_mobile_edit.getText().toString();
                        deleteStudentData(getEditMobi);
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

        setSupportActionBar(admin_tool);
        admin_abdt = new ActionBarDrawerToggle(this,admin_drawer,admin_tool,app_name,app_name);
        admin_drawer.addDrawerListener(admin_abdt);
        admin_abdt.syncState();
        admin_navi.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home_screen:
                        i = new Intent(AdminAccessPage.this,MainActivity.class);
                        startActivity(i);
                        break;
                    case R.id.department:
                        i = new Intent(AdminAccessPage.this,Departments.class);
                        startActivity(i);
                        break;
                    case R.id.registration:
                        i = new Intent(AdminAccessPage.this,Registration.class);
                        startActivity(i);
                        break;
                    case R.id.mission:
                        i = new Intent(AdminAccessPage.this,SVITMission.class);
                        startActivity(i);
                        break;
                    case R.id.about:
                        i = new Intent(AdminAccessPage.this,AboutUs.class);
                        startActivity(i);
                        break;
                    case R.id.login_id:
                        i = new Intent(AdminAccessPage.this,ReachUs.class);
                        startActivity(i);
                        break;
                }

                return false;
            }
        });

    }


    public void getAllEnquiryData()
    {
        Cursor c = helper.getAllEnquiryData();
        if(c.getCount() == 0)
            displayEnquiryData("Oops...!","No Enquiry yet!");
        StringBuffer bf = new StringBuffer();
        while (c.moveToNext())
        {
            bf.append("First Name : "+c.getString(0)+"\n");
            bf.append("Last Name  : "+c.getString(1)+"\n");
            bf.append("Mobile No  : "+c.getString(2)+"\n");
            bf.append("Email ID   : "+c.getString(3)+"\n");
            bf.append("Enquiry Date : "+c.getString(4)+"\n");
            bf.append("Comment : "+c.getString(5)+"\n");
            bf.append("\n___________________________________\n\n");
        }
        displayEnquiryData("Enquiry Data",bf.toString());

    }

    public void getAllStudentData()
    {
        Cursor c = helper.getAllDatabaseData();
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
            bf.append("Today's Date : "+c.getString(7)+"\n");
            bf.append("\n___________________________________\n\n");
        }
        showMessage("Student Data",bf.toString());
    }
    public void showMessage(String title,String msg)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true).setTitle(title).setMessage(msg).show();
    }

    public void displayEnquiryData(String title,String Msg)
    {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true).setTitle(title).setMessage(Msg).show();
    }


    public void deleteStudentData(String mobile)
    {
        int affectedRows = helper.deleteData(mobile);
        if(affectedRows > 0)
            Toast.makeText(AdminAccessPage.this,"Data Deleted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(AdminAccessPage.this,"Error to Delete Data",Toast.LENGTH_SHORT).show();

    }


}
