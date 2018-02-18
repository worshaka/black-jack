package org.worshaka.blackjack.ui;

public interface BlackJackUI {

    boolean askPlayerHitOrStay();

    void displayHands(GameState gameState);

    void displayPlayerBusted(String displayName);

    boolean shouldDealAnotherHand();

    void displayResult(GameState gameState);

    void displayGameFinished();

    String getPlayerName();

    void displayOpeningTitle();

    void displayDealerHasBusted(String displayName);
}
