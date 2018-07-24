package ru.valkeru.test;

public interface B {
    default void z() {
        System.out.println("B");
    }
}
