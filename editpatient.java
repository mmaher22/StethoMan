package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class editpatient extends AppCompatActivity {

    private void buttonClick1() { startActivity(new Intent("cp3.name.addtopatient"));}
    private void buttonClick2() { startActivity(new Intent("cp3.name.addmedication"));}
    private void buttonClick3() { startActivity(new Intent("cp3.name.addmedicalrecord"));}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpatient);

        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        Button btn = (Button) findViewById(R.id.button8);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedID = rg.getCheckedRadioButtonId();
                switch (selectedID){
                    case R.id.radioButton5:
                        buttonClick1();
                        break;
                    case R.id.radioButton6:
                        buttonClick2();
                        break;
                    case R.id.radioButton7:
                        buttonClick3();
                        break;
                }
            }
        });
    }
}
