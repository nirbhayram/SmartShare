package iot.nirbhay.com.smartshare;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FragmentBook fragmentBook;
    FragmentArticle fragmentArticle;
    FragmentQPaper fragmentQPaper;
    FragmentLNotes fragmentLNotes;
    LinearLayout book,article,lnotes,qpaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        book = (LinearLayout) findViewById(R.id.book);
        article = (LinearLayout) findViewById(R.id.article);
        qpaper = (LinearLayout) findViewById(R.id.qpaper);
        lnotes = (LinearLayout) findViewById(R.id.lnotes);
        book.setOnClickListener(this);
        article.setOnClickListener(this);
        qpaper.setOnClickListener(this);
        lnotes.setOnClickListener(this);
        onClick(book);
//        ConnectionHelper c =new ConnectionHelper();
//        c.connectionclasss();
    }

    @Override
    public void onClick(View view) {
        getSupportFragmentManager().popBackStack();
        int id = view.getId();
        if (id == R.id.book){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            fragmentBook = new FragmentBook();
            transaction.replace(R.id.container,fragmentBook);
            transaction.addToBackStack(null);
            transaction.commit();
            book.setBackgroundColor(getResources().getColor(R.color.gray));
            article.setBackgroundColor(getResources().getColor(R.color.white));
            lnotes.setBackgroundColor(getResources().getColor(R.color.white));
            qpaper.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else if (id == R.id.article){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            fragmentArticle = new FragmentArticle();
            transaction.replace(R.id.container,fragmentArticle);
            transaction.addToBackStack(null);
            transaction.commit();
            article.setBackgroundColor(getResources().getColor(R.color.gray));
            book.setBackgroundColor(getResources().getColor(R.color.white));
            lnotes.setBackgroundColor(getResources().getColor(R.color.white));
            qpaper.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else if (id==R.id.qpaper){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            fragmentQPaper = new FragmentQPaper();
            transaction.replace(R.id.container,fragmentQPaper);
            transaction.addToBackStack(null);
            transaction.commit();
            qpaper.setBackgroundColor(getResources().getColor(R.color.gray));
            article.setBackgroundColor(getResources().getColor(R.color.white));
            lnotes.setBackgroundColor(getResources().getColor(R.color.white));
            book.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else if (id==R.id.lnotes){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            fragmentLNotes = new FragmentLNotes();
            transaction.replace(R.id.container,fragmentLNotes);
            transaction.addToBackStack(null);
            transaction.commit();
            lnotes.setBackgroundColor(getResources().getColor(R.color.gray));
            article.setBackgroundColor(getResources().getColor(R.color.white));
            book.setBackgroundColor(getResources().getColor(R.color.white));
            qpaper.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getFragments().size()==1) {
            this.finish();
        }
        super.onBackPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.addcar:
                startActivity(new Intent(MainActivity.this,AddMaterial.class));
                //this.finish();
                break;
            default:
                break;
        }

        return true;
    }
}
