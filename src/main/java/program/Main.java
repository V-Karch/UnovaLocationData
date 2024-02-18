package program;

import program.DataTypes.Location;
import program.DataTypes.LocationManager;

public class Main {
    public static void main(String args[]) {
        LocationManager manager = new LocationManager();
        Location unknown = manager.loadLocation("womp womp");
        unknown.printAllEntries(); // Should error
    } 
}