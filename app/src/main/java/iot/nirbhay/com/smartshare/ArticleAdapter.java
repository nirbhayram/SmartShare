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

public class ArticleAdapter extends BaseAdapter {
    ArrayList<Article> list;
    Context context;

    public ArticleAdapter(Context c,ArrayList<Article> l){
        this.list = l;
        this.context = c;
    }
    private class ViewHolder {
        //declare items in single item of list view here
        TextView title,course,writtenby,price;
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
        ArticleAdapter.ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(view==null) {
            view = mInflater.inflate(R.layout.single_book_item, null);
            holder = new ArticleAdapter.ViewHolder();
            holder.title = (TextView)view.findViewById(R.id.title);
            holder.course = (TextView)view.findViewById(R.id.course);
            holder.writtenby = (TextView)view.findViewById(R.id.writtenby);
            holder.price = (TextView)view.findViewById(R.id.price);
            view.setTag(holder);
        }
        else {
            holder = (ArticleAdapter.ViewHolder) view.getTag();
        }
        Article temp = list.get(i);
        holder.title.setText(temp.getTitle());
        holder.course.setText(temp.getCourse());
        holder.writtenby.setText("Written by "+temp.getWrittenby());
        holder.price.setText("Price "+temp.getPrice()+" Rs");

        return view;
    }
}
