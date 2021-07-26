package com.nix.lesson8.planet;

public class Planet implements Gravity{
    private final int yearLength;
    private final int averageTemperature;
    private final String[] satellites;

    public Planet(int yearLength, int averageTemperature, String[] satellites) {
        this.yearLength = yearLength;
        this.averageTemperature = averageTemperature;
        this.satellites = satellites;
    }


    public int getYearLength() {
        return yearLength;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public String[] getSatellites() {
        return satellites;
    }

    public void showSatellites() {
        if (satellites.length == 0) {
            System.out.println("There are no satellites");
        } else {
            for (String satellite : satellites) {
                System.out.print(satellite + " ");
            }
            System.out.println();
        }
    }

    @Override
    public double gravityAcceleration() {
        return (double) averageTemperature * yearLength / 2;
    }
}
