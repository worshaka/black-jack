package org.worshaka.blackjack.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJackConsoleUI implements BlackJackUI {

    private BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getPlayerName() {
        System.out.println("Please enter your name");
        printCommandPrompt();
        return readLine();
    }

    @Override
    public boolean askPlayerHitOrStay() {
        System.out.println("Would you like to hit or stay? [Hit/Stay]");
        printCommandPrompt();
        return readLine().toLowerCase().startsWith("h");
    }

    @Override
    public void displayHands(GameState gameState) {
        PlayerState dealer = gameState.getDealerState();
        PlayerState player = gameState.getPlayerState();
        System.out.printf("%s -> Cards: %s%n", dealer.getDisplayName(), dealer.getHand());
        System.out.printf("%s -> Cards: %s%n", player.getDisplayName(), player.getHand());
    }

    @Override
    public void displayPlayerBusted(String displayName) {
        System.out.printf("%s has busted!!!%n", displayName);
        System.out.println("You LOSE...");
    }

    @Override
    public boolean shouldDealAnotherHand() {
        System.out.println("Do you want to deal another hand?");
        printCommandPrompt();
        return readLine().toLowerCase().startsWith("y");
    }

    @Override
    public void displayResult(GameState gameState) {
        PlayerState player = gameState.getPlayerState();
        PlayerState dealer = gameState.getDealerState();
        System.out.printf("%s Wins!!!%n", (gameState.hasPlayerWon()) ? player.getDisplayName() : dealer.getDisplayName());
        displayHands(gameState);
    }

    @Override
    public void displayGameFinished() {
        System.out.println("Thank you for playing");
    }

    @Override
    public void displayOpeningTitle() {
        System.out.println("Welcome to Black Jack!");
    }

    @Override
    public void displayDealerHasBusted(String displayName) {
        System.out.printf("%s has busted!!!%n", displayName);
        System.out.println("You Win.");
    }

    private void printCommandPrompt() {
        System.out.print("> ");
    }

    private String readLine() {
        try {
            return console.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
