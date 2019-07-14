package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChosePlayerActivity extends AppCompatActivity {

    private Button player_1, player_2, player_3, player_4, player_5, player_6, player_7, player_8,
            player_9, player_10, viewAction_button;
    static String number =  "Player Number";
    private String player_number;
    private Integer ADD_STATS_ACTIVITY_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_player);
        player_1 = (Button)findViewById(R.id.chose_player_button1);
        player_2 = (Button)findViewById(R.id.chose_player_button2);
        player_3 = (Button)findViewById(R.id.chose_player_button3);
        player_4 = (Button)findViewById(R.id.chose_player_button4);
        player_5 = (Button)findViewById(R.id.chose_player_button5);
        player_6 = (Button)findViewById(R.id.chose_player_button6);
        player_7 = (Button)findViewById(R.id.chose_player_button7);
        player_8 = (Button)findViewById(R.id.chose_player_button8);
        player_9 = (Button)findViewById(R.id.chose_player_button9);
        player_10 = (Button)findViewById(R.id.chose_player_button10);
        viewAction_button = (Button)findViewById(R.id.viewAction_button);
        TextView stats_button = findViewById(R.id.button);
        Button[] players= {player_1, player_2, player_3, player_4, player_5,
            player_6, player_7, player_8, player_9, player_10};
        for(int i = 0; i < 10; i++){
            players[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), AddStatsActivity.class);
                    Button temp = findViewById(view.getId());
                    player_number = temp.getText().toString();
                    intent.putExtra(number, player_number);
                    startActivityForResult(intent, ADD_STATS_ACTIVITY_REQUEST);
                }
            });
        }

        viewAction_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewActionActivity.class);
                startActivity(intent);
            }
        });

        stats_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewTeamsActivity.class);
                startActivity(intent);
            }
        });

    }
    public void onActivityResult(int activityCode, int resultCode, Intent intent){
        if (activityCode == ADD_STATS_ACTIVITY_REQUEST){
            if (resultCode == RESULT_OK){
                // this code block is the point where the stats are added to the total.
                String player_num = intent.getStringExtra(number);
                String action = intent.getStringExtra(AddStatsActivity.Action);
                Toast.makeText(this, player_num, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, action, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
