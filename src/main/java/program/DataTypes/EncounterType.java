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

    public static EncounterType fromString(String readString) {
        switch (readString) {
            case "Walking":
                return EncounterType.WALKING;
            case "Surfing":
                return EncounterType.SURFING;
            case "Super Rod":
                return EncounterType.SUPER_ROD;
            case "Interact":
                return EncounterType.INTERACT;
            case "Trade":
                return EncounterType.TRADE;
            case "Gift":
                return EncounterType.GIFT;
            default:
                return EncounterType.WALKING;
        }
    }
}
