package com.me.dailyline;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    public String readDay = null;
    public String str = null;
    public CalendarView calendarView;
    public Button saveButton, modifyButton, delButton;
    public TextView dailyText, showText;
    public EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        calendarView = findViewById(R.id.calendarView);
        dailyText = findViewById(R.id.dailyText);
        inputText = findViewById(R.id.inputText);
        saveButton = findViewById(R.id.saveButton);
        modifyButton = findViewById(R.id.modifyButton);
        delButton = findViewById(R.id.delButton);
        showText = findViewById(R.id.showText);

    }
}

