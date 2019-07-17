package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class PlayerSwapActivity extends AppCompatActivity {

    int players_selected_count = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_swap);

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

    //    player1checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener());
    //    player2checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()) {


    }

//    public void onCheckedChange(CompoundButton compoundButton, boolean b){
//        @Override
//
//    }


}
