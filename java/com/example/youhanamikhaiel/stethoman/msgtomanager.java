package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class msgtomanager extends AppCompatActivity {

    Button button2;
    private void button2Click() {
        // Here the function of the button titled SEND MESSAGE TO MANAGER
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msgtomanager);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2Click();
            }
        });
    }
}
