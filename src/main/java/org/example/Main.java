package org.example;

import org.example.entities.Player;
import org.example.service.PlaySnakeAndLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder!");
        Scanner scan = new Scanner(System.in);
        int id=1;
        Queue<Player> allPlayers = new LinkedList<>();
        HashMap<String,Integer> playersCurrentPosition = new HashMap<>();

        System.out.println("Enter the number of players");
        int numberOfPlayers = scan.nextInt();
        while(numberOfPlayers>0){
            String name = "Player"+ id;
            Player player = new Player(name);
            allPlayers.offer(player);
            playersCurrentPosition.put(name,0);
            numberOfPlayers--;
            id++;
        }
        HashMap<Integer, Integer> snakes = new HashMap<>();
        System.out.println("Enter the number of snakes, with their start and end positions");
        int noOfSnakes=scan.nextInt();
        while(noOfSnakes>0){
            int start=scan.nextInt();
            int end=scan.nextInt();
            snakes.put(start, end);
            noOfSnakes--;
        }
        System.out.println("Enter the number of ladders, with their start and end positions");
        HashMap<Integer, Integer> ladders = new HashMap<>();
        int noOfLadders=scan.nextInt();
        while(noOfLadders>0){
            int start=scan.nextInt();
            int end=scan.nextInt();
            ladders.put(start, end);
            noOfLadders--;
        }

        PlaySnakeAndLadder playSnakeAndLadder = new PlaySnakeAndLadder(6, 100, allPlayers, playersCurrentPosition, snakes, ladders);
        System.out.println(playSnakeAndLadder.playGame() + " won the game!");
    }
}