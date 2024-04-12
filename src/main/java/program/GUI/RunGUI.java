package program.GUI;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.application.Application;
import program.DataTypes.Enums.Rarity;
import program.DataTypes.Enums.Season;
import program.DataTypes.Enums.Modifier;
import program.DataTypes.Enums.FilterType;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Classes.Collection;
import program.DataTypes.Enums.EncounterType;
import program.DataTypes.Classes.CollectionManager;

public class RunGUI extends Application {
    public static final Collection allData = CollectionManager.loadAll();
    // Load all the data a single time so it doesn't have to be loaded
    // repeatedly, which would waste resources
    public static void runGUI(String args[]) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setStyle("-fx-background-color: #9a9a9a");
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        stage.setTitle("Gen 5 Location Data Parser");

        // Adding everything to the gridpane
        gridPane.add(GUIFactory.gameVersionLabel, 0, 0);
        gridPane.add(GUIFactory.gameVersionDropdown, 0, 1);
        gridPane.add(GUIFactory.encounterTypeLabel, 0, 2);
        gridPane.add(GUIFactory.encounterTypeDropdown, 0, 3);
        gridPane.add(GUIFactory.modifierLabel, 0, 4);
        gridPane.add(GUIFactory.modifierDropdown, 0, 5);
        gridPane.add(GUIFactory.rarityLabel, 0, 6);
        gridPane.add(GUIFactory.rarityDropdown, 0, 7);
        gridPane.add(GUIFactory.seasonLabel, 0, 8);
        gridPane.add(GUIFactory.seasonDropdown, 0, 9);
        gridPane.add(GUIFactory.locationLabel, 0, 10);
        gridPane.add(GUIFactory.locationDropDown, 0, 11);
        gridPane.add(GUIFactory.pokemonNameLabel, 0, 12);
        gridPane.add(GUIFactory.pokemonNameEntry, 0, 13);
        gridPane.add(GUIFactory.levelLabel, 0, 14);
        gridPane.add(GUIFactory.levelEntry, 0, 15);
        gridPane.add(GUIFactory.searchButton, 0, 16);
        gridPane.add(GUIFactory.resetButton, 0, 17);
        gridPane.add(GUIFactory.entryTableView, 1, 0, 2, 18);

        GUIFactory.entryTableView.setStyle("-fx-background-color: #FFFFFF;");
        GUIFactory.entryTableView.setPrefWidth(931);
        GUIFactory.entryTableView.setMaxHeight(Double.MAX_VALUE);
        GUIFactory.entryTableView.setEditable(false);

        GUIFactory.searchButton.setOnAction(event -> {
            Collection results = search(GUIFactory.gameVersionDropdown, 
            GUIFactory.encounterTypeDropdown, 
            GUIFactory.modifierDropdown, GUIFactory.rarityDropdown, GUIFactory.seasonDropdown, 
            GUIFactory.locationDropDown, GUIFactory.pokemonNameEntry, GUIFactory.levelEntry);

            GUIFactory.updateTable(GUIFactory.entryTableView, results);
        });

        GUIFactory.resetButton.setOnAction(event -> {
            GUIFactory.gameVersionDropdown.getSelectionModel().clearSelection();
            GUIFactory.encounterTypeDropdown.getSelectionModel().clearSelection();
            GUIFactory.modifierDropdown.getSelectionModel().clearSelection();
            GUIFactory.rarityDropdown.getSelectionModel().clearSelection();
            GUIFactory.seasonDropdown.getSelectionModel().clearSelection();
            GUIFactory.locationDropDown.getSelectionModel().clearSelection();
            GUIFactory.pokemonNameEntry.clear();
            GUIFactory.levelEntry.clear();
            GUIFactory.entryTableView.getItems().clear();
        });
        
        Scene scene = new Scene(gridPane, 1140, 500);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        GUIFactory.resizeGUI(gridPane);
    }

    public static Collection search(ComboBox<GameVersion> gameVersionDropdown, 
    ComboBox<EncounterType> encounterTypeDropdown, 
    ComboBox<Modifier> modifierDropdown,
    ComboBox<Rarity> rarityDropdown, ComboBox<Season> seasonDropdown, 
    ComboBox<String> locationDropDown,
    TextField pokemonNameEntry, TextField levelEntry) {

        GameVersion gameVersion = gameVersionDropdown.getValue();
        EncounterType encounterType = GUIFactory.encounterTypeDropdown.getValue();
        Modifier modifier = modifierDropdown.getValue();
        Rarity rarity = rarityDropdown.getValue();
        Season season = seasonDropdown.getValue();
        String location = locationDropDown.getValue();
        String pokemonName = pokemonNameEntry.getText();
        String levelValues = levelEntry.getText();

        Collection result = allData; // This data will never change
        // Running .filter() is non-destructive

        if (location != null) {
            result = result.filter(FilterType.LOCATION, location);
        }

        if (gameVersion != null) {
            result = result.filter(FilterType.GAME_VERSION, gameVersion.toString());
        } // I forgot that they all take in strings... womp womp

        if (encounterType != null) {
            result = result.filter(FilterType.ENCOUNTER_TYPE, encounterType.toString());
        }

        if (modifier != null) {
            result = result.filter(FilterType.MODIFIER, modifier.toString());
        }

        if (rarity != null) {
            result = result.filter(FilterType.RARITY, rarity.toString());
        }

        if (season != null) {
            result = result.filter(FilterType.SEASON, season.toString());
        }

        if (!pokemonName.equals("")) {
            result = result.filter(FilterType.POKEMON_NAME, pokemonName);
        }

        if (!levelValues.equals("")) {
            result = result.filter(FilterType.LEVEL, levelValues);
        }
        
        return result;
    }
}
