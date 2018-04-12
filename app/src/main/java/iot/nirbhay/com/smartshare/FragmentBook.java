package iot.nirbhay.com.smartshare;

import android.support.v4.app.Fragment;import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class FragmentBook extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_book, container, false);

        listView = (ListView)thisView.findViewById(R.id.listview);
        BookAdapter bookAdapter = new BookAdapter(getActivity(),getList());
        listView.setAdapter(bookAdapter);

        return thisView;
    }

    public ArrayList<Book> getList(){
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        list.add(new Book("Introduction to programming","IT314","Nirbhay","899","This is usefull book for programming learning experience","13524","5"));
        return list;
    }
}
