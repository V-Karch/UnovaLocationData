package program.DataTypes;

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
}
