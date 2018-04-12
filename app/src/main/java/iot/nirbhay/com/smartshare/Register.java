package iot.nirbhay.com.smartshare;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    int to = 0;
    Button submit;
    TextView college;
    TextInputEditText studentid,instructorid,collegeid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
                startActivity(new Intent(Register.this,MainActivity.class));
                finishAffinity();
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
}
