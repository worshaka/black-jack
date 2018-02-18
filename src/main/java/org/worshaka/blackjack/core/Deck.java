package org.worshaka.blackjack.core;

import java.util.Random;

public class Deck {

    private static int HIGHEST_CARD_VALUE = 11;

    private Random random = new Random(System.currentTimeMillis());

    public int getNextCard() {
        return random.nextInt(HIGHEST_CARD_VALUE) + 1;
    }
}
