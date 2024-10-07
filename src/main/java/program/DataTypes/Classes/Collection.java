package program.DataTypes.Classes;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

import program.DataTypes.Enums.FilterType;

public class Collection {
    private final ArrayList<Entry> collection;
    public String locationName;
    public Collection(String locationName) {
        this.collection = Entry.readLocation("data/encounterData.csv", locationName);
        this.locationName = locationName;
    }

    public Collection(ArrayList<Entry> collection) {
        this.collection = collection; // Alternate constructor for chaining
        this.locationName = "N/A";
    }

    public Collection() {
        this.collection = new ArrayList<>(); // Create empty collection
        this.locationName = "N/A"; // Creating an empty collection
    }

    public ArrayList<Entry> getAllEntries() {
        return this.collection;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void printAllEntries() {
        this.collection.stream().forEach(entry -> {
            System.out.println(entry);
        });
    }
    private Collection filterEncounterType(String filterString) {
        if (filterString.equals("all")) {
            return this;
        }

        ArrayList<Entry> result = this.collection
            .stream()
            .filter(e -> e.getEncounterType().toLowerCase().equals(filterString))
            .collect(Collectors.toCollection(ArrayList::new));

        return new Collection(result);
    };

    private Collection filterFloor(String filterString) {
        ArrayList<Entry> result = this.collection
            .stream()
            .filter(e -> e.getFloor().toLowerCase().equals(filterString))
            .collect(Collectors.toCollection(ArrayList::new));

        return new Collection(result);
    };

    private Collection filterGameVersion(String filterString) {
        if (filterString.equals("all")) {
            return this;
        }

        ArrayList<Entry> filteredEntries = this.collection.stream()
            .filter(e -> Arrays.asList(e.getGameVersionsArray()).contains(filterString))
            .collect(Collectors.toCollection(ArrayList::new));
        
        return new Collection(filteredEntries);
    };

    private Collection filterLevel(String filterString) {
        if (!filterString.contains("-")) {
            try { // no range found
                int value = Integer.parseInt(filterString);

                ArrayList<Entry> filteredEntries = this.collection.stream()
                    .filter(e -> Arrays.asList(e.getPossibleLevels()).contains(value))
                    .collect(Collectors.toCollection(ArrayList::new));

                return new Collection(filteredEntries);
            } catch (NumberFormatException e) {
                return this; // if anything breaks, act like nothing happened
            }
        } else {
            String[] values = filterString.split("-");

            try {
                int minimum = Integer.parseInt(values[0]);
                int maximum = Integer.parseInt(values[1]);

                List<Integer> levelRange = IntStream.rangeClosed(minimum, maximum).boxed().collect(Collectors.toList());

                ArrayList<Entry> filteredEntries = this.collection.stream()
                    .filter(e -> Arrays.asList(e.getPossibleLevels()).stream().anyMatch(levelRange::contains))
                    .collect(Collectors.toCollection(ArrayList::new));

                return new Collection(filteredEntries);
            } catch (NumberFormatException e) {
                return this; // act like nothing happened if it breaks
            }
        }
    };

    private Collection filterModifier(String filterString) {
        ArrayList<Entry> result = this.collection
            .stream()
            .filter(e -> e.getModifier().toLowerCase().equals(filterString))
            .collect(Collectors.toCollection(ArrayList::new));

        return new Collection(result);
    };

    private Collection filterPokemonName(String filterString) {
        ArrayList<Entry> result = this.collection
            .stream()
            .filter(e -> e.getPokemonName().toLowerCase().equals(filterString))
            .collect(Collectors.toCollection(ArrayList::new));

        return new Collection(result);
    };

    private Collection filterRarity(String filterString) {
        ArrayList<Entry> result = this.collection
            .stream()
            .filter(e -> e.getRarity().toLowerCase().equals(filterString))
            .collect(Collectors.toCollection(ArrayList::new));

        return new Collection(result);
    };

    private Collection filterSeason(String filterString) {
        if (filterString.equals("all")) {
            return this;
        }

        ArrayList<Entry> filteredEntries = this.collection.stream()
            .filter(e -> Arrays.asList(e.getSeasonsArray())
            .contains(filterString))
            .collect(Collectors.toCollection(ArrayList::new));

        return new Collection(filteredEntries);
    };

    private Collection filterLocation(String filterString) {
        if (filterString.equals("all")) {
            return this;
        }

        ArrayList<Entry> result = this.collection
            .stream()
            .filter(e -> e.getLocation().toLowerCase().equals(filterString))
            .collect(Collectors.toCollection(ArrayList::new));

        return new Collection(result);
    };

    public Collection filter(FilterType method, String filterString) {
        filterString = filterString.toLowerCase();

        switch (method) {
            case ENCOUNTER_TYPE:
                return this.filterEncounterType(filterString);
            case FLOOR:
                return this.filterFloor(filterString);
            case GAME_VERSION:
                return this.filterGameVersion(filterString);
            case LEVEL:
                return this.filterLevel(filterString);
            case MODIFIER:
                return this.filterModifier(filterString);
            case POKEMON_NAME:
                return this.filterPokemonName(filterString);
            case RARITY:
                return this.filterRarity(filterString);
            case SEASON:
                return this.filterSeason(filterString);
            case LOCATION:
                return this.filterLocation(filterString);
            default:
                return this; // If the method is somehow unknown, give back the original collection
        }
    }

    public Collection combine(Collection otherCollection) {
        ArrayList<Entry> result = this.collection;
        ArrayList<Entry> otherEntries = otherCollection.getAllEntries();

        otherEntries.stream().forEach(entry -> {
            result.add(entry);
        });

        return new Collection(result);
    }
}
