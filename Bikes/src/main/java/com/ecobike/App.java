package com.ecobike;

import com.ecobike.helpers.Menu;

import java.io.FileNotFoundException;

import static com.ecobike.helpers.Menu.parseInputFile;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing filePath parameter. Please put it as command line argument.");
            return;
        }
        String filePath = args[0];
        try {
            parseInputFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(
                    "Input file not found. You can continue to work with empty dataset. Created bikes will be saved in file: " + filePath);
        }
        Menu menu = new Menu(filePath);
        menu.showMenu();
    }
}
