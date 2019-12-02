package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatapp.fakeservice.LoginService;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView txtView;
    EditText loginText;
    EditText passwordText;

    Context context ;
    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        txtView = (TextView) findViewById(R.id.text);
        loginText = (EditText) findViewById(R.id.loginText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        context = getApplicationContext();
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txtView.setText("Go Ahead");
                txtView.setTextSize(25);
                CharSequence text = "Username is " + loginText.getText().toString() +
                        "\r\nPassword is " + passwordText.getText().toString();

                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//                showToast();
                login();
            }
        });
    }

    private void login() {

        if (isNotNull(loginText)) {
            if (isNotNull(passwordText)) {
                if(LoginService.authUser(loginText.getText().toString(), passwordText.getText().toString())){
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid user credidentals", duration).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Password is null", duration).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Username is null", duration).show();
        }
    }

    private boolean isNotNull(EditText view) {
        return view != null && (!view.getText().toString().isEmpty());
    }


    public void showToast() {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        Button button = (Button) findViewById(R.id.button3);
        if (button != null) {
            txtView.setText("Toast Clicker");
        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                txtView.setText("Toast Clicker");
//            }
//        });


        toast.show();
    }


}
