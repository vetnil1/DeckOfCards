package edu.ntnu.idi.idatt;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Suit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CardTest {

  /**
   * Test class for the positive tests in the CardTest class
   */
  @Nested
  class PositiveTests {

    /**
     * Test creating a card with a valid suit and rank
     */

    @Test
    void testCreateCardWithValidSuitAndRank() {
      Card card = new Card(Suit.CLUBS, Rank.ACE);
      assertEquals(Suit.CLUBS, card.suit());
      assertEquals(Rank.ACE, card.rank());
    }
  }

  /**
   * Test class for the negative tests in the CardTest class
   */
  @Nested
  class NegativeTests {

    /**
     * Test creating a card object with a null suit
     */
    @Test
    void testCreateCardWithInvalidSuit() {
      assertThrows(IllegalArgumentException.class, () -> new Card(null, Rank.ACE));
    }

    /**
     * Test creating a card object with a null rank
     */
    @Test
    void testCreateCardWithInvalidRank() {
      assertThrows(IllegalArgumentException.class, () -> new Card(Suit.CLUBS, null));
    }

    /**
     * Test creating a card object with a null suit and rank
     */

    @Test
    void testCreateCardWithNullSuitAndRank() {
      assertThrows(IllegalArgumentException.class, () -> new Card(null, null));
    }
  }
}