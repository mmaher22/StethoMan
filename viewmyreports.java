package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class viewmyreports extends AppCompatActivity implements AsyncResponse {

    private ExpandableListView listView;
    BackgroundPatient  asyncTask;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmyreports);

        listView = (ExpandableListView) findViewById(R.id.viewmyreports);

        if(((StethoMan) this.getApplication()).gettype() == 'P') {
            asyncTask = new BackgroundPatient(this);
            asyncTask.delegate = this;
            asyncTask.execute("myreports", Integer.toString(((StethoMan) this.getApplication()).getid()));
        }

    }

    @Override
    public void processFinish(String output) {
        System.out.println("the output here is "+output);
        if (output.contains("REPORT:")) {
            listDataHeader = new ArrayList<>();
            listHashMap = new HashMap<>();
            List<String> msg = new ArrayList<>();
            int count = 0;
            String title = "", body = "";
            Boolean flag = false;
            System.out.println("7ader");
            for (int i = 8; i < output.length(); i++) {
                if (output.charAt(i) == '$') {
                    listDataHeader.add(title);
                    msg.add(body);
                    System.out.println("msh 3arf"+body);

                    listHashMap.put(listDataHeader.get(count), msg);
                    msg = new ArrayList<>();
                    body = "";
                    title = "";
                    flag = false;
                    count++;
                } else if (output.charAt(i) == '^') {
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
