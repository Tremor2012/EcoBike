package com.ecobike.model;

import java.util.Objects;

public class EBike extends AbstractBike {
    private int maxSpeed;
    private int battery;

    public EBike(String brand, String maxSpeed, String weight,
                     String lights, String battery, String color, String price) {
        super(brand, weight, lights,color,price);
        this.brand = brand;
        this.maxSpeed = Integer.parseInt(maxSpeed);
        this.battery = Integer.parseInt(battery);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public String toString() {
        return getType().name() + " " + getBrand() + " with " + battery +" mAh battery and "
                + getLightsForPrint() + "\n" + "Price: " + getPrice() + " euros.\n";
    }

    @Override
    public BikeType getType() {
        return BikeType.E_BIKE;
    }

    @Override
    public String toRecord() {
        return getType().getName() + " " + brand + "; " + maxSpeed + "; " + weight + "; " + lights + "; "
                + battery + "; " + color + "; " + price + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EBike that = (EBike) o;
        return maxSpeed == that.maxSpeed &&
                battery == that.battery &&
                weight == that.weight &&
                lights == that.lights &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(color, that.color) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSpeed, battery);
    }
}
