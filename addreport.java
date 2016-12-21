package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class addreport extends AppCompatActivity implements AsyncResponse{
    BackgroundDoctor asyncTask;
    String e11;
    Button btnn;
    EditText cont,title,spec;
    int e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreport);
        title=(EditText)findViewById(R.id.title);
        spec=(EditText)findViewById(R.id.Specialization);
        cont =(EditText)findViewById(R.id.editText77);
        btnn = (Button) findViewById(R.id.button44);
        System.out.println("rrrr");
    }

    public void report(View view) {
        String tit = title.getText().toString();
        String specialization = spec.getText().toString();
        String content = cont.getText().toString();
        String type = "report";
        e1=((StethoMan) this.getApplication()).getid2();
        String id= Integer.toString(e1);
System.out.println("kn  "+id);
        asyncTask = new BackgroundDoctor(this);
        asyncTask.delegate = this;
        asyncTask.execute(type,id,tit,specialization,content);
    }

    public void processFinish(String output) {
    }
}
