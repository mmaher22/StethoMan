package com.example.youhanamikhaiel.stethoman;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RatingBar;

public class reviewdoctor extends AppCompatActivity implements AsyncResponse{

    RatingBar review;
    AutoCompleteTextView dret;
    String type="";
    BackgroundPatient asyncTask, asyncTask2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewdoctor);

        dret = (AutoCompleteTextView) findViewById(R.id.doctorid);
        review = (RatingBar) findViewById(R.id.ratingBar);
        type = "finddocreview";
        asyncTask = new BackgroundPatient(this);
        asyncTask.delegate = this;
        asyncTask.execute(type, Integer.toString(((StethoMan) this.getApplication()).getid()));
    }
    public void addreview(View view) {
        //Extract Rating
        float rating = review.getRating();
        //Extract Doctor ID selected
        String docid1="", docid2 = dret.getText().toString();
        int i;
        for(i=0; i<docid2.length(); i++)
        {
            if(docid2.charAt(i) == ':')break;
        }
        for(int j=i+1; j<docid2.length(); j++)docid1 += docid2.charAt(j);

        type = "addreview";
        asyncTask2 = new BackgroundPatient(this);
        asyncTask2.delegate = this;
        asyncTask2.execute(type, docid1, Float.toString(rating), Integer.toString(((StethoMan) this.getApplication()).getid()));
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
            dret.setThreshold(2);
            dret.setAdapter(adapter);
        }
    }
}
