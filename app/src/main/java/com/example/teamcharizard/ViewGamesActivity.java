package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class ViewGamesActivity extends AppCompatActivity {
    private Button game1_button;
    private Button team_button;
    private Button add_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_games);
        game1_button = (Button)findViewById(R.id.game1);
//        add_game = (Button)findViewById(R.id.add_new_game);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
        ScrollView scroll = (ScrollView)findViewById(R.id.scroll);
        Intent i = getIntent();
        String left = i.getStringExtra("LEFT");
        String right = i.getStringExtra("RIGHT");
        if (left!= null && right!= null) {
            //Toast.makeText(getApplicationContext(), left + right, Toast.LENGTH_SHORT).show();
            Button second = new Button(this);
            String text = left + " VS "+ right;
            second.setText(text);
            second.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.addView(second);
            second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ChosePlayerActivity.class);
                    startActivity(intent);
                }
            });
        }
        game1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChosePlayerActivity.class);
                startActivity(intent);
            }
        });

        for (int x = 0; x < 2/*MainActivity.games.size()*/; x++){
            Button newButton = new Button(this);
            String s = "test string"; //MainActivity.games[x].date + " - " + MainActivity.team.team_name + " vs. " + MainActivity.games[x].opponent;
            newButton.setText(s);
            newButton.setId(x);
            newButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ChosePlayerActivity.class);
                    intent.putExtra("game num", view.getId());
                    startActivity(intent);
                }
            });
            layout.addView(newButton);
        }

//        add_game.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), StartNewGameActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
