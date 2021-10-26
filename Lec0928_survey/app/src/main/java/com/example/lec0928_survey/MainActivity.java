package com.example.lec0928_survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

//    TextView selectAnswer;
//    RadioGroup radioGroup;
//    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        selectAnswer = findViewById(R.id.textView);
//        radioGroup = findViewById(R.id.radio_group)

    }

    public void onButtonClick(View view) {
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);
        RadioButton radio3 = findViewById(R.id.radio3);

        ImageView img1 = findViewById(R.id.image1);
        ImageView img2 = findViewById(R.id.image2);
        ImageView img3 = findViewById(R.id.image3);

        if(radio1.isChecked()) {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);

        }
        else if(radio2.isChecked()) {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.GONE);
        }
        else if(radio3.isChecked()) {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.VISIBLE);
        }

    }
}