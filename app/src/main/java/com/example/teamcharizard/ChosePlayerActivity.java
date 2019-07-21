package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup;

public class ChosePlayerActivity extends AppCompatActivity {

    private RadioButton player_1, player_2, player_3, player_4, player_5;
    private Button viewAction_button, submit_button;
    private RadioGroup player_group, action_group;
    private int prevPressed;
    static String number =  "Player Number";
    private Integer ADD_STATS_ACTIVITY_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_player);
        player_group = (RadioGroup)findViewById(R.id.player_group);
        action_group = (RadioGroup)findViewById(R.id.action_group);
        player_1 = (RadioButton)findViewById(R.id.chose_player_button1);
        player_2 = (RadioButton)findViewById(R.id.chose_player_button2);
        player_3 = (RadioButton)findViewById(R.id.chose_player_button3);
        player_4 = (RadioButton)findViewById(R.id.chose_player_button4);
        player_5 = (RadioButton)findViewById(R.id.chose_player_button5);
        viewAction_button = (Button)findViewById(R.id.viewAction_button);
        submit_button = (Button)findViewById(R.id.submit_chose_player);
        TextView stats_button = findViewById(R.id.button);
        RadioButton[] players= {player_1, player_2, player_3, player_4, player_5};
        player_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup arg0, int selectedId) {
                    int temp = player_group.getCheckedRadioButtonId();
                    RadioButton button = (RadioButton)findViewById(temp);
                    button.setBackground(getResources().getDrawable(R.drawable.round_button_2));
                    if (prevPressed != 0) {
                        button = (RadioButton)findViewById(prevPressed);
                        button.setBackground(getResources().getDrawable(R.drawable.round_button_1));
                    }
                    prevPressed = temp;
                }
            });
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton selectedPlayer = (RadioButton)findViewById(player_group.getCheckedRadioButtonId());
                RadioButton selectedAction = (RadioButton)findViewById(action_group.getCheckedRadioButtonId());
                Globals g = (Globals)getApplication();
                String action = "";
                int playerNum = -1;
                Log.v("player", Integer.toString(player_group.getCheckedRadioButtonId()));
                Log.v("action", Integer.toString(action_group.getCheckedRadioButtonId()));
                if (action_group.getCheckedRadioButtonId() == -1){
                    Log.v("action", Integer.toString(action_group.getCheckedRadioButtonId()));
                }else {
                    action = selectedAction.getText().toString();
                    Log.v("action", action);
                }
                if (player_group.getCheckedRadioButtonId() != -1){
                    playerNum = Integer.parseInt(selectedPlayer.getText().toString());
                }
                int playerOffset = 0;
                TextView textView;
                Integer x;
                /*while (playerNum != g.gamesList.pActions[playerOffset].playerNumber){
                    playerOffset++;
                }*/
                switch(action) {
                    case "Opp 3pt fg":
                        textView = (TextView) findViewById(R.id.score2);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 3;
                        textView.setText(x.toString());

                        Log.v("3pt fg", Integer.toString(action_group.getCheckedRadioButtonId()));
                        break;
                    case "Opp 2pt fg":
                        textView = (TextView) findViewById(R.id.score2);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 2;
                        textView.setText(x.toString());
                        Log.v("2pt fg", Integer.toString(action_group.getCheckedRadioButtonId()));
                        break;
                    case "3pt fg made":
                        textView = (TextView) findViewById(R.id.score1);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 3;
                        textView.setText(x.toString());
                        g.gamesList.pActions[playerOffset].threeMade += 1;
                        break;
                    case "3pt fg missed":
                        g.gamesList.pActions[playerOffset].threeMissed += 1;
                        break;
                    case "2pt fg made":
                        textView = (TextView) findViewById(R.id.score1);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 2;
                        textView.setText(x.toString());
                        g.gamesList.pActions[playerOffset].fgMade += 1;
                        // need to do the global variations for all of these
                        break;
                    case "2pt fg missed":
                        g.gamesList.pActions[playerOffset].fgMissed += 1;
                        break;
                    case "ft made":
                        g.gamesList.pActions[playerOffset].ftMade += 1;
                        break;
                    case "ft missed":
                        g.gamesList.pActions[playerOffset].ftMissed += 1;
                        break;
                    case "Rebound":
                        g.gamesList.pActions[playerOffset].rebounds += 1;
                        break;
                    case "Steal":
                        g.gamesList.pActions[playerOffset].steals += 1;
                        break;
                    case "Block":
                        g.gamesList.pActions[playerOffset].blocks += 1;
                        break;
                    default:
                        break;
                }
            }
        });

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
        super.onActivityResult(activityCode, resultCode, intent);
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
