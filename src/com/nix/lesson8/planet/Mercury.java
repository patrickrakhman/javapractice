package com.nix.lesson8.planet;

public class Mercury extends Planet {
    private static final int YEAR_LENGTH = 89;
    private static final int AVERAGE_TEMPERATURE = 250;
    private static final String[] SATELLITES = new String[0];

    public Mercury() {
        super(YEAR_LENGTH, AVERAGE_TEMPERATURE, SATELLITES);
    }
}
