package com.example.youhanamikhaiel.stethoman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class doctorsearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorsearch);
        ArrayList<doctorresult> Items = new ArrayList<doctorresult> ();
        // The items which will be showen is search results for different doctors available
        Items.add(new doctorresult("Dr Youhana Mikhaiel","Cardiology","Fees: 100 LE","Sunday 1/1 3:00 PM"));
        Items.add(new doctorresult("Dr Mohamed Maher","Dentistry","Fees: 75 LE","Monday 2/1 8:00 PM"));
        Items.add(new doctorresult("Dr Youhana Mikhaiel","Cardiology","Fees: 100 LE","Sunday 1/1 3:00 PM"));
        Items.add(new doctorresult("Dr Youhana Mikhaiel","Cardiology","Fees: 100 LE","Sunday 1/1 3:00 PM"));
        Items.add(new doctorresult("Dr Youhana Mikhaiel","Cardiology","Fees: 100 LE","Sunday 1/1 3:00 PM"));
        Items.add(new doctorresult("Dr Youhana Mikhaiel","Cardiology","Fees: 100 LE","Sunday 1/1 3:00 PM"));
        MyCustomAdapter myadpter = new MyCustomAdapter(Items);

        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(myadpter);
    }

    class MyCustomAdapter extends BaseAdapter {
        ArrayList<doctorresult> Items = new ArrayList<doctorresult>();

        MyCustomAdapter(ArrayList<doctorresult> Items) {
            this.Items = Items;

        }


        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public String getItem(int position) {
            return Items.get(position).doctorname;

        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater = getLayoutInflater();
            View view1 = linflater.inflate(R.layout.activity_doctorresult, null);

            TextView doctorname = (TextView) view1.findViewById(R.id.doctorname);
            TextView special = (TextView) view1.findViewById(R.id.special);
            TextView fees = (TextView) view1.findViewById(R.id.fees);
            TextView timeslot = (TextView) view1.findViewById(R.id.timeslot);
            Button button8 = (Button) view1.findViewById(R.id.button8);
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Enter the function of booking the patient to this time slot of this doctor
                }
            });
            doctorname.setText(Items.get(i).doctorname);
            special.setText(Items.get(i).special);
            fees.setText(Items.get(i).fees);
            timeslot.setText(Items.get(i).timeslot);
            return view1;

        }
    }
}
