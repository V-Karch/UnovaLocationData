package program.DataTypes;

public enum GameVersion {
    BLACK("Black"),
    WHITE("White"),
    BLACK2("Black 2"),
    WHITE2("White 2");

    private String gameVersionString;

    private GameVersion(String gameVersionString) {
        this.gameVersionString = gameVersionString;
    }

    @Override
    public String toString() {
        return this.gameVersionString;
    }
}
