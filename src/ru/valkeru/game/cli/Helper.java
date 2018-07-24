package ru.valkeru.game.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Helper {
    String getUserInput(String prompt) {
        String input = null;
        System.out.println(prompt + ": ");

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        return input;
    }

    ArrayList<String> placeShip(int comSize) {
        String alphabet = "abcdefg";
        int gridLength = 7;
        int gridSize = 49;
        int[] grid = new int[gridSize];
        int comCount = 0;
        ArrayList<String> alphaCells = new ArrayList<>();
        String temp;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location;
        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }
        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
            int x = 0;
            success = true;
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }
        int x = 0;
        int row;
        int column;
        while (x < comSize) {
            grid[coords[x]] = 1;
            row = (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }
        return alphaCells;
    }
}
