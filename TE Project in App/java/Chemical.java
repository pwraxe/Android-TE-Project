package com.example.akshay.teproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Chemical extends AppCompatActivity {

    ImageButton chem_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical);


        chem_back = findViewById(R.id.chemical_back);
        chem_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Chemical.this,Departments.class);
                startActivity(i);
                finish();
            }
        });
    }
}
