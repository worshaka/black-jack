package org.worshaka.blackjack.core;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Integer> getHand() {
        return Collections.unmodifiableList(cards);
    }

    public void startNewHand() {
        cards = new ArrayList<>();
    }

    public int getNumberOfCardsInHand() {
        return cards.size();
    }

    public boolean hasBusted() {
        return getTotalCardValue() > 21;
    }
}
