package com.ecobike.model;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class EBikeTest extends TestCase {

    public void testConstruct() {
        EBike bike = new EBike("Dahon", "14", "21", "true", "12200", "golden", "1169");
        assertEquals(BikeType.E_BIKE, bike.getType());
        assertEquals("Dahon", bike.getBrand());
        assertEquals(14, bike.getMaxSpeed());
        assertEquals(21, bike.getWeight());
        assertEquals(12200, bike.getBattery());
        assertEquals(true, bike.getLights());
        assertEquals("golden", bike.getColor());
        assertEquals(new BigDecimal(1169), bike.getPrice());
    }

    public void testToString() {
        Bike bike = new EBike("Koga", "14", "21", "true", "11000", "golden", "1169");
        assertEquals("E_BIKE Koga with 11000 mAh battery and head/tail light\n" +
                "Price: 1169 euros.\n", bike.toString());
    }

    public void testToRecord() {
        Bike bike = new EBike("Gazelle", "45", "25200", "true", "11000", "yellow", "855");
        assertEquals("E-BIKE Gazelle; 45; 25200; true; 11000; yellow; 855\n", bike.toRecord());
    }

    public void testEquals() {
        Bike bike1 = new EBike("Dahon", "140", "500", "true", "1500", "golden", "1169");
        Bike bike2 = new EBike("Dahon", "140", "500", "true", "1500", "golden", "1169");
        assertEquals(bike1, bike2);
    }

    public void testNotEquals() {
        Bike baseBike = new EBike("Dahon", "44", "21000", "true", "1500", "golden", "1169");
        Bike bike = new EBike("Don", "44", "21000", "true", "1500", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new EBike("Dahon", "434", "21000", "true", "1500", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new EBike("Dahon", "44", "2100", "true", "1500", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new EBike("Dahon", "44", "21000", "false", "150", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new EBike("Dahon", "44", "21000", "true", "1500", "golen", "169");
        assertNotEquals(baseBike, bike);
    }
}