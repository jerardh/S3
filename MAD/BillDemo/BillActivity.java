package com.example.billviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BillActivity extends AppCompatActivity {
    TextView bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        bill=findViewById(R.id.bill);
        Intent intent=getIntent();
        bill.setText(intent.getStringExtra("billinfo"));
    }
}