package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;

public class sendmsg extends AppCompatActivity implements AsyncResponse {
    AutoCompleteTextView useret;
    BackgroundWorker asyncTask, asyncTask2;
    BackgroundPatient asyncTask3, asyncTask4;
    BackgroundDoctor asyncTask5, asyncTask6;
    EditText msget;
    String type;
    CheckBox tomanager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmsg);
        useret = (AutoCompleteTextView)findViewById(R.id.touserbox);
        msget = (EditText)findViewById(R.id.editText4);
        tomanager = (CheckBox)findViewById(R.id.checkBox);

        if( ((StethoMan) this.getApplication()).gettype() == 'M'){
            tomanager.setVisibility(View.GONE) ;
            type = "finduser";
            asyncTask = new BackgroundWorker(this);
            asyncTask.delegate = this;
            asyncTask.execute(type);
        }
        else if(((StethoMan) this.getApplication()).gettype() == 'P'){
            type = "findmydoc";
            asyncTask3 = new BackgroundPatient(this);
            asyncTask3.delegate = this;
            asyncTask3.execute(type, Integer.toString(((StethoMan) this.getApplication()).getid()));
        }
        else{
            type = "findmypat";
            asyncTask5 = new BackgroundDoctor(this);
            asyncTask5.delegate = this;
            asyncTask5.execute(type, Integer.toString(((StethoMan) this.getApplication()).getid()));
        }
    }
    public void sendsms(View view) {
        //Msg Content
        String msg = msget.getText().toString();
        //Get ToId
        String userid1="", userid2 = useret.getText().toString(), table="doctor";
        int i;
        for(i=0; i<userid2.length(); i++)
        {
            if(userid2.charAt(i) == ':')break;
            else if(userid2.charAt(i) == '(' && userid2.charAt(i+1) == 'p')table = "patient";
        }
        for(int j=i+1; j<userid2.length(); j++)userid1 += userid2.charAt(j);

        type = "sendsms";
        if( ((StethoMan) this.getApplication()).gettype() == 'M'){
            asyncTask2 = new BackgroundWorker(this);
            asyncTask2.delegate = this;
            asyncTask2.execute(type, msg, userid1, table);
        }
        else if( ((StethoMan) this.getApplication()).gettype() == 'P'){
            if(tomanager.isChecked()){
                userid1 = "0";
                table = "manager";
            }
            asyncTask4 = new BackgroundPatient(this);
            asyncTask4.delegate = this;
            asyncTask4.execute(type, msg, userid1, table, Integer.toString(((StethoMan) this.getApplication()).getid()));
        }
        else {
            if(tomanager.isChecked()){
                userid1 = "0";
                table = "manager";
            }
            asyncTask6 = new BackgroundDoctor(this);
            asyncTask6.delegate = this;
            asyncTask6.execute(type, msg, userid1, table, Integer.toString(((StethoMan) this.getApplication()).getid()));
        }

    }
    @Override
    public void processFinish(String output){
        if(output.contains("USER") || output.contains("MYDOC") || output.contains("MYPAT")) {
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
            useret.setThreshold(2);
            useret.setAdapter(adapter);
        }
    }
}
