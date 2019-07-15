package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddStatsActivity extends AppCompatActivity {
    Button[] stats = new Button[12];
    static String Action = "Action committed";
    private String player_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stats);
        player_number = getIntent().getStringExtra(ChosePlayerActivity.number);
        stats[0] = (Button)findViewById(R.id.add_stat1);
        stats[1] = (Button)findViewById(R.id.add_stat2);
        stats[2] = (Button)findViewById(R.id.add_stat3);
        stats[3] = (Button)findViewById(R.id.add_stat4);
        stats[4] = (Button)findViewById(R.id.add_stat5);
        stats[5] = (Button)findViewById(R.id.add_stat6);
        stats[6] = (Button)findViewById(R.id.add_stat7);
        stats[7] = (Button)findViewById(R.id.add_stat8);
        stats[8] = (Button)findViewById(R.id.add_stat9);
        stats[9] = (Button)findViewById(R.id.add_stat10);
        stats[10] = (Button)findViewById(R.id.add_stat11);
        stats[11] = (Button)findViewById(R.id.add_stat12);
        for(int i = 0; i < 12; i++){
            stats[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // need to figure out how we are going to send the stats back through the app.
                    Intent intent = new Intent();
                    Button temp = findViewById(view.getId());
                    String s = temp.getText().toString();
                    intent.putExtra(Action, s);
                    intent.putExtra(ChosePlayerActivity.number, player_number);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }
    }
}
