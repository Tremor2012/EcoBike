package com.ecobike.model;

public class Speedelec extends EBike {

    public Speedelec(String brand, String maxSpeed, String weight, String lights, String battery, String color, String price) {
        super(brand, maxSpeed, weight, lights, battery, color, price);
    }

    public BikeType getType() {
        return BikeType.SPEEDELEC;
    }
}