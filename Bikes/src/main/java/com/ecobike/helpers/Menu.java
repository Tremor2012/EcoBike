package com.ecobike.helpers;

import com.ecobike.model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ecobike.helpers.BikeCreator.getBikeFromString;
import static com.ecobike.helpers.BikeCreator.logger;

public final class Menu {

    private final String filePath;
    private static List<Bike> bikes = new ArrayList<>();

    public Menu(String filePath) {
        this.filePath = filePath;
    }

    public static void parseInputFile(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                try {
                    bikes.add(getBikeFromString(line));
                } catch (Exception e) {
                    logger.error("Invalid line in Input file: [ " + line + " ]. Skipped");
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("Please make your choice:\n"
                + "1 - Show the entire EcoBike catalog\n"
                + "2 – Add a new folding bike\n"
                + "3 – Add a new speedelec\n"
                + "4 – Add a new e-bike\n"
                + "5 – Find the first item of a particular brand\n"
                + "6 – Write to file\n"
                + "7 – Stop the program"
        );

        int num = 0;
        try {
            num = Integer.parseInt(readInputString());
        } catch (NumberFormatException e) {
            System.out.println("Enter number from 1 to 7 please");
            showMenu();
            return;
        }

        switch (num) {
            case (1):
                showAll(bikes);
                break;
            case (2):
                addNewBike(BikeType.FOLDING_BIKE);
                break;
            case (3):
                addNewBike(BikeType.SPEEDELEC);
                break;
            case (4):
                addNewBike(BikeType.E_BIKE);
                break;
            case (5):
                findByBrand();
                break;
            case (6):
                saveBikeToFile();
                break;
            case (7):
                return;
            default:
        }
        showMenu();
    }

    private void addNewBike(BikeType type) {
        try {
            bikes.add(inputNewBike(type));
        } catch (Exception e) {
            System.out.println("Invalid input params, try again please");
            return;
        }
        System.out.println("New bike add successfully");
    }

    private void showAll(List<Bike> bikes) {
        bikes.forEach(a -> System.out.print(a.toString()));
    }

    private Bike inputNewBike(BikeType type) throws Exception {
        System.out.println("Enter a description of the new " + type.getName() + "\n Input brand: ");
        String brand = readInputString();
        System.out.println("Weight of the bike (in grams): ");
        String weight = readInputString();
        System.out.println("Availability of lights at front and back (TRUE/FALSE): ");
        String lights = readInputString();
        System.out.println("Color: ");
        String color = readInputString();
        System.out.println("Price: ");
        String price = readInputString();
        if (type.getName().equals(BikeType.FOLDING_BIKE.getName())) {
            System.out.println("Size of the wheels (in inch): ");
            String wheels = readInputString();
            System.out.println("Number of gears: ");
            String gears = readInputString();
            return new FoldingBike(brand, wheels, gears, weight, lights, color, price);
        }
        System.out.println("Maximum speed (in km/h): ");
        String maxSpeed = readInputString();
        System.out.println("Battery capacity (in mAh): ");
        String battery = readInputString();
        if (type.getName().equals(BikeType.E_BIKE.getName())) {
            return new EBike(brand, maxSpeed, weight, lights, battery, color, price);
        }
        return new Speedelec(brand, maxSpeed, weight, lights, battery, color, price);
    }

    private String readInputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return line;
    }

    private void findByBrand() {
        String brand = readInputString();
        if (brand.isEmpty()) {
            System.out.println("No brand selected: ");
            readInputString();
        }
        for (Bike bike : bikes) {
            if (brand.equals(bike.getBrand())) {
                System.out.println(bike);
                return;
            }
        }
        System.out.println("No bikes of brand " + brand + " found");
    }

    private void saveBikeToFile() {
        try {
            FileWriter writer = new FileWriter(filePath, false);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (Bike b : bikes) {
                bufferWriter.write(b.toRecord());
            }
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            return;
        }
        System.out.println("All bikes are saved!");
    }

    public List<Bike> getBikes() {
        return bikes;
    }
}
