package edu.ntnu.idi.idatt.controller;


import edu.ntnu.idi.idatt.model.DeckOfCards;
import edu.ntnu.idi.idatt.model.HandOfCards;
import edu.ntnu.idi.idatt.model.Rank;
import edu.ntnu.idi.idatt.model.Card;
import edu.ntnu.idi.idatt.model.Suit;

import edu.ntnu.idi.idatt.view.CardGameView;
import edu.ntnu.idi.idatt.view.CardAreaView;
import edu.ntnu.idi.idatt.view.ControlPanelView;

import java.util.stream.Collectors;
import javafx.scene.image.Image;

/**
 * controller for card game
 */

public class CardGameController {
  private CardAreaView cardAreaView;
  private ControlPanelView controlPanelView;

  private DeckOfCards deck;
  private HandOfCards hand;

  /**
   * Constructs a new card game controller
   */
  public CardGameController() {
    initDeckOfCards();
  }

  /**
   * inits views card game view

   */
  public void initViews(CardGameView cardGameView) {
    this.controlPanelView = cardGameView.getControlPanelView();
    this.cardAreaView = cardGameView.getCardAreaView();
  }

  public void handleDealHandButtonClick() {
    this.hand = deck.dealHand(5);
    updateCards();
  }

  /**
   * Handles the click of the check hand button
   */
  public void handleCheckHandButtonClick() {
    updateSumValueLabel();
    updateHeartsValueLabel();
    updateQueenValueLabel();
    updateFlushValueLabel();
  }

  /**
   * Initializes the deck of cards
   */
  private void initDeckOfCards() {
    this.deck = new DeckOfCards();
  }

  /**
   * Updates the cards in the card area view
   */
  private void updateCards() {
    for (int i = 0; i < hand.getCards().size(); i++) {
      Card card = hand.getCards().get(i);
      cardAreaView.getCardImages().get(i).setImage(new Image(String.format(
          "images/%d_of_%s.png", card.rank().getValue(), card.suit().toString()
      )));
    }
  }

  /**
   * Updates the sum value label view
   */
  private void updateSumValueLabel() {
    int sum = 0;
    for (Card card : hand.getCards()) {
      sum += card.rank().getValue();
    }

    final int finalSum = sum;
    controlPanelView.getSumValueLabel().setText(String.valueOf(finalSum));
  }

  /**
   * Updates the hearts value label view
   */
  private void updateHeartsValueLabel() {
    String handString = hand.getCards().stream()
        .filter(card -> card.suit().equals(Suit.HEARTS))
        .map(card -> String.valueOf(card.suit().toString().charAt(0)) + card.rank().getValue())
        .collect(Collectors.joining(" "));

    if (handString.isEmpty()) {
      controlPanelView.getHeartsValueLabel().setText("No hearts");
      return;
    }
    controlPanelView.getHeartsValueLabel().setText(handString);
  }

  /**
   * Updates the queen value label view
   */
  private void updateQueenValueLabel() {
    for (Card card : hand.getCards()) {
      if (card.rank().equals(Rank.QUEEN) && card.suit().equals(Suit.SPADES)) {
        controlPanelView.getQueenValueLabel().setText("The queen of spades is in the hand");
        return;
      }
      controlPanelView.getQueenValueLabel().setText("No queen of spades");
    }
  }

  /**
   * Updates the flush value label view
   */
  private void updateFlushValueLabel() {
    if (hand.checkFlush()) {
      controlPanelView.getFlushValueLabel().setText("Flush in hand");
    } else {
      controlPanelView.getFlushValueLabel().setText("No flush");
    }
  }


}
