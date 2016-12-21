package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class viewnotifications extends AppCompatActivity implements AsyncResponse {

    private ExpandableListView listView;
    BackgroundPatient  asyncTask;
    BackgroundWorker  asyncTask2;
    BackgroundDoctor asyncTask3;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnotifications);

        listView = (ExpandableListView) findViewById(R.id.viewnotifications);

       if(((StethoMan) this.getApplication()).gettype() == 'P') {
            asyncTask = new BackgroundPatient(this);
            asyncTask.delegate = this;
            asyncTask.execute("getmsg", Integer.toString(((StethoMan) this.getApplication()).getid()));
        }
        else if(((StethoMan) this.getApplication()).gettype() == 'M') {
            asyncTask2 = new BackgroundWorker(this);
            asyncTask2.delegate = this;
            asyncTask2.execute("getmsg");
        }
        else {
            asyncTask3 = new BackgroundDoctor(this);
            asyncTask3.delegate = this;
            asyncTask3.execute("getmsg", Integer.toString(((StethoMan) this.getApplication()).getid()));
        }

    }

    @Override
    public void processFinish(String output) {

        if (output.contains("MSG:")) {
            listDataHeader = new ArrayList<>();
            listHashMap = new HashMap<>();
            List<String> msg = new ArrayList<>();
            int count = 0;
            String title = "", body = "";
            Boolean flag = false;
            for (int i = 5; i < output.length(); i++) {
                if (output.charAt(i) == ';') {
                    listDataHeader.add(title);
                    msg.add(body);
                    listHashMap.put(listDataHeader.get(count), msg);
                    msg = new ArrayList<>();
                    body = "";
                    title = "";
                    flag = false;
                    count++;
                } else if (output.charAt(i) == '$') {
                    flag = true;
                } else if (flag) {
                    body += output.charAt(i);
                } else {
                    title += output.charAt(i);
                }
            }
            listAdapter = new Expandablelistadapter(this,listDataHeader,listHashMap);
            listView.setAdapter(listAdapter);
        }
    }
}
