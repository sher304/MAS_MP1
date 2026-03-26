package org.example;

import java.io.Serializable;
import java.util.Optional;

public abstract class Person implements Serializable {
    public String name;
    public String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person Name: " + this.name + " Surname " + this.surname;
    }
}
