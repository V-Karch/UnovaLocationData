package program.DataTypes;

public enum Season {
    SPRING("Spring"),
    SUMMER("Summer"),
    AUTUMN("Autumn"),
    WINTER("Winter");

    private String seasonString;

    private Season(String seasonString) {
        this.seasonString = seasonString;
    }

    @Override
    public String toString() {
        return this.seasonString;
    }
}
