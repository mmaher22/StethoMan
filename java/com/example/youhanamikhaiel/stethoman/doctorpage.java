package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class doctorpage extends AppCompatActivity {

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    Button msgtomanager;
    Button button14;

    private void imagebutton1Click() {startActivity(new Intent("cp3.name.sendmsg"));}
    private void imagebutton2Click() {startActivity(new Intent("cp3.name.viewnotifications"));}
    private void imagebutton3Click() {startActivity(new Intent("cp3.name.doctoreditinfo"));}
    private void imagebutton4Click() {startActivity(new Intent("cp3.name.searchforpatient"));}
    private void button14Click() {startActivity(new Intent("cp3.name.editpatient"));}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorpage);

        button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button14Click();
            }
        });

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
    }
}
