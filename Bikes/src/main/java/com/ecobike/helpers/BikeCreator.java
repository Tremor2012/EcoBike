package com.ecobike.helpers;

import com.ecobike.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BikeCreator {
    final static Logger logger = LogManager.getLogger("EkoBike");
    public static final int NUMBER_OF_FIELDS = 7;;



    public static Bike getBikeFromString(String line) throws Exception {
        String[] words = line.split(";");
        if (words.length != NUMBER_OF_FIELDS) {
            throw new Exception("Invalid line");
        }
        if (line.startsWith(BikeType.FOLDING_BIKE.getName())) {
            String brand = words[0].substring(BikeType.FOLDING_BIKE.getName().length()).trim();
            return new FoldingBike(brand, words[1].trim(), words[2].trim(), words[3].trim(), words[4].trim(), words[5].trim(), words[6].trim());
        }
        if (line.startsWith(BikeType.E_BIKE.getName())) {
            String brand = words[0].substring(BikeType.E_BIKE.getName().length()).trim();
            return new EBike(brand, words[1].trim(), words[2].trim(), words[3].trim(), words[4].trim(), words[5].trim(), words[6].trim());
        }
        if (line.startsWith(BikeType.SPEEDELEC.getName())) {
            String brand = words[0].substring(BikeType.SPEEDELEC.getName().length()).trim();
            return new Speedelec(brand, words[1].trim(), words[2].trim(), words[3].trim(), words[4].trim(), words[5].trim(), words[6].trim());
        }
        throw new Exception("Unknown bike type: " + words[0]);
    }
}
