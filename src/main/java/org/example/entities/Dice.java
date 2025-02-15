package org.example.entities;

public class Dice {
    private int diceNumber;
    public Dice(int N){
        this.diceNumber = N;
    }
    public int rollDice(){
        return (int)Math.floor(Math.random() * diceNumber) + 1;
    }
}
