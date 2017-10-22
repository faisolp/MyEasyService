package com.thaipg.faisolphalawon.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thaipg.faisolphalawon.myeasyservice.R;

/**
 * Created by faisolphalawon on 10/22/2017 AD.
 */
//Mann class
public class SecondFragment extends Fragment {
    //Main Methode

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return  view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
