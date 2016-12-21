package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class resetpassword extends AppCompatActivity implements AsyncResponse{

    EditText useridet;
    BackgroundWorker asyncTask;
    RadioButton rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        useridet = (EditText)findViewById(R.id.userid);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
    }

    public void resetpass(View view){
        String userid = useridet.getText().toString(), table="patient";
        if(rb2.isChecked())table = "doctor";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute("resetpass", userid, table);
    }

    public void processFinish(String output){
    }
}
