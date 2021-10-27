package com.example.lec1012_timepicker_re;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.lec1012_timepicker_re.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //    private TextView text1;
//    private TimePicker timePicker1;
//    private Button button1;
    TimePicker timePicker1;
    TextView text1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker1 = findViewById(R.id.timePicker1);

            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            timePicker1.setHour(mHour);
            timePicker1.setMinute(mMinute);
        }
//        textView = findViewById(R.id.text1);
//        timePicker = findViewById(R.id.timePicker1);

//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
//                textView.setText(hourOfDay + "시" + minute + "분");
//            }
//        });
//
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    text1 = findViewById(R.id.text1);
                    int mHour = timePicker1.getHour();
                    int mMinute = timePicker1.getMinute();
                    text1.setText("[time] " + mHour + " : "+ mMinute);
                }
            }
        });
    }
}