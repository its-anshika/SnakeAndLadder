package org.example.service;

import org.example.entities.Dice;
import org.example.entities.Player;

import java.util.HashMap;
import java.util.Queue;

public class PlaySnakeAndLadder {
    Dice dice;
    int boardSize;
    HashMap<Integer, Integer> snakes;
    HashMap<Integer, Integer> ladders;
    HashMap<String, Integer> playersCurrentPosition;
    Queue<Player> nextTurn; //for Round robin turns of n players

    public PlaySnakeAndLadder(int diceNumber, int boardSize, Queue<Player> nextTurn, HashMap<String, Integer> playersCurrentPosition, HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders) {
        this.dice = new Dice(diceNumber);
        this.boardSize = boardSize;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
    }

    public String playGame() {
        while (nextTurn.size() > 1) {
            Player player = nextTurn.poll(); //front player removed
            String playerName = player.getName();
            int currentPos = playersCurrentPosition.get(playerName);
            int diceVal = dice.rollDice();
            System.out.println(playerName + ": Dice value is "+ diceVal);

            int nextPos = currentPos + diceVal;
            if (nextPos > boardSize)
                nextTurn.offer(player); //put it back at end of queue
            else if (nextPos == boardSize)
                return playerName; //won
            else {
                if (snakes.containsKey(nextPos)) {
                    System.out.println(playerName + " bitten by snake at " + nextPos);
                    nextPos = snakes.get(nextPos);
                }
                if (ladders.containsKey(nextPos)) {
                    System.out.println(playerName + " climbed Ladder at " + nextPos);
                    nextPos = ladders.get(nextPos);
                }
                if (nextPos == boardSize)
                    return playerName;
                System.out.println(playerName + " moved to position " + nextPos);
                playersCurrentPosition.put(playerName, nextPos);
                nextTurn.offer(player); //put it back at end of queue
            }

        }
        return "No one";
    }
}

