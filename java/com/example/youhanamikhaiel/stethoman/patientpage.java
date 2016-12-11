package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class patientpage extends AppCompatActivity {

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    Button msgtomanager;

    private void imagebutton1Click() {startActivity(new Intent("cp3.name.sendmsg"));}
    private void imagebutton2Click() {startActivity(new Intent("cp3.name.mynotifications"));}
    private void imagebutton3Click() {startActivity(new Intent("cp3.name.myinfo"));}
    private void imagebutton4Click() {startActivity(new Intent("cp3.name.medicalstatus"));}
    private void imagebutton5Click() {startActivity(new Intent("cp3.name.requestvisit"));}
    private void imagebutton6Click() {startActivity(new Intent("cp3.name.reviewdoctor"));}
    private void buttonmsgtomanagerClick() {startActivity(new Intent("cp3.name.msgtomanager"));}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientpage);


        msgtomanager = (Button) findViewById(R.id.msgtomanager);
        msgtomanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.msgtomanager:
                        buttonmsgtomanagerClick();
                        break;
                }
            }
        });
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.imageButton2:
                        imagebutton2Click();
                        break;
                }
            }
        });
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.imageButton3:
                        imagebutton3Click();
                        break;
                }
            }
        });
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.imageButton4:
                        imagebutton4Click();
                        break;
                }
            }
        });
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.imageButton5:
                        imagebutton5Click();
                        break;
                }
            }
        });
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.imageButton6:
                        imagebutton6Click();
                        break;
                }
            }
        });
    }
}
