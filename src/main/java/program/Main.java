package program;

import program.DataTypes.Enums.FilterType;
import program.DataTypes.Classes.Collection;
import program.DataTypes.Classes.CollectionManager;

public class Main {
    public static void main(String args[]) {
        Collection route14 = CollectionManager.loadCollection("Abundant Shrine");
        route14
            .filter(FilterType.GAME_VERSION, "Black")
            .filter(FilterType.ENCOUNTER_TYPE, "Walking")
            .printAllEntries();
    }
}