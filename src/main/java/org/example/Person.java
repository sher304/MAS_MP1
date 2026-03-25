package org.example;

import java.io.Serializable;
import java.util.Optional;

public abstract class Person implements Serializable {
    public String name;
    public String surname;
    public String PESEL;

    public Person(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        this.PESEL = pesel;
    }

    @Override
    public String toString() {
        return "Person Name: " + this.name + " Surname " + this.surname + " PESEL " + this.PESEL;
    }
}
