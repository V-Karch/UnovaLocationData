package program;

import program.DataTypes.Classes.Location;
import program.DataTypes.Classes.LocationManager;

public class Main {
    public static void main(String args[]) {
        Location route1 = LocationManager.loadLocation("Route 1");
        route1.printAllEntries();
    }
}