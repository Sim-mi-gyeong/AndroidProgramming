package com.me.dailyline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class SignIn extends AppCompatActivity {
    private Object editable;
    private CheckBox checkBox;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        mContext = this;   // 필수!!


        EditText editText_id = (EditText)findViewById(R.id.editText_id);
        EditText editText_pw = (EditText)findViewById(R.id.editText_pw);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        Button signInButton = (Button)findViewById(R.id.signin);

        signInButton.setEnabled(false);   // 버튼 기본 비활성화 상태(미입력시 버튼 제한을 위해)

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
                    signInButton.setEnabled(false);
                }
                else {
                    signInButton.setEnabled(true);
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

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 아이디와 비밀번호가 사용자 정보와 일치한지 확인 한 후
                // 일치하는 경우에만 intent 실행 -> toast Message로 '로그인 되었습니다'
                // 일치하지 않는 경우에는 intent 실행 X -> toast Message로 '회원 정보를 확인하세요.'
//                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                Intent intent = new Intent(getApplicationContext(), TotalFrame.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "로그인 되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

    }
}
