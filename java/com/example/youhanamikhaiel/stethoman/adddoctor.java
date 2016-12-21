package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class adddoctor extends AppCompatActivity  implements AsyncResponse {

    private static final int PICK_IMAGE2 = 100;
    EditText nameet, passet, mailet, mobileet, feeset, eduet;
    AutoCompleteTextView specet;
    BackgroundWorker asyncTask;

    AutoCompleteTextView autocomplete;
    String specialization_arr[]={
            "Dermatology", "Cardiac Surgery", "Family medicine", "Neurology", "Orthopedic surgery",
            "Obstetrics and Gynecology", "Pediatrics", "Psychiatry", "Surgery", "Gastroenterology",
            "Nephrology", "Endocrinology"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adddoctor2);

        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, specialization_arr);
        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);

        nameet = (EditText)findViewById(R.id.doctorname);
        passet = (EditText)findViewById(R.id.doctorpassword);
        mailet = (EditText)findViewById(R.id.doctoremail);
        mobileet = (EditText)findViewById(R.id.doctormobile);
        feeset = (EditText)findViewById(R.id.doctorfees);
        specet = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);
        eduet = (EditText)findViewById(R.id.awards);

    }

    public void onaddingdoc(View view){
        String name = nameet.getText().toString();
        String mobile = mobileet.getText().toString();
        String mail = mailet.getText().toString();
        String pass = passet.getText().toString();
        String fees = feeset.getText().toString();
        String edu = eduet.getText().toString();
        String spec = specet.getText().toString();

        String type = "adddoc";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute(type, name, mobile, mail, pass, fees, edu, spec);
    }

    @Override
    public void processFinish(String output){
    }
}
