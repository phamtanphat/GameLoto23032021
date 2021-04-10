package com.example.gameloto23032021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSMin,mEdtSMax;
    Button mBtnRandom,mBtnAddRange,mBtnReset;
    TextView mTvResult;
    String mTextSMin = "";
    String mTextSMax = "";
    Random mRandom = null;
    String mTextResult = "";
    List<Integer> mArrList;
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

        mArrList = new ArrayList<>();
        mRandom = new Random();

        // Task 1 : Bàn phím phải là số
        // Task 2 : Chỉ nhập tối đa là 3 số
        // Task 3 : Kiểm tra giá trị nhập vào không đủ thì thông báo
        // Task 4 : Ngoài việc click button có thể click action done để random

        mBtnAddRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();

                // Chuyển chuỗi thành số
                int sMax = Integer.parseInt(mTextSMax);
                int sMin = Integer.parseInt(mTextSMin);

                if (sMin >= sMax){
                    sMax = sMin + 1;
                }
                mEdtSMax.setText(String.valueOf(sMax));

                mArrList.clear();

                for (int i = sMin; i <= sMax ; i++) {
                    mArrList.add(i);
                }
                Toast.makeText(MainActivity.this, "Hoàn tất việc thêm giá trị", Toast.LENGTH_SHORT).show();
                disableView(mBtnAddRange);
                disableView(mEdtSMax);
                disableView(mEdtSMin);
            }
        });

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mArrList.size() > 0){
                    int index = mRandom.nextInt(mArrList.size());
                    int value = mArrList.get(index);
//                    if (mArrList.size() == 1){
//                        mTextResult += value;
//                    }else{
//                        mTextResult += value + " - ";
//                    }
                    mTextResult += value + " - ";

                    // Regular expression
                    if (mArrList.size() == 1){
                        // subString (vị trí bắt đầu cắt , vị trí kết thúc cắt)
                        mTextResult = mTextResult.substring(0,mTextResult.length() - 3);
                    }

                    mTvResult.setText(mTextResult);
                    mArrList.remove(index);
                }else{
                    Toast.makeText(MainActivity.this, "Hết số để random", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // xóa dữ liệu
                mEdtSMax.setText("");
                mEdtSMin.setText("");
                mArrList.clear();
                mTvResult.setText("");
                mTextResult = "";

                // shift + f6 : rename all

                // bật tương tác cho view
                enableView(mEdtSMin);
                enableView(mEdtSMax);
                enableView(mBtnAddRange);
            }
        });
        // App freaking

    }
    private void validateForm(){
        mTextSMin = mEdtSMin.getText().toString();
        mTextSMax = mEdtSMax.getText().toString();

        if (mTextSMin.isEmpty() || mTextSMax.isEmpty()){
            Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin!!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void enableView(View v){
        v.setEnabled(true);
    }
    private void disableView(View v){
        v.setEnabled(false);
    }
}