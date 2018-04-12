package iot.nirbhay.com.smartshare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class CollegeAdapter extends BaseAdapter {
    ArrayList<College> list;
    Context context;
    private class ViewHolder {
        //declare items in single item of list view here
        TextView id,name;
    }

    public CollegeAdapter(Context c,ArrayList<College> l){
        this.context = c;
        this.list = l;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CollegeAdapter.ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(view==null) {
            view = mInflater.inflate(R.layout.single_college_item, null);
            holder = new CollegeAdapter.ViewHolder();
            holder.id = (TextView)view.findViewById(R.id.id);
            holder.name = (TextView)view.findViewById(R.id.name);
            view.setTag(holder);
        }
        else {
            holder = (CollegeAdapter.ViewHolder) view.getTag();
        }
        College temp = list.get(i);
        holder.id.setText(temp.getId());
        holder.name.setText(temp.getName());

        return view;
    }
}
