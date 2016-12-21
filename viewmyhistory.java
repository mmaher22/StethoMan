package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class viewmyhistory extends AppCompatActivity implements AsyncResponse {
    BackgroundPatient asyncTask;
    RadioButton report;


    Button btn;
    String a;
    char type;
    int e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmyhistory);
        report = (RadioButton) findViewById(R.id.radioButton6);
        btn = (Button) findViewById(R.id.button122);

    }

    public void viewmedic(View view) {
        String table;
        e1 = ((StethoMan) this.getApplication()).getid2();

        String id = Integer.toString(e1);

        String type = "rep";
        asyncTask = new BackgroundPatient(this);
        asyncTask.delegate = this;
        asyncTask.execute(type, id);
        System.out.println("idd is "+ id);
    }


    public void processFinish(String output) {
        if (output.contains("Found") && report.isChecked()) {
            ((StethoMan) this.getApplication()).setid2(e1);


            startActivity(new Intent(this, viewmyreports.class));
        }

    }
}