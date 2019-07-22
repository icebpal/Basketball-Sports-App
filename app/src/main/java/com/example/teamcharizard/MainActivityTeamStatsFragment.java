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
        Toast.makeText(getContext(), g.playerList[11].name, Toast.LENGTH_SHORT).show();
        if (true){
            if (g.playerList.length > 0 ){
                for (int x = 0; x < g.playerList.length /* TeamProfileActivity.gameList[game_num] */; x++){
                    TableRow tr = new TableRow(getActivity());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    TextView tv = new TextView(getActivity());
                    tv.setText(g.playerList[x].name); /* get the input from the game action list */
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Integer Fg = g.playerList[x].fgMade + g.playerList[x].fgMissed;
                    String fg = g.playerList[x].fgMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Fg = g.playerList[x].threeMade + g.playerList[x].threeMissed;
                    fg = g.playerList[x].threeMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Fg = g.playerList[x].ftMade + g.playerList[x].ftMissed;
                    fg = g.playerList[x].ftMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText(g.playerList[x].rebounds.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText(g.playerList[x].steals.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText(g.playerList[x].blocks.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    tv.setText("0");
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(getActivity());
                    Fg = g.playerList[x].ftMade + 2 * g.playerList[x].fgMade + 3 * g.playerList[x].threeMade;
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
