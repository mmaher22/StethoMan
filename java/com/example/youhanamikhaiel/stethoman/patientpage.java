package com.example.youhanamikhaiel.stethoman;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class patientpage extends AppCompatActivity implements AsyncResponse {

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    BackgroundPatient asyncTask;

    private void imagebutton1Click() {
        startActivity(new Intent("cp3.name.sendmsg"));
    }

    private void imagebutton2Click() {
        startActivity(new Intent("cp3.name.viewnotifications"));
    }

    private void imagebutton3Click() {
        startActivity(new Intent("cp3.name.patienteditinfo"));
    }

    private void imagebutton4Click() {
        startActivity(new Intent("cp3.name.searchforpatient"));
    }

    private void imagebutton5Click() {
        startActivity(new Intent("cp3.name.requestvisit"));
    }

    private void imagebutton6Click() {
        startActivity(new Intent("cp3.name.reviewdoctor"));
    }


    //@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientpage);

        /*Calendar current = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.set(2016,
                12,
                20,
                00,
                06,
                00);

        if (cal.compareTo(current) <= 0) {
            //The set Date/Time already passed
            Toast.makeText(getApplicationContext(),
                    "Invalid Date/Time",
                    Toast.LENGTH_LONG).show();
        } else {
            setAlarm(cal);
        }
        System.out.println("a7aaaaaaaa");*/
       // asyncTask = new BackgroundPatient(this);
       // asyncTask.delegate = this;
       // asyncTask.execute("getalarm", Integer.toString(1));//Integer.toString(((StethoMan) this.getApplication()).getid()));

        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageButton2:
                        imagebutton2Click();
                        break;
                }
            }
        });
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageButton3:
                        imagebutton3Click();
                        break;
                }
            }
        });
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageButton4:
                        imagebutton4Click();
                        break;
                }
            }
        });
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageButton5:
                        imagebutton5Click();
                        break;
                }
            }
        });
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.imageButton6:
                        imagebutton6Click();
                        break;
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void processFinish(String output) {
        /*System.out.println("haha " + output);
        String medname = "", strdate = "", strtimes = "", strinterval = "";
        int syear, smonth, sday, times, interval;
        int i = 0, count = 0;
        for (i = 0; i < output.length(); i++) {
            if (output.charAt(i) == '+') count++;
            else if (output.charAt(i) == '+') {
                count = 0;
                interval = Integer.parseInt(strinterval) * 60 * 60 * 1000;
                times = Integer.parseInt(strtimes);
                for (int j = 0; j < times; j++) {
                    Calendar current = Calendar.getInstance();
                    Calendar cal = Calendar.getInstance();
                    cal.set(2016,
                            12,
                            20,
                            22,
                            30,
                            00);

                    if (cal.compareTo(current) <= 0) {
                        //The set Date/Time already passed
                        Toast.makeText(getApplicationContext(),
                                "Invalid Date/Time",
                                Toast.LENGTH_LONG).show();
                    } else {
                        setAlarm(cal);
                    }
                }
                medname = "";
                strdate = "";
                strtimes = "";
                strinterval = "";
            } else if (count == 0) medname += output.charAt(i);
            else if (count == 1) strdate += output.charAt(i);
            else if (count == 2) strtimes += output.charAt(i);
            else if (count == 3) strinterval += output.charAt(i);
        }*/

    }


}
