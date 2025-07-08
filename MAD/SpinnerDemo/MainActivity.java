package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button submit;
    EditText name,phone;
    RadioGroup gender;
    RadioButton selectedGender;
    Spinner sems;
    ArrayAdapter<String> adapter;
    String[] semdata=new String[]{"S1","S2","S3","S4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        gender=findViewById(R.id.genders);
        submit=findViewById(R.id.submit);
        sems=findViewById(R.id.semester);
        adapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,semdata);
        sems.setAdapter(adapter);
        submit.setOnClickListener(this);
        sems.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameValue=name.getText().toString();
        String phoneNum=phone.getText().toString();
        selectedGender=findViewById(gender.getCheckedRadioButtonId());
        String selectedSem=sems.getSelectedItem().toString();
        Toast.makeText(this, "Name:"+nameValue, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Phone:"+phoneNum, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Gender"+selectedGender.getText(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Sem="+selectedSem,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item="+ parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Mandatory method to override
    }
}