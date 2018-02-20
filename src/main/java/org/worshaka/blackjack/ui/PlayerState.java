package org.worshaka.blackjack.ui;

import java.util.List;

public class PlayerState {

    private final String displayName;
    private final List<Integer> hand;
    private final int total;
    private final boolean busted;

    public PlayerState(String displayName, List<Integer> hand, int total, boolean busted) {
        this.displayName = displayName;
        this.hand = hand;
        this.total = total;
        this.busted = busted;
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

    public int getLastDealtCard() {
        return hand.get(hand.size() - 1);
    }

    public boolean hasBusted() {
        return busted;
    }
}
