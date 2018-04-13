package iot.nirbhay.com.smartshare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    TextView register;
    Button login;
    TextInputEditText email,password;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        email = (TextInputEditText) this.findViewById(R.id.email);
        password = (TextInputEditText) this.findViewById(R.id.password);
        register = (TextView) this.findViewById(R.id.regiter);
        login = (Button) this.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(Login.this,Register.class));
                checkUser(new OnGetDataListener() {
                    @Override
                    public void onStart() {
                        progressDialog.setMessage("Loading...");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                    }

                    @Override
                    public void onSuccess(DataSnapshot data) {
                        if (data.getValue()!=null){
                            try {
                                Log.e("+++++", data.child("PASSWORD").getValue().toString() + " gjgjgj");
                                if (password.getText().toString().equals(data.child("PASSWORD").getValue().toString())) {
                                    if (data.child("NAME").getValue()!=null)
                                        User.setName(data.child("NAME").getValue().toString());
                                    if (data.child("ADDRESS").getValue()!=null)
                                        User.setAddress(data.child("ADDRESS").getValue().toString());
                                    if (data.child("EMAIL").getValue()!=null)
                                        User.setEmail(data.child("EMAIL").getValue().toString());
                                    if (data.child("MOBILENO").getValue()!=null)
                                        User.setMobileno(data.child("MOBILENO").getValue().toString());
                                    if (data.child("PASSWORD").getValue()!=null)
                                        User.setPassword(data.child("PASSWORD").getValue().toString());
                                    if (data.child("STUDENTID").getValue()!=null)
                                        User.setStudentid(data.child("STUDENTID").getValue().toString());
                                    if (data.child("COLLEGEID").getValue()!=null)
                                        User.setCollegeid(data.child("COLLEGEID").getValue().toString());
                                    if (data.child("INSTRUCTORID").getValue()!=null)
                                        User.setInstructoeid(data.child("INSTRUCTORID").getValue().toString());
                                    progressDialog.dismiss();
                                    startActivity();
                                } else {
                                    Toast.makeText(Login.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                            }
                            catch (Exception e){
                                Log.e("+++++",e.toString()+"");
                                Toast.makeText(Login.this,"Some error has occured",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                        else{
                            Toast.makeText(Login.this,"User does not exists",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailed(DatabaseError databaseError) {
                        progressDialog.dismiss();
                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }

    public void startActivity(){
        startActivity(new Intent(Login.this,MainActivity.class));
        finishAffinity();
    }
    public void checkUser(final OnGetDataListener getDataListener){
        getDataListener.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("USER").child(trim(email.getText().toString()));
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
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
}
