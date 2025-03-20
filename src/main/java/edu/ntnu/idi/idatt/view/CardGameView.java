package edu.ntnu.idi.idatt.view;

import edu.ntnu.idi.idatt.controller.CardGameController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.VBox;



public class CardGameView extends VBox {
  private final CardAreaView cardAreaView;
  private final ControlPanelView controlPanelView;

  /**
   * Constructs a card game view
   */
  public CardGameView() {
    CardGameController controller = new CardGameController();

    cardAreaView = new CardAreaView();
    controlPanelView = new ControlPanelView(controller);
    VBox.setMargin(controlPanelView, new Insets(70, 0, 0, 0));

    controller.initViews(this);
    getChildren().addAll(cardAreaView, controlPanelView);

    this.getStyleClass().add("main-background");
    setPadding(new Insets(65, 65, 65, 65));
    setAlignment(Pos.CENTER);
  }


  /**
   * Returns the control panel view
   */
  public ControlPanelView getControlPanelView() {
    return controlPanelView;
  }

  /**
   * Returns the card area view
   */
  public CardAreaView getCardAreaView() {
    return cardAreaView;
  }
  /**
   * Returns the card game view
   */
  public VBox getView() {
    return this;
  }

}
