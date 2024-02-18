package program;

import program.DataTypes.Location;
import program.DataTypes.LocationManager;

public class Main {
    public static void main(String args[]) {
        Location unknown = LocationManager.loadLocation("womp womp");
        unknown.printAllEntries(); // Should error
    } 
}