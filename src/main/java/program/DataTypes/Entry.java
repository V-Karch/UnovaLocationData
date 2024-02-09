package program.DataTypes;

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
}
