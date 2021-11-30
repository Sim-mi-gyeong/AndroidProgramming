package com.me.dailyline;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Calendar extends AppCompatActivity {

//    public String selectDay = null;
//    public String str = null;
//    public CalendarView calendarView;
//    public Button saveButton, modifyButton, delButton;
//    public TextView dailyText, showText;
//    public EditText inputText;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.calendar);
//
//        calendarView = findViewById(R.id.calendarView);
//        dailyText = findViewById(R.id.dailyText);
//        inputText = findViewById(R.id.inputText);
//        saveButton = findViewById(R.id.saveButton);
//        modifyButton = findViewById(R.id.modifyButton);
//        delButton = findViewById(R.id.delButton);
//        showText = findViewById(R.id.showText);
//
//        // CalendarView 날짜 전환 리스너
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                // 원하는 날짜 클릭했을 때 보이게 하는 View
//                dailyText.setVisibility(View.VISIBLE);
//                inputText.setVisibility(View.VISIBLE);
//                saveButton.setVisibility(View.VISIBLE);
//
//                // 날짜별 Text 등록 전 보이지 않게 하는 View
//                modifyButton.setVisibility(View.INVISIBLE);
//                delButton.setVisibility(View.INVISIBLE);
//                showText.setVisibility(View.INVISIBLE);
//
//                // Text View format 설정
//                dailyText.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
//                inputText.setText("");
//
//                // 날짜에 띠른 저장 내용 확인 함수 실행
//                checkDay(year, month, dayOfMonth);
//
//            }
//        });
//
//        // 날짜에 따른 구절 저장 버튼 클릭 리스너
//        saveButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                saveDaily(selectDay);
//
//                str = inputText.getText().toString();   // 입력한 구절의 문자열을 str에 저장
//
//                showText.setText(str);   // 저장한 구절을 보여주는 showText에 str 내용 설정
//                saveButton.setVisibility(View.INVISIBLE);   // 이미 사용한 저장 버튼은 보이지 않게 설정
//
//                // 수정 및 삭제 버튼이 보이도록 설정
//                modifyButton.setVisibility(View.VISIBLE);
//                delButton.setVisibility(View.VISIBLE);
//
//                inputText.setVisibility(View.INVISIBLE);   // EditText 부분 보이지 않게 설정
//                showText.setVisibility(View.VISIBLE);
//
//            }
//        });
//
//    }
//
//    // 날짜에 띠른 저장 내용 확인 함수 정의
//    public void checkDay(int cYear, int cMonth, int cDay) {
//        selectDay = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt";
//        FileInputStream fis;
//
//        try {
//            fis = openFileInput(selectDay);
//
//            byte[] fileData = new byte[fis.available()];   // available(): 파일의 길이
//            fis.read(fileData);
//            fis.close();
//
//            str = new String(fileData);
//
//            inputText.setVisibility(View.INVISIBLE);   // 이미 입력된 부분을 읽는 것이므로 inputText 는 invisible로 설정
//            showText.setVisibility(View.VISIBLE);
//            showText.setText(str);   // txt 파일에 저장된 내용이 담긴 str로 text 내용 설정
//
//            saveButton.setVisibility(View.INVISIBLE);
//            modifyButton.setVisibility(View.VISIBLE);
//            delButton.setVisibility(View.VISIBLE);
//
//            // 불러온 기록 내용에 대해 수정 버튼 이벤트 리스너
//            modifyButton.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    inputText.setVisibility(View.VISIBLE);   // 직접 입력했던 내용이 보이고
//                    showText.setVisibility(View.INVISIBLE);
//                    inputText.setText(str);
//
//                    saveButton.setVisibility(View.VISIBLE);
//                    modifyButton.setVisibility(View.INVISIBLE);
//                    delButton.setVisibility(View.INVISIBLE);
//                    showText.setText(inputText.getText());   // inputText를 통해 입력받은 내용을 showText로 지정
//                }
//            });
//
//            // 불러온 기록 내용에 대해 삭제 버튼 이벤트 리스너
//            delButton.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    showText.setVisibility(View.INVISIBLE);   // 보여주는 내용의 텍스트를 보이지 않도록 설정
//                    inputText.setText("");   // 삭제를 하므로 입력한 내용을 ""로 초기화
//                    inputText.setVisibility(View.VISIBLE);
//
//                    saveButton.setVisibility(View.VISIBLE);
//                    modifyButton.setVisibility(View.INVISIBLE);
//                    delButton.setVisibility(View.INVISIBLE);
//
//                    removeDaily(selectDay);   // 해당 날짜에 대한 txt 파일 내용도 지우기
//                }
//            });
//
//            if (showText.getText() == null) {   // 삭제를 하려고 하는 내용의 텍스트가 null값이면
//                showText.setVisibility(View.INVISIBLE);
//                dailyText.setVisibility(View.VISIBLE);   // 날짜에 대한 텍스트를 보이고,
//
//                saveButton.setVisibility(View.VISIBLE);
//                modifyButton.setVisibility(View.INVISIBLE);
//                delButton.setVisibility(View.INVISIBLE);
//
//                inputText.setVisibility(View.VISIBLE);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    // 날짜에 따른 구절 저장 함수 정의
//    @SuppressLint("WrongConstant")
//    public void saveDaily(String selectDay) {
//
//        FileOutputStream fos;
//
//        try {
//            fos = openFileOutput(selectDay, MODE_NO_LOCALIZED_COLLATORS);
//            String inputContent = inputText.getText().toString();
//            fos.write(inputContent.getBytes());
//            fos.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 날짜에 따른 저장된 구절 삭제 함수 정의
//    @SuppressLint("WrongConstant")
//    public void removeDaily(String SelectDay) {
//
//        FileOutputStream fos;
//
//        try {
//            fos = openFileOutput(selectDay, MODE_NO_LOCALIZED_COLLATORS);
//            String inputContent = "";   // 삭제하므로 input의 내용을 초기화
//            fos.write(inputContent.getBytes());
//            fos.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}

