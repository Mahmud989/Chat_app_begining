package com.example.chatapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    TextView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        loginView = (TextView) findViewById(R.id.home_user_name);
        if (loginView != null)
            loginView.setText(getIntent().getExtras().getString("username", "null"));
    }
}
