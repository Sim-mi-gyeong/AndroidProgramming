package com.me.dailyline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class List extends AppCompatActivity {

    private Button memoButton, chartButton, listButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        memoButton = findViewById(R.id.memoButton);
        chartButton = findViewById(R.id.chartButton);
        listButton = findViewById(R.id.listButton);


        // 버튼을 통한 화면 전환 리스너
        // 버튼을 통한 화면 전환 리스너
        memoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
            }
        });

        chartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chart.class);
                startActivity(intent);
            }
        });

    }
}
