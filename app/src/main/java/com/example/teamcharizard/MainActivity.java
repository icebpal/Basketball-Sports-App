package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private Button start_game_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fr;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        fr = new MainActivityTeamStatsFragment();
        transaction.replace(R.id.fragment_container, fr);
        transaction.commit();
        setContentView(R.layout.activity_main);
        start_game_button = (Button)findViewById(R.id.start_game_button);
        start_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartNewGameActivity.class);
                startActivity(intent);
            }
        });
    }

    public void selectFrag(View view){

        Fragment fr;


        if(view == findViewById(R.id.team_stats_button)){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            fr = new MainActivityTeamStatsFragment();
            transaction.replace(R.id.fragment_container, fr);
            transaction.commit();
        }else{
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            fr = new MainActivityViewGamesFragment();
            transaction.replace(R.id.fragment_container, fr);
            transaction.commit();
        }

    }



}
