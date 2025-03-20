package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.HandOfCards;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Suit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class HandOfCardsTest {

  /**
   * Test class for the positive tests in the HandOfCardsTest class.
   */
  @Nested
  class PositiveTests {

    /**
     * Test creating a hand of cards with a valid list of cards.
     */

    @Test
    void testCreateHandOfCardsWithValidListOfCards() {
      List<Card> cards = List.of(
          new Card(Suit.CLUBS, Rank.ACE),
          new Card(Suit.CLUBS, Rank.TWO),
          new Card(Suit.CLUBS, Rank.THREE),
          new Card(Suit.CLUBS, Rank.FOUR),
          new Card(Suit.CLUBS, Rank.FIVE)
      );

      HandOfCards hand = new HandOfCards(cards);
      assertEquals(cards, hand.getCards());
    }

    /**
     * Test checking a hand for a flush
     */

    @Test
    void testCheckFlush() {
      List<Card> cards = List.of(
          new Card(Suit.CLUBS, Rank.ACE),
          new Card(Suit.CLUBS, Rank.TWO),
          new Card(Suit.CLUBS, Rank.THREE),
          new Card(Suit.CLUBS, Rank.FOUR),
          new Card(Suit.CLUBS, Rank.FIVE)
      );

      HandOfCards hand = new HandOfCards(cards);
      assertTrue(hand.checkFlush());
    }
  }

  /**
   * Test class for the negative tests in the HandOfCardsTest class
   */
  @Nested
  class NegativeTests {

    /**
     * Test which creates a hand of cards with a null list of cards throws an exception
     */

    @Test
    void testCreateHandOfCardsWithNullListOfCardsThrowsException() {
      assertThrows(IllegalArgumentException.class, () -> new HandOfCards(null));
    }

    /**
     * Test that creating a hand of cards with an empty list of cards throws an exception
     */

    @Test
    void testCreateHandOfCardsWithEmptyListOfCardsThrowsException() {
      List<Card> emptyList = List.of();
      assertThrows(IllegalArgumentException.class, () -> new HandOfCards(emptyList));
    }
  }
}