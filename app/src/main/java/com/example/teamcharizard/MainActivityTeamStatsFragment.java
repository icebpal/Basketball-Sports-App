package com.example.teamcharizard;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


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


        return v;
    }

}
