package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CoachLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_login);




        EditText username_input = findViewById(R.id.username_entry);
        EditText password_input = findViewById(R.id.password_entry);


    }
}
