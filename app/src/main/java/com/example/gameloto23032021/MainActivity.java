package com.example.gameloto23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSMin,mEdtSMax;
    Button mBtnRandom;
    TextView mTvResult;
    String mTextSMin = "";
    String mTextSMax = "";
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

                int sMax = Integer.parseInt(textSMax);
                int SMin = Integer.parseInt(textSMin);
            }
        });
    }
    // Cách định 1 phương thức
    // 1 : Phạm vi hoạt động
    // 2 : Kiểu dữ liệu trả về
    // 3 : Tên phương thức
    private void validateForm(){
        mTextSMin = mEdtSMin.getText().toString();
        mTextSMax = mEdtSMax.getText().toString();

        if (mTextSMin.isEmpty() || mTextSMax.isEmpty()){
            Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin!!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}