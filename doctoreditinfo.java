package com.example.youhanamikhaiel.stethoman;
import android.os.AsyncTask;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;




public class doctoreditinfo extends AppCompatActivity {
    EditText Email, Mobile, Password, Awards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctoreditinfo);

        Email = (EditText) findViewById(R.id.doctoremail);
        Mobile = (EditText) findViewById(R.id.doctormobile);
        Password = (EditText) findViewById(R.id.doctorpassword);
        Awards = (EditText) findViewById(R.id.awards);
        Button btn = (Button) findViewById(R.id.button7);

            }


            public void UpdateInfo(View view) {
                String email = Email.getText().toString();
                String mobile = Mobile.getText().toString();
                String password = Password.getText().toString();
                String awards = Awards.getText().toString();

                String type = "update";
                BackgroundDoctor backgrounddoctor = new BackgroundDoctor(this);
                backgrounddoctor.execute(type, email, mobile, password, awards);
            }

  }
