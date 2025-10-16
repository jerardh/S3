package com.example.scrollviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    ScrollView scrollView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = new TextView(this);
        textView.setTextSize(60);
        scrollView =  findViewById(R.id.scrollView);
        layout = findViewById(R.id.layout);
        for(int i=1;i<=40;i++){
            textView.append("\n"+"Textview "+i);
        }
        layout.addView(textView);

    }
}