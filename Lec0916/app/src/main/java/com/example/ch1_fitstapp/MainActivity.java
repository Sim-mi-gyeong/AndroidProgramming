package com.example.ch1_fitstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View view) {
        TextView text1 = (EditText) findViewById(R.id.edit1);
        TextView text2 = (EditText) findViewById(R.id.edit2);
        TextView text3 = (TextView) findViewById(R.id.textView5);

        int num1 = Integer.parseInt(text1.getText().toString());
        int num2 = Integer.parseInt(text2.getText().toString());

        switch (view.getId()) {
            case R.id.button:
                text3.setText(Integer.toString(num1 + num2));
                break;
            case R.id.button2:
                text3.setText(Integer.toString(num1 - num2));
                break;
            case R.id.button3:
                text3.setText(Integer.toString(num1 * num2));
                break;
            case R.id.button4:
                if (num1>num2) {
                    text3.setText(Integer.toString(num1 / num2));
                }else{
                    text3.setText(Integer.toString(num2 / num1));
                }

                break;
        }
    }
}