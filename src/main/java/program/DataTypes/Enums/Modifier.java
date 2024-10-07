package program.DataTypes.Enums;

public enum Modifier {
    SHAKING_BUBBLING_SPOTS("Shaking/Bubbling spots"),
    DOUBLE_GRASS("Double Grass"),
    NONE("None"),
    SWARM("Swarm");

    private final String modifierString;

    private Modifier(String modifierString) {
        this.modifierString = modifierString;
    }

    @Override
    public String toString() {
        return this.modifierString;
    }

    public static Modifier fromString(String readLine) {
        readLine = readLine.toLowerCase();
        switch (readLine) {
            case "shaking/bubbling spots":
                return Modifier.SHAKING_BUBBLING_SPOTS;
            case "double grass":
                return Modifier.DOUBLE_GRASS;
            case "swarm":
                return Modifier.SWARM;
            case "":
                return Modifier.NONE;
            default:
                return Modifier.NONE;
        }
    }
}
