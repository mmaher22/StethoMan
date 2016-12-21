package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;

public class editdoctorstimeslot extends AppCompatActivity implements AsyncResponse{
    AutoCompleteTextView docet;
    BackgroundWorker asyncTask, asyncTask2, asyncTask3;
    String type;
    Spinner lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdoctorstimeslot);
        docet = (AutoCompleteTextView) findViewById(R.id.Doctorname);
        lv = (Spinner) findViewById(R.id.slots);

        type = "finddoc";
        asyncTask = new BackgroundWorker(this);
        asyncTask.delegate = this;
        asyncTask.execute(type);
    }
    public void clickadd (View view) {
        Intent i = new Intent(getApplicationContext(), edittimeslots.class);
        startActivity(i);
    }
    public void clickviewslots (View view) {
        type = "findslot";
        //Extract Doctor ID selected
        String docid1="", docid2 = docet.getText().toString();
        int i;
        for(i=0; i<docid2.length(); i++)
        {
            if(docid2.charAt(i) == ':')break;
        }
        for(int j=i+1; j<docid2.length(); j++)docid1 += docid2.charAt(j);

        asyncTask2 = new BackgroundWorker(this);
        asyncTask2.delegate = this;
        asyncTask2.execute(type, docid1);
    }
    public void clickdelslot (View view) {
        type = "delslot";
        //Extract Doctor ID selected
        String slotid1="", slotid2 = lv.getSelectedItem().toString();
        int i;
        for(i=0; i<slotid2.length(); i++)
        {
            if(slotid2.charAt(i) == '*')break;
        }
        for(int j=i+1; j<slotid2.length(); j++)slotid1 += slotid2.charAt(j);

        asyncTask3 = new BackgroundWorker(this);
        asyncTask3.delegate = this;
        asyncTask3.execute(type, slotid1);
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

        else if(output.contains("SLOT")) {
            String str=""; int count = 0;
            for (int i = 5; i < output.length(); i++) {
                if (output.charAt(i) == '/') {
                    count++;
                }
            }
            String doc_arr[]= new String[count];
            count = 0;
            for (int i = 5; i < output.length(); i++) {
                if(output.charAt(i) == '/')
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
            lv.setAdapter(adapter);
        }
        else if(output.contains("Time Slot Deleted")){
            Intent i = new Intent(getApplicationContext(), Managerpage.class);
            startActivity(i);
        }
    }
}
