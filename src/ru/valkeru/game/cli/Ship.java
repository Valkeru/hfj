package ru.valkeru.game.cli;

import java.util.ArrayList;

class Ship {
    private ArrayList<String> locationCells;
    private boolean isAlive = true;
    private String name;

    boolean checkHit(String coord) {
        boolean result = false;

        int index = locationCells.indexOf(coord);

        if (index >= 0) {
            locationCells.remove(coord);
            result = true;
            if (locationCells.isEmpty()) {
                isAlive = false;
            }
        }

        return result;
    }

    void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    boolean isAlive() {
        return isAlive;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
