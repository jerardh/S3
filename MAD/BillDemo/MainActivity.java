package com.example.billviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.billviewer.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Map<String,Integer> datas,billinfo;
    ArrayList<String> keys;
    String[] arr;
    Button add,generate;
    Spinner items;
    EditText quantity;
    TextView billView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas=new HashMap<String,Integer>();
        billinfo=new HashMap<String,Integer>();
        keys=new ArrayList<String>();
        datas.put("Bag",300);
        datas.put("Pen",10);
        datas.put("Pencil",15);
        datas.put("Bottle",80);
        for(String key:datas.keySet()){
            keys.add(key);
        }
        add=findViewById(R.id.add);
        items=findViewById(R.id.items);
        generate=findViewById(R.id.generate);
        quantity=findViewById(R.id.quantity);
        billView=findViewById(R.id.billview);
        add.setOnClickListener(this);
        generate.setOnClickListener(this);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,keys);
        items.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==add.getId()){
            int total=0,temp=0;
            String currItem=items.getSelectedItem().toString();
            billinfo.put(currItem,billinfo.getOrDefault(currItem,0)+Integer.parseInt(quantity.getText().toString()));
            String billInfoString="";
            for(String key:billinfo.keySet()){
                temp=billinfo.get(key)*datas.get(key);
                total+=temp;
                billInfoString+=key+":"+billinfo.get(key)+"-"+temp+"\n";
            }
            billView.setText(billInfoString+"\n\nTotal="+total);
        }
        else{
            Intent intent=new Intent(MainActivity.this,BillActivity.class);
            intent.putExtra("billinfo",billView.getText());
            startActivity(intent);
        }
    }
}