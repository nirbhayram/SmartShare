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

public class FragmentLNotes extends Fragment{
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_lnotes, container, false);

        listView = (ListView)thisView.findViewById(R.id.listview);
        LNotesAdapter bookAdapter = new LNotesAdapter(getActivity(),getList());
        listView.setAdapter(bookAdapter);

        return thisView;
    }

    public ArrayList<LNotes> getList(){
        ArrayList<LNotes> list = new ArrayList<LNotes>();
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        list.add(new LNotes("System Software Notes","IT215","Nirbhay","0","very helpful for quick revision"));
        return list;
    }
}
