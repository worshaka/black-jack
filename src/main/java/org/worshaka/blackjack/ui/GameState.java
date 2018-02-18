package org.worshaka.blackjack.ui;

public class GameState {

    private final PlayerState playerState;
    private final PlayerState dealerState;
    private final Boolean hasPlayerWon;

    public GameState(PlayerState playerState, PlayerState dealerState) {
        this(playerState, dealerState, null);
    }

    public GameState(PlayerState playerState, PlayerState dealerState, Boolean hasPlayerWon) {
        this.playerState = playerState;
        this.dealerState = dealerState;
        this.hasPlayerWon = hasPlayerWon;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public PlayerState getDealerState() {
        return dealerState;
    }

    public Boolean hasPlayerWon() {
        return hasPlayerWon;
    }
}
