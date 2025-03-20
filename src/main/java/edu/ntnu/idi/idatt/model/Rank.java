package edu.ntnu.idi.idatt.model;



public enum Rank {
  /**
   * according to our given task ace value should be set to 1
   */
  ACE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13);

  private final int value;

  private Rank(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

}
