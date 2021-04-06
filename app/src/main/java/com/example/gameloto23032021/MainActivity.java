package com.example.gameloto23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Math
        // 1 : Làm tròn
        float st1 = 0.9999f;
        float valueSt1 = Math.round(st1);
        double valueSt2 = Math.ceil(Double.parseDouble(st1 + ""));
        double valueSt3 = Math.floor(Double.parseDouble(st1 + ""));

        Log.d("BBB", valueSt3 + "");

    }
}