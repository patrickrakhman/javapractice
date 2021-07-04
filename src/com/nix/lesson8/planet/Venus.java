package com.nix.lesson8.planet;

public class Venus extends Planet {
    private static final int YEAR_LENGTH = 225;
    private static final int AVERAGE_TEMPERATURE = 462;
    private static final String[] SATELLITES = new String[0];

    public Venus() {
        super(YEAR_LENGTH, AVERAGE_TEMPERATURE, SATELLITES);
    }
}
