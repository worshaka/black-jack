package org.worshaka;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String displayName = null;
    private List<Integer> cards = new ArrayList<>();


    public Player(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void hit(int cardValue) {
        if (getTotalCardValue() > 21) {
            throw new IllegalStateException("Cannot hit! Player has busted");
        }
        cards.add(cardValue);
    }

    public int getTotalCardValue() {
        return cards.stream().mapToInt(Integer::intValue).sum();
    }

    public String getHand() {
        return cards.toString();
    }

    public void startNewHand() {
        cards = new ArrayList<>();
    }

    public int getNumberOfCardsInHand() {
        return cards.size();
    }
}
