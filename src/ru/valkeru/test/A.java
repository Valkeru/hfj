package ru.valkeru.test;

public interface A {
    default void z() {
        System.out.println("B");
    }
}
