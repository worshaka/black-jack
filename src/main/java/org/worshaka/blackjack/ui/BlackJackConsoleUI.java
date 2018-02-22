package org.worshaka.blackjack.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BlackJackConsoleUI implements BlackJackUI {

    private BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void displayBeginDealerTurn(PlayerState dealer) {
        System.out.println("Okay, dealer's turn.");
        System.out.printf("His hidden card was a %d%n", dealer.getLastDealtCard());
        System.out.printf("His total was %d%n%n", dealer.getPointTotal());
    }

    @Override
    public void displayDealerStays() {
        System.out.println("Dealer stays.");
        System.out.println();
    }

    @Override
    public void displayGameFinished() {
        System.out.println("Thank you for playing.");
    }

    @Override
    public void displayHandResult(GameState gameState, HandResult handResult) {
        displayFinalHands(gameState);
        switch (handResult) {
            case TIE:
                System.out.println("GAME TIED!!!");
                break;
            case PLAYER_WINS:
                System.out.println("YOU WIN!!!");
                break;
            case DEALER_WINS:
                System.out.println("DEALER WINS!!!");
        }
        System.out.println();
    }

    @Override
    public void displayOpeningHands(GameState gameState) {
        displayPlayerOpeningHand(gameState.getPlayerState());
        displayDealerOpeningHand(gameState.getDealerState());
    }

    @Override
    public void displayOpeningTitle() {
        System.out.println();
        System.out.println("Welcome to Travis' blackjack program!");
    }

    @Override
    public void displayResultOfDealerHit(PlayerState dealer) {
        System.out.println("Dealer chooses to hit.");
        System.out.printf("He drew a %s%n", dealer.getLastDealtCard());
        System.out.printf("His total is %s%n%n", dealer.getPointTotal());
    }

    @Override
    public void displayResultOfPlayerHit(PlayerState player) {
        System.out.printf("You drew a %s%n", player.getLastDealtCard());
        System.out.printf("Your total is %s%n%n", player.getPointTotal());
    }

    @Override
    public boolean hasPlayerHit() {
        System.out.println("Would you like to \"hit\" or \"stay\"?");
        printCommandPrompt();
        boolean hasHit = readLine().toLowerCase().startsWith("h");
        System.out.println();
        return hasHit;
    }

    @Override
    public boolean shouldDealAnotherHand() {
        System.out.println("Do you want to deal another hand?");
        printCommandPrompt();
        return readLine().toLowerCase().startsWith("y");
    }

    private void displayFinalHands(GameState gameState) {
        displayFinalHand("Dealer", gameState.getDealerState());
        displayFinalHand("Player", gameState.getPlayerState());
        System.out.println();
    }

    private void displayFinalHand(String name, PlayerState playerState) {
        if (playerState.hasBusted()) {
            System.out.printf("%s has busted.%n", name);
        } else {
            System.out.printf("%s total is %d%n", name, playerState.getPointTotal());
        }
    }

    private void displayPlayerOpeningHand(PlayerState player) {
        List<Integer> playerHand = player.getHand();
        System.out.printf("You get a %d and a %d.%n", playerHand.get(0), playerHand.get(1));
        System.out.printf("Your total is %d.%n%n", player.getPointTotal());
    }

    private void displayDealerOpeningHand(PlayerState dealer) {
        System.out.printf("The dealer has a %d showing, and a hidden card.%n", dealer.getHand().get(0));
        System.out.println("His total is hidden, too.");
        System.out.println();
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
