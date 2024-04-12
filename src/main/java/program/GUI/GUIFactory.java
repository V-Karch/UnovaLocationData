package program.GUI;

import java.util.List;
import java.util.Arrays;

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
import program.DataTypes.Classes.CollectionManager;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Contains all of the GUI elements used by the program, stored as static, single-load objects
 * 
 * @author Luna Karch
 */
public class GUIFactory {
    private static final ArrayList<String> validNodeTypes = new ArrayList<>();
    private static final List<String> validLocations = Arrays.asList(CollectionManager.allLocations);

    static {
        validNodeTypes.add("Label");
        validNodeTypes.add("ComboBox");
        validNodeTypes.add("TextField");
        validNodeTypes.add("Button");
    }

    public static final Label gameVersionLabel = new Label("Game Version:");
    public static final Label modifierLabel = new Label("Modifier:");
    public static final Label rarityLabel = new Label("Rarity:");
    public static final Label seasonLabel = new Label("Season:");
    public static final TextField pokemonNameEntry = new TextField();
    public static final Label pokemonNameLabel = new Label("Pokemon Name:");
    public static final TextField levelEntry = new TextField();
    public static final Label levelLabel = new Label("Level:");
    public static final Button resetButton = new Button("Reset Filters");
    public static final Button searchButton = new Button("Search");
    public static final Label locationLabel = new Label("Location:");
    public static final Label encounterTypeLabel = new Label("Encounter Type:");

    public static final ComboBox<EncounterType> encounterTypeDropdown = new ComboBox<>(
        FXCollections.observableArrayList(
                EncounterType.ALL,
                EncounterType.WALKING,
                EncounterType.SURFING,
                EncounterType.SUPER_ROD,
                EncounterType.INTERACT,
                EncounterType.TRADE,
                EncounterType.GIFT
            )
    );

    public static final ComboBox<GameVersion> gameVersionDropdown = new ComboBox<>(
        FXCollections.observableArrayList(
                GameVersion.ALL,
                GameVersion.BLACK,
                GameVersion.WHITE,
                GameVersion.BLACK2,
                GameVersion.WHITE2
            )
    );

    public static final ComboBox<Modifier> modifierDropdown = new ComboBox<>(
        FXCollections.observableArrayList(
                Modifier.NONE,
                Modifier.DOUBLE_GRASS,
                Modifier.SHAKING_BUBBLING_SPOTS,
                Modifier.SWARM
            )
    );

    public static final ComboBox<Rarity> rarityDropdown = new ComboBox<>(
        FXCollections.observableArrayList(
                Rarity.COMMON,
                Rarity.UNCOMMON,
                Rarity.RARE,
                Rarity.LIMITED
            )
    );

    public static final ComboBox<Season> seasonDropdown = new ComboBox<>(
        FXCollections.observableArrayList(
                Season.ALL,
                Season.SPRING,
                Season.SUMMER,
                Season.AUTUMN,
                Season.WINTER
            )
    );

    public static final ComboBox<String> locationDropDown = new ComboBox<>(
        FXCollections.observableArrayList(validLocations)
    );

    public static final ListView<Entry> entryList = new ListView<>();

    public static final TableView<Entry> entryTableView = makeEntryTableView();

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

    /**
     * 
     * @return Returns a TableView<Entry>, the Table View used internally to provide a single static object reference to the required table
     */
    @SuppressWarnings("unchecked")
    private static TableView<Entry> makeEntryTableView() {
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
        encounterTypeColumn.setCellValueFactory(new PropertyValueFactory<>("encounterType"));
        modifierColumn.setCellValueFactory(new PropertyValueFactory<>("modifier"));
        floorColumn.setCellValueFactory(new PropertyValueFactory<>("floor"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        encounterTypeColumn.setMinWidth(130);
        floorColumn.setMinWidth(90);
        modifierColumn.setMinWidth(160);
        locationColumn.setMinWidth(150);

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
