package com.ecobike.model;

import java.util.Objects;

public class FoldingBike extends AbstractBike {
    private int wheels;
    private int gears;


    public FoldingBike(String brand, String wheels, String gears,
                       String weight, String lights, String color, String price) {
        super(brand, weight, lights, color, price);
        this.gears = Integer.parseInt(gears);
        this.wheels = Integer.parseInt(wheels);
    }

    public BikeType getType() {
        return BikeType.FOLDING_BIKE;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    @Override
    public String toString() {
        return getType().getName() + " " + brand + " with " + gears + " gear(s) and "
                + getLightsForPrint() + "\n" + "Price: " + price + " euros.\n";
    }

    @Override
    public String toRecord() {
        return getType().getName() + " " + brand + "; " + wheels + "; " + gears + "; " + weight + "; " + lights + "; "
                + color + "; " + price + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoldingBike that = (FoldingBike) o;
        return wheels == that.wheels &&
                gears == that.gears &&
                weight == that.weight &&
                lights == that.lights &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(color, that.color) &&
                price.equals(that.price);
    }
}
