package program.DataTypes;

public class Location {
    private Entry[] entries;
    public Location(Entry[] entries) {
        this.entries = entries;
    }

    public Entry[] getAllEntries() {
        return this.entries;
    }
}
