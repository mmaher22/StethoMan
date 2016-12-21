package com.example.youhanamikhaiel.stethoman;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class edittimeslots extends AppCompatActivity implements AsyncResponse{
    AutoCompleteTextView docet;
    BackgroundWorker asyncTask, asyncTask2;
    String type;
    EditText maxpatet;
    DatePicker dp1;
    TimePicker tp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittimeslots);

        docet = (AutoCompleteTextView)
                findViewById(R.id.doctorname);
        maxpatet = (EditText)findViewById(R.id.editText14);
        dp1 = (DatePicker)findViewById(R.id.datePicker);
        tp1 = (TimePicker)findViewById(R.id.timePicker);

        type = "finddoc";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute(type);
    }

    public void addslot(View view) {
        //Maximum Number of Patients
        String maxpat = maxpatet.getText().toString();

        //Extract Doctor ID selected
        String docid1="", docid2 = docet.getText().toString();
        int i;
        for(i=0; i<docid2.length(); i++)
        {
            if(docid2.charAt(i) == ':')break;
        }
        for(int j=i+1; j<docid2.length(); j++)docid1 += docid2.charAt(j);

        //Extract TimeStamp
        int H, Mi, Y = dp1.getYear(), M = dp1.getMonth(), D = dp1.getDayOfMonth();
        if (Build.VERSION.SDK_INT >= 23 ) {
            H = tp1.getHour(); Mi = tp1.getMinute();
        }
        else {
            H = tp1.getCurrentHour(); Mi = tp1.getCurrentMinute();
        }
        String timestamp = Integer.toString(Y) + "-" + Integer.toString(M+1) + "-" + Integer.toString(D) + " " + Integer.toString(H) + ":" + Integer.toString(Mi) + ":00";

        type = "addslot";
        asyncTask2 = new BackgroundWorker(this);
        asyncTask2.delegate = this;
        asyncTask2.execute(type, maxpat, timestamp, docid1);
    }
    @Override
    public void processFinish(String output){
        if(output.contains("DOC")) {
            String str=""; int count = 0;

            for (int i = 4; i < output.length(); i++) {
                if (output.charAt(i) == '-') {
                    count++;
                }
            }

            String doc_arr[]= new String[count];
            count = 0;
            for (int i = 4; i < output.length(); i++) {
                if(output.charAt(i) == '-')
                {
                    doc_arr[count] = str;
                    str = "";
                    count++;
                }
                else
                {
                    str += output.charAt(i);
                }
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, doc_arr);
            docet.setThreshold(2);
            docet.setAdapter(adapter);
        }
    }
}
