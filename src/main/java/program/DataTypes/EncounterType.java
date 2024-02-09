package program.DataTypes;

public enum EncounterType {
    WALKING("Walking"),
    SURFING("Surfing"),
    SUPER_ROD("Super Rod"),
    INTERACT("Interact"),
    TRADE("Trade"),
    GIFT("Gift");

    private String encounterTypeString;

    private EncounterType(String encounterTypeString) {
        this.encounterTypeString = encounterTypeString;
    }

    @Override
    public String toString() {
        return this.encounterTypeString;
    }
}
