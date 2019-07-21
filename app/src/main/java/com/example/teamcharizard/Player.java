package com.example.teamcharizard;

public class Player {
    String name;
    int number;

    String position;



    public Player() {
        name = "Default Name";
        number = -1;
        position = "Default Position";
    }

    public Player(String name, int number) {
        name = name;
        number = number;
        position = "Default Position";
    }


    public Player(String name, int number, String position) {
        name = name;
        number = number;
        position = position;
    }
}
