package ru.valkeru.polymorph;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<Animal> s = new ArrayList<>();
        Animal cat = new Cat();
        Cat cat1 = new Cat();
        Dog dog = new Dog();

        cat.voice();
        dog.voice();
        ((Cat) cat).step();

        Tester.animalTest(cat);
        Tester.animalTest(cat1);
        Tester.animalTest(dog);
    }
}
