package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class forgotpassword extends AppCompatActivity implements AsyncResponse{
    BackgroundWorker asyncTask;
    EditText useridet, mobet, nameet;
    RadioButton rpatient, rdoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        rpatient = (RadioButton) findViewById(R.id.radioButton2);
        rdoctor = (RadioButton) findViewById(R.id.radioButton3);
        useridet = (EditText)findViewById(R.id.editText3);
        nameet = (EditText)findViewById(R.id.editText);
        mobet = (EditText)findViewById(R.id.editText2);
    }

    public void forgetpass (View view) {
        String userid = useridet.getText().toString();
        String mob = mobet.getText().toString();
        String name = nameet.getText().toString();
        String table;

        if(rpatient.isChecked()) table = "patient";
        else table = "doctor";
        String type = "forget";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute(type, userid, mob, name, table);
    }

    @Override
    public void processFinish(String output){

    }

}
