package ru.valkeru.constructors;

public class Singleton {
    private static Singleton me;

    static {
        System.out.println("Лол");
    }

    private Singleton() {

    }

    public static Singleton makeInstance() {
        if (me == null) {
            me = new Singleton();
        }

        return me;
    }
}
