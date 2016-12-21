package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.graphics.*;
import android.animation.*;
import android.transition.*;
import android.widget.*;
import android.content.*;

import static com.example.youhanamikhaiel.stethoman.R.id.activity_forgotpassword;
import static com.example.youhanamikhaiel.stethoman.R.id.textView;


public class Login extends AppCompatActivity implements AsyncResponse{
    BackgroundWorker asyncTask;
    EditText useridet, passet;
    RadioButton rmanager, rdoctor;
    TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rmanager = (RadioButton) findViewById(R.id.radioButton1);
        rdoctor = (RadioButton) findViewById(R.id.radioButton2);
        useridet = (EditText)findViewById(R.id.editText);
        passet = (EditText)findViewById(R.id.editText2);
        tView = (TextView)this.findViewById(R.id.textView3);

        tView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), forgotpassword.class);
                startActivity(intent);
            }
        });
    }


    public void OnLogin (View view) {
        String userid = useridet.getText().toString();
        String pass = passet.getText().toString();
        String table;

        if(rmanager.isChecked()) table = "manager";
        else if(rdoctor.isChecked()) table = "doctor";
        else table = "patient";
        String type = "login";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute(type, userid, pass, table);
    }

    @Override
     public void processFinish(String output){
            if(output.contains("Logged") && rmanager.isChecked())
            {
                ((StethoMan) this.getApplication()).setid(Integer.parseInt(useridet.getText().toString()), 'M');
                Intent i = new Intent(getApplicationContext(), Managerpage.class);
                startActivity(i);
            }
            else if(output.contains("Logged") && rdoctor.isChecked())
            {
                ((StethoMan) this.getApplication()).setid(Integer.parseInt(useridet.getText().toString()), 'D');
                Intent i = new Intent(getApplicationContext(),doctorpage.class);
                startActivity(i);
            }
            else if(output.contains("Logged"))
            {
                ((StethoMan) this.getApplication()).setid(Integer.parseInt(useridet.getText().toString()), 'P');
                Intent i = new Intent(getApplicationContext(),patientpage.class);
                startActivity(i);
            }
        }

}
