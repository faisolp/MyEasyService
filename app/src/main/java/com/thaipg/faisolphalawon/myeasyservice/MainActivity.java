package com.thaipg.faisolphalawon.myeasyservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thaipg.faisolphalawon.myeasyservice.fragment.MainFragment;

//Main Class
public class MainActivity extends AppCompatActivity {

    // Main Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //เก็บ สถานะล่าสุด หากเป็น Null คือเริ่มจาก o

        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            //สวมหน้ากาก
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain,new MainFragment()).commit();
        }
    }


}
