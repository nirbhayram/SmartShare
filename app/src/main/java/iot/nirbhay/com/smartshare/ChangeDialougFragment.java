package iot.nirbhay.com.smartshare;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Nirbhay on 14-04-2018.
 */

public class ChangeDialougFragment extends DialogFragment {
    ProgressDialog progressDialog;
    EditText editText;
    TextView textView;
    Button button;
    String textS="";
    String editS="";
    OnComplete onComplete;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View thisView = inflater.inflate(R.layout.fragment_change, container, false);

        editText = (EditText) thisView.findViewById(R.id.edittext);
        textView = (TextView) thisView.findViewById(R.id.textview);
        button = (Button) thisView.findViewById(R.id.button);
        progressDialog = new ProgressDialog(getActivity());
        editText.setText(editS+"");
        textView.setText(textS+"");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().equals("")) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("USER").child(trim(User.getEmail()));
                    myRef.child(textS).setValue(editText.getText().toString());
                    checkUser(new OnGetDataListener() {
                        @Override
                        public void onStart() {
                            progressDialog.setMessage("Loading...");
                            progressDialog.setCancelable(false);
                            progressDialog.show();
                        }

                        @Override
                        public void onSuccess(DataSnapshot data) {
                            if (data.getValue() != null) {
                                try {
                                    Log.e("+++++", data.child("PASSWORD").getValue().toString() + " gjgjgj");
                                    SharedPreferences.Editor editor = getActivity().getSharedPreferences(Data.getSharedPrefrence(), MODE_PRIVATE).edit();
                                    editor.putString("login", "true");
                                    User.reset();
                                    if (data.child("NAME").getValue() != null) {
                                        User.setName(data.child("NAME").getValue().toString());
                                        editor.putString("name", data.child("NAME").getValue().toString());
                                    }
                                    if (data.child("ADDRESS").getValue() != null) {
                                        User.setAddress(data.child("ADDRESS").getValue().toString());
                                        editor.putString("address", data.child("ADDRESS").getValue().toString());
                                    }
                                    if (data.child("EMAIL").getValue() != null) {
                                        User.setEmail(data.child("EMAIL").getValue().toString());
                                        editor.putString("email", data.child("EMAIL").getValue().toString());
                                    }
                                    if (data.child("MOBILENO").getValue() != null) {
                                        User.setMobileno(data.child("MOBILENO").getValue().toString());
                                        editor.putString("mobileno", data.child("MOBILENO").getValue().toString());
                                    }
                                    if (data.child("PASSWORD").getValue() != null) {
                                        User.setPassword(data.child("PASSWORD").getValue().toString());
                                        editor.putString("password", data.child("PASSWORD").getValue().toString());
                                    }
                                    if (data.child("STUDENTID").getValue() != null) {
                                        User.setStudentid(data.child("STUDENTID").getValue().toString());
                                        editor.putString("studentid", data.child("STUDENTID").getValue().toString());
                                    }
                                    if (data.child("COLLEGEID").getValue() != null) {
                                        User.setCollegeid(data.child("COLLEGEID").getValue().toString());
                                        editor.putString("collegeid", data.child("COLLEGEID").getValue().toString());
                                    }
                                    if (data.child("INSTRUCTORID").getValue() != null) {
                                        User.setInstructoeid(data.child("INSTRUCTORID").getValue().toString());
                                        editor.putString("instructorid", data.child("INSTRUCTORID").getValue().toString());
                                    }
                                    editor.apply();
                                    editor.commit();
                                    onComplete.onComplete();
                                    progressDialog.dismiss();
                                    dismiss();
                                } catch (Exception e) {
                                    Log.e("+++++", e.toString() + "");
                                    Toast.makeText(getActivity(), "Some error has occured", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                            } else {
                                Toast.makeText(getActivity(), "User does not exists", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }

                        @Override
                        public void onFailed(DatabaseError databaseError) {
                            progressDialog.dismiss();
                        }
                    });
                } else {
                    Toast.makeText(getActivity(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return thisView;
    }


    public void checkUser(final OnGetDataListener getDataListener) {
        getDataListener.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("USER").child(trim(User.getEmail()));
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


    public String trim(String key) {
        key = key.replaceAll("\\#", "");
        key = key.replaceAll("\\$", "");
        key = key.replaceAll("\\[", "");
        key = key.replaceAll("\\]", "");
        key = key.replaceAll("\\.", " ");
        return key;
    }

    public String getText() {
        return textS;
    }

    public void setText(String text) {
        this.textS = text;
    }

    public String getEdit() {
        return editS;
    }

    public void setEdit(String edit) {
        this.editS = edit;
    }

    public OnComplete getOnComplete() {
        return onComplete;
    }

    public void setOnComplete(OnComplete onComplete) {
        this.onComplete = onComplete;
    }

    @Override
    public void onResume() {

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getDialog().getWindow().setGravity(Gravity.CENTER);
        super.onResume();

    }

}
