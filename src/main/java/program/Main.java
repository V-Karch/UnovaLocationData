package program;

import java.util.ArrayList;

import program.DataTypes.Entry;
import program.DataTypes.Location;
import program.DataTypes.LocationManager;

public class Main {
    public static void main(String args[]) {
        Location route1 = LocationManager.loadLocation("Route 1");
        ArrayList<Entry> basculin = Entry.filterByPokemonName(route1.getAllEntries(), "Basculin");
        Entry.printGivenEntries(basculin);
    }
}