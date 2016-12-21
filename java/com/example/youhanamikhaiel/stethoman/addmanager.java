package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class addmanager extends AppCompatActivity implements AsyncResponse{
    EditText nameet, passet, mailet, mobileet;
    BackgroundWorker asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmanager);

        nameet = (EditText)findViewById(R.id.managername);
        passet = (EditText)findViewById(R.id.managerpassword);
        mailet = (EditText)findViewById(R.id.manageremail);
        mobileet = (EditText)findViewById(R.id.managermobile);
    }

    public void onaddingman(View view){
        String name = nameet.getText().toString();
        String mobile = mobileet.getText().toString();
        String mail = mailet.getText().toString();
        String pass = passet.getText().toString();

        String type = "addman";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute(type, name, mobile, mail, pass);
    }

    @Override
    public void processFinish(String output){
    }
}
