package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class doctoreditinfo extends AppCompatActivity {
    EditText Email, Mobile, Password, Achievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctoreditinfo);
        Email = (EditText)findViewById(R.id.doctoremail);
        Mobile = (EditText)findViewById(R.id.doctormobile);
        Password = (EditText)findViewById(R.id.doctorpassword);
        Achievements = (EditText)findViewById(R.id.awards);
        // 185.27.134.10
    }



    public void UpdateInfo(View view)
    {
        String email = Email.getText().toString();
        String mobile = Mobile.getText().toString();
        String pass = Password.getText().toString();
        String awards = Achievements.getText().toString();
        //startactivity(new Intent(this,))

        String type = "update";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,email,mobile,pass,awards);
    }


}
