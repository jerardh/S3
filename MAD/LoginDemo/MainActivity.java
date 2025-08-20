package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText userName,userPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        userName=findViewById(R.id.userName);
        userPass=findViewById(R.id.userPass);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = userName.getText().toString();
        String userpass = userPass.getText().toString();
        if(username.equals("admin") && userpass.equals("admin")){
            Toast.makeText(this, "Welcome admin", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }
}