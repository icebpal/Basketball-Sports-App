package com.example.teamcharizard;

public class Team {
    public String team_name;

    public Player [] active_roster = new Player[5];
    public Player [] bench_roster = new Player[12];
    //  Player full_roster[] = new Player[100];


    public Team(String name) {
        team_name = name;
        for (int i = 0; i < 5; i++) {
            Player np = new Player();
            active_roster[i] = np;
            bench_roster[i] = active_roster[i];
        }
        for (int i = 6; i < 12; i++) {
            Player np = new Player();
            bench_roster[i] = np;
        }
    }

    public int min(int a, int b){
        if (a < b){
            return a;
        }
        return b;
    }
    public Team(String name, Player[] active, Player[] bench) {
        team_name = name;
        set_team_rosters(active, bench);
    }


    public void set_team_rosters(Player[] active, Player[] bench){
        for (int i=0; i< min(5, active.length); i++){
            active_roster[i] = active[i];
        }
        for (int i=0; i< min(12, bench.length); i++){
            bench_roster[i] = bench[i];
        }
        return;

    }


    public void add_player_to_active_roster(Player newplayer){
        for (int i = 0; i < 5; i++) {
            if (active_roster[i].number == -1) {
                active_roster[i] = newplayer;
                break;
            }
        }
        return;
    }


    public void remove_player_from_active_roster(Player oldplayer){
        for (int i = 0; i < 5; i++) {
            if (active_roster[i].number == oldplayer.number) {
                active_roster[i] = new Player();
                break;
            }
        }
        return;
    }

    public Player getPlayer(String name){
        for (int i =0; i <12; i++){
            if (bench_roster[i].name == name){
                return bench_roster[i];
            }
        }
        return new Player();
    }
}
