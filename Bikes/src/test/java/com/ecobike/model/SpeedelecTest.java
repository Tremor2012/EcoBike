package com.ecobike.model;

import junit.framework.TestCase;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SpeedelecTest extends TestCase {

    public void testConstruct() {
        EBike bike = new Speedelec("Dahon", "14", "21", "true", "12200", "golden", "1169");
        assertEquals(BikeType.SPEEDELEC, bike.getType());
        assertEquals("Dahon", bike.getBrand());
        assertEquals(14, bike.getMaxSpeed());
        assertEquals(21, bike.getWeight());
        assertEquals(12200, bike.getBattery());
        assertEquals(true, bike.getLights());
        assertEquals("golden", bike.getColor());
        assertEquals(new BigDecimal(1169), bike.getPrice());
    }



    public void testToString() {
        Bike bike = new Speedelec("Koga", "14", "21", "true", "11000", "golden", "1169");
        assertEquals("SPEEDELEC Koga with 11000 mAh battery and head/tail light\n" +
                "Price: 1169 euros.\n", bike.toString());
    }

    public void testToRecord() {
        Bike bike = new Speedelec("Gazelle", "45", "25200", "true", "11000", "yellow", "855");
        assertEquals("SPEEDELEC Gazelle; 45; 25200; true; 11000; yellow; 855\n", bike.toRecord());
    }

    public void testEquals() {
        Bike bike1 = new Speedelec("Dahon", "140", "500", "true", "1500", "golden", "1169");
        Bike bike2 = new Speedelec("Dahon", "140", "500", "true", "1500", "golden", "1169");
        assertEquals(bike1, bike2);
    }

    public void testNotEquals() {
        Bike baseBike = new Speedelec("Dahon", "44", "21000", "true", "1500", "golden", "1169");
        Bike bike = new Speedelec("Don", "44", "21000", "true", "1500", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new Speedelec("Dahon", "434", "21000", "true", "1500", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new Speedelec("Dahon", "44", "2100", "true", "1500", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new Speedelec("Dahon", "44", "21000", "false", "150", "golden", "1169");
        assertNotEquals(baseBike, bike);
        bike = new Speedelec("Dahon", "44", "21000", "true", "1500", "golen", "169");
        assertNotEquals(baseBike, bike);
    }

}