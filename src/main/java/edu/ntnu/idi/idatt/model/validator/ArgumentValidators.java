package edu.ntnu.idi.idatt.model.validator;

import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Suit;

import java.util.List;

/**
 * class which validates arguments passed through methods
 */

public class ArgumentValidators {
  /**
   * Prevents instantiation of the ArgumentValidator class
   */
  private ArgumentValidators() {
  }

  /**
   * Validates the arguments of the constructor of the Card class
   */
  public static void cardConstructorValidator(Suit suit, Rank rank) {
    if (suit == null) {
      throw new IllegalArgumentException("Suit cant be null");
    }
    if (rank == null) {
      throw new IllegalArgumentException("Rank cant be null");
    }
  }

  /**
   * Validates the arguments of the constructor of the DeckOfCards class
   */
  public static void dealHandValidator(int n, int deckSize) {
    if (n < 1) {
      throw new IllegalArgumentException("Number of cards dealt must be greater than 0");
    }
    if (n > deckSize) {
      throw new IllegalArgumentException("Number of cards dealt must be less than or equal to "
          + "the number of cards in the deck");
    }
  }

  /**
   * Validates the arguments of the constructor of the HandOfCards class
   */
  public static void handOfCardsConstructorValidator(List<Card> cards) {
    if (cards == null) {
      throw new IllegalArgumentException("Cards cant be null");
    }
    if (cards.isEmpty()) {
      throw new IllegalArgumentException("Cards cant be an empty list");
    }
  }
}
