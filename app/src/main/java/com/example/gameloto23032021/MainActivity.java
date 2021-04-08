package com.example.gameloto23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSMin,mEdtSMax;
    Button mBtnRandom;
    TextView mTvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSMin = findViewById(R.id.editTextSMin);
        mEdtSMax = findViewById(R.id.editTextSMax);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mTvResult = findViewById(R.id.textViewKetqua);


        // Task 1 : Bàn phím phải là số
        // Task 2 : Chỉ nhập tối đa là 3 số
        // Task 3 : Kiểm tra giá trị nhập vào không đủ thì thông báo
        // Task 4 : Ngoài việc click button có thể click action done để random

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textSMin = mEdtSMin.getText().toString();
                String textSMax = mEdtSMax.getText().toString();


            }
        });


    }
}