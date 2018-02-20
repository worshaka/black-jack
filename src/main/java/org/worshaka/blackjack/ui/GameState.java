package org.worshaka.blackjack.ui;

public class GameState {

    private final PlayerState playerState;
    private final PlayerState dealerState;

    public GameState(PlayerState playerState, PlayerState dealerState) {
        this.playerState = playerState;
        this.dealerState = dealerState;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public PlayerState getDealerState() {
        return dealerState;
    }
}
