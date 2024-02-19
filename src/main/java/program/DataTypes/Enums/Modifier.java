package program.DataTypes.Enums;

public enum Modifier {
    SHAKING_BUBBLING_SPOTS("Shaking/Bubbling spots"),
    DOUBLE_GRASS("Double Grass"),
    NONE(""),
    SWARM("Swarm");

    private String modifierString;

    private Modifier(String modifierString) {
        this.modifierString = modifierString;
    }

    @Override
    public String toString() {
        return this.modifierString;
    }

    public static Modifier fromString(String readLine) {
        switch (readLine) {
            case "Shaking/Bubbling spots":
                return Modifier.SHAKING_BUBBLING_SPOTS;
            case "Double Grass":
                return Modifier.DOUBLE_GRASS;
            case "Swarm":
                return Modifier.SWARM;
            default:
                return Modifier.NONE;
        }
    }
}
