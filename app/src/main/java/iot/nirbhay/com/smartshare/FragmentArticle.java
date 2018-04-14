package iot.nirbhay.com.smartshare;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class FragmentArticle extends Fragment {
    ArrayList<Article> arrayList;
    ListView listView;
    ProgressDialog progressDialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_article, container, false);

        progressDialog =new ProgressDialog(getActivity());
        listView = (ListView)thisView.findViewById(R.id.listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Article temp = arrayList.get(i);
                Data.reset();
                Data.setCourse(temp.getCourse());
                Data.setMaterialname(temp.getTitle());
                Data.setDiscription(temp.getDiscription());
                Data.setAmount(temp.getPrice());
                Data.setCategory("Article");
                Data.setWrittenby(temp.getWrittenby());
                Data.setArticleno(temp.getArtticleno());
                Data.setOwnerid(temp.getOwnerid());
                ShowDialougFragment dialougFragmentConfirm = new ShowDialougFragment();
                dialougFragmentConfirm.show(getActivity().getFragmentManager(),"confirm");
            }
        });

        list();
        return thisView;
    }


    public void changeAdapter(ArrayList<Article> list){
        arrayList = list;
        listView.setAdapter(null);
        ArticleAdapter bookAdapter = new ArticleAdapter(getActivity(),list);
        listView.setAdapter(bookAdapter);
    }

    public void list(){
        final ArrayList<Article> list = new ArrayList<Article>();
        getBookList(new OnGetDataListener() {
            @Override
            public void onStart() {
                progressDialog.setMessage("Loading");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }

            @Override
            public void onSuccess(DataSnapshot data) {
                for (DataSnapshot snapshot: data.getChildren()){
                    Log.e("++++++",snapshot.child("MATERIALNAME")+" this");
                    try {
                        list.add(new Article(
                                snapshot.child("MATERIALNAME").getValue().toString(),
                                snapshot.child("COURSE").getValue().toString(),
                                snapshot.child("WRITTENBY").getValue().toString(),
                                snapshot.child("AMOUNT").getValue().toString(),
                                snapshot.child("DISCRIPTION").getValue().toString(),
                                snapshot.child("OWNERID").getValue().toString(),
                                snapshot.child("ARTICLENO").getValue().toString()
                        ));
                    }
                    catch (Exception e){
                        Log.e("++++++",e.toString()+" Nirbhay");
                    }
                }
                changeAdapter(list);
                progressDialog.dismiss();
            }

            @Override
            public void onFailed(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
    }

    public void getBookList(final OnGetDataListener onGetDataListener){
        onGetDataListener.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("MATERIAL").child("ARTICLE");
        myRef.addValueEventListener(new ValueEventListener() {
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
    @Override
    public void onResume() {
        listView.setAdapter(null);
        list();
        super.onResume();
    }

}
