package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class deleteuser extends AppCompatActivity  implements AsyncResponse{
    BackgroundWorker asyncTask1, asyncTask2;
    EditText useridet, usernameet;
    RadioButton rpatient, rdoctor;
    String table, userid, type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteuser);

        rpatient = (RadioButton) findViewById(R.id.radioButton10);
        rdoctor = (RadioButton) findViewById(R.id.radioButton11);
        useridet = (EditText)findViewById(R.id.editText18);
        usernameet = (EditText)findViewById(R.id.editText9);
    }
    public void Ondelsel (View view) {
        type = "delsel";
        userid = useridet.getText().toString();
        if(rdoctor.isChecked()) table = "doctor";
        else table = "patient";
        asyncTask1 = new BackgroundWorker(this);
        asyncTask1.delegate = this;
        asyncTask1.execute(type, userid, table);
    }
    public void Ondeldel (View view) {
        type = "deldel";
        asyncTask2 = new BackgroundWorker(this);
        asyncTask2.delegate = this;
        asyncTask2.execute(type, userid, table);
    }
    @Override
    public void processFinish(String output){
        if(output.contains("User Name")) usernameet.setText(output);
    }

}
