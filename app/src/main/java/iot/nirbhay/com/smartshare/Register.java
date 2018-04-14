package iot.nirbhay.com.smartshare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    int to = 0;
    Button submit;
    TextView college;
    ProgressDialog progressDialog;
    TextInputEditText studentid,instructorid,collegeid;
    TextInputEditText name, mobileno,email,password,repassword,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(this);
        name = (TextInputEditText) this.findViewById(R.id.name);
        mobileno = (TextInputEditText) this.findViewById(R.id.mobileno);
        email = (TextInputEditText) this.findViewById(R.id.email);
        password = (TextInputEditText) this.findViewById(R.id.password);
        repassword = (TextInputEditText) this.findViewById(R.id.repassword);
        address = (TextInputEditText) this.findViewById(R.id.address);
        studentid = (TextInputEditText) this.findViewById(R.id.studentid);
        instructorid = (TextInputEditText) this.findViewById(R.id.instructorid);
        collegeid = (TextInputEditText) this.findViewById(R.id.collegeid);
        college = (TextView) this.findViewById(R.id.college);
        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,CollegeActivity.class));
            }
        });

        submit = (Button) this.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Register.this,MainActivity.class));
                //finishAffinity();
                checkValid();
            }
        });
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        setView();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Register.this,i+" this is i",Toast.LENGTH_SHORT).show();
                to = i;
                setView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void setView(){
        if (to==0){
            studentid.setVisibility(View.VISIBLE);
            instructorid.setVisibility(View.GONE);
            collegeid.setVisibility(View.VISIBLE);
            college.setVisibility(View.VISIBLE);
        }
        else if (to==1){
            studentid.setVisibility(View.GONE);
            instructorid.setVisibility(View.VISIBLE);
            collegeid.setVisibility(View.VISIBLE);
            college.setVisibility(View.VISIBLE);
        }
        else if(to==2){
            studentid.setVisibility(View.GONE);
            instructorid.setVisibility(View.GONE);
            collegeid.setVisibility(View.GONE);
            college.setVisibility(View.GONE);
        }
        else if (to==3){
            studentid.setVisibility(View.GONE);
            instructorid.setVisibility(View.GONE);
            collegeid.setVisibility(View.VISIBLE);
            college.setVisibility(View.VISIBLE);
        }
    }

    public void startActivity(){
        startActivity(new Intent(Register.this,Login.class));
        finishAffinity();
    }

    public void registerUser(){
        checkUser(new OnGetDataListener() {
            @Override
            public void onStart() {
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }

            @Override
            public void onSuccess(DataSnapshot data) {
                if (data.getValue()==null){
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("USER").child(trim(email.getText().toString()));
                    myRef.child("NAME").setValue(name.getText().toString());
                    myRef.child("MOBILENO").setValue(mobileno.getText().toString());
                    myRef.child("EMAIL").setValue(email.getText().toString());
                    myRef.child("PASSWORD").setValue(password.getText().toString());
                    myRef.child("ADDRESS").setValue(address.getText().toString());
                    if (to==0){
                        myRef.child("STUDENTID").setValue(studentid.getText().toString());
                        myRef.child("COLLEGEID").setValue(collegeid.getText().toString());
                    }
                    else if (to==1){
                        myRef.child("INSTRUCTORID").setValue(instructorid.getText().toString());
                        myRef.child("COLLEGEID").setValue(collegeid.getText().toString());
                    }
                    else if (to==2){

                    }
                    else if (to==3){
                        myRef.child("COLLEGEID").setValue(collegeid.getText().toString());
                    }
                    progressDialog.dismiss();
                    startActivity();
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(Register.this,"User already registered",Toast.LENGTH_SHORT).show();
                }
                Log.e("+++++",data.toString()+" ");
            }
            @Override
            public void onFailed(DatabaseError databaseError) {
                Log.e("+++++",databaseError.toString()+" ");
                progressDialog.dismiss();
            }
        });
    }

    public void checkUser(final OnGetDataListener getDataListener){
        getDataListener.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("USER").child(trim(email.getText().toString()));
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                getDataListener.onSuccess(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                getDataListener.onFailed(error);
            }
        });
    }

    public String trim(String key){
        key = key.replaceAll("\\#","");
        key = key.replaceAll("\\$","");
        key = key.replaceAll("\\[","");
        key = key.replaceAll("\\]","");
        key = key.replaceAll("\\."," ");
        return key;
    }

    public boolean  checkValid(){
        if (name.getText().toString().equals("")){
            Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mobileno.getText().toString().equals("")){
            Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.getText().toString().equals("")){
            Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (address.getText().toString().equals("")){
            Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.getText().toString().equals("")){
            Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (repassword.getText().toString().equals("")){
            Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.getText().toString().equals(repassword.getText().toString())){
            Toast.makeText(Register.this,"Password does not match",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (to==0){
            if (studentid.getText().toString().equals("")){
                Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
                return false;
            }
            if (collegeid.getText().toString().equals("")){
                Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
                return false;
            }
            getList(collegeid.getText().toString());
        }
        else if (to==1) {
            if (instructorid.getText().toString().equals("")) {
                Toast.makeText(Register.this, "Please fill all entry", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (collegeid.getText().toString().equals("")) {
                Toast.makeText(Register.this, "Please fill all entry", Toast.LENGTH_SHORT).show();
                return false;
            }
            getList(collegeid.getText().toString());
        }
        else if (to==3){
            if (collegeid.getText().toString().equals("")){
                Toast.makeText(Register.this,"Please fill all entry",Toast.LENGTH_SHORT).show();
                return false;
            }
            getList(collegeid.getText().toString());
        }
        else{
            registerUser();
        }
        return true;
    }

    public void getList(final String id){
        final ArrayList<String> list = new ArrayList<String>();
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
                    if (snapshot.getKey().toString().equals(id)) {
                        registerUser();
                        progressDialog.dismiss();
                        return;
                    }
                }
                Toast.makeText(Register.this,"College ID does not match",Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onFailed(DatabaseError databaseError) {

                progressDialog.dismiss();
            }
        });
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
