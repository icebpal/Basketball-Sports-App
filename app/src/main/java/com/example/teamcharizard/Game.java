package com.example.teamcharizard;

import java.util.Vector;

public class Game {
    Vector actions;
    Vector player;
    Vector quarter;
    playerActions[] pActions;
    int ourScore, theirScore;
    String s;
    Game(){
        pActions = new playerActions[12];
        for (int x = 0; x < 12; x++){
            pActions[x] = new playerActions();
        }
        actions = new Vector();
        player = new Vector();
        quarter = new Vector();
        ourScore = 0;
        theirScore = 0;
        s = "hello";
    }
}

