package com.example.teamcharizard;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivityViewGamesFragment extends Fragment {

    private Button current_game_button;

    public MainActivityViewGamesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.main_activity_view_games_fragment, container, false);
        current_game_button = (Button)v.findViewById(R.id.game1);
        current_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), ChosePlayerActivity.class);
                startActivity(intent);
            }
        });
        for (int x = 0; x < 2/*MainActivity.games.size()*/; x++){
            LinearLayout layout = (LinearLayout) v.findViewById(R.id.layout);
            Button newButton = new Button(getActivity());
            String s = "test string"; //MainActivity.games[x].date + " - " + MainActivity.team.team_name + " vs. " + MainActivity.games[x].opponent;
            newButton.setText(s);
            newButton.setTextSize(20);
            //newButton.setPadding(20,20,20,20);
            newButton.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            newButton.setId(x);
            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonParams.setMargins(0,0,0,8);
            newButton.setLayoutParams(buttonParams);
            /*newButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), ChosePlayerActivity.class);
                    intent.putExtra("game num", view.getId());
                    startActivity(intent);
                }
            });*/
            layout.addView(newButton);
        }
        return v;
    }

}
