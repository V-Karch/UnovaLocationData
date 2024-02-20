package program;

import program.DataTypes.Enums.FilterType;
import program.DataTypes.Classes.Collection;

public class Main {
    public static void main(String args[]) {
        Collection route14 = new Collection("Route 14");
        route14
            .filter(FilterType.LEVEL, "58")
            .filter(FilterType.GAME_VERSION, "Black")
            .filter(FilterType.ENCOUNTER_TYPE, "Walking")
            .printAllEntries();
    }
}