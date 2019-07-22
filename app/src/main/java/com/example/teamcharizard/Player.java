package com.example.teamcharizard;

public class Player {
    String name;
    int number;
    public Integer fgMade;
    public Integer fgMissed;
    public Integer ftMade;
    public Integer ftMissed;
    public Integer threeMade;
    public Integer threeMissed;
    public Integer steals;
    public Integer rebounds;
    public Integer blocks;
    String position;



    public Player() {
        name = "Default Name";
        number = -1;
        position = "Default Position";
        fgMade = 0;
        fgMissed = 0;
        ftMade = 0;
        ftMissed = 0;
        threeMade = 0;
        threeMissed = 0;
        steals = 0;
        rebounds = 0;
        blocks = 0;
    }

    public Player(String name_, int number_) {
        name = name_;
        number = number_;
        position = "Default Position";
        fgMade = 0;
        fgMissed = 0;
        ftMade = 0;
        ftMissed = 0;
        threeMade = 0;
        threeMissed = 0;
        steals = 0;
        rebounds = 0;
        blocks = 0;
    }


    public Player(String name, int number, String position) {
        name = name;
        number = number;
        position = position;
    }
}
