package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class requestvisit extends AppCompatActivity {

    Button buttonsearch;
    private void button666Click() {startActivity(new Intent("cp3.name.doctorsearch"));}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestvisit);

        buttonsearch = (Button) findViewById(R.id.buttonsearch);
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button666Click();
            }
        });
    }

}
