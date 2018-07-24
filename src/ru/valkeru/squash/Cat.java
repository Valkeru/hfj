package ru.valkeru.squash;

import java.io.Serializable;

public class Cat implements Serializable {
    transient public boolean hasTail = true;
}
