package com.example.teamcharizard;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
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

        //Add new game to the list.
        LinearLayout layout = (LinearLayout)v.findViewById(R.id.layout);
        //Get new game info.
        Intent i = getActivity().getIntent();
        if (i!=null && i.getStringExtra("LEFT")!= null && i.getStringExtra("RIGHT")!= null){
            String left = i.getStringExtra("LEFT").toUpperCase();
            String right = i.getStringExtra("RIGHT").toUpperCase();
            String date = i.getStringExtra("DATE");
            if (date != "") {
                //Add new button.
                Button second = new Button(getContext());
                String text = date+ " - " + left + " VS "+ right;
                second.setText(text);
                second.setTextSize(20);
                ViewGroup.LayoutParams lp = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                ((LinearLayoutCompat.LayoutParams) lp).setMargins(0,0,0,8);
                second.setLayoutParams(lp);
                second.setGravity(Gravity.LEFT);
                layout.addView(second);
                second.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), ChosePlayerActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
        return v;
    }

}
