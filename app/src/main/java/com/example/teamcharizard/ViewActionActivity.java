package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_action);
        Integer game_num = getIntent().getIntExtra("Game",-1);
        if (game_num == -1){
            if (true == true /* TeamProfileActivity.gameList.size() > game_num */){
                for (int x = 0; x < 10 /* TeamProfileActivity.gameList[game_num] */; x++){
                    TableLayout tl = (TableLayout) findViewById(R.id.view_action_table);
                    TableRow tr = new TableRow(this);
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    for (int y = 0; y < 4; y++) {
                        TextView tv = new TextView(this);
                        tv.setText("test"); /* get the input from the game action list */
                        tv.setTextSize(13);
                        tv.setGravity(Gravity.START);
                        tr.addView(tv);
                    }
                    tl.addView(tr);
                }
            }
        }
    }
}
