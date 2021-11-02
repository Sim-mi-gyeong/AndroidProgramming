 package com.me.handwrittensignature;
// RealSign

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RealSign extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.real_sign);

        Button startButton = (Button)findViewById(R.id.button_start);
        Button saveButton = (Button)findViewById(R.id.button_save);
        Button clearButton = (Button)findViewById(R.id.button_clear);

//        saveButton.setVisibility(false)
//        clearButton.setVisibility(false);

        signaturePad = (SignaturePad) findViewById(R.id.signaturePad);

        signaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {

            @Override
            public void onStartSigning() {
                //Event triggered when the pad is touched

                clearButton.setVisibility(true);
                saveButton.setVisibility(true);
            }

            @Override
            public void onSigned() {
                //Event triggered when the pad is signed
                clearButton.setEnabled(true);
                saveButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                //Event triggered when the pad is cleared
                clearButton.setEnabled(false);
                saveButton.setEnabled(false);
            }
        });

    }

//    public void onClick(View view) {
//        button1.setText("초기화")
//    }


}
