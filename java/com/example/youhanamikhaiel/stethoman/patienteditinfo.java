package com.example.youhanamikhaiel.stethoman;
        import android.os.AsyncTask;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;

public class patienteditinfo extends AppCompatActivity {
    EditText Email, Password,Mobile,  Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patienteditinfo);
        Email = (EditText) findViewById(R.id.patientemail);
        Mobile = (EditText) findViewById(R.id.patientmobile);
        Password = (EditText) findViewById(R.id.patientpassword);
        Address = (EditText) findViewById(R.id.patientaddress);
    }

    public void UpdatePatient(View view) {
        String email = Email.getText().toString();
        String mobile = Mobile.getText().toString();
        String password = Password.getText().toString();
        String address = Address.getText().toString();
        String type = "update2";
        BackgroundDoctor backgrounddoctor = new BackgroundDoctor(this);
        backgrounddoctor.execute(type, email, mobile, password, address);
    }

}
