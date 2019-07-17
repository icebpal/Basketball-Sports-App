package com.example.teamcharizard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class CoachLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String entered_username;
        String entered_password

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_login);


        EditText username_input = findViewById(R.id.username_entry);
        EditText password_input = findViewById(R.id.password_entry);

        username_input.setOnEditorActionListener(new View.OnEditorActionListenener(){
            @Override
            public void onEditorAction(){



            }
        });





        password_input.setOnEditorActionListener(new View.OnEditorActionListenener(){
            @Override
            public void onEditorAction(){

            }
        });
    }



}
