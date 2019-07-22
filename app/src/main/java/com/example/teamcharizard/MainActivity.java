package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button start_game_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Globals g = (Globals)getApplication();


        g.player1.name =  getResources().getString(R.string.player1_name);
        g.player1.number = 0;
        g.player1.position =  getResources().getString(R.string.guard_position);

        g.player2.setPlayer(g.player2, getResources().getString(R.string.player2_name), 1,  getResources().getString(R.string.guard_position));
        g.player3.setPlayer(g.player3, getResources().getString(R.string.player3_name), 2,  getResources().getString(R.string.forward_position));
        g.player4.setPlayer(g.player4, getResources().getString(R.string.player4_name), 3,  getResources().getString(R.string.guard_position));
        g.player5.setPlayer(g.player5, getResources().getString(R.string.player5_name), 4,  getResources().getString(R.string.guard_position));
        g.player6.setPlayer(g.player6, getResources().getString(R.string.player6_name), 5,  getResources().getString(R.string.guard_position));
        g.player7.setPlayer(g.player7, getResources().getString(R.string.player7_name), 10,  getResources().getString(R.string.guard_position));
        g.player8.setPlayer(g.player8,getResources().getString(R.string.player8_name), 11,  getResources().getString(R.string.guard_position));
        g.player9.setPlayer(g.player9,getResources().getString(R.string.player9_name), 12,  getResources().getString(R.string.guard_position));
        g.player10.setPlayer(g.player10,getResources().getString(R.string.player10_name), 13,  getResources().getString(R.string.guard_position));
        g.player11.setPlayer(g.player11,getResources().getString(R.string.player11_name), 21,  getResources().getString(R.string.forward_position));
        g.player12.setPlayer(g.player12,getResources().getString(R.string.player12_name), 23,  getResources().getString(R.string.forward_position));


        Player[] active = {g.player1, g.player2, g.player3, g.player4, g.player5};
        Player[] bench = {g.player1, g.player2, g.player3, g.player4, g.player5, g.player6, g.player7, g.player8, g.player9, g.player10, g.player11, g.player12};

        g.our_team.team_name =  getResources().getString(R.string.our_team_name);
        g.our_team.set_team_rosters(active, bench);




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
            fr = new MainActivityTeamStatsFragment();
        }else{
            fr = new MainActivityViewGamesFragment();
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fr);
        transaction.commit();
    }

}
