package org.worshaka;

public interface BlackJackUI {

    boolean askPlayerHitOrStay();

    String reportGameState(String dealerHand, String playerHand);
}
