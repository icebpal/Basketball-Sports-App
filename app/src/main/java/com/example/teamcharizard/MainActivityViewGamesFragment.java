package com.example.teamcharizard;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivityViewGamesFragment extends Fragment {

    private Button more_info_button;
    private Button game1;
    private Button end_game1;

    public MainActivityViewGamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.main_activity_view_games_fragment, container, false);
        more_info_button = (Button)v.findViewById(R.id.more_info_button_2);
        game1 = (Button)v.findViewById(R.id.game1);
        end_game1 = (Button)v.findViewById(R.id.game2);
        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), ChosePlayerActivity.class);
                startActivity(intent);
            }
        });
        end_game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SummaryActivity.class);
                startActivity(intent);
            }
        });
        more_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), ViewGamesActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }


//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(getActivity().getApplicationContext(), ChosePlayerActivity.class);
//        startActivity(intent);
//    }


}
