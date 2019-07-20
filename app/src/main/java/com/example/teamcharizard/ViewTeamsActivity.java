package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class ViewTeamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_teams);
    }

    public void selectFrag(View view){

        Fragment fr;

//        if(view == findViewById(R.id.team1_button)){
//            fr = new ViewTeamsFragmentOne();
//        }else{
//            fr = new ViewTeamsFragmentTwo();
//        }
        if(view == findViewById(R.id.team1_button)){
            fr = new ViewTeamsFragmentOne();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment, fr);
            transaction.commit();
        }
        if(view == findViewById(R.id.team2_button)){
            fr = new ViewTeamsFragmentTwo();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment, fr);
            transaction.commit();
        }

//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.fragment, fr);
//        transaction.commit();
    }
}
