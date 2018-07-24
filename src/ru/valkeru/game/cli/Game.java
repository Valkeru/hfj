package ru.valkeru.game.cli;

import java.util.ArrayList;

public class Game {
    private ArrayList<Ship> shipList = new ArrayList<>();
    private Helper helper = new Helper();
    private static int hitsTotal;

    public static void main(String[] args) {
        Game game = new Game();
        game.setupGame();
        game.play();

        System.out.println("Все корабли потоплены");
        if (hitsTotal < 18) {
            System.out.println("Ты хорошо поработал, пират! " + hitsTotal + " выстрелов!");
            System.out.println("Йо-хо-хо и бутылка рома!");
        } else {
            System.out.println("Но пора бы и самому починить своё корыто");
            System.out.println("Ты стрелял " + hitsTotal + " раз");
        }
    }

    private void setupGame() {
        Helper helper = new Helper();
        Ship ship = new Ship();
        ship.setName("123");
        Ship ship1 = new Ship();
        ship1.setName("456");
        Ship ship2 = new Ship();
        ship2.setName("789");
        shipList.add(ship);
        shipList.add(ship1);
        shipList.add(ship2);

        for (Ship s : shipList) {
            ArrayList<String> location = helper.placeShip(3);
            s.setLocationCells(location);
        }
    }

    private void play() {
        while (!shipList.isEmpty()) {
            String coord = helper.getUserInput("Введите координату");
            if (coord.isEmpty()) {
                continue;
            }

            hitsTotal++;
            System.out.println(checkHit(coord));
        }
    }

    private String checkHit(String coord) {
        boolean result = false;
        for (Ship ship : shipList) {
            result = ship.checkHit(coord);
            if (result) {
                if (!ship.isAlive()) {
                    shipList.remove(ship);
                    System.out.println("Бульк!");
                    System.out.println(ship.getName() + " утоп!");
                }

                break;
            }
        }

        return result ? "Попал!" : "Мимо!";
    }
}
