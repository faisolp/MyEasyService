package com.thaipg.faisolphalawon.myeasyservice;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thaipg.faisolphalawon.myeasyservice.fragment.MainFragment;

//Main Class
public class MainActivity extends AppCompatActivity {
    //Set variable
    private DrawerLayout drawerLayout;

    // Main Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //เก็บ สถานะล่าสุด หากเป็น Null คือเริ่มจาก o

        setContentView(R.layout.activity_main);

        //Add frg to Activity
        addFrgToActivity(savedInstanceState);


        // Setup Drawer Menu
        SetupDrawerMenu();

        //Text Control
        textMenuControl();

        //End Drawer Menu

    }//END Main Method

    private void textMenuControl() {
        TextView mainTextView = (TextView) findViewById(R.id.txtFrgMainManu);
        TextView secondTextView = (TextView)findViewById(R.id.txtFrgSecondMenu);
        TextView exitTextView =  (TextView) findViewById(R.id.txtExitMenu);

        mainTextView.setOnClickListener(new View.OnClickListener() { //Ctn +Spec
            @Override
            public void onClick(View v) {
                //Close Drawer
                drawerLayout.closeDrawers();
            }
        });
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Close Drawer
                drawerLayout.closeDrawers();

            }
        });

        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Close Drawer
                drawerLayout.closeDrawers();
            }
        });


    }

    protected void SetupDrawerMenu() {

         drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayout);

    }

    private void addFrgToActivity(Bundle savedInstanceState) {
        if(savedInstanceState==null){
            //สวมหน้ากาก
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain,new MainFragment()).commit();
        }
    }







}
