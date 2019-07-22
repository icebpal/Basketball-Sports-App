package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class StartNewGameActivity extends AppCompatActivity {
    private Button add;
    private EditText team_2;
    private static String teamleft;
    private static String teamright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_game);
        team_2 = (EditText)findViewById(R.id.team2);
        add = (Button) findViewById(R.id.addGame);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                teamright = team_2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), ChosePlayerActivity.class);
                intent.putExtra("RIGHT",teamright);
                startActivity(intent);
            }
        });
    }
}
