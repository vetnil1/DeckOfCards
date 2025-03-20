package edu.ntnu.idi.idatt.model;

import static edu.ntnu.idi.idatt.model.validator.ArgumentValidators.dealHandValidator;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
  private final List<Card> cards;

  /**
   * Creates a new deck of cards, and shuffles it
   */
  public DeckOfCards() {
    cards = new ArrayList<>();

    initializeDeck();
    shuffleDeck();
  }

  /**
   * Returns a list of the cards in the deck.
   */
  public List<Card> getCards()   {
    return cards;
  }

  /**
   * Creates 52 unique cards and adds them to the deck
   */
  private void initializeDeck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        this.cards.add(new Card(suit, rank));
      }
    }
  }

  /**
   * Shuffles the deck of cards
   */
  public void shuffleDeck() {
    Collections.shuffle(cards);
  }

  /**
   * Deals a hand of cards from the deck of cards
   */
  public HandOfCards dealHand(int n) {
    dealHandValidator(n, cards.size());

    shuffleDeck();
    List<Card> handCards = new ArrayList<>(cards.stream().limit(5).toList());
    return new HandOfCards(handCards);
  }
}
