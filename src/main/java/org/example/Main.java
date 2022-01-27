package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main( String[] args ) throws InvalidGameString {

        // I made this a bit more scalable, so you can pass in poker-hands.txt files with more cards or more players
        byte playerCount = 2;
        byte handSize = 5;
        PokerGame poker = new PokerGame(playerCount, handSize);
        ArrayList<String> games = new ArrayList<>();

        // get the games as strings from the txt file
        try {
            File myFile = new File("poker-hands.txt");
            Scanner fileReader = new Scanner(myFile);
            while (fileReader.hasNextLine()) {
                String gameAsString = fileReader.nextLine();
                games.add(gameAsString);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please provide a poker-hands.txt");
        }

        // play a game of poker for every line from the txt file
        for (String gameAsString : games) {
            try {
                poker.playRound(gameAsString);
            } catch (InvalidGameString e) {
                System.out.println("One of the game strings was invalid. Skipped game string!");
            }
        }


        // List how many victories each player has
        for (Player player : poker.players) {
            System.out.println(player.toString());
        }
    }
}
