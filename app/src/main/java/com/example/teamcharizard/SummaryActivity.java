package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SummaryActivity extends AppCompatActivity {

    private Button stats_button;
    private Button view_action_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        stats_button = (Button)findViewById(R.id.stats_button);
        view_action_button = (Button)findViewById(R.id.view_action_table);
        view_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChosePlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}
