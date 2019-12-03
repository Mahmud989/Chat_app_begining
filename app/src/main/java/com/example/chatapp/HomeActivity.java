package com.example.chatapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView loginView;
    TextView passwordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        loginView = (TextView) findViewById(R.id.home_user_name);
        passwordView = (TextView) findViewById(R.id.home_user_password);
        loginView.setText(getIntent().getExtras().getString("username", "null"));
        passwordView.setText(getIntent().getExtras().getString("password", "null"));
    }
}
