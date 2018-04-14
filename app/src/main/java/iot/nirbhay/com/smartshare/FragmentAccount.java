package iot.nirbhay.com.smartshare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Nirbhay on 14-04-2018.
 */

public class FragmentAccount extends Fragment {

    ImageView ename,emobileno,eaddress,eemail,estudentid,einstructorid,ecollegeid;
    TextView name, mobileno, email,address,studentid,instructorid,collegeid;
    LinearLayout l_studentid,l_instructorid,l_collegeid;
    Button logout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View thisView = inflater.inflate(R.layout.fragment_account, container, false);

        logout = (Button) thisView.findViewById(R.id.logout);
        name = (TextView) thisView.findViewById(R.id.tx_name);
        mobileno = (TextView) thisView.findViewById(R.id.tx_mobileno);
        email = (TextView) thisView.findViewById(R.id.tx_email);
        address = (TextView) thisView.findViewById(R.id.tx_address);
        studentid = (TextView) thisView.findViewById(R.id.tx_studentid);
        instructorid = (TextView) thisView.findViewById(R.id.tx_instructorid);
        collegeid = (TextView) thisView.findViewById(R.id.tx_collegeid);

        ename = (ImageView) thisView.findViewById(R.id.ed_name);
        emobileno = (ImageView) thisView.findViewById(R.id.ed_mobileno);
        eaddress = (ImageView) thisView.findViewById(R.id.ed_address);
        eemail = (ImageView) thisView.findViewById(R.id.ed_email);
        estudentid = (ImageView) thisView.findViewById(R.id.ed_studentid);
        einstructorid = (ImageView) thisView.findViewById(R.id.ed_instructorid);

        l_studentid = (LinearLayout) thisView.findViewById(R.id.studentid);
        l_instructorid = (LinearLayout) thisView.findViewById(R.id.instructorid);
        l_collegeid = (LinearLayout) thisView.findViewById(R.id.collegeid);
        changeView();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getActivity().getSharedPreferences(Data.getSharedPrefrence(), MODE_PRIVATE).edit();
                editor.putString("login","false");
                editor.apply();
                editor.commit();
                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finishAffinity();
            }
        });

        ename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeDialougFragment changeDialougFragment = new ChangeDialougFragment();
                changeDialougFragment.setText("NAME");
                changeDialougFragment.setEdit(User.getName());
                changeDialougFragment.setOnComplete(new OnComplete() {
                    @Override
                    public void onComplete() {
                        changeView();
                    }
                });
                changeDialougFragment.show(getActivity().getFragmentManager(),"OPEN");
            }
        });
        emobileno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeDialougFragment changeDialougFragment = new ChangeDialougFragment();
                changeDialougFragment.setText("MOBILENO");
                changeDialougFragment.setEdit(User.getMobileno());
                changeDialougFragment.setOnComplete(new OnComplete() {
                    @Override
                    public void onComplete() {
                        changeView();
                    }
                });
                changeDialougFragment.show(getActivity().getFragmentManager(),"OPEN");
            }
        });
        eaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeDialougFragment changeDialougFragment = new ChangeDialougFragment();
                changeDialougFragment.setText("ADDRESS");
                changeDialougFragment.setEdit(User.getAddress());
                changeDialougFragment.setOnComplete(new OnComplete() {
                    @Override
                    public void onComplete() {
                        changeView();
                    }
                });
                changeDialougFragment.show(getActivity().getFragmentManager(),"OPEN");
            }
        });
        estudentid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeDialougFragment changeDialougFragment = new ChangeDialougFragment();
                changeDialougFragment.setText("STUDENTID");
                changeDialougFragment.setEdit(User.getStudentid());
                changeDialougFragment.setOnComplete(new OnComplete() {
                    @Override
                    public void onComplete() {
                        changeView();
                    }
                });
                changeDialougFragment.show(getActivity().getFragmentManager(),"OPEN");
            }
        });
        einstructorid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeDialougFragment changeDialougFragment = new ChangeDialougFragment();
                changeDialougFragment.setText("INSTRUCTORID");
                changeDialougFragment.setEdit(User.getInstructoeid());
                changeDialougFragment.setOnComplete(new OnComplete() {
                    @Override
                    public void onComplete() {
                        changeView();
                    }
                });
                changeDialougFragment.show(getActivity().getFragmentManager(),"OPEN");
            }
        });


        return thisView;
    }

    @Override
    public void onResume() {
        changeView();
        super.onResume();
    }

    public void changeView() {
        int user = User.checkUser();

        if (user==0){
            l_instructorid.setVisibility(View.GONE);
            studentid.setText(User.getStudentid());
            collegeid.setText(User.getCollegeid());
        }
        else if (user==1){
            l_studentid.setVisibility(View.GONE);
            instructorid.setText(User.getInstructoeid());
            collegeid.setText(User.getCollegeid());
        }
        else if (user ==2){
            l_studentid.setVisibility(View.GONE);
            l_instructorid.setVisibility(View.GONE);
            l_collegeid.setVisibility(View.GONE);
        }
        else if(user==3){
            l_studentid.setVisibility(View.GONE);
            l_instructorid.setVisibility(View.GONE);
            collegeid.setText(User.getCollegeid());
        }
        name.setText(User.getName());
        mobileno.setText(User.getMobileno());
        email.setText(User.getEmail());
        address.setText(User.getAddress());
    }
}
