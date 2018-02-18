package org.worshaka.blackjack.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {

    @DisplayName("should get a total card value equal to all hits")
    @Test
    public void shouldGetTotalCardValueEqualToAllHits() {
        Player player = new Player("name");
        player.hit(10);
        player.hit(11);
        assertEquals(21, player.getTotalCardValue());
    }

    @DisplayName("should throw an IllegalStateException if trying to hit a player who has busted already")
    @Test
    public void shouldNotBeAbleToHitIfPlayerHasBusted() {
        Player player = new Player("name");
        player.hit(11);
        player.hit(11);
        assertThrows(IllegalStateException.class, () -> player.hit(1));
    }

    @DisplayName("should have no cards in hand when starting a new hand")
    @Test
    public void shouldHaveNoCardsInHandWhenStartingNewGame() {
        Player player = new Player("name");
        player.hit(11);
        player.hit(1);
        player.startNewHand();
        assertEquals(0, player.getNumberOfCardsInHand());
    }

    @DisplayName("should return the correct number of cards in hand")
    @Test
    public void shouldReturnTheCorrectNumberOfCardsInHand() {
        Player player = new Player("name");
        player.hit(1);
        player.hit(1);
        player.hit(1);
        player.hit(1);
        player.hit(1);

        assertEquals(5, player.getNumberOfCardsInHand());
    }
}
