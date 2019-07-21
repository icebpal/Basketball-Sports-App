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

    private RadioButton player_1, player_2, player_3, player_4, player_5, action1, action2, action3,
            action4, action5, action6, action7, action8, action9, action10;
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
        action1 = (RadioButton)findViewById(R.id.stat1);
        action2 = (RadioButton)findViewById(R.id.stat2);
        action3 = (RadioButton)findViewById(R.id.stat3);
        action4 = (RadioButton)findViewById(R.id.stat4);
        action5 = (RadioButton)findViewById(R.id.stat5);
        action6 = (RadioButton)findViewById(R.id.stat6);
        action7 = (RadioButton)findViewById(R.id.stat7);
        action8 = (RadioButton)findViewById(R.id.stat8);
        action9 = (RadioButton)findViewById(R.id.stat9);
        action10 = (RadioButton)findViewById(R.id.stat10);
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
                /*if (action_group.getCheckedRadioButtonId() == -1){
                    Log.v("action", Integer.toString(action_group.getCheckedRadioButtonId()));
                }else{
                    selectedAction.getText().toString();
                    playerNum = Integer.parseInt(selectedPlayer.getText().toString());
                }*/
                /*int playerOffset = 0;
                TextView textView;
                Integer x;
                while (playerNum != g.gamesList.playersActions[playerOffset].playerNumber){
                    playerOffset++;
                }
                switch(action) {
                    case "opp 3pt fg":
                        textView = (TextView) findViewById(R.id.score2);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 3;
                        textView.setText(x.toString());
                        break;
                    case "opp 2pt fg":
                        textView = (TextView) findViewById(R.id.score2);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 2;
                        textView.setText(x.toString());
                        break;
                    case "3pt fg made":
                        textView = (TextView) findViewById(R.id.score1);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 3;
                        textView.setText(x.toString());
                        g.gamesList.playersActions[playerOffset].threeMade += 1;
                        break;
                    case "3pt fg missed":
                        g.gamesList.playersActions[playerOffset].threeMissed += 1;
                        break;
                    case "2pt fg made":
                        textView = (TextView) findViewById(R.id.score1);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 2;
                        textView.setText(x.toString());
                        g.gamesList.playersActions[playerOffset].fgMade += 1;
                        // need to do the global variations for all of these
                        break;
                    case "2pt fg missed":
                        g.gamesList.playersActions[playerOffset].fgMissed += 1;
                        break;
                    case "ft made":
                        g.gamesList.playersActions[playerOffset].ftMade += 1;
                        break;
                    case "ft missed":
                        g.gamesList.playersActions[playerOffset].ftMissed += 1;
                        break;
                    case "rebound":
                        g.gamesList.playersActions[playerOffset].rebounds += 1;
                        break;
                    case "steal":
                        g.gamesList.playersActions[playerOffset].steals += 1;
                        break;
                    case "block":
                        g.gamesList.playersActions[playerOffset].blocks += 1;
                        break;
                    default:
                        break;
                }*/
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
