package com.example.nutrition;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityManager {
    public static void GoToActivity(AppCompatActivity current, Class next){
        Intent intent = new Intent(current, next);
        current.startActivity(intent);
    }
}
