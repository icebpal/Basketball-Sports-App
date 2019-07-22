package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class PlayerSwapActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    Team UIUC;

    CheckBox[] playercheckboxes = new CheckBox[12];
    TextView[] playernames = new TextView[12];

    int players_selected_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_swap);


        //access the global team which stores the current playing team
        Globals g = (Globals) getApplication();
        UIUC = g.our_team;


        TextView title = findViewById(R.id.playerswaptitle);
        title.setText(UIUC.team_name);


        //find the checkboxes that represent players 1-12
        CheckBox player1checkbox = findViewById(R.id.player1_checkbox);
        CheckBox player2checkbox = findViewById(R.id.player2_checkbox);
        CheckBox player3checkbox = findViewById(R.id.player3_checkbox);
        CheckBox player4checkbox = findViewById(R.id.player4_checkbox);
        CheckBox player5checkbox = findViewById(R.id.player5_checkbox);
        CheckBox player6checkbox = findViewById(R.id.player6_checkbox);
        CheckBox player7checkbox = findViewById(R.id.player7_checkbox);
        CheckBox player8checkbox = findViewById(R.id.player8_checkbox);
        CheckBox player9checkbox = findViewById(R.id.player9_checkbox);
        CheckBox player10checkbox = findViewById(R.id.player10_checkbox);
        CheckBox player11checkbox = findViewById(R.id.player11_checkbox);
        CheckBox player12checkbox = findViewById(R.id.player12_checkbox);

        CheckBox[] checklist = {player1checkbox, player2checkbox, player3checkbox, player4checkbox, player5checkbox, player6checkbox,
                player7checkbox, player8checkbox, player9checkbox, player10checkbox, player11checkbox, player12checkbox};



        //copy newly created checklist of the player's checkboxes into a larger scope list that can be used to check logic in onCheckedChange
        for (int i = 0; i < 12; i++) {
            playercheckboxes[i] = checklist[i];
        }


        //done with checkboxes, now textviews-names and numbers


        //get all the textviews that hold player names
        TextView player1_name = findViewById(R.id.player1_name);
        TextView player2_name = findViewById(R.id.player2_name);
        TextView player3_name = findViewById(R.id.player3_name);
        TextView player4_name = findViewById(R.id.player4_name);
        TextView player5_name = findViewById(R.id.player5_name);
        TextView player6_name = findViewById(R.id.player6_name);
        TextView player7_name = findViewById(R.id.player7_name);
        TextView player8_name = findViewById(R.id.player8_name);
        TextView player9_name = findViewById(R.id.player9_name);
        TextView player10_name = findViewById(R.id.player10_name);
        TextView player11_name = findViewById(R.id.player11_name);
        TextView player12_name = findViewById(R.id.player12_name);

        TextView[] namelist = {player1_name, player2_name, player3_name, player4_name, player5_name, player6_name,
                player7_name, player8_name, player9_name, player10_name, player11_name, player12_name};


        //copy player's name textviews into a larger scope list that can be used in later logic
        for (int i = 0; i < 12; i++) {
            playernames[i] = namelist[i];
        }

        //on the screen, we want the textboxes to hold the names of the players 1-12
        for (int i = 0; i < 12; i++) {
            playernames[i].setText(UIUC.bench_roster[i].name);
        }




        players_selected_count=0;
        //on the screen, we need to select the players that are on the active team
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 5; j++) {
                if (playernames[i].getText() == UIUC.active_roster[j].name) {
                    playercheckboxes[i].setChecked(true);
                    players_selected_count++;
                }

            }
        }

        //done with names, now numbers

        //get the textviews that will hold player numbers, they overlay checkbox buttons
        TextView player1_number = findViewById(R.id.player1_number);
        TextView player2_number = findViewById(R.id.player2_number);
        TextView player3_number = findViewById(R.id.player3_number);
        TextView player4_number = findViewById(R.id.player4_number);
        TextView player5_number = findViewById(R.id.player5_number);
        TextView player6_number = findViewById(R.id.player6_number);
        TextView player7_number = findViewById(R.id.player7_number);
        TextView player8_number = findViewById(R.id.player8_number);
        TextView player9_number = findViewById(R.id.player9_number);
        TextView player10_number = findViewById(R.id.player10_number);
        TextView player11_number = findViewById(R.id.player11_number);
        TextView player12_number = findViewById(R.id.player12_number);


        TextView[] numberlist = {player1_number, player2_number, player3_number, player4_number, player5_number, player6_number,
                player7_number, player8_number, player9_number, player10_number, player11_number, player12_number};

        //set the textviews to the player numbers
        for (int i = 0; i < 12; i++) {
            numberlist[i].setText(Integer.toString(UIUC.bench_roster[i].number));
        }
        //text is for some reason really hard to add to xml so numbers over icons have to be done with textviews over the checkbox circles


        //last but not least, the submit button
        Button teamready = findViewById(R.id.team_ready_button);
        teamready.setOnClickListener(this);







        player1checkbox.setOnCheckedChangeListener(this);
        player2checkbox.setOnCheckedChangeListener(this);
        player3checkbox.setOnCheckedChangeListener(this);
        player4checkbox.setOnCheckedChangeListener(this);
        player5checkbox.setOnCheckedChangeListener(this);
        player6checkbox.setOnCheckedChangeListener(this);
        player7checkbox.setOnCheckedChangeListener(this);
        player8checkbox.setOnCheckedChangeListener(this);
        player9checkbox.setOnCheckedChangeListener(this);
        player10checkbox.setOnCheckedChangeListener(this);
        player11checkbox.setOnCheckedChangeListener(this);
        player12checkbox.setOnCheckedChangeListener(this);

    }




    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.team_ready_button) {
            //on submit, go to some other activity, the global team has changed (as long as you dont go back to main which resets the team)
            Intent intent = new Intent(getApplicationContext(), ChosePlayerActivity.class);
            startActivity(intent);
        }

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //logic for maintaining correct team size and for editing the global variable accordingly



        //players_selected_count is declared before onCreate and was incremented for each non-default member of the active team list
        //we can't have more than five players so if someone tries to select a player button but the team is already full, then unselect the button
        if (players_selected_count >= 5 && buttonView.isChecked() == true) {
            buttonView.setChecked(false);
        }

        //if five or more players are on the list and someone wants to deselect, that's fine
        else if (players_selected_count >= 5 && buttonView.isChecked() == false) {

            //find the player that was deselected and remove the player from the team's active roster
            for (int i = 0; i < 12; i++) {
                if (buttonView == playercheckboxes[i]) {
                    Player remove_player = UIUC.getPlayer(playernames[i].getText().toString());
                    UIUC.remove_player_from_active_roster(remove_player);
                    players_selected_count--;
                    break;
                }
            }
        }

        //if the team is not full, and someone selected a player, find and add that player to the active roster
        else if (players_selected_count < 5 && buttonView.isChecked() == true) {
            for (int i = 0; i < 12; i++) {
                if (buttonView == playercheckboxes[i]) {
                    Player add_player = UIUC.getPlayer(playernames[i].getText().toString());
                    UIUC.add_player_to_active_roster(add_player);
                    players_selected_count++;
                    break;
                }
            }

        }

        //if the team is not full and someone deselects a player, remove that player from the roster
        else if (players_selected_count < 5 && buttonView.isChecked() == false) {
            for (int i = 0; i < 12; i++) {
                if (buttonView == playercheckboxes[i]) {
                    Player remove_player = UIUC.getPlayer(playernames[i].getText().toString());
                    UIUC.remove_player_from_active_roster(remove_player);
                    players_selected_count--;
                    break;
                }
            }
        }

    }
}
