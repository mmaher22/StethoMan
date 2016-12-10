package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.graphics.*;
import android.animation.*;
import android.transition.*;
import android.widget.*;
import android.content.*;


public class Login extends AppCompatActivity implements View.OnClickListener {

    TextView textView3;
// The three operations leading to the three pages of doctor, manager and patient
    private void buttonClick1() { startActivity(new Intent("cp3.name.managerpage"));}
    private void buttonClick2() { startActivity(new Intent("cp3.name.doctorpage"));}
    private void buttonClick3() { startActivity(new Intent("cp3.name.patientpage"));}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(this);
// The selection of the radio button leads to one of the three pages
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        Button btn = (Button) findViewById(R.id.buttonone);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedID = rg.getCheckedRadioButtonId();
                switch (selectedID){
                    case R.id.radioButton1:
                        buttonClick1();
                        break;
                    case R.id.radioButton2:
                        buttonClick2();
                        break;
                    case R.id.radioButton3:
                        buttonClick3();
                        break;
                }
            }
        });
    }

    private void textClick()
    {
        startActivity(new Intent("cp3.name.forgotpassword"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.textView3:
                textClick();
                break;
        }
    }
}
