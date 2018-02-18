package org.worshaka.blackjack.ui;

import java.util.List;

public class PlayerState {

    private final String displayName;
    private final List<Integer> hand;
    private final int total;

    public PlayerState(String displayName, List<Integer> hand, int total) {
        this.displayName = displayName;
        this.hand = hand;
        this.total = total;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Integer> getHand() {
        return hand;
    }

    public int getTotal() {
        return total;
    }
}
