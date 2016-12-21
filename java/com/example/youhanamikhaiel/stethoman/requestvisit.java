package com.example.youhanamikhaiel.stethoman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class requestvisit extends AppCompatActivity implements AsyncResponse{

    DatePicker dp1;
    ImageButton viewdoc, book;
    BackgroundPatient  asyncTask, asyncTask2;
    AutoCompleteTextView autocomplete;
    Spinner slots;
    String slotid1, slotid2, docid="";
    String specialization_arr[]={
            "Dermatology", "Cardiac Surgery", "Family medicine", "Neurology", "Orthopedic surgery",
            "Obstetrics and Gynecology", "Pediatrics", "Psychiatry", "Surgery", "Gastroenterology",
            "Nephrology", "Endocrinology"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestvisit);
        //Image Buttons (View Doc - Book)
        viewdoc = (ImageButton)findViewById(R.id.bookimg);
        book = (ImageButton)findViewById(R.id.viewdocimg);
        //Date Picker
        dp1 = (DatePicker)findViewById(R.id.datePicker);
        //AutoComplete Specialization
        autocomplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, specialization_arr);
        autocomplete.setThreshold(1);
        autocomplete.setAdapter(adapter);
        //Spinner Slots
        slots = (Spinner) findViewById(R.id.slots);
    }

    public void findatslot(View view) {
        //Get Specialization
        String spec = autocomplete.getText().toString();
        //Extract TimeStamp
        int Y = dp1.getYear(), M = dp1.getMonth(), D = dp1.getDayOfMonth();

        String timestamp = Integer.toString(Y) + "-" + Integer.toString(M+1) + "-" + Integer.toString(D);

        asyncTask2 = new BackgroundPatient(this);
        asyncTask2.delegate = this;
        asyncTask2.execute("findatslot", timestamp, spec);
    }

    public void setappointment(View view) {
        //Get Slotid
        slotid1=""; slotid2 = slots.getSelectedItem().toString(); docid="";
        int p1=0, p2=0, p3=0;
        for(int i=0; i<slotid2.length(); i++)
        {
            if(slotid2.charAt(i) == '*')p3 = i;
            else if(slotid2.charAt(i) == '(')p1 = i;
            else if(slotid2.charAt(i) == ')')p2 = i;
        }
        for(int j=p3+1; j<slotid2.length(); j++)slotid1 += slotid2.charAt(j);
        for(int j=p1+1; j < p2; j++)docid += slotid2.charAt(j);
        //Get Doctorid
        asyncTask = new BackgroundPatient(this);
        asyncTask.delegate = this;
        asyncTask.execute("setappointment", docid, slotid1, Integer.toString(((StethoMan) this.getApplication()).getid()));
    }
    public void viewdoctor(){
        ((StethoMan) this.getApplication()).setviewdocid(Integer.parseInt(docid));
        Intent i = new Intent(getApplicationContext(),doctorprofile.class);
        startActivity(i);
    }
    @Override
    public void processFinish(String output){
        if(output.contains("SLOT")) {
            String str=""; int count = 0;
            for (int i = 5; i < output.length(); i++) {
                if (output.charAt(i) == '/') {
                    count++;
                }
            }
            String doc_arr[]= new String[count];
            if(count > 0) {
                book.setVisibility(View.VISIBLE);
                viewdoc.setVisibility(View.VISIBLE);
            }
            else{
                book.setVisibility(View.GONE);
                viewdoc.setVisibility(View.GONE);
            }
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
            slots.setAdapter(adapter);
        }
    }
}
