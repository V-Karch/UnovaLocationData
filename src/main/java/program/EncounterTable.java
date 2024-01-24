package program;

import java.util.ArrayList;

public class EncounterTable {
    private int minimumLevel;
    private int maximumLevel;

    private ArrayList<String> times;
    private ArrayList<String> seasons;
    private ArrayList<String> gameVersions;

    private String rarity;
    private String spriteUrl;
    private String pokemonName;
    private String encounterType;
    private String formAnnotation;

    public EncounterTable(int minimumLevel, int maximumLevel,
    ArrayList<String> gameVersions, ArrayList<String> seasons,
    ArrayList<String> times, String pokemonName, String encounterType,
    String formAnnotation, String rarity, String spriteUrl
    ) {
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;

        this.times = times;
        this.seasons = seasons;
        this.gameVersions = gameVersions;
        
        this.rarity = rarity;
        this.spriteUrl = spriteUrl;
        this.pokemonName = pokemonName;
        this.formAnnotation = formAnnotation;
    }

}
