package com.nix.lesson8.planet;

public class Earth extends Planet {
    private static final int YEAR_LENGTH = 365;
    private static final int AVERAGE_TEMPERATURE = 14;
    private static final String[] SATELLITES = new String[]{"Moon"};

    public Earth() {
        super(YEAR_LENGTH, AVERAGE_TEMPERATURE, SATELLITES);
    }
}
