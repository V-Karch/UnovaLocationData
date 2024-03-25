package program;

import program.DataTypes.Enums.FilterType;
import program.DataTypes.Classes.Collection;
import program.DataTypes.Classes.CollectionManager;

public class Main {
    public static void main(String args[]) {
        Collection data = CollectionManager.loadAll();
        data
            .filter(FilterType.LEVEL, "1-5")
            .printAllEntries();
    }
}