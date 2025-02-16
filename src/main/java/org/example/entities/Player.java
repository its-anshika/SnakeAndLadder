package org.example.entities;

public class Player {
    private String name;
    private int id;

    public Player(String playerName, int id){
        this.name = playerName;
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
