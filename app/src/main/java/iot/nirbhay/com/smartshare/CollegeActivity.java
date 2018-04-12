package iot.nirbhay.com.smartshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CollegeActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colllege);

        listView = (ListView) this.findViewById(R.id.listview);
        CollegeAdapter collegeAdapter = new CollegeAdapter(this,getList());
        listView.setAdapter(collegeAdapter);
    }

    public ArrayList<College> getList(){
        ArrayList<College> list = new ArrayList<College>();
        list.add(new College("1","Daiict"));
        list.add(new College("2","Daiict"));
        list.add(new College("3","Daiict"));
        list.add(new College("4","Daiict"));
        list.add(new College("5","Daiict"));
        list.add(new College("6","Daiict"));
        list.add(new College("7","Daiict"));
        return list;
    }
}
