package org.worshaka.blackjack.ui;

import java.util.List;

public class PlayerState {

    private final List<Integer> hand;
    private final int pointTotal;
    private final boolean busted;

    public PlayerState(List<Integer> hand, int pointTotal, boolean busted) {
        this.hand = hand;
        this.pointTotal = pointTotal;
        this.busted = busted;
    }

    public List<Integer> getHand() {
        return hand;
    }

    public int getPointTotal() {
        return pointTotal;
    }

    public int getLastDealtCard() {
        return hand.get(hand.size() - 1);
    }

    public boolean hasBusted() {
        return busted;
    }
}
