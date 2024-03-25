package program.GUI;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.application.Application;
import program.DataTypes.Enums.Rarity;
import program.DataTypes.Enums.Season;
import program.DataTypes.Enums.Modifier;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Enums.EncounterType;

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

        // Variable Setup
        Label gameVersionLabel = GUIFactory.gameVersionLabel();
        ComboBox<GameVersion> gameVersionDropdown = GUIFactory.gameVersionDropdown();
        Label encounterTypeLabel = GUIFactory.encounterTypeLabel();
        ComboBox<EncounterType> encounterTypeDropdown = GUIFactory.encounterTypeDropdown();
        Label modifierLabel = GUIFactory.modifierLabel();
        ComboBox<Modifier> modifierDropdown = GUIFactory.modifierDropdown();
        Label rarityLabel = GUIFactory.rarityLabel();
        ComboBox<Rarity> rarityDropdown = GUIFactory.rarityDropdown();
        Label seasonLabel = GUIFactory.seasonLabel();
        ComboBox<Season> seasonDropdown = GUIFactory.seasonDropdown();
        Label pokemonNameLabel = GUIFactory.pokemonNameLabel();
        TextField pokemonNameEntry = GUIFactory.pokemonNameEntry();
        Label levelLabel = GUIFactory.levelLabel();
        TextField levelEntry = GUIFactory.levelEntry();
        Button resetButton = GUIFactory.resetButton();

        // Adding everything to the gridpane
        gridPane.add(gameVersionLabel, 0, 0);
        gridPane.add(gameVersionDropdown, 0, 1);
        gridPane.add(encounterTypeLabel, 0, 2);
        gridPane.add(encounterTypeDropdown, 0, 3);
        gridPane.add(modifierLabel, 0, 4);
        gridPane.add(modifierDropdown, 0, 5);
        gridPane.add(rarityLabel, 0, 6);
        gridPane.add(rarityDropdown, 0, 7);
        gridPane.add(seasonLabel, 0, 8);
        gridPane.add(seasonDropdown, 0, 9);
        gridPane.add(pokemonNameLabel, 0, 10);
        gridPane.add(pokemonNameEntry, 0, 11);
        gridPane.add(levelLabel, 0, 12);
        gridPane.add(levelEntry, 0, 13);
        gridPane.add(resetButton, 0, 14);

        Scene scene = new Scene(gridPane, 500, 500);
        stage.setScene(scene);
        stage.show();

        GUIFactory.resizeGUI(gridPane);
    }
}
