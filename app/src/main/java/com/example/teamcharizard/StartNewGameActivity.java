package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class StartNewGameActivity extends AppCompatActivity {
    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_game);
        add = (Button) findViewById(R.id.addGame);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ViewGamesActivity.class);
                startActivity(intent);
            }
        });
    }
}
