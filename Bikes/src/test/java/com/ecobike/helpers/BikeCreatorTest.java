package com.ecobike.helpers;

import com.ecobike.model.Bike;
import com.ecobike.model.BikeType;
import junit.framework.TestCase;
import org.junit.Assert;

import java.math.BigDecimal;

public class BikeCreatorTest extends TestCase {

    public void testGetBikeFromStringEBike() throws Exception {
        Bike bike = BikeCreator.getBikeFromString("E-BIKE Lankeleisi; 65; 24200; false; 10000; black; 2399");
        Assert.assertEquals(bike.getBrand(), "Lankeleisi");
        Assert.assertEquals(bike.getType(), BikeType.E_BIKE);
        Assert.assertEquals(bike.getColor(), "black");
        Assert.assertEquals(bike.getLights(), false);
        Assert.assertEquals(bike.getWeight(), 24200);
        Assert.assertEquals(bike.getPrice(), new BigDecimal(2399));
    }

    public void testGetBikeFromStringSpeedelec() throws Exception {
        Bike bike = BikeCreator.getBikeFromString("SPEEDELEC Lankeleisi; 65; 24200; false; 10000; black; 2399");
        Assert.assertEquals(bike.getBrand(), "Lankeleisi");
        Assert.assertEquals(bike.getType(), BikeType.SPEEDELEC);
        Assert.assertEquals(bike.getColor(), "black");
        Assert.assertEquals(bike.getLights(), false);
        Assert.assertEquals(bike.getWeight(), 24200);
        Assert.assertEquals(bike.getPrice(), new BigDecimal(2399));
    }

    public void testGetBikeFromString() throws Exception {
        Bike bike = BikeCreator.getBikeFromString("FOLDING BIKE Titan; 20; 1; 11800; false; khaki; 1115");
        Assert.assertEquals(bike.getBrand(), "Titan");
        Assert.assertEquals(bike.getType(), BikeType.FOLDING_BIKE);
        Assert.assertEquals(bike.getColor(), "khaki");
        Assert.assertEquals(bike.getLights(), false);
        Assert.assertEquals(bike.getWeight(), 11800);
        Assert.assertEquals(bike.getPrice(), new BigDecimal(1115));
    }
}