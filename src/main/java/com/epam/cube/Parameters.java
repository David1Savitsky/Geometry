package com.epam.cube;

public class Parameters {

    private final double volume;
    private final double surfaceArea;

    public Parameters(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }
}
