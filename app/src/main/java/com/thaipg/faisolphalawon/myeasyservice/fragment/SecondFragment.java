package com.thaipg.faisolphalawon.myeasyservice.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.thaipg.faisolphalawon.myeasyservice.R;

import java.time.Instant;

/**
 * Created by faisolphalawon on 10/22/2017 AD.
 */
//Mani class
public class SecondFragment extends Fragment {

    private ImageView imageViewHm;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // button control
        btnBackControl();

        //Image Control
        imageControl();

    }

    // Recall to Result Service
    @Override
    public void onActivityResult(int requestCode
            , int resultCode
            , Intent data) {

        //requestCode =1  -->1 array select 1
        //resultCode ผลการทำงาน
        //ผลข้อมูล
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == getActivity().RESULT_OK){
            try { //กัน Error
                Uri uri = data.getData();
                Bitmap bitmap = BitmapFactory.decodeStream(
                        getActivity()
                                .getContentResolver()
                                .openInputStream(uri)

                );
                imageViewHm.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else  {
            Toast.makeText(getActivity(),"Not Choose Image",Toast.LENGTH_SHORT).show();
        }
    }

    //Image Control
    private void imageControl() {
        imageViewHm = getView().findViewById(R.id.imgHm);
        imageViewHm.setOnClickListener(new View.OnClickListener() { //Cnt +Enter
            @Override
            public void onClick(View v) {
                Intent intant =new Intent(Intent.ACTION_GET_CONTENT);
                intant.setType("image/*");
                startActivityForResult(Intent.createChooser(intant,"Please Choose App"), 1);


            }
        });

    }

    private void btnBackControl() {
        Button btnBack = getView().findViewById(R.id.btnBack) ;
        // Ctr + Space
        btnBack.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //Go to Main fragment
                                           getActivity().getSupportFragmentManager().popBackStack();
                                       }
                                   }
        );
    }

    //Main Method
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return  view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }






}
