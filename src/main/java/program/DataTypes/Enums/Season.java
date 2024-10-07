package program.DataTypes.Enums;

public enum Season {
    SPRING("Spring"),
    SUMMER("Summer"),
    AUTUMN("Autumn"),
    WINTER("Winter"),
    ALL("All");

    private final String seasonString;

    private Season(String seasonString) {
        this.seasonString = seasonString;
    }

    @Override
    public String toString() {
        return this.seasonString;
    }
    public static Season[] fromString(String readLine) {
        if (readLine.contains("/")) { // Cannot be all
            String[] seasonStrings = readLine.split("/");
            Season[] result = new Season[seasonStrings.length];

            for (int i = 0; i < seasonStrings.length; i++) {
                switch (seasonStrings[i]) {
                    case "Spring":
                        result[i] = Season.SPRING;
                        break;
                    case "Summer":
                        result[i] = Season.SUMMER;
                        break;
                    case "Autumn":
                        result[i] = Season.AUTUMN;
                        break;
                    case "Winter":
                        result[i] = Season.WINTER;
                        break;
                }
            }

            return result;
        }

        switch (readLine) {
            case "All":
                Season[] all = { Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER };
                return all;
            case "Spring":
                Season[] spring = { Season.SPRING };
                return spring;
            case "Summer":
                Season[] summer = { Season.SUMMER };
                return summer;
            case "Autumn":
                Season[] autumn = { Season.AUTUMN };
                return autumn;
            case "Winter":
                Season[] winter = { Season.WINTER };
                return winter;
            default:
                Season[] defaultSeasons = { Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER };
                return defaultSeasons;
        }
    }
}
