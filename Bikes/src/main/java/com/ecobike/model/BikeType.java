package com.ecobike.model;

public enum BikeType {
    E_BIKE("E-BIKE"), FOLDING_BIKE("FOLDING BIKE"), SPEEDELEC("SPEEDELEC");

    private final String name;

    BikeType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
