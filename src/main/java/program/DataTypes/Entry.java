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
}
