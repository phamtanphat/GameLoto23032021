package com.example.gameloto23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSMin,mEdtSMax;
    Button mBtnRandom,mBtnAddRange,mBtnReset;
    TextView mTvResult;
    String mTextSMin = "";
    String mTextSMax = "";
    Random mRandom = null;
    String mTextResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSMin = findViewById(R.id.editTextSMin);
        mEdtSMax = findViewById(R.id.editTextSMax);
        mBtnRandom = findViewById(R.id.buttonRandom);
        mTvResult = findViewById(R.id.textViewKetqua);
        mBtnAddRange = findViewById(R.id.buttonAddRange);
        mBtnReset = findViewById(R.id.buttonReset);


        // Task 1 : Bàn phím phải là số
        // Task 2 : Chỉ nhập tối đa là 3 số
        // Task 3 : Kiểm tra giá trị nhập vào không đủ thì thông báo
        // Task 4 : Ngoài việc click button có thể click action done để random

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();

                int sMax = Integer.parseInt(mTextSMax);
                int sMin = Integer.parseInt(mTextSMin);

                if (sMin >= sMax){
                    sMax = sMin + 1;
                }
                mEdtSMax.setText(String.valueOf(sMax));



            }
        });

        mEdtSMax.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId , KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    validateForm();

                    int sMax = Integer.parseInt(mTextSMax);
                    int sMin = Integer.parseInt(mTextSMin);

                    if (sMin >= sMax){
                        sMax = sMin + 1;
                    }
                    mEdtSMax.setText(String.valueOf(sMax));


                    mRandom = new Random();
                    int value = mRandom.nextInt(sMax - sMin + 1) + sMin;

                    mTextResult += value + " - ";

                    mTvResult.setText(mTextResult);
                }
                return true;
            }
        });
    }
    // Cách định 1 phương thức
    // 1 : Phạm vi hoạt động
    // 2 : Kiểu dữ liệu trả về
    // 3 : Tên phương thức

    // Xử lý giá trị đầu vào từ edittext
    private void validateForm(){
        mTextSMin = mEdtSMin.getText().toString();
        mTextSMax = mEdtSMax.getText().toString();

        if (mTextSMin.isEmpty() || mTextSMax.isEmpty()){
            Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin!!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}