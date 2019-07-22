package com.example.teamcharizard;

import java.util.Vector;

public class Game {
    Vector<String> actions;
    Vector<Integer> player;
    Vector<Integer> quarter;
    Integer currQuarter;
    playerActions[] pActions;
    Integer ourScore, theirScore;
    String date, theirName;
    Game(){
        pActions = new playerActions[12];
        for (int x = 0; x < 12; x++){
            pActions[x] = new playerActions();
        }
        actions = new Vector<String>();
        player = new Vector<Integer>();
        quarter = new Vector<Integer>();
        ourScore = 0;
        theirScore = 0;
        currQuarter = 1;
        date = "";
    }
}

