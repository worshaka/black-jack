package org.worshaka;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {

    @DisplayName("a deck should return a random value between one and eleven inclusive")
    @RepeatedTest(100)
    public void aDeckShouldReturnValuesBetweenOneAndElevenInclusive() {
        Deck deck = new Deck();

        int nextCard = deck.getNextCard();
        assertTrue(nextCard > 0 && nextCard < 12);
    }
}
