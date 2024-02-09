package program.DataTypes;

public class Location {
    private Entry[] entries;
    public String locationName;
    public Location(Entry[] entries, String locationName) {
        this.entries = entries;
        this.locationName = locationName;
    }

    public Entry[] getAllEntries() {
        return this.entries;
    }

    public String getLocationName() {
        return this.locationName;
    }
}
