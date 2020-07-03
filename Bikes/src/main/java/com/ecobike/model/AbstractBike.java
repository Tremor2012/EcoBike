package com.ecobike.model;


import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractBike implements Bike{

    protected String brand;
    protected int weight;
    protected boolean lights;
    protected String color;
    protected BigDecimal price;


    public AbstractBike(String brand, String weight, String lights, String color, String price) {
        this(brand, Integer.parseInt(weight), Boolean.parseBoolean(lights), color, new BigDecimal(price));
    }

    public AbstractBike(String brand, int weight, boolean lights, String color, BigDecimal price) {
        this.brand = brand;
        this.weight = weight;
        this.lights = lights;
        this.color = color;
        this.price = price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean getLights() {
        return lights;
    }

    @Override
    public void setLights(boolean lights) {
        this.lights = lights;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    protected String getLightsForPrint() {
        if (lights)
            return  "head/tail light";
        else
            return  "no head/tail light";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBike that = (AbstractBike) o;
        return weight == that.weight &&
                lights == that.lights &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(color, that.color) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, weight, lights, color, price);
    }
}
