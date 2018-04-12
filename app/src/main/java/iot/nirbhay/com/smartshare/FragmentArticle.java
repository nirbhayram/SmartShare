package iot.nirbhay.com.smartshare;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class FragmentArticle extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_book, container, false);

        listView = (ListView)thisView.findViewById(R.id.listview);
        ArticleAdapter bookAdapter = new ArticleAdapter(getActivity(),getList());
        listView.setAdapter(bookAdapter);

        return thisView;
    }
    public ArrayList<Article> getList(){
        ArrayList<Article> list = new ArrayList<Article>();
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        list.add(new Article("Extension to LEACH protocol","IOT","Nirbhay","99","important to network engineering","5"));
        return list;
    }
}
