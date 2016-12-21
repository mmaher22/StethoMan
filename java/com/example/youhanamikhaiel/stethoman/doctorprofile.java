package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class doctorprofile extends AppCompatActivity implements AsyncResponse{

    BackgroundPatient  asyncTask;
    TextView dname, dmail, deducation, dfees;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorprofile);

        dname = (TextView)findViewById(R.id.doctorname);
        dmail = (TextView)findViewById(R.id.mail);
        deducation = (TextView)findViewById(R.id.education);
        dfees = (TextView)findViewById(R.id.fees);
        rb = (RatingBar)findViewById(R.id.ratingBar2);
        asyncTask = new BackgroundPatient(this);
        asyncTask.delegate = this;
        asyncTask.execute("getdocdata", Integer.toString(((StethoMan) this.getApplication()).getviewdocid()));
    }

    @Override
    public void processFinish(String output){
        int i=0, j;
        String docname="", docmail="", docedu="", docfees="", docrb="";
        for(i=0; i<output.length(); i++)
        {
            if(output.charAt(i) == '/')break;
            else docname += output.charAt(i);
        }
        for(j = i+1; j<output.length(); j++)
        {
            if(output.charAt(j) == '/')break;
            else docedu += output.charAt(j);
        }
        for(i = j+1; i<output.length(); i++)
        {
            if(output.charAt(i) == '/')break;
            else docfees += output.charAt(i);
        }
        for(j = i+1; j<output.length(); j++)
        {
            if(output.charAt(j) == '/')break;
            else docmail += output.charAt(j);
        }
        for(i = j+1; i<output.length(); i++)
        {
            if(output.charAt(i) == '/')break;
            else docrb += output.charAt(i);
        }
        dname.setText(docname);
        dmail.setText(docmail);
        deducation.setText(docedu);
        dfees.setText(docfees);
        rb.setRating(Float.parseFloat(docrb));
    }
}
