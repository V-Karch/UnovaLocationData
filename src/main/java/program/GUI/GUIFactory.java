package program.GUI;

import javafx.scene.Node;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import program.DataTypes.Enums.Rarity;
import program.DataTypes.Enums.Season;
import javafx.collections.FXCollections;
import program.DataTypes.Enums.Modifier;
import javafx.collections.ObservableList;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Enums.EncounterType;

public class GUIFactory {
    public static final ArrayList<String> validNodeTypes = new ArrayList<>();

    static {
        validNodeTypes.add("Label");
        validNodeTypes.add("ComboBox");
        validNodeTypes.add("TextField");
    }

    /**
     * This method only works correctly after the stage has been shown at least
     * one time
     * 
     * @param gridPane
     */
    @SuppressWarnings("rawtypes")
    public static void resizeGUI(GridPane gridPane) {
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
            }
        }
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
}
