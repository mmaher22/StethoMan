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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.util.Log;
import android.provider.MediaStore;

public class addmedication extends AppCompatActivity implements AsyncResponse{
    BackgroundDoctor asyncTask;
    EditText medicnamet, timet, periodt, commentst;

    String e2;
    int e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmedication);

        medicnamet = (EditText)findViewById(R.id.editText5);
        timet = (EditText)findViewById(R.id.editText11);
        periodt= (EditText)findViewById(R.id.editText12);
        commentst = (EditText)findViewById(R.id.editText13);
        Button btn = (Button) findViewById(R.id.button10);
    }

    public void addingmedc(View view) {
        String medication = medicnamet.getText().toString();
        String time = timet.getText().toString();
        String period = periodt.getText().toString();
        String comments = commentst.getText().toString();
        e1=((StethoMan) this.getApplication()).getid2();

        String id= Integer.toString(e1);
            String type = "medic";

            asyncTask = new BackgroundDoctor(this);
            asyncTask.delegate = this;
            asyncTask.execute(type, id,medication, time, period, comments);
    }

    @Override
    public void processFinish(String output) {
    }
}