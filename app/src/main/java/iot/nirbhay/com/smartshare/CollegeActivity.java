package iot.nirbhay.com.smartshare;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CollegeActivity extends AppCompatActivity {
    ListView listView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colllege);
        progressDialog = new ProgressDialog(this);
        listView = (ListView) this.findViewById(R.id.listview);
        getList();
    }

    public void changeAdapter(ArrayList<College> list){
        CollegeAdapter collegeAdapter = new CollegeAdapter(this,list);
        listView.setAdapter(collegeAdapter);
    }

    public ArrayList<College> getList(){
        final ArrayList<College> list = new ArrayList<College>();
        getCollege(new OnGetDataListener() {
            @Override
            public void onStart() {
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }

            @Override
            public void onSuccess(DataSnapshot data) {
                for (DataSnapshot snapshot:data.getChildren()){
                    list.add(new College(snapshot.getKey().toString(),snapshot.getValue().toString()));
                }
                progressDialog.dismiss();
                changeAdapter(list);
            }

            @Override
            public void onFailed(DatabaseError databaseError) {

                progressDialog.dismiss();
            }
        });
        return list;
    }

    public void getCollege(final OnGetDataListener onGetDataListener){
        onGetDataListener.onStart();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("COLLEGE");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                onGetDataListener.onSuccess(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                onGetDataListener.onFailed(databaseError);
            }
        });
    }

}
