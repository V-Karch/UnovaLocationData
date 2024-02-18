package program;

import program.DataTypes.Location;
import program.DataTypes.LocationManager;

public class Main {
    public static void main(String args[]) {
        Location route1 = LocationManager.loadLocation("Route 1");
        route1.printAllEntries();
    } 
}