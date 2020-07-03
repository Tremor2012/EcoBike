package com.ecobike.model;

import java.math.BigDecimal;

public interface Bike {

    BikeType getType();

    String getBrand();

    void setBrand(String brand);

    int getWeight();

    void setWeight(int weight);

    boolean getLights();

    void setLights(boolean lights);

    String getColor();

    void setColor(String color);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    String toRecord();
}
