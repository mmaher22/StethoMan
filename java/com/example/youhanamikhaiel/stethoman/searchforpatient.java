package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;

public class searchforpatient extends AppCompatActivity implements AsyncResponse{
    EditText patet;
    RadioButton rb7, rb6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchforpatient);
        patet = (EditText) findViewById(R.id.patientID);
        rb6 = (RadioButton)findViewById(R.id.radioButton6);
        rb7 = (RadioButton)findViewById(R.id.radioButton7);
    }
    public void showpat(View v){
        if(rb6.isChecked()){
        }
        else{
            ((StethoMan) this.getApplication()).setviewpatid(Integer.parseInt(patet.getText().toString()));
            Intent i = new Intent(getApplicationContext(),viewmyreports.class);
            startActivity(i);
        }
    }
    @Override
    public void processFinish(String output){
    }
}
