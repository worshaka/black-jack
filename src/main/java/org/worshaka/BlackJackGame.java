package org.worshaka;

public class BlackJackGame {

    private Player dealer = null;
    private Player player = null;
    private Deck deck = new Deck();
    private BlackJackUI blackJackUI;

    public BlackJackGame(BlackJackUI blackJackUI) {
        this.blackJackUI = blackJackUI;
    }

    public void newGame(String playerName) {

    }

    public void start() {
        openingDeal();
        blackJackUI.reportGameState(dealer.getHand(), player.getHand());
        playerTurn();

    }

    private void openingDeal() {
        for (int i = 0; i < 2; i++) {
            player.hit(deck.getNextCard());
            dealer.hit(deck.getNextCard());
        }
    }

    private playerTurn() {
        do {

        }
    }
}
