package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class viewnotifications extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnotifications);

        listView = (ExpandableListView) findViewById(R.id.viewnotifications);
        enterData();
        listAdapter = new Expandablelistadapter(this,listDataHeader,listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void enterData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("From " + "manager..... " + "30/12/2016 " + "at " + "13:00");
        listDataHeader.add("From " + "Dr. Mohamed Maher..... " + "24/12/2016 " + "at " + "14:00");
        listDataHeader.add("From " + "manager.... " + "20/12/2016 " + "at " + "20:00");
        listDataHeader.add("From " + "Dr. Youhana Mourad.... " + "18/12/2016 " + "at " + "22:00");

        List<String> firstmsg = new ArrayList<>();
        firstmsg.add("The doctor had to cancel his time slot for certain circumstances, please try to pick another time slot very soon");

        List<String> scndmsg = new ArrayList<>();
        scndmsg.add("Don't forget about what I told you about the medication");

        List<String> thrdmsg = new ArrayList<>();
        thrdmsg.add("The doctor had to cancel his time slot for certain circumstances, please try to pick another time slot very soon");

        List<String> frthmsg = new ArrayList<>();
        frthmsg.add("Your last lab investigation was very good, don't worry");

        listHashMap.put(listDataHeader.get(0), firstmsg);
        listHashMap.put(listDataHeader.get(1), scndmsg);
        listHashMap.put(listDataHeader.get(2), thrdmsg);
        listHashMap.put(listDataHeader.get(3), thrdmsg);

    }
}
