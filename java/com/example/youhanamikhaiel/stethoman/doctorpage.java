package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class doctorpage extends AppCompatActivity {


    Button msgtomanager;
    private void buttonmsgtomanagerClick() {startActivity(new Intent("cp3.name.msgtomanager"));}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorpage);

        msgtomanager = (Button) findViewById(R.id.msgtomanager);
        msgtomanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonmsgtomanagerClick();
            }
        });
    }
}
