package program.DataTypes;

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
}
