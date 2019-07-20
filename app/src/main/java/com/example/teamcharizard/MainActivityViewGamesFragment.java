package com.example.teamcharizard;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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
        return v;
    }

}
