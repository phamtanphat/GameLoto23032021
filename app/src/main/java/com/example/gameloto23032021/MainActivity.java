package com.example.gameloto23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Math
        // 1 : Làm tròn
//        float st1 = 0.9999f;
//        float valueSt1 = Math.round(st1);
//        double valueSt2 = Math.ceil(Double.parseDouble(st1 + ""));
//        double valueSt3 = Math.floor(Double.parseDouble(st1 + ""));

        // 2 : Random
        // 0 ~ 5

//        for (int i = 0; i < 100; i++) {
//            double value = Math.floor(Math.random() * 6);
//            Log.d("BBB",value + "");
//        }

        // 5 - 127
        Random random = new Random();
        for (int i = 0; i < 200; i++) {

            int value = random.nextInt(127 - 5 + 1) + 5;
            Log.d("BBB",value  + "");
        }





    }
}