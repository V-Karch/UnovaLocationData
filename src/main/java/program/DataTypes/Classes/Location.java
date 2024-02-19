package program.DataTypes.Classes;

import java.util.ArrayList;

public class Location {
    private ArrayList<Entry> entries;
    public String locationName;
    public Location(String locationName) {
        this.entries = Entry.readLocation("data/encounterData.csv", locationName);
        this.locationName = locationName;
    }

    public ArrayList<Entry> getAllEntries() {
        return this.entries;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void printAllEntries() {
        for (int i = 0; i < entries.size(); i++) {
            System.out.println(entries.get(i));
        }
    }
}
