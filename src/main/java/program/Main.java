package program;

import program.DataTypes.Enums.FilterType;
import program.DataTypes.Classes.Collection;
import program.DataTypes.Classes.CollectionManager;

public class Main {
    public static void main(String args[]) {
        Collection data = CollectionManager.loadAll();
        data
            .filter(FilterType.LOCATION, "Abundant Shrine")
            .filter(FilterType.GAME_VERSION, "Black")
            .filter(FilterType.ENCOUNTER_TYPE, "Interact")
            .printAllEntries();
    }
}