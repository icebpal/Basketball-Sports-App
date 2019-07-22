package com.example.teamcharizard;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivityTeamStatsFragment extends Fragment {

    private Button more_info_button;

    public MainActivityTeamStatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.main_activity_team_stats_fragment, container, false);
        more_info_button = (Button)v.findViewById(R.id.more_info_button);
        more_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), ViewMyTeamActivity.class);
                startActivity(intent);
            }
        });
        Globals g = (Globals)getActivity().getApplication();
        TableLayout tl = (TableLayout) v.findViewById(R.id.team_stats_table);
        if (g.our_team.active_roster[0] == null) {
            Player[] starting = {g.player1, g.player2, g.player3, g.player4, g.player5};
            Player[] bench = {g.player6, g.player7, g.player8, g.player9, g.player10, g.player11, g.player12};
            g.our_team.set_team_rosters(starting, bench);
        }else if (g.our_team.active_roster[0].name == "Default Name"){
            Player[] starting = {g.player1, g.player2, g.player3, g.player4, g.player5};
            Player[] bench = {g.player6, g.player7, g.player8, g.player9, g.player10, g.player11, g.player12};
            g.our_team.set_team_rosters(starting, bench);
        }
        if (true){
            if (g.playerList.length > 0 ){
                for (int x = 0; x < g.playerList.length /* TeamProfileActivity.gameList[game_num] */; x++){
                    TableRow tr = new TableRow(getActivity());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    TextView tv = new TextView(getActivity());
                    Player player;
                    if (x < 5){
                        player = g.our_team.active_roster[x];
                    } else{
                        player = g.our_team.bench_roster[x-5];
                    }
                    tv.setText(player.name); /* get the input from the game action list */
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Integer Fg =player.fgMade + player.fgMissed;
                    String fg = player.fgMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Fg = player.threeMade + player.threeMissed;
                    fg = player.threeMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Fg = player.ftMade + player.ftMissed;
                    fg = player.ftMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText(player.rebounds.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText(player.steals.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText(player.blocks.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText("0");
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Fg = player.ftMade + 2 * player.fgMade + 3 * player.threeMade;
                    tv.setText(Fg.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    Log.v("made it", "here");
                    tl.addView(tr);
                }
            }
        }
        tl.requestLayout();

        return v;
    }

}
