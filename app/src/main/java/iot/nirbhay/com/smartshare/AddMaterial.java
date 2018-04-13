package iot.nirbhay.com.smartshare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMaterial extends AppCompatActivity {
    int to = 0;
    int course = 0;
    Button submit;
    EditText writtenby,isbn,articleno,paperid,year;
    EditText materialname,discription,amount;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_material);

        progressDialog = new ProgressDialog(this);
        submit = (Button) this.findViewById(R.id.submit);
        materialname = (EditText) this.findViewById(R.id.materialname);
        discription = (EditText) this.findViewById(R.id.discription);
        amount = (EditText) this.findViewById(R.id.amount);
        writtenby = (EditText)this.findViewById(R.id.writtenby);
        isbn = (EditText)this.findViewById(R.id.isbn);
        articleno = (EditText)this.findViewById(R.id.articleno);
        paperid = (EditText)this.findViewById(R.id.paperid);
        year = (EditText)this.findViewById(R.id.year);
        Spinner spinner1 = (Spinner) findViewById(R.id.coursespinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.course_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.categoryspinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        setView();
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                to = i;
                setView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                course = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();
                addMaterial();
                progressDialog.dismiss();
                onBackPressed();
            }
        });

    }

    public void setView(){
        if (to==1){
            articleno.setVisibility(View.VISIBLE);
            paperid.setVisibility(View.GONE);
            year.setVisibility(View.GONE);
            writtenby.setVisibility(View.VISIBLE);
            isbn.setVisibility(View.GONE);
        }
        else if (to==2){
            articleno.setVisibility(View.GONE);
            paperid.setVisibility(View.VISIBLE);
            year.setVisibility(View.VISIBLE);
            writtenby.setVisibility(View.GONE);
            isbn.setVisibility(View.GONE);
        }
        else if (to==3){
            articleno.setVisibility(View.GONE);
            paperid.setVisibility(View.GONE);
            year.setVisibility(View.GONE);
            writtenby.setVisibility(View.VISIBLE);
            isbn.setVisibility(View.GONE);
        }
        else if (to==0){
            articleno.setVisibility(View.GONE);
            paperid.setVisibility(View.GONE);
            year.setVisibility(View.GONE);
            writtenby.setVisibility(View.VISIBLE);
            isbn.setVisibility(View.VISIBLE);
        }
    }

    public void addMaterial(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("MATERIAL").child("BOOK");
        if (to==0){
             myRef = database.getReference("MATERIAL").child("BOOK");
        }
        else if (to==1){
            myRef = database.getReference("MATERIAL").child("ARTICLE");
        }
        else if (to==2){
            myRef = database.getReference("MATERIAL").child("QUESTION PAPER");
        }
        else if (to==3){
            myRef = database.getReference("MATERIAL").child("LECTURE NOTES");
        }
        myRef = myRef.push();
        myRef.child("MATERIALNAME").setValue(materialname.getText().toString());
        myRef.child("DISCRIPTION").setValue(discription.getText().toString());
        myRef.child("AMOUNT").setValue(amount.getText().toString());
        myRef.child("OWNERID").setValue(User.getEmail());
        if (to==0){
            myRef.child("WRITTENBY").setValue(writtenby.getText().toString());
            myRef.child("ISBN").setValue(isbn.getText().toString());
        }
        else if (to==1){
            myRef.child("ARTICLENO").setValue(articleno.getText().toString());
            myRef.child("WRITTENBY").setValue(isbn.getText().toString());
        }
        else if (to==2){
            myRef.child("PAPERID").setValue(paperid.getText().toString());
            myRef.child("YEAR").setValue(year.getText().toString());
        }
        else if(to==3){
            myRef.child("WRITTENBY").setValue(writtenby.getText().toString());
        }
        if (course == 0){
            myRef.child("COURSE").setValue("Software Enginnering");
        }
        else if (course == 1){
            myRef.child("COURSE").setValue("System Software");
        }
        else if (course ==2){
            myRef.child("COURSE").setValue("Differential Equation");
        }
        else if (course==3){
            myRef.child("COURSE").setValue("Cryptography");
        }
        else if (course == 4){
            myRef.child("COURSE").setValue("Probability");
        }
        else if (course==5){
            myRef.child("COURSE").setValue("Internet of things");
        }
    }

}
