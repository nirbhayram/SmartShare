package iot.nirbhay.com.smartshare;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nirbhay on 14-04-2018.
 */

public class ShowDialougFragment extends DialogFragment {

    TextView materialname,discription,amount,course,category,writtenby,isbn,articleno,paperid,year,ownerid;
    LinearLayout l_writtenby,l_isbn,l_articleno,l_paperid,l_year,l_ownerid;
    Button order;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View thisView = inflater.inflate(R.layout.fragment_show,container,false);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        order = (Button) thisView.findViewById(R.id.order);
        materialname = (TextView) thisView.findViewById(R.id.tx_materialname);
        discription = (TextView) thisView.findViewById(R.id.tx_discription);
        amount = (TextView) thisView.findViewById(R.id.tx_amount);
        course = (TextView) thisView.findViewById(R.id.tx_course);
        category = (TextView) thisView.findViewById(R.id.tx_category);
        writtenby = (TextView) thisView.findViewById(R.id.tx_writtenby);
        isbn = (TextView) thisView.findViewById(R.id.tx_isbn);
        articleno = (TextView) thisView.findViewById(R.id.tx_articleno);
        paperid = (TextView) thisView.findViewById(R.id.tx_paperid);
        year = (TextView) thisView.findViewById(R.id.tx_year);
        ownerid = (TextView) thisView.findViewById(R.id.tx_ownerid);

        l_writtenby = (LinearLayout) thisView.findViewById(R.id.writtenby);
        l_isbn = (LinearLayout) thisView.findViewById(R.id.isbn);
        l_articleno = (LinearLayout) thisView.findViewById(R.id.articleno);
        l_paperid = (LinearLayout) thisView.findViewById(R.id.paperid);
        l_year = (LinearLayout) thisView.findViewById(R.id.year);
        l_ownerid = (LinearLayout) thisView.findViewById(R.id.ownerid);

        if (Data.getWrittenby().equals("")){
            l_writtenby.setVisibility(View.GONE);
        }
        else{
            writtenby.setText(Data.getWrittenby());
        }
        if (Data.getIsbn().equals("")){
            l_isbn.setVisibility(View.GONE);
        }
        else{
            isbn.setText(Data.getIsbn());
        }
        if (Data.getArticleno().equals("")){
            l_articleno.setVisibility(View.GONE);
        }
        else{
            articleno.setText(Data.getArticleno());
        }
        if (Data.getPaperid().equals("")){
            l_paperid.setVisibility(View.GONE);
        }
        else{
            paperid.setText(Data.getPaperid());
        }
        if (Data.getYear().equals("")){
            l_year.setVisibility(View.GONE);
        }
        else{
            year.setText(Data.getYear());
        }
        if (Data.getOwnerid().equals("")){
            l_ownerid.setVisibility(View.GONE);
        }
        else{
            ownerid.setText(Data.getOwnerid());
        }
        materialname.setText(Data.getMaterialname());
        discription.setText(Data.getDiscription());
        amount.setText(Data.getAmount());
        course.setText(Data.getCourse());
        category.setText(Data.getCategory());

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Sorry this functionality is not yet implemented",Toast.LENGTH_SHORT).show();
            }
        });

        return thisView;
    }

    @Override
    public void onResume() {

        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getDialog().getWindow().setGravity(Gravity.CENTER);
        super.onResume();

    }
}
