package iot.nirbhay.com.smartshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class FragmentQPaper extends Fragment{
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_qpaper, container, false);

        listView = (ListView)thisView.findViewById(R.id.listview);
        QPaperAdapter bookAdapter = new QPaperAdapter(getActivity(),getList());
        listView.setAdapter(bookAdapter);

        return thisView;
    }
    public ArrayList<QPaper> getList(){
        ArrayList<QPaper> list = new ArrayList<QPaper>();
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        list.add(new QPaper("<nothing>","IT215","IT215ISEM2","0","nothing more discription paper itself will tell you","2015"));
        return list;
    }

}
