package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.*;
import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.View;


public class Managerpage extends AppCompatActivity{

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    Button deleteuserbtn;
    Button addmanagerbtn;
    Button updatepassword;

    private void imagebutton1Click() {startActivity(new Intent("cp3.name.sendmsg"));}
    private void imagebutton2Click() {startActivity(new Intent("cp3.name.viewnotifications"));}
    private void imagebutton3Click() {startActivity(new Intent("cp3.name.addpatient"));}
    private void imagebutton4Click() {startActivity(new Intent("cp3.name.adddoctor"));}
    private void imagebutton5Click() {startActivity(new Intent("cp3.name.editdoctorstimeslot"));}
    private void imagebutton6Click() {startActivity(new Intent("cp3.name.editpatient"));}
    private void button2Click() {startActivity(new Intent("cp3.name.deleteuser"));}
    private void button3Click() {startActivity(new Intent("cp3.name.addmanager"));}
    private void button4Click() {startActivity(new Intent("cp3.name.resetpassword"));}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerpage);

        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.imageButton1:
                        imagebutton1Click();
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
        deleteuserbtn = (Button) findViewById(R.id.deleteuserbtn);
        deleteuserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.deleteuserbtn:
                        button2Click();
                        break;
                }
            }
        });
        addmanagerbtn = (Button) findViewById(R.id.addmanagerbtn);
        addmanagerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.addmanagerbtn:
                        button3Click();
                        break;
                }
            }
        });
        updatepassword = (Button) findViewById(R.id.updatepassword);
        updatepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.updatepassword:
                        button4Click();
                        break;
                }
            }
        });

    }
}
