package edu.ntnu.idi.idatt.model;

import static edu.ntnu.idi.idatt.model.validator.
    ArgumentValidators.cardConstructorValidator;

public record Card(Suit suit, Rank rank) {

  /**
   *Creates new card with given suit and rank
   */
  public Card{
    cardConstructorValidator(suit, rank);
  }

  @Override
  public String toString() {
    return String.format("%s of %s", rank, suit);
  }
}
