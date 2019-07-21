package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        action1 = (RadioButton)findViewById(R.id.add_stat1);
        action2 = (RadioButton)findViewById(R.id.add_stat2);
        action3 = (RadioButton)findViewById(R.id.add_stat3);
        action4 = (RadioButton)findViewById(R.id.add_stat4);
        action5 = (RadioButton)findViewById(R.id.add_stat5);
        action6 = (RadioButton)findViewById(R.id.add_stat6);
        action7 = (RadioButton)findViewById(R.id.add_stat7);
        action8 = (RadioButton)findViewById(R.id.add_stat8);
        action9 = (RadioButton)findViewById(R.id.add_stat9);
        action10 = (RadioButton)findViewById(R.id.add_stat10);
        viewAction_button = (Button)findViewById(R.id.viewAction_button);
        submit_button = (Button)findViewById(R.id.submit_chose_player);
        TextView stats_button = findViewById(R.id.button);
        RadioButton[] players= {player_1, player_2, player_3, player_4, player_5};
        player_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup arg0, int selectedId) {
                    RadioButton temp = findViewById(player_group.getCheckedRadioButtonId());
                    String s = temp.getText().toString();
                    Integer x;
                    TextView textView;

                }
            });
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton selectedPlayer = (RadioButton)findViewById(player_group.getCheckedRadioButtonId());
                RadioButton selectedAction = (RadioButton)findViewById(action_group.getCheckedRadioButtonId());
                Globals g = (Globals)getApplication();
                String action = selectedAction.getText().toString();
                Integer playerNum = Integer.parseInt(selectedPlayer.getText().toString());
                int actionOffset;
                int playerOffset = 0;
                TextView textView;
                Boolean actionSuccess;
                Integer x;
                switch(action) {
                    case "opp 3pt fg":
                        textView = (TextView) findViewById(R.id.score2);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 3;
                        textView.setText(x.toString());
                        actionOffset = -1;
                        break;
                    case "opp 2pt fg":
                        textView = (TextView) findViewById(R.id.score2);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 2;
                        textView.setText(x.toString());
                        actionOffset = -1;
                        break;
                    case "3pt fg made":
                        textView = (TextView) findViewById(R.id.score1);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 3;
                        textView.setText(x.toString());
                        actionOffset = 2;
                        actionSuccess = true;
                        break;
                    case "3pt fg missed":
                        actionOffset = 2;
                        actionSuccess = false;
                        break;
                    case "2pt fg made":
                        textView = (TextView) findViewById(R.id.score1);
                        x = Integer.parseInt(textView.getText().toString());
                        x += 2;
                        textView.setText(x.toString());
                        actionOffset = 1;
                        actionSuccess = true;
                        // need to do the global variations for all of these
                        break;
                    case "2pt fg missed":
                        actionOffset = 1;
                        actionSuccess = false;
                        break;
                    case "ft made":
                        actionOffset = 3;
                        actionSuccess = true;
                        break;
                    case "ft missed":
                        actionOffset = 3;
                        actionSuccess = false;
                        break;
                    case "rebound":
                        actionOffset = 4;
                        break;
                    case "steal":
                        actionOffset = 5;
                        break;
                    case "block":
                        actionOffset = 6;
                        break;
                    case "foul":
                        actionOffset = 7;
                        break;
                    default:
                        break;
                }
                while (playerNum != g.gamesList.playersActions[playerOffset].playerNumber){
                    playerOffset++;
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
