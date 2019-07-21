package com.example.teamcharizard;

import android.app.Application;
import java.util.Vector;

public class Globals extends Application {
    public Team our_team = new Team("helloworld");

    public Player player1 = new Player();
    public Player player2 = new Player();
    public Player player3 = new Player();
    public Player player4 = new Player();
    public Player player5 = new Player();
    public Player player6 = new Player();
    public Player player7 = new Player();
    public Player player8 = new Player();
    public Player player9 = new Player();
    public Player player10 = new Player();
    public Player player11 = new Player();
    public Player player12 = new Player();
    public Game gamesList;


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
