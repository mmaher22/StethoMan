package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class addpatient extends AppCompatActivity implements AsyncResponse  {

    Button buttonupload2;
    EditText nameet, passet, mailet, mobileet, bloodet, addresset, noteet;
    BackgroundWorker asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpatient);

        nameet = (EditText)findViewById(R.id.patientname);
        passet = (EditText)findViewById(R.id.patientpassword);
        mailet = (EditText)findViewById(R.id.patientemail);
        mobileet = (EditText)findViewById(R.id.patientmobile);
        bloodet = (EditText)findViewById(R.id.bloodtype);
        addresset = (EditText)findViewById(R.id.patientaddress);
        noteet = (EditText)findViewById(R.id.medicalnotes);
    }

    public void onaddingpat(View view){
        String name = nameet.getText().toString();
        String mobile = mobileet.getText().toString();
        String mail = mailet.getText().toString();
        String pass = passet.getText().toString();
        String address = addresset.getText().toString();
        String blood = bloodet.getText().toString();
        String notes = noteet.getText().toString();

        String type = "addpat";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute(type, name, mobile, mail, pass, address, blood, notes);
    }

    @Override
    public void processFinish(String output){
    }

}
