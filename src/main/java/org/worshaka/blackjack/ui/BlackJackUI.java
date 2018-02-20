package org.worshaka.blackjack.ui;

public interface BlackJackUI {

    void displayBeginDealerTurn(PlayerState dealer);

    void displayDealerStays();

    void displayGameFinished();

    void displayHandResult(GameState gameState, HandResult handResult);

    void displayOpeningHands(GameState gameState);

    void displayOpeningTitle();

    void displayResultOfDealerHit(PlayerState dealerState);

    void displayResultOfPlayerHit(PlayerState player);

    boolean hasPlayerHit();

    boolean shouldDealAnotherHand();
}
