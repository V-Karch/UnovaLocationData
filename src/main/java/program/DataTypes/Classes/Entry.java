package program.DataTypes.Classes;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import program.DataTypes.Enums.EncounterType;
import program.DataTypes.Enums.GameVersion;
import program.DataTypes.Enums.Modifier;
import program.DataTypes.Enums.Rarity;
import program.DataTypes.Enums.Season;

public class Entry {
    private String floor;
    private Rarity rarity;
    private String details;
    private int minimumLevel;
    private int maximumLevel;
    private Season[] seasons;
    private Modifier modifier;
    private String pokemonName;
    private String formInformation;
    private GameVersion[] gameVersions;
    private EncounterType encounterType;

    public Entry(String floor, Rarity rarity, String details,
    int minimumLevel, int maximumLevel, Season[] seasons,
    Modifier modifier, String pokemonName, String formInformation,
    GameVersion[] gameVersions, EncounterType encounterType) {
        this.floor = floor;
        this.rarity = rarity;
        this.details = details;
        this.seasons = seasons;
        this.modifier = modifier;
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
            String[] nextRecord = csvReader.readNext(); // Skip header
            ArrayList<Entry> result = new ArrayList<>();


            while (nextRecord != null) {
                if (!location.equals(nextRecord[1])) {
                    nextRecord = csvReader.readNext(); // Read next line
                    continue; // If the location doesn't match, skip the previous line
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

                Entry readEntry = new Entry(floor, rarity, details, minimumLevel, maximumLevel, seasons,
                modifier, pokemonName, formInformation, gameVersions, encounterType);

                result.add(readEntry);
                nextRecord = csvReader.readNext();
            }

            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (CsvValidationException e) {
            e.printStackTrace();
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

    public int[] getPossibleLevels() {
        if (this.minimumLevel == this.maximumLevel) {
            return new int[] { this.minimumLevel };
            // If the levels are equal
            // just return one of them in an array of length 1
        }

        int levelDifference = this.maximumLevel - this.minimumLevel;
        int[] possibleLevels = new int[levelDifference];
        int possibleLevelsIndex = 0;

        for (int i = this.minimumLevel; i <= this.maximumLevel; i++) {
            // For every number from minimum level to maximum level
            // Add it to the returned array

            possibleLevels[possibleLevelsIndex] = i;
            possibleLevelsIndex++;
        }

        return possibleLevels;
    }

    public String[] getSeasons() {
        String[] possibleSeasons = new String[this.seasons.length];

        for (int i = 0; i < this.seasons.length; i++) {
            possibleSeasons[i] = this.seasons[i].toString();
        }

        return possibleSeasons;
    }

    public String getModifier() {
        return this.modifier.toString();
    }

    public String pokemonName() {
        return this.pokemonName;
    }
    
    public String getFormInformation() {
        return this.formInformation;
    }

    public String[] getGameVersions() {
        String[] possibleGameVersions = new String[this.gameVersions.length];

        for (int i = 0; i < this.gameVersions.length; i++) {
            possibleGameVersions[i] = this.gameVersions[i].toString();
        }

        return possibleGameVersions;
    }

    public String getEncounterType() {
        return this.encounterType.toString();
    }

    private String formatGameVersionsForToString() {
        String[] gameVersions = this.getGameVersions();
        String output = "";

        for (int i = 0; i < gameVersions.length; i++) {
            output += gameVersions[i] + ", ";
        }

        return output.substring(0, output.length() - 2);
    }

    private String formatSeasonsForToString() {
        String[] seasons = this.getSeasons();
        String output = "";

        for (int i = 0; i < seasons.length; i++) {
            output += seasons[i] + ", ";
        }

        return output.substring(0, output.length() - 2);
    }

    @Override
    public String toString() {
        String output = String.format(
        "Entry{pokemonName=<%s>, gameVersions=<%s>, seasons=<%s>, rarity=<%s>, levelRange=<%d-%d>, encounterType=<%s>, details=<%s>, modifier=<%s>, floor=<%s>, formInformation=<%s>",
        pokemonName, this.formatGameVersionsForToString(), this.formatSeasonsForToString(), this.rarity.toString(),
        this.minimumLevel, this.maximumLevel, this.getEncounterType(), 
        this.getDetails(), this.getModifier(), this.getFloor(), this.getFormInformation());

        return output;
    }

    public static void printGivenEntries(ArrayList<Entry> givenEntires) {
        for (int i = 0; i < givenEntires.size(); i++) {
            System.out.println(givenEntires.get(i));
        }

        return;
    }
    
    // Implement many methods here to filter an ArrayList<Entry> by a specific token
    public static ArrayList<Entry> filterByPokemonName(ArrayList<Entry> givenEntries, String pokemonName) {
        ArrayList<Entry> filteredResult = new ArrayList<Entry>();

        for (int i = 0; i < givenEntries.size(); i++) {
            if (givenEntries.get(i).pokemonName().toLowerCase().equals(pokemonName.toLowerCase())) {
                filteredResult.add(givenEntries.get(i));
            }
        }

        return filteredResult;
    }
}
