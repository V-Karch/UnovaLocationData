package program.GUI;


import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import program.DataTypes.Enums.Modifier;
import javafx.collections.ObservableList;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Enums.EncounterType;

public class GUIFactory {
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
}
