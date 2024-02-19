package program.DataTypes.Enums;

public enum Rarity {
    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    LIMITED("Limited");

    private String rarityString;

    private Rarity(String rarityString) {
        this.rarityString = rarityString;
    }

    @Override
    public String toString() {
        return this.rarityString;
    }

    public static Rarity fromString(String readLine) {
        switch (readLine) {
            case "Common":
                return Rarity.COMMON;
            case "Uncommon":
                return Rarity.UNCOMMON;
            case "Rare":
                return Rarity.RARE;
            case "Limited":
                return Rarity.LIMITED;
            default:
                return Rarity.COMMON;
        }
    }
}
