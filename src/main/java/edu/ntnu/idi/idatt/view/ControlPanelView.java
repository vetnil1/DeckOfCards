package edu.ntnu.idi.idatt.view;

import edu.ntnu.idi.idatt.controller.CardGameController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class ControlPanelView extends HBox{
  private static final String DEFAULT_TEXT_CLASS = "text-label";
  private final Label sumValueLabel;
  private final Label heartsValueLabel;
  private final Label queenValueLabel;
  private final Label flushValueLabel;

  /**
   * Constructs a control panel view
   */
  public ControlPanelView(CardGameController controller) {
    this.setPrefWidth(USE_COMPUTED_SIZE);
    this.setMaxWidth(USE_PREF_SIZE);
    this.setMinWidth(USE_PREF_SIZE);
    this.setSpacing(30);
    this.setAlignment(Pos.CENTER);
    this.setPadding(new Insets(10, 30, 10, 30));
    this.getStyleClass().add("control-panel");

    Button dealHandButton = new Button("Deal hand");
    dealHandButton.getStyleClass().add("deal-hand-button");
    dealHandButton.setPrefWidth(135);

    Button checkHandButton = new Button("Check hand");
    checkHandButton.getStyleClass().add("check-hand-button");
    checkHandButton.setPrefWidth(135);

    Label sumTextLabel = new Label("Sum of the face cards");
    sumTextLabel.getStyleClass().add(DEFAULT_TEXT_CLASS);

    Label heartsTextLabel = new Label("Cards of hearts");
    heartsTextLabel.getStyleClass().add(DEFAULT_TEXT_CLASS);

    Label queenTextLabel = new Label("Queen of spades");
    queenTextLabel.getStyleClass().add(DEFAULT_TEXT_CLASS);

    Label flushTextLabel = new Label("Flush");
    flushTextLabel.getStyleClass().add(DEFAULT_TEXT_CLASS);

    sumValueLabel = new Label("0");
    sumValueLabel.getStyleClass().add("valueLabel");

    heartsValueLabel = new Label("0");
    heartsValueLabel.getStyleClass().add("valueLabel");

    queenValueLabel = new Label("0");
    queenValueLabel.getStyleClass().add("queenValueLabel");

    flushValueLabel = new Label("0");
    flushValueLabel.getStyleClass().add("flushValueLabel");

    GridPane statsPane = new GridPane();
    statsPane.setHgap(18);
    statsPane.setVgap(15);
    statsPane.add(sumTextLabel, 0, 0);
    statsPane.add(sumValueLabel, 1, 0);
    statsPane.add(heartsTextLabel, 0, 1);
    statsPane.add(heartsValueLabel, 1, 1);
    statsPane.add(queenTextLabel, 0, 2);
    statsPane.add(queenValueLabel, 1, 2);
    statsPane.add(flushTextLabel, 0, 3);
    statsPane.add(flushValueLabel, 1, 3);

    VBox buttonBox = new VBox(30);
    buttonBox.setAlignment(Pos.CENTER);
    buttonBox.getChildren().addAll(dealHandButton, checkHandButton);

    dealHandButton.setOnAction(e -> controller.handleDealHandButtonClick());
    checkHandButton.setOnAction(e -> controller.handleCheckHandButtonClick());

    getChildren().addAll(buttonBox, statsPane);
  }

  public Label getSumValueLabel() {
    return sumValueLabel;
  }

  public Label getQueenValueLabel() {
    return queenValueLabel;
  }

  public Label getFlushValueLabel() {
    return flushValueLabel;
  }

  public Label getHeartsValueLabel() {
    return heartsValueLabel;
  }

}
