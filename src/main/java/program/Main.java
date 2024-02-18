package program;

import program.DataTypes.Location;

import java.util.ArrayList;

import program.DataTypes.Entry;
import program.DataTypes.LocationManager;

public class Main {
    public static void main(String args[]) {
        Location route1 = LocationManager.loadLocation("Route 1");
        ArrayList<Entry> entries = route1.getEntriesByPokemonName("Basculin");
        Entry.printGivenEntries(entries);
    } 
}