package com.nix.lesson8.planet;

public class Mars extends Planet {
    private static final int YEAR_LENGTH = 687;
    private static final int AVERAGE_TEMPERATURE = -63;
    private static final String[] SATELLITES = new String[]{"Phoebus", "Deimos"};

    public Mars() {
        super(YEAR_LENGTH, AVERAGE_TEMPERATURE, SATELLITES);
    }
}
