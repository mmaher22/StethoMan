package com.example.youhanamikhaiel.stethoman;
import android.provider.MediaStore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.RadioGroup;
import android.graphics.*;
import android.animation.*;
import android.transition.*;
import android.content.*;

//implements AsyncResponse
public class editpatient extends AppCompatActivity implements AsyncResponse{
    BackgroundDoctor asyncTask;
    EditText patientid,editText;
    RadioButton addtopatient, addmedication,report;
Button btn;
    String a;
    char type;
    int g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpatient);
        addmedication = (RadioButton) findViewById(R.id.radioButton6);

        type=((StethoMan) this.getApplication()).gettype();
        if(type=='M'){
            addmedication.setVisibility(View.INVISIBLE);
        }
        else{
            addmedication.setVisibility(View.VISIBLE);
        }
        addtopatient = (RadioButton) findViewById(R.id.radioButton5);
        report = (RadioButton) findViewById(R.id.radioButton77);
        patientid = (EditText) findViewById(R.id.editText10);
        editText = (EditText) findViewById(R.id.editText10);
        btn = (Button) findViewById(R.id.button8);
        a= editText.getText().toString();
    }

            public void pproceed(View view){
                String patient = patientid.getText().toString();
                String table ;
                if(addtopatient.isChecked()) table= "lab";
                else if(addmedication.isChecked()) table = "medication";
               else  if(report.isChecked()) table ="report";
                else table = "";
                String type = "editpat";
                asyncTask = new BackgroundDoctor(this);
                asyncTask.delegate = this;
                asyncTask.execute(type,patient);
            }

    public void processFinish(String output){
        if( output.contains("Found")&& addtopatient.isChecked()) {
            ((StethoMan) this.getApplication()).setid2(Integer.parseInt(patientid.getText().toString()));
            startActivity(new Intent(this,addtopatient.class));
        }
        else if(output.contains("Found") && addmedication.isChecked()){
            ((StethoMan) this.getApplication()).setid2(Integer.parseInt(patientid.getText().toString()));
            startActivity(new Intent(this,addmedication.class));
        }
        else if(output.contains("Found")&& report.isChecked()){
            ((StethoMan) this.getApplication()).setid2(Integer.parseInt(patientid.getText().toString()));
            startActivity(new Intent(this,addreport.class));
        }
        else {
            System.out.println(output);
        }
    }

}
