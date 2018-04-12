package iot.nirbhay.com.smartshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddMaterial extends AppCompatActivity {
    int to = 0;
    Button next;
    EditText writtenby,isbn,articleno,paperid,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_material);

        writtenby = (EditText)this.findViewById(R.id.writtenby);
        isbn = (EditText)this.findViewById(R.id.isbn);
        articleno = (EditText)this.findViewById(R.id.articleno);
        paperid = (EditText)this.findViewById(R.id.paperid);
        year = (EditText)this.findViewById(R.id.year);
        next = (Button) this.findViewById(R.id.next);
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
}
