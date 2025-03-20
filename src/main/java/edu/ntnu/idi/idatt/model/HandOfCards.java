package edu.ntnu.idi.idatt.model;

import static edu.ntnu.idi.idatt.model.
    validator.ArgumentValidators.handOfCardsConstructorValidator;

import java.util.List;

public class HandOfCards {
  private List<Card> cards;

  /**
   * Constructs a new hand of cards with the given list of cards
   */
  public HandOfCards(List<Card> cards) {
    handOfCardsConstructorValidator(cards);
    initializeHand(cards);
  }

  /**
   * Returns a list of the cards in the hand
   */
  public List<Card> getCards() {
    return cards;
  }

  /**
   * Initializes the hand with the given list of cards
   */
  private void initializeHand(List<Card> cards) {
    this.cards = new java.util.ArrayList<>();
    this.cards.addAll(cards);
  }

  /**
   * Checks if the hand has a flush
   */
  public boolean checkFlush() {
    return this.cards.stream().map(Card::suit).distinct().count() == 1;
  }
}