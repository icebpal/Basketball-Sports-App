package com.example.teamcharizard;

import android.app.Application;
import java.util.Vector;

public class Globals extends Application {
    public Team our_team = new Team("UIUC Basketball");

    public Player player1 = new Player("Brandi Beasley", 1);
    public Player player2 = new Player("Lyric Robins", 2);
    public Player player3 = new Player("Arieal Scott", 3);
    public Player player4 = new Player("Carolyn Waleski", 4);
    public Player player5 = new Player("Cierra Rice", 5);
    public Player player6 = new Player("Jeanae Terry", 10);
    public Player player7 = new Player("Jada Peebles", 11);
    public Player player8 = new Player("Taylor Edwards", 12);
    public Player player9 = new Player("Petra Hol", 13);
    public Player player10 = new Player("Nancy And", 21);
    public Player player11 = new Player("Mackenzie", 23);
    public Player player12 = new Player("Courtney Jones", 30);


    public Player[] playerList = {player1, player2, player3, player4, player5, player6, player7,
            player8, player9, player10, player11, player12};
    public Vector<Game> gamesList = new Vector<Game>();

    public Team getOurTeam(){
        return our_team;
    }
    public void setOurTeam(Team newteam){
        our_team.team_name = newteam.team_name;
        for (int i=0; i<12; i++){
            our_team.active_roster[i] = newteam.active_roster[i];
            our_team.bench_roster[i] = newteam.bench_roster[i];
        }
        return;
    }


}
