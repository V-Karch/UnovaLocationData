package program.DataTypes;

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

    public ArrayList<Entry> getEntriesByPokemonName(String pokemonName) {
        String asLowerCase = pokemonName.toLowerCase();
        ArrayList<Entry> foundEntries = new ArrayList<Entry>(); 

        for (int i = 0; i < this.entries.size(); i++) {
            if (asLowerCase.equals(this.entries.get(i).pokemonName().toLowerCase())) {
                foundEntries.add(this.entries.get(i));
            }
        }

        return foundEntries;
    }

    public void printAllEntries() {
        for (int i = 0; i < entries.size(); i++) {
            System.out.println(entries.get(i));
        }
    }
}
