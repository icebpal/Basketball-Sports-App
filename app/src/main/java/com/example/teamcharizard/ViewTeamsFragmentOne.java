package com.example.teamcharizard;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class ViewTeamsFragmentOne extends Fragment {

    public ViewTeamsFragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.view_team_fragment_one,container,false);
        TableLayout tl = (TableLayout) view.findViewById(R.id.fragment_table);
        Integer game_num = -1;
        if (game_num == -1){
            if (true == true /* TeamProfileActivity.gameList.size() > game_num */){
                for (int x = 0; x < 11 /* TeamProfileActivity.gameList[game_num] */; x++){
                    TableRow tr = new TableRow(getActivity());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    for (int y = 0; y < 9; y++) {
                        TextView tv = new TextView(getActivity());
                        tv.setText("1"); /* get the input from the game action list */
                        tv.setTextColor(Color.BLACK);
                        tv.setGravity(Gravity.START);
                        tr.addView(tv);
                    }
                    tl.addView(tr);
                }
                //Integer num = tl.getChildCount();
                //Toast.makeText(getActivity(), num.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        return inflater.inflate(R.layout.view_team_fragment_one, container, false);
    }

}