package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    HashMap<Integer, ArrayList<String>> data =new HashMap<>();
    ArrayAdapter<String> adapter;
    int size = 2;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addData();
        layout = findViewById(R.id.layout);
        for(int i=1;i<=size;i++){
            TextView question = new TextView(this);
            RadioGroup group = new RadioGroup(this);
            ArrayList<String> info = data.get(i);
            question.setText(info.get(0));
            RadioButton op1 =new RadioButton(this);
            op1.setText(info.get(1));
            RadioButton op2 =new RadioButton(this);
            op2.setText(info.get(2));
            RadioButton op3 =new RadioButton(this);
            op3.setText(info.get(3));
            RadioButton op4 =new RadioButton(this);
            op4.setText(info.get(4));
            group.setId(i);
            group.addView(op1);
            group.addView(op2);
            group.addView(op3);
            group.addView(op4);
            layout.addView(question);
            layout.addView(group);
            LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,60,10,10);
            LinearLayout.LayoutParams txtparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.MATCH_PARENT);
            txtparams.setMargins(10,30,10,0);
            question.setLayoutParams(txtparams);
            group.setLayoutParams(params);
            group.setOnCheckedChangeListener(this);
        }
    }
    void addData(){
        ArrayList<String> q1 = new ArrayList<String>();
        q1.add("Capital of India?");
        q1.add("Mumbai");
        q1.add("Delhi");
        q1.add("Goa");
        q1.add("Chennai");
        q1.add("Delhi");
        data.put(1,q1);
        ArrayList<String> q2 = new ArrayList<String>();
        q2.add("Largest Country In world");
        q2.add("India");
        q2.add("USA");
        q2.add("Russia");
        q2.add("China");
        q2.add("Russia");
        data.put(2,q2);
    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
        RadioButton checked=findViewById(radioGroup.getCheckedRadioButtonId());
        int id = radioGroup.getId();
        String correct = data.get(id).get(5);
        String checkedstr = checked.getText().toString();
        Toast.makeText(getApplicationContext(),"id="+id+" checked="+checkedstr+" correct="+correct,Toast.LENGTH_LONG).show();
    }
}