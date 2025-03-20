package edu.ntnu.idi.idatt.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import javafx.geometry.Pos;
import javafx.scene.image.Image;

import java.util.List;

/**
 * view of the card area
 */


public class CardAreaView extends StackPane {
  private final List<ImageView> cardImages;

  /**
   * Constructs a card area view
   */
  public CardAreaView() {
    this.getStyleClass().add("card-area-table");

    StackPane greenFeltPane = new StackPane();
    greenFeltPane.getStyleClass().add("card-area-table-felt");

    HBox cardBox = new HBox(10);
    cardBox.setAlignment(Pos.CENTER);
    greenFeltPane.getChildren().add(cardBox);

    String redJoker = "images/red_joker.png";
    String blackJoker = "images/black_joker.png";
    cardImages = List.of(
        new ImageView(new Image(redJoker)),
        new ImageView(new Image(blackJoker)),
        new ImageView(new Image(redJoker)),
        new ImageView(new Image(blackJoker)),
        new ImageView(new Image(redJoker))
    );
    for (ImageView cardImage : cardImages) {
      cardImage.setFitWidth(100);
      cardImage.setPreserveRatio(true);
      cardImage.getStyleClass().add("card-image");
      cardBox.getChildren().add(cardImage);
    }

    getChildren().add(greenFeltPane);
  }

  public List<ImageView> getCardImages() {
    return this.cardImages;
  }

}
