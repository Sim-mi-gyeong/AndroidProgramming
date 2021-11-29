package com.me.dailyline;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        EditText editText_id = (EditText)findViewById(R.id.editText_id);
        EditText editText_pw = (EditText)findViewById(R.id.editText_pw);

        Button signUpButton = (Button)findViewById(R.id.signup);

        signUpButton.setEnabled(false);   // 버튼 기본 비활성화 상태(미입력시 버튼 제한을 위해)

//        String text_id = editText_id.getText().toString();
//        String text_pw = editText_pw.getText().toString();

//        if(text_id.length() == 0 || text_pw.length() == 0) {
//            signInButton.setEnabled(false);
//        }
//        if(text_id.length() > 0 && text_pw.length() > 0) {
//            signInButton.setEnabled(true);
//        }

        // EditText 입력 시 호출 - 아이디와 비밀번호 모두 입력하여야 함. -> 우선 아이디 입력에 대해서만 입력 체크
        editText_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text_id = editText_id.getText().toString();
//                String text_pw = editText_pw.getText().toString();
                if(text_id.length() == 0) {
                    signUpButton.setEnabled(false);
                }
                else {
                    signUpButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//
//        String text_pw = editText_pw.getText().toString();
//        if (text_pw.length() == 0) {
//            signInButton.setEnabled(false);
//        } else {
//            signInButton.setEnabled(true);
//        }

//        editText_pw.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                String text_pw = editText_pw.getText().toString();
//                if (text_pw.length() == 0) {
//                    signInButton.setEnabled(false);
//                } else {
//                    signInButton.setEnabled(true);
//                }
//            }
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "회원가입 되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

    }

}
