package com.example.lec0930_switchtemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view) {

        EditText editText = findViewById(R.id.editText);

        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);

        Float temp1 = Float.parseFloat(editText.getText().toString());   // Float: 자료형 객체
        Float temp2 = 0.0f;

        if(radio1.isChecked()) {  // 섭씨
            temp2 = temp1 / 33.8f;
            editText.setText(temp2.toString());   // setText
        }
        else if(radio2.isChecked()) {  // 화씨
            temp2 = temp1 * 33.8f;
            editText.setText(temp2.toString());
        }
        else{   // 둘 다 선택되지 않는 경우 0으로 초기
            temp2 = 0.0f;
            editText.setText(temp2.toString());
        }
    }
}