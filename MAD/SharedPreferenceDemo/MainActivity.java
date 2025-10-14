package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button add,view;
    EditText username,name;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        view = findViewById(R.id.view);
        username = findViewById(R.id.username);
        name =  findViewById(R.id.name);
        add.setOnClickListener(this);
        view.setOnClickListener(this);
        preferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = preferences.edit();
        if(v.getId() ==  add.getId()){
            editor.putString("USER_NAME",username.getText().toString());
            editor.putString("NAME",username.getText().toString());
            editor.apply();
            Toast.makeText(this, "Updated Value", Toast.LENGTH_SHORT).show();
        }
        else{
            String username = preferences.getString("USER_NAME","");
            String name = preferences.getString("NAME","");
            Toast.makeText(this, "Username:"+username+" Name:"+name, Toast.LENGTH_SHORT).show();
        }
    }
}