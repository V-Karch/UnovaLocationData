package program.DataTypes.Classes;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import program.DataTypes.Enums.EncounterType;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Enums.Modifier;
import program.DataTypes.Enums.Rarity;
import program.DataTypes.Enums.Season;

public class Entry {
    private final String floor;
    private final Rarity rarity;
    private final String details;
    private final String location;
    private final int minimumLevel;
    private final int maximumLevel;
    private final Season[] seasons;
    private final Modifier modifier;
    private final String pokemonName;
    private final String formInformation;
    private final GameVersion[] gameVersions;
    private final EncounterType encounterType;

    public Entry(String floor, Rarity rarity, String details, 
    String location, int minimumLevel, int maximumLevel, 
    Season[] seasons,Modifier modifier, String pokemonName, 
    String formInformation, GameVersion[] gameVersions, 
    EncounterType encounterType) {
        this.floor = floor;
        this.rarity = rarity;
        this.details = details;
        this.seasons = seasons;
        this.modifier = modifier;
        this.location = location;
        this.pokemonName = pokemonName;
        this.gameVersions = gameVersions;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
        this.encounterType = encounterType;
        this.formInformation = formInformation;
    }

    public static ArrayList<Entry> readLocation(String filename, String location) {
        try (FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReader(fileReader);
        ) {
            csvReader.readNext(); // Skip header
            String[] nextRecord = csvReader.readNext(); // Assign to first row
            ArrayList<Entry> result = new ArrayList<>();
            Boolean started_recording = false; // whether or not the reader has found a matching location

            while (nextRecord != null) {
                if (!location.equals(nextRecord[1])) {
                    nextRecord = csvReader.readNext(); // Read next line
                    continue; // If the location doesn't match, skip the previous line
                }

                if (!location.equals(nextRecord[1]) && started_recording) {
                    break; // Exit loop as soon as the reader hits a location that doesn't match
                    // AND is guarenteed to have read at least one location
                }

                if (!started_recording) {
                    started_recording = true; 
                    // At this point, we are certain that an eligable entry has been met
                    // If started recording is still false, turn it to true

                    // The if statement prevents multiple assignments to the same variable
                }

                // Contstruct Entry
                String pokemonName = nextRecord[0];
                EncounterType encounterType = EncounterType.fromString(nextRecord[2]);
                GameVersion[] gameVersions = GameVersion.fromString(nextRecord[3]);
                Season[] seasons = Season.fromString(nextRecord[4]);

                int minimumLevel;
                int maximumLevel;

                if (nextRecord[5].contains("-")) { // levelRange
                    String[] levelValues = nextRecord[5].split("-");
                    minimumLevel = Integer.parseInt(levelValues[0]);
                    maximumLevel = Integer.parseInt(levelValues[1]);
                } else {
                    minimumLevel = Integer.parseInt(nextRecord[5]);
                    maximumLevel = Integer.parseInt(nextRecord[5]);
                } // Assign level range

                String details = nextRecord[6];
                String floor = nextRecord[7];
                Rarity rarity = Rarity.fromString(nextRecord[8]);
                Modifier modifier = Modifier.fromString(nextRecord[9]);
                String formInformation = nextRecord[10];

                Entry readEntry = new Entry(floor, rarity, details, location, 
                minimumLevel, maximumLevel, seasons, modifier, 
                pokemonName, formInformation, gameVersions, encounterType);

                result.add(readEntry);
                nextRecord = csvReader.readNext();
            }

            return result;

        } catch (IOException | CsvValidationException e) {
            return null;
        }
    }

    public static ArrayList<Entry> readAll(String filename) {
        try (FileReader fileReader = new FileReader(filename);
        CSVReader csvReader = new CSVReader(fileReader);
        ) {
            csvReader.readNext(); // Skip header
            
            String[] nextRecord = csvReader.readNext(); // Assign first value
            ArrayList<Entry> result = new ArrayList<>();

            while (nextRecord != null) {
                // Contstruct Entry
                String pokemonName = nextRecord[0];
                String location = nextRecord[1];
                EncounterType encounterType = EncounterType.fromString(nextRecord[2]);
                GameVersion[] gameVersions = GameVersion.fromString(nextRecord[3]);
                Season[] seasons = Season.fromString(nextRecord[4]);

                int minimumLevel;
                int maximumLevel;

                if (nextRecord[5].contains("-")) { // levelRange
                    String[] levelValues = nextRecord[5].split("-");
                    minimumLevel = Integer.parseInt(levelValues[0]);
                    maximumLevel = Integer.parseInt(levelValues[1]);
                } else {
                    minimumLevel = Integer.parseInt(nextRecord[5]);
                    maximumLevel = Integer.parseInt(nextRecord[5]);
                } // Assign level range

                String details = nextRecord[6];
                String floor = nextRecord[7];
                Rarity rarity = Rarity.fromString(nextRecord[8]);
                Modifier modifier = Modifier.fromString(nextRecord[9]);
                String formInformation = nextRecord[10];

                Entry readEntry = new Entry(floor, rarity, details, location, 
                minimumLevel, maximumLevel, seasons, modifier, 
                pokemonName, formInformation, gameVersions, encounterType);

                result.add(readEntry); // Add Entry to list
                nextRecord = csvReader.readNext();
            }

            return result;

        } catch (IOException | CsvValidationException e) {
            return null;
        }
    }

    public String getFloor() {
        return this.floor;
    }

    public String getRarity() {
        return this.rarity.toString();
    }

    public String getDetails() {
        return this.details;
    }

    public String getLocation() {
        return this.location;
    }

    public String getLevelRange() {
        return this.minimumLevel == this.maximumLevel ? this.minimumLevel + "" : this.minimumLevel + "-" + this.maximumLevel;
    }

    public Integer[] getPossibleLevels() {
        if (this.minimumLevel == this.maximumLevel) {
            return new Integer[] { this.minimumLevel };
            // If the levels are equal
            // just return one of them in an array of length 1
        }

        int levelDifference = this.maximumLevel - this.minimumLevel + 1;
        Integer[] possibleLevels = new Integer[levelDifference];
        int possibleLevelsIndex = 0;

        for (int i = this.minimumLevel; i <= this.maximumLevel; i++) {
            // For every number from minimum level to maximum level
            // Add it to the returned array

            possibleLevels[possibleLevelsIndex] = i;
            possibleLevelsIndex++;
        }

        return possibleLevels;
    }

    public String getSeasons() {
        String result = "";
        String[] seasonsArray = getSeasonsArray();

        if (seasonsArray.length == 4) {
            return "All";
        }

        for (String season: getSeasonsArray()) {
            if (season.toLowerCase().equals("spring")) {
                result += "sp";
            }

            if (season.toLowerCase().equals("summer")) {
                result += "su";
            }

            if (season.toLowerCase().equals("autumn")) {
                result += "au";
            }

            if (season.toLowerCase().equals("winter")) {
                result += "wi";
            }

            result += "/";
        }

        return result.substring(0, result.length() - 1);
    }

    public String[] getSeasonsArray() {
        String[] possibleSeasons = new String[this.seasons.length];

        for (int i = 0; i < this.seasons.length; i++) {
            possibleSeasons[i] = this.seasons[i].toString().toLowerCase();
        }

        return possibleSeasons;
    }

    public String getModifier() {
        return this.modifier.toString();
    }

    public String getPokemonName() {
        return this.pokemonName;
    }
    
    public String getFormInformation() {
        return this.formInformation;
    }

    public String[] getGameVersionsArray() {
        String[] possibleGameVersions = new String[this.gameVersions.length];

        for (int i = 0; i < this.gameVersions.length; i++) {
            possibleGameVersions[i] = this.gameVersions[i].toString().toLowerCase();
        }

        return possibleGameVersions;
    }

    public String getEncounterType() {
        return this.encounterType.toString();
    }

    public String getGameVersions() {
        HashMap<String, String> aliases = new HashMap<>();
        aliases.put("black", "B");
        aliases.put("white", "W");
        aliases.put("black 2", "B2");
        aliases.put("white 2", "W2");

        return Stream.of(this.getGameVersionsArray())
            .map(version -> aliases.get(version.toLowerCase()))
            .collect(Collectors.joining("/")); /** This is wild */
    }

    private String formatGameVersionsForToString() {
        return Stream.of(this.getGameVersionsArray()).collect(Collectors.joining(", "));
    }

    private String formatSeasonsForToString() {
        String[] local_seasons = this.getSeasonsArray();
        String output = "";

        for (String season : local_seasons) {
            output += season + ", ";
        }

        return output.substring(0, output.length() - 2);
    }

    @Override
    public String toString() {
        String output = String.format(
        "Entry{pokemonName=<%s>, gameVersions=<%s>, seasons=<%s>, rarity=<%s>, levelRange=<%d-%d>, encounterType=<%s>, details=<%s>, modifier=<%s>, floor=<%s>, formInformation=<%s>}",
        pokemonName, this.formatGameVersionsForToString(), this.formatSeasonsForToString(), this.rarity.toString(),
        this.minimumLevel, this.maximumLevel, this.getEncounterType(), 
        this.getDetails(), this.getModifier(), this.getFloor(), this.getFormInformation());

        return output;
    }

    public static void printGivenEntries(ArrayList<Entry> givenEntires) {
        for (int i = 0; i < givenEntires.size(); i++) {
            System.out.println(givenEntires.get(i));
        }
    }
}
