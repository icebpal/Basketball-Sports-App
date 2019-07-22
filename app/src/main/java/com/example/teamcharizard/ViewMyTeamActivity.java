package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ViewMyTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_team);
        Globals g = (Globals)getApplication();
        int gameNum = g.gamesList.size() - 1;
        TableLayout tl = (TableLayout)findViewById(R.id.view_my_team_table);
        if (true){
            if (gameNum > -1 ){
                for (int x = 0; x < g.gamesList.get(gameNum).pActions.length; x++){
                    TableRow tr = new TableRow(this);
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    TextView tv = new TextView(this);
                    playerActions player = g.gamesList.get(gameNum).pActions[x];
                    tv.setText(Integer.toString(player.playerNumber)); /* get the input from the game action list */
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    Integer Fg =player.fgMade + player.fgMissed;
                    String fg = player.fgMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    Fg = player.threeMade + player.threeMissed;
                    fg = player.threeMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    Fg = player.ftMade + player.ftMissed;
                    fg = player.ftMade.toString() + "/" + Fg.toString();
                    tv.setText(fg);
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    tv.setText(player.rebounds.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    tv.setText(player.steals.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    tv.setText(player.blocks.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    tv.setText("0");
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    tv = new TextView(this);
                    Fg = player.ftMade + 2 * player.fgMade + 3 * player.threeMade;
                    tv.setText(Fg.toString());
                    tv.setTextColor(Color.BLACK);
                    tv.setGravity(Gravity.START);
                    tr.addView(tv);
                    Log.v("made it", "here");
                    tl.addView(tr);
                }
            }
        }
        tl.requestLayout();
    }
}
