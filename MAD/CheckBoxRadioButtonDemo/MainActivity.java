package com.example.checkboxradiodemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    RadioGroup gender;
    Button submit;
    CheckBox eng,hin,mal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gender =  findViewById(R.id.gender);
        submit = findViewById(R.id.submit);
        eng= findViewById(R.id.english);
        hin=findViewById(R.id.hindi);
        mal = findViewById(R.id.mal);
        submit.setOnClickListener(this);
        gender.setOnCheckedChangeListener(this);
        eng.setOnCheckedChangeListener(this);
        hin.setOnCheckedChangeListener(this);
        mal.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        String res ="";
        if(eng.isChecked()){
            res+=eng.getText();
        }
        if(hin.isChecked()){
            res+=hin.getText();
        }
        if(mal.isChecked()){
            res+=mal.getText();
        }
        Toast.makeText(this,"Checked Langauges="+res,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton checked = findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(this,"Checked gender is "+checked.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Toast.makeText(this,"Status changed for "+compoundButton.getText(),Toast.LENGTH_SHORT).show();
    }
}