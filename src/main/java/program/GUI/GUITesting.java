package program.GUI;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.application.Application;
import program.DataTypes.Enums.Rarity;
import program.DataTypes.Enums.Season;
import program.DataTypes.Classes.Entry;
import program.DataTypes.Enums.Modifier;
import program.DataTypes.Enums.FilterType;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Classes.Collection;
import program.DataTypes.Enums.EncounterType;
import program.DataTypes.Classes.CollectionManager;

public class GUITesting extends Application {
    public static final Collection allData = CollectionManager.loadAll();
    // Load all the data a single time so it doesn't have to be loaded
    // repeatedly, which would waste resources
    public static void main(String args[]) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setStyle("-fx-background-color: #9a9a9a");
        gridPane.setPadding(new Insets(5, 5, 5, 5));
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
        Button searchButton = GUIFactory.searchButton();
        Label locationLabel = GUIFactory.locationLabel();
        ComboBox<String> locationDropdown = GUIFactory.locationDropDown();
        ListView<Entry> entryList = GUIFactory.entryList();

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
        gridPane.add(locationLabel, 0, 10);
        gridPane.add(locationDropdown, 0, 11);
        gridPane.add(pokemonNameLabel, 0, 12);
        gridPane.add(pokemonNameEntry, 0, 13);
        gridPane.add(levelLabel, 0, 14);
        gridPane.add(levelEntry, 0, 15);
        gridPane.add(searchButton, 0, 16);
        gridPane.add(resetButton, 0, 17);
        gridPane.add(entryList, 1, 0, 2, 18);

        entryList.setStyle("-fx-background-color: #FFFFFF;");
        entryList.setPrefWidth(500);
        entryList.setMaxHeight(Double.MAX_VALUE);
        entryList.setOrientation(Orientation.VERTICAL);

        searchButton.setOnAction(event -> {
            System.out.println("Search Button Pressed!");
            Collection results = search(gameVersionDropdown, 
            encounterTypeDropdown, 
            modifierDropdown, rarityDropdown, seasonDropdown, 
            locationDropdown, pokemonNameEntry, levelEntry);

            results.printAllEntries();
        });

        resetButton.setOnAction(event -> {
            gameVersionDropdown.getSelectionModel().clearSelection();
            encounterTypeDropdown.getSelectionModel().clearSelection();
            modifierDropdown.getSelectionModel().clearSelection();
            rarityDropdown.getSelectionModel().clearSelection();
            seasonDropdown.getSelectionModel().clearSelection();
            locationDropdown.getSelectionModel().clearSelection();
            pokemonNameEntry.clear();
            levelEntry.clear();
        });
        
        Scene scene = new Scene(gridPane, 700, 500);
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
        EncounterType encounterType = encounterTypeDropdown.getValue();
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
            System.out.println("Filtered Location!");
            result.printAllEntries();
        }

        if (gameVersion != null) {
            result = result.filter(FilterType.GAME_VERSION, gameVersion.toString());
            System.out.println("Filtered Game Version!");
            result.printAllEntries();
        } // I forgot that they all take in strings... womp womp

        if (encounterType != null) {
            result = result.filter(FilterType.ENCOUNTER_TYPE, encounterType.toString());
            System.out.println("Filtered Encounter Type!");
            result.printAllEntries();
        }

        if (modifier != null) {
            result = result.filter(FilterType.MODIFIER, modifier.toString());
            System.out.println("Filtered Modifier!");
            result.printAllEntries();
        }

        if (rarity != null) {
            result = result.filter(FilterType.RARITY, rarity.toString());
            System.out.println("Filtered Rarity!");
            result.printAllEntries();
        }

        if (season != null) {
            result = result.filter(FilterType.SEASON, season.toString());
            System.out.println("Filtered Season!");
            result.printAllEntries();
        }

        if (!pokemonName.equals("")) {
            result = result.filter(FilterType.POKEMON_NAME, pokemonName);
            System.out.println("Filtered Pokemon Name!");
            result.printAllEntries();
        }

        if (!levelValues.equals("")) {
            result = result.filter(FilterType.LEVEL, levelValues);
            System.out.println("Filtered Level!");
            result.printAllEntries();
        }

        System.out.println("Reached end of method!");

        return result;
    }
}
