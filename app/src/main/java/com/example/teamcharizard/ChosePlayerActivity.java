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
    private RadioGroup.OnCheckedChangeListener listener1, listener2, listener3;
    private RadioButton player_1, player_2, player_3, player_4, player_5;
    private Button viewAction_button, submit_button;
    private RadioGroup player_group, action_group1, action_group2;
    private int prevPressed;
    static String number =  "Player Number";
    private Integer ADD_STATS_ACTIVITY_REQUEST = 1;
    private Integer gameNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_player);
        gameNum = getIntent().getIntExtra("game num",-1);
        Globals g = (Globals) getApplication();
        player_group = (RadioGroup)findViewById(R.id.player_group);
        player_group.clearCheck();
        action_group1 = (RadioGroup)findViewById(R.id.action_group1);
        action_group1.clearCheck();
        action_group2 = (RadioGroup)findViewById(R.id.action_group2);
        action_group2.clearCheck();
        player_1 = (RadioButton)findViewById(R.id.chose_player_button1);
        player_2 = (RadioButton)findViewById(R.id.chose_player_button2);
        player_3 = (RadioButton)findViewById(R.id.chose_player_button3);
        player_4 = (RadioButton)findViewById(R.id.chose_player_button4);
        player_5 = (RadioButton)findViewById(R.id.chose_player_button5);
        viewAction_button = (Button)findViewById(R.id.viewAction_button);
        submit_button = (Button)findViewById(R.id.submit_chose_player);
        TextView stats_button = findViewById(R.id.button);
        TextView stats1 = (TextView)findViewById(R.id.score1);
        stats1.setText(g.gamesList.get(gameNum).ourScore.toString());
        TextView stats2 = (TextView)findViewById(R.id.score2);
        stats2.setText(g.gamesList.get(gameNum).theirScore.toString());
        RadioButton[] players= {player_1, player_2, player_3, player_4, player_5};
        listener1 = new RadioGroup.OnCheckedChangeListener() {
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
            };
        player_group.setOnCheckedChangeListener(listener1);
        listener2 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1) {
                    action_group2.setOnCheckedChangeListener(null);
                    action_group2.clearCheck();
                    action_group2.setOnCheckedChangeListener(listener3);
                    Log.e("XXX2", "do the work");
                }
            }
        };
        listener3 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != -1) {
                    action_group1.setOnCheckedChangeListener(null);
                    action_group1.clearCheck();
                    action_group1.setOnCheckedChangeListener(listener2);
                    Log.e("XXX2", "do the work");
                }
            }
        };
        action_group1.setOnCheckedChangeListener(listener2);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton selectedPlayer = (RadioButton)findViewById(player_group.getCheckedRadioButtonId());
                RadioButton selectedAction;
                if (action_group1.getCheckedRadioButtonId() != -1) {
                    selectedAction = (RadioButton) findViewById(action_group1.getCheckedRadioButtonId());
                }else{
                    selectedAction = (RadioButton) findViewById(action_group2.getCheckedRadioButtonId());
                }
                Globals g = (Globals)getApplication();
                String action = "";
                int playerNum = -1;
                Log.v("player", Integer.toString(player_group.getCheckedRadioButtonId()));
                Log.v("action", Integer.toString(action_group1.getCheckedRadioButtonId()));
                if (action_group1.getCheckedRadioButtonId() == -1 && action_group2.getCheckedRadioButtonId() == -1){
                    Log.v("action", Integer.toString(action_group1.getCheckedRadioButtonId()));
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
                        g.gamesList.get(gameNum).theirScore += 3;
                        textView = (TextView) findViewById(R.id.score2);
                        textView.setText(g.gamesList.get(gameNum).theirScore.toString());
                        break;
                    case "Opp 2pt fg":
                        g.gamesList.get(gameNum).theirScore += 2;
                        textView = (TextView) findViewById(R.id.score2);
                        textView.setText(g.gamesList.get(gameNum).theirScore.toString());
                        break;
                    case "3pt fg made":
                        g.gamesList.get(gameNum).ourScore += 3;
                        g.gamesList.get(gameNum).actions.add("3pt fg made");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        textView = (TextView) findViewById(R.id.score1);
                        textView.setText(g.gamesList.get(gameNum).ourScore.toString());
                        g.gamesList.get(gameNum).pActions[playerOffset].threeMade += 1;
                        break;
                    case "3pt fg missed":
                        g.gamesList.get(gameNum).actions.add("3pt fg missed");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).pActions[playerOffset].threeMissed += 1;
                        break;
                    case "2pt fg made":
                        g.gamesList.get(gameNum).actions.add("2pt fg made");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).ourScore += 2;
                        textView = (TextView) findViewById(R.id.score1);
                        textView.setText(g.gamesList.get(gameNum).ourScore.toString());
                        g.gamesList.get(gameNum).pActions[playerOffset].fgMade += 1;
                        // need to do the global variations for all of these
                        break;
                    case "2pt fg missed":
                        g.gamesList.get(gameNum).actions.add("2pt fg missed");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).pActions[playerOffset].fgMissed += 1;
                        break;
                    case "ft made":
                        g.gamesList.get(gameNum).actions.add("ft made");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).pActions[playerOffset].ftMade += 1;
                        break;
                    case "ft missed":
                        g.gamesList.get(gameNum).actions.add("ft made");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).pActions[playerOffset].ftMissed += 1;
                        break;
                    case "Rebound":
                        g.gamesList.get(gameNum).actions.add("Rebound");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).pActions[playerOffset].rebounds += 1;
                        break;
                    case "Steal":
                        g.gamesList.get(gameNum).actions.add("Steal");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).pActions[playerOffset].steals += 1;
                        break;
                    case "Block":
                        g.gamesList.get(gameNum).actions.add("Block");
                        g.gamesList.get(gameNum).quarter.add(g.gamesList.get(gameNum).currQuarter);
                        g.gamesList.get(gameNum).player.add(playerNum);
                        g.gamesList.get(gameNum).pActions[playerOffset].blocks += 1;
                        break;
                    default:
                        break;
                }
                player_group.setOnCheckedChangeListener(null);
                action_group1.setOnCheckedChangeListener(null);
                action_group2.setOnCheckedChangeListener(null);
                player_group.clearCheck();
                action_group1.clearCheck();
                action_group2.clearCheck();
                Button button;
                if (prevPressed != 0) {
                    button = (RadioButton)findViewById(prevPressed);
                    button.setBackground(getResources().getDrawable(R.drawable.round_button_1));
                    prevPressed = 0;
                }
                player_group.setOnCheckedChangeListener(listener1);
                action_group1.setOnCheckedChangeListener(listener2);
                action_group2.setOnCheckedChangeListener(listener3);
                Log.v("action", g.gamesList.get(gameNum).actions.lastElement());
                Log.v("player", Integer.toString(g.gamesList.get(gameNum).player.lastElement()));
                Log.v("quarter", Integer.toString(g.gamesList.get(gameNum).quarter.lastElement()));
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
