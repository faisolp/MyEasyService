package com.thaipg.faisolphalawon.myeasyservice;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thaipg.faisolphalawon.myeasyservice.fragment.MainFragment;
import com.thaipg.faisolphalawon.myeasyservice.fragment.SecondFragment;

//Main Class
public class MainActivity extends AppCompatActivity {
    //Set variable
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle ;
    private Toolbar toolbarMain;


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


        //CreateToolBar
        createToolBarMain();

        //ToolbarControl


    }//END Main Method


    //Set Hambager Manu

    // Call Manue
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override  //Comand + N
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();


    }
    //End Hambager Manu

    private void createToolBarMain() {
        toolbarMain = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.openDrawer,
                R.string.closeDrawer
        ) ;
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //Open Home Hamberger
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void textMenuControl() {
        TextView mainTextView = (TextView) findViewById(R.id.txtFrgMainManu);
        TextView secondTextView = (TextView)findViewById(R.id.txtFrgSecondMenu);
        TextView exitTextView =  (TextView) findViewById(R.id.txtExitMenu);

        mainTextView.setOnClickListener(new View.OnClickListener() { //Ctn +Spec


            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new MainFragment())
                        .commit();
                //Close Drawer
                drawerLayout.closeDrawers();
            }
        });
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain,new SecondFragment())
                        .commit();

                //Close Drawer
                drawerLayout.closeDrawers();

            }
        });

        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


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
