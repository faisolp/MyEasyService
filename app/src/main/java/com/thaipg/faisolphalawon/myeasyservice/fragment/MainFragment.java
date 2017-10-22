package com.thaipg.faisolphalawon.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.thaipg.faisolphalawon.myeasyservice.R;

/**
 * Created by faisolphalawon on 10/21/2017 AD.
 */

public class MainFragment extends Fragment {
    //Main Method

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //button control
        btnGotSecond_Control();


        // Main Method


    }

    private void btnGotSecond_Control() {

//      //init control
        Button btnGotSecond = getView().findViewById(R.id.btnGotSecond);
        btnGotSecond.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Go to second fragment
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentFragmentMain,new SecondFragment())
                                .addToBackStack(null) //ไม่ถอดหน้ากากเก่าออก
                                .commit();
                    }
                }
        );
    }


    //หน้ากาก

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(
                R.layout.fragment_main
                ,container
                ,false
        );   // XML --> Java
        return  view;


    //    return super.onCreateView(inflater, container, savedInstanceState);

    }
}
