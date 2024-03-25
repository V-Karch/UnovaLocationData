package program.GUI;

import javafx.scene.Node;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ListView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import program.DataTypes.Enums.Rarity;
import program.DataTypes.Enums.Season;
import program.DataTypes.Classes.Entry;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import program.DataTypes.Enums.Modifier;
import javafx.collections.ObservableList;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Classes.Collection;
import program.DataTypes.Enums.EncounterType;
import javafx.scene.control.cell.PropertyValueFactory;

public class GUIFactory {
    private static final ArrayList<String> validNodeTypes = new ArrayList<>();
    private static final ArrayList<String> validLocations = new ArrayList<>();

    static {
        validNodeTypes.add("Label");
        validNodeTypes.add("ComboBox");
        validNodeTypes.add("TextField");
        validNodeTypes.add("Button");

        // Lots of stuff in here, please try not to vomit
        validLocations.add("All");
        validLocations.add("Route 1");
        validLocations.add("Route 2");
        validLocations.add("Route 3");
        validLocations.add("Route 4");
        validLocations.add("Route 5");
        validLocations.add("Route 6");
        validLocations.add("Route 7");
        validLocations.add("Route 8");
        validLocations.add("Route 9");
        validLocations.add("Route 10");
        validLocations.add("Route 11");
        validLocations.add("Route 12");
        validLocations.add("Route 13");
        validLocations.add("Route 14");
        validLocations.add("Route 15");
        validLocations.add("Route 16");
        validLocations.add("Route 17");
        validLocations.add("Route 18");
        validLocations.add("Route 19");
        validLocations.add("Route 20");
        validLocations.add("Route 21");
        validLocations.add("Route 22");
        validLocations.add("Route 23");
        validLocations.add("Abundant Shrine");
        validLocations.add("Accumula Town");
        validLocations.add("Aspertia City");
        validLocations.add("Castelia City");
        validLocations.add("Castelia Sewers");
        validLocations.add("Celestial Tower");
        validLocations.add("Challenger's Cave");
        validLocations.add("Chargestone Cave");
        validLocations.add("Clay Tunnel");
        validLocations.add("Cold Storage");
        validLocations.add("Desert Resort");
        validLocations.add("Dragonspiral Tower");
        validLocations.add("Dreamyard");
        validLocations.add("Driftveil City");
        validLocations.add("Driftveil Drawbridge");
        validLocations.add("Floccesy Ranch");
        validLocations.add("Giant Chasm");
        validLocations.add("Humilau City");
        validLocations.add("Icirrus City");
        validLocations.add("Liberty Island");
        validLocations.add("Lostlorn Forest");
        validLocations.add("Marvelous Bridge");
        validLocations.add("Mistralton Cave");
        validLocations.add("Moor of Icirrus");
        validLocations.add("N's Castle");
        validLocations.add("Nacrene City");
        validLocations.add("Nature Preserve");
        validLocations.add("Nature Sanctuary");
        validLocations.add("Nuvema Town");
        validLocations.add("P2 Laboratory");
        validLocations.add("Pinwheel Forest");
        validLocations.add("Relic Castle");
        validLocations.add("Relic Passage");
        validLocations.add("Reversal Mountain");
        validLocations.add("Roaming Unova");
        validLocations.add("Seaside Cave");
        validLocations.add("Strange House");
        validLocations.add("Striaton City");
        validLocations.add("Twist Mountain");
        validLocations.add("Undella Bay");
        validLocations.add("Undella Town");
        validLocations.add("Underground Ruins");
        validLocations.add("Victory Road");
        validLocations.add("Village Bridge");
        validLocations.add("Virbank City");
        validLocations.add("Virbank Complex");
        validLocations.add("Wellspring Cave");
        validLocations.add("White Forest");
    }

    /**
     * This method only works correctly after the stage has been shown at least
     * one time
     * 
     * @param gridPane
     */
    @SuppressWarnings("rawtypes")
    public static double resizeGUI(GridPane gridPane) {
        double maximumNodeWidth = 0;

        for (Node node: gridPane.getChildren()) {
            String nodeType = node.getTypeSelector();
            if (!validNodeTypes.contains(nodeType)) {
                continue; // skip the loop if the node type
                // is invalid, ex: listview
            }

            double nodeWidth = node.getBoundsInParent().getWidth();

            if (nodeWidth > maximumNodeWidth) {
                maximumNodeWidth = nodeWidth;
            }
        } // Determine the largest width element shown

        for (Node node: gridPane.getChildren()) {
            String nodeType = node.getTypeSelector();
            switch (nodeType) {
                case "Label":
                    ((Label)node).setPrefWidth(maximumNodeWidth);
                    break;
                case "ComboBox":
                    ((ComboBox)node).setPrefWidth(maximumNodeWidth);
                    break;
                case "TextField":
                    ((TextField)node).setPrefWidth(maximumNodeWidth);
                    break;
                case "Button":
                    ((Button)node).setPrefWidth(maximumNodeWidth);
                    break;
                default:
                    break;
            }
        }

        return maximumNodeWidth;
    }
    public static ComboBox<EncounterType> encounterTypeDropdown() {
        ObservableList<EncounterType> options = 
            FXCollections.observableArrayList(
                EncounterType.WALKING,
                EncounterType.SURFING,
                EncounterType.SUPER_ROD,
                EncounterType.INTERACT,
                EncounterType.TRADE,
                EncounterType.GIFT
            );

        final ComboBox<EncounterType> dropdownMenu = new ComboBox<>(options);
        return dropdownMenu;
    }

    public static Label encounterTypeLabel() {
        Label label = new Label("Encounter Type:");
        return label;
    }

    public static ComboBox<GameVersion> gameVersionDropdown() {
        ObservableList<GameVersion> options = 
            FXCollections.observableArrayList(
                GameVersion.BLACK,
                GameVersion.WHITE,
                GameVersion.BLACK2,
                GameVersion.WHITE2
            );
        // ^^ POSSIBLY MODIFY LATER TO INCLUDE ALL GAME VERSIONS AS AN OPTION

        final ComboBox<GameVersion> dropdownMenu = new ComboBox<>(options);
        return dropdownMenu;
    }

    public static Label gameVersionLabel() {
        Label label = new Label("Game Version:");
        return label;
    }

    public static ComboBox<Modifier> modifierDropdown() {
        ObservableList<Modifier> options =
            FXCollections.observableArrayList(
                Modifier.NONE,
                Modifier.DOUBLE_GRASS,
                Modifier.SHAKING_BUBBLING_SPOTS,
                Modifier.SWARM
            );

        final ComboBox<Modifier> dropdownMenu = new ComboBox<>(options);
        return dropdownMenu;
    }

    public static Label modifierLabel() {
        Label label = new Label("Modifier:");
        return label;
    }

    public static ComboBox<Rarity> rarityDropdown() {
        ObservableList<Rarity> options = 
            FXCollections.observableArrayList(
                Rarity.COMMON,
                Rarity.UNCOMMON,
                Rarity.RARE,
                Rarity.LIMITED
            );

        final ComboBox<Rarity> dropdownMenu = new ComboBox<>(options);
        return dropdownMenu;
    }

    public static Label rarityLabel() {
        Label label = new Label("Rarity:");
        return label;
    }

    public static ComboBox<Season> seasonDropdown() {
        ObservableList<Season> options =
            FXCollections.observableArrayList(
                Season.SPRING,
                Season.SUMMER,
                Season.AUTUMN,
                Season.WINTER
            );

        final ComboBox<Season> dropdownMenu = new ComboBox<>(options);
        return dropdownMenu;
    }

    public static Label seasonLabel() {
        Label label = new Label("Season:");
        return label;
    }

    public static TextField pokemonNameEntry() {
        TextField entryField = new TextField();
        return entryField;
    }

    public static Label pokemonNameLabel() {
        Label label = new Label("Pokemon Name:");
        return label;
    }

    public static TextField levelEntry() {
        TextField entryField = new TextField();
        return entryField;
    }

    public static Label levelLabel() {
        Label label = new Label("Level:");
        return label;
    }

    public static Button resetButton() {
        Button button = new Button("Reset Filters");
        return button;
    }

    public static Button searchButton() {
        Button button = new Button("Search");
        return button;
    }

    public static ComboBox<String> locationDropDown() {
        ObservableList<String> options = FXCollections.observableArrayList(validLocations);
        final ComboBox<String> dropdownMenu = new ComboBox<>(options);

        return dropdownMenu;
    }
    
    public static Label locationLabel() {
        Label label = new Label("Location:");
        return label;
    }

    public static ListView<Entry> entryList() {
        ListView<Entry> list = new ListView<>();
        return list;
    }

    @SuppressWarnings("unchecked")
    public static TableView<Entry> entryTableView() {
        TableView<Entry> entryTable = new TableView<>();
        entryTable.setEditable(false);
        TableColumn<Entry, String> pokemonNameColumn = new TableColumn<>("Pokemon"); 
        TableColumn<Entry, String> gameVersionColumn = new TableColumn<>("Versions"); 
        TableColumn<Entry, String> seasonColumn = new TableColumn<>("Seasons"); 
        TableColumn<Entry, String> rarityColumn = new TableColumn<>("Rarity"); 
        TableColumn<Entry, String> levelColumn = new TableColumn<>("Levels"); 
        TableColumn<Entry, String> encounterTypeColumn = new TableColumn<>("Encounter Type");
        TableColumn<Entry, String> modifierColumn = new TableColumn<>("Modifier");
        TableColumn<Entry, String> floorColumn = new TableColumn<>("Floor");
        TableColumn<Entry, String> locationColumn = new TableColumn<>("Location");

        pokemonNameColumn.setCellValueFactory(new PropertyValueFactory<>("pokemonName"));
        gameVersionColumn.setCellValueFactory(new PropertyValueFactory<>("gameVersions"));
        seasonColumn.setCellValueFactory(new PropertyValueFactory<>("seasons"));
        rarityColumn.setCellValueFactory(new PropertyValueFactory<>("rarity"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("levelRange"));


        encounterTypeColumn.setMinWidth(130);

        entryTable.getColumns().addAll(pokemonNameColumn, 
        gameVersionColumn, seasonColumn, rarityColumn, 
        levelColumn, encounterTypeColumn, 
        modifierColumn, floorColumn, locationColumn);

        for (TableColumn<Entry, ?> column: entryTable.getColumns()) {
            column.setEditable(false);
            column.setResizable(false);
            column.setReorderable(false);
            column.setSortable(false);
        }

        return entryTable;
    }

    public static void updateTable(TableView<Entry> entryTableView, 
    Collection filteredCollection) {
        ObservableList<Entry> entryList = 
            FXCollections.observableArrayList(filteredCollection.getAllEntries());
        
        entryTableView.setItems(entryList);
    }
}
