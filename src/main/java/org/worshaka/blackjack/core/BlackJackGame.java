package org.worshaka.blackjack.core;

import org.worshaka.blackjack.ui.BlackJackUI;
import org.worshaka.blackjack.ui.GameState;
import org.worshaka.blackjack.ui.PlayerState;
import org.worshaka.blackjack.ui.HandResult;

import static org.worshaka.blackjack.ui.HandResult.*;

public class BlackJackGame implements Runnable {

    private Player dealer = new Player("Dealer");
    private Player player = new Player("Player");
    private Deck deck = new Deck();
    private BlackJackUI blackJackUI;

    public BlackJackGame(BlackJackUI blackJackUI) {
        this.blackJackUI = blackJackUI;
    }

    private void initGame() {
        blackJackUI.displayOpeningTitle();
    }

    @Override
    public void run() {
        initGame();
        do {
            dealOpeningHand();
            playerTurn();
            dealerTurn();
            displayResult();
        } while (blackJackUI.shouldDealAnotherHand());

        blackJackUI.displayGameFinished();
    }

    private void displayResult() {
        HandResult handResult = null;
        if (player.hasBusted() && dealer.hasBusted()) {
            handResult = TIE;
        } else if (dealer.hasBusted()) {
            handResult = PLAYER_WINS;
        } else if (player.hasBusted()) {
            handResult = DEALER_WINS;
        } else if (dealer.getTotalCardValue() >= player.getTotalCardValue()) {
            handResult = DEALER_WINS;
        } else {
            handResult = PLAYER_WINS;
        }
        blackJackUI.displayHandResult(getGameState(), handResult);
    }

    private void dealOpeningHand() {
        player.startNewHand();
        dealer.startNewHand();
        for (int i = 0; i < 2; i++) {
            player.hit(deck.getNextCard());
            dealer.hit(deck.getNextCard());
        }
        blackJackUI.displayOpeningHands(getGameState());
    }

    private void playerTurn() {
        while (blackJackUI.hasPlayerHit()) {
            player.hit(deck.getNextCard());
            blackJackUI.displayResultOfPlayerHit(getGameState().getPlayerState());
            if (player.hasBusted()) {
                return;
            }
        }
    }

    private void dealerTurn() {
        blackJackUI.displayBeginDealerTurn(getGameState().getDealerState());
        while (dealer.getTotalCardValue() < 17) {
            dealer.hit(deck.getNextCard());
            blackJackUI.displayResultOfDealerHit(getGameState().getDealerState());
        }
        if (!dealer.hasBusted()) {
            blackJackUI.displayDealerStays();
        }
    }

    private GameState getGameState() {
        return new GameState(
                new PlayerState(player.getDisplayName(), player.getHand(), player.getTotalCardValue(), player.hasBusted()),
                new PlayerState(dealer.getDisplayName(), dealer.getHand(), dealer.getTotalCardValue(), dealer.hasBusted())
        );
    }
}
