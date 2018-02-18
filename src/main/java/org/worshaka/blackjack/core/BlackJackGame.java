package org.worshaka.blackjack.core;

import org.worshaka.blackjack.ui.BlackJackUI;
import org.worshaka.blackjack.ui.GameState;
import org.worshaka.blackjack.ui.PlayerState;

public class BlackJackGame implements  Runnable {

    private Player dealer = new Player("Dealer");;
    private Player player = null;
    private Deck deck = new Deck();
    private BlackJackUI blackJackUI;

    public BlackJackGame(BlackJackUI blackJackUI) {
        this.blackJackUI = blackJackUI;
    }

    public void initGame() {
        blackJackUI.displayOpeningTitle();
        String playerName = blackJackUI.getPlayerName();
        player = new Player(playerName);
    }

    @Override
    public void run() {
        do {
            dealOpeningHand();
            blackJackUI.displayHands(getGameState());
            playerTurn();
            if (player.hasBusted()) {
                blackJackUI.displayPlayerBusted(player.getDisplayName());
            }
            dealerTurn();
            if (dealer.hasBusted()) {
                blackJackUI.displayDealerHasBusted(dealer.getDisplayName());
            } else {
                blackJackUI.displayResult(getGameState());
            }
        } while (blackJackUI.shouldDealAnotherHand());
        blackJackUI.displayGameFinished();
    }

    private void dealOpeningHand() {
        player.startNewHand();
        dealer.startNewHand();
        for (int i = 0; i < 2; i++) {
            player.hit(deck.getNextCard());
            dealer.hit(deck.getNextCard());
        }
    }

    private void playerTurn() {
        while (player.getTotalCardValue() < 21) {
            boolean hasHit = blackJackUI.askPlayerHitOrStay();
            if (!hasHit) {
                return;
            }
            player.hit(deck.getNextCard());
            blackJackUI.displayHands(getGameState());
        }
    }

    private void dealerTurn() {
        while (dealer.getTotalCardValue() < 17) {
            dealer.hit(deck.getNextCard());
            blackJackUI.displayHands(getGameState());
        }
    }

    private GameState getGameState() {
        return new GameState(
                new PlayerState(player.getDisplayName(), player.getHand(), player.getTotalCardValue()),
                new PlayerState(dealer.getDisplayName(), dealer.getHand(), dealer.getTotalCardValue()),
                player.getTotalCardValue() > dealer.getTotalCardValue()
        );
    }
}
