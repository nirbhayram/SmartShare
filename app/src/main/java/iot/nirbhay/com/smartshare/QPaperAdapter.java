package iot.nirbhay.com.smartshare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nirbhay on 12-04-2018.
 */

public class QPaperAdapter extends BaseAdapter {

    Context context;
    ArrayList<QPaper> list;
    public QPaperAdapter(Context c,ArrayList<QPaper> l){
        this.context = c;
        this.list = l;
    }
    private class ViewHolder {
        //declare items in single item of list view here
        TextView name,course,paperid,price;
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
        QPaperAdapter.ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(view==null) {
            view = mInflater.inflate(R.layout.single_qpaper_item, null);
            holder = new QPaperAdapter.ViewHolder();
            holder.name = (TextView)view.findViewById(R.id.name);
            holder.course = (TextView)view.findViewById(R.id.course);
            holder.paperid = (TextView)view.findViewById(R.id.paperid);
            holder.price = (TextView)view.findViewById(R.id.price);
            view.setTag(holder);
        }
        else {
            holder = (QPaperAdapter.ViewHolder) view.getTag();
        }
        QPaper temp = list.get(i);
        holder.name.setText(temp.getName());
        holder.course.setText(temp.getCourse());
        holder.paperid.setText("Paper ID "+temp.getPaperid());
        holder.price.setText("Price "+temp.getPrice()+" Rs");

        return view;
    }
}
