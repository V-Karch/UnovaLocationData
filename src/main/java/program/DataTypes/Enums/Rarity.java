package program.DataTypes.Enums;

public enum Rarity {
    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    LIMITED("Limited");

    private final String rarityString;

    private Rarity(String rarityString) {
        this.rarityString = rarityString;
    }

    @Override
    public String toString() {
        return this.rarityString;
    }

    public static Rarity fromString(String readLine) {
        readLine = readLine.toLowerCase();
        switch (readLine) {
            case "common":
                return Rarity.COMMON;
            case "uncommon":
                return Rarity.UNCOMMON;
            case "rare":
                return Rarity.RARE;
            case "limited":
                return Rarity.LIMITED;
            default:
                return Rarity.COMMON;
        }
    }
}
