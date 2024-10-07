package program.DataTypes.Enums;

public enum GameVersion {
    BLACK("Black"),
    WHITE("White"),
    BLACK2("Black 2"),
    WHITE2("White 2"),
    ALL("All");

    private final String gameVersionString;

    private GameVersion(String gameVersionString) {
        this.gameVersionString = gameVersionString;
    }

    @Override
    public String toString() { return this.gameVersionString; }

    public static GameVersion[] fromString(String readLine) {
        String[] gameStrings = readLine.split("/");
        GameVersion[] result = new GameVersion[gameStrings.length];

        for (int i = 0; i < gameStrings.length; i++) {
            switch (gameStrings[i]) {
                case "Black":
                    result[i] = GameVersion.BLACK;
                    break;
                case "Black 2":
                    result[i] = GameVersion.BLACK2;
                    break;
                case "White":
                    result[i] = GameVersion.WHITE;
                    break;
                case "White 2":
                    result[i] = GameVersion.WHITE2;
                    break;
            }
        }

        return result;
    }
}
