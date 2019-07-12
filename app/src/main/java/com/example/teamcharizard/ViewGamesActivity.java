package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewGamesActivity extends AppCompatActivity {

    private Button game1_button;
    private Button team_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_games);
        game1_button = (Button)findViewById(R.id.game1);
        team_button = (Button)findViewById(R.id.team_button);
        game1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChosePlayerActivity.class);
                startActivity(intent);
            }
        });
        team_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PickTeamActivity.class);
                startActivity(intent);
            }
        });
    }
}
