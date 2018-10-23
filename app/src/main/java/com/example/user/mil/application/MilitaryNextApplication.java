package com.example.user.mil.application;

import android.app.Application;

import com.example.user.mil.model.User;

public class MilitaryNextApplication extends Application {
    private static User currentUser = new User();

    @Override
    public void onCreate() {
        super.onCreate();
        // 폰트 설정
    }

    // retrofit 설정
    // firebase 설정

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

}
