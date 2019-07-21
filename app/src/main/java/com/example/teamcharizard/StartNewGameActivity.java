package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class StartNewGameActivity extends AppCompatActivity {
    private Button add;
    private EditText team_1;
    private EditText team_2;
    private EditText date;
    private static String datestring;
    private static String teamleft;
    private static String teamright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_game);
        team_1 = (EditText)findViewById(R.id.team1);
        team_2 = (EditText)findViewById(R.id.team2);
        date = (EditText)findViewById(R.id.date);
        add = (Button) findViewById(R.id.addGame);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                teamleft = team_1.getText().toString();
                teamright = team_2.getText().toString();
                datestring = date.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("LEFT", teamleft);
                intent.putExtra("RIGHT",teamright);
                intent.putExtra("DATE", datestring);
                startActivity(intent);
            }
        });
    }
}
