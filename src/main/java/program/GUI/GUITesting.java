package program.GUI;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.application.Application;

public class GUITesting extends Application {
    public static void main(String args[]) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setStyle("-fx-background-color: #9695a0");
        stage.setTitle("Unova Location Data Parser");
        gridPane.add(GUIFactory.gameVersionLabel(), 0, 0);
        gridPane.add(GUIFactory.gameVersionDropdown(), 0, 1);
        gridPane.add(GUIFactory.encounterTypeLabel(), 1, 0);
        gridPane.add(GUIFactory.encounterTypeDropdown(), 1, 1);
        gridPane.add(GUIFactory.modifierLabel(), 2, 0);
        gridPane.add(GUIFactory.modifierDropdown(), 2, 1);
        gridPane.add(GUIFactory.rarityLabel(), 0, 3);
        gridPane.add(GUIFactory.rarityDropdown(), 0, 4);
        gridPane.add(GUIFactory.seasonLabel(), 1, 3);
        gridPane.add(GUIFactory.seasonDropdown(), 1, 4);
        gridPane.add(GUIFactory.pokemonNameLabel(), 2, 3);
        gridPane.add(GUIFactory.pokemonNameEntry(), 2, 4);

        Scene scene = new Scene(gridPane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
