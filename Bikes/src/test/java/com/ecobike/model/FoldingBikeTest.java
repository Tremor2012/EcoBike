package com.ecobike.model;

import junit.framework.TestCase;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FoldingBikeTest extends TestCase {

    public void testConstruct() {
        FoldingBike bike = new FoldingBike("Dahon", "14", "21", "12200", "true", "golden", "1169");
        assertEquals(BikeType.FOLDING_BIKE, bike.getType());
        assertEquals("Dahon", bike.getBrand());
        assertEquals(14, bike.getWheels());
        assertEquals(21, bike.getGears());
        assertEquals(12200, bike.getWeight());
        assertEquals(true, bike.getLights());
        assertEquals("golden", bike.getColor());
        assertEquals(new BigDecimal(1169), bike.getPrice());
    }

    public void testToRecord() {
        Bike bike = new FoldingBike("Dahon", "14", "21", "12200", "true", "golden", "1169");
        assertEquals("FOLDING BIKE Dahon; 14; 21; 12200; true; golden; 1169\n", bike.toRecord());
    }

    public void testToString() {
        Bike bike = new FoldingBike("Dahon", "14", "21", "12200", "true", "golden", "1169");
        assertEquals("FOLDING BIKE Dahon with 21 gear(s) and head/tail light\n" +
                "Price: 1169 euros.\n", bike.toString());
    }

    public void testEquals() {
        Bike bike1 = new FoldingBike("Dahon", "14", "21", "12200", "true", "golden", "1169");
        Bike bike2 = new FoldingBike("Dahon", "14", "21", "12200", "true", "golden", "1169");
        assertEquals(bike1, bike2);
    }

    public void testNotEquals() {
        Bike baseBike = new FoldingBike("Dahon", "14", "21", "12200", "true", "golden", "1169");
        Bike otherBike = new FoldingBike("Comanche", "14", "21", "12200", "true", "golden", "1169");
        assertNotEquals(baseBike, otherBike);
        otherBike = new FoldingBike("Dahon", "15", "21", "12200", "true", "golden", "1169");
        assertNotEquals(baseBike, otherBike);
        otherBike = new FoldingBike("Dahon", "14", "22", "12201", "true", "golden", "1169");
        assertNotEquals(baseBike, otherBike);
        otherBike = new FoldingBike("Dahon", "14", "21", "12200", "false", "golden", "1169");
        assertNotEquals(baseBike, otherBike);
        otherBike = new FoldingBike("Dahon", "14", "21", "12200", "true", "red", "1169");
        assertNotEquals(baseBike, otherBike);
        otherBike = new FoldingBike("Dahon", "14", "21", "12200", "true", "golden", "116");
        assertNotEquals(baseBike, otherBike);
    }
}