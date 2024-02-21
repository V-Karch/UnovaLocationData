package program.DataTypes.Classes;

public class CollectionManager {
    public static String[] allLocations = {
        "Route 1",
        "Route 2",
        "Route 3",
        "Route 4",
        "Route 5",
        "Route 6",
        "Route 7",
        "Route 8",
        "Route 9",
        "Route 10",
        "Route 11",
        "Route 12",
        "Route 13",
        "Route 14",
        "Route 15",
        "Route 16",
        "Route 17",
        "Route 18",
        "Route 19",
        "Route 20",
        "Route 21",
        "Route 22",
        "Route 23",
        "Abundant Shrine",
        "Accumula Town",
        "Aspertia City",
        "Castelia City",
        "Castelia Sewers",
        "Celestial Tower",
        "Challenger's Cave",
        "Chargestone Cave",
        "Clay Tunnel",
        "Cold Storage",
        "Desert Resort",
        "Dragonspiral Tower",
        "Dreamyard",
        "Driftveil City",
        "Driftveil Drawbridge",
        "Floccesy Ranch",
        "Giant Chasm",
        "Humilau City",
        "Icirrus City",
        "Liberty Island",
        "Lostlorn Forest",
        "Marvelous Bridge",
        "Mistralton Cave",
        "Moor of Icirrus",
        "N's Castle",
        "Nacrene City",
        "Nature Preserve",
        "Nature Sanctuary",
        "Nuvema Town",
        "P2 Laboratory",
        "Pinwheel Forest",
        "Relic Castle",
        "Relic Passage",
        "Reversal Mountain",
        "Roaming Unova",
        "Seaside Cave",
        "Strange House",
        "Striaton City",
        "Twist Mountain",
        "Undella Bay",
        "Undella Town",
        "Underground Ruins",
        "Victory Road",
        "Village Bridge",
        "Virbank City",
        "Virbank Complex",
        "Wellspring Cave",
        "White Forest"
    };

    /**
     * Attempts to load a location
     * If it fails to, returns null
     */
    public static Collection loadLocation(String locationName) {
        boolean validityCheck = isValidLocation(locationName);

        if (!validityCheck) {
            System.out.printf("Location name \"%s\" is not a valid location.\n", locationName);
            return null;
        }

        Collection collection = new Collection(locationName);
        return collection;
    }

    /**
     * Loads every Entry in the file and returns them as a Collection
     * @return Collection
     */
    public static Collection loadAll() {
        Collection result = new Collection(Entry.readAll("data/encounterData.csv"));
        return result; // Loads all Entries and returns a collection with all of them
    }

    /**
     * 
     * @param locationName String
     * @return boolean, whether the location is in the valid list (true) or not (false)
     */
    private static boolean isValidLocation(String locationName) {
        String asLowerCase = locationName.toLowerCase();

        for (int i = 0; i < allLocations.length; i++) {
            if (asLowerCase.equals(allLocations[i].toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public static void listValidLocations() {
        String toPrint = "";
        for (int i = 0; i < allLocations.length; i++) {
            toPrint += allLocations[i] + ", ";
        }

        toPrint = toPrint.substring(0, toPrint.length() - 2);

        System.out.println(toPrint);
    }
}