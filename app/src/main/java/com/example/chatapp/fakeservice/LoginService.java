package com.example.chatapp.fakeservice;

public class LoginService {
    public static boolean authUser(CharSequence username, CharSequence password) {
        return username.toString().equalsIgnoreCase("user") & password.toString().equalsIgnoreCase("pass");
    }
}
