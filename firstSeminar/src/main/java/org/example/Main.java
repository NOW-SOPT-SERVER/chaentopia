package org.example;

import org.example.classes.Person;
import org.example.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


    Person person = new Person("정채은", 24, "Female");
    		person.walk();
            System.out.println(person.getName());
            person.setName("아요파이팅");
            System.out.println(person.getName());

    }
    Person personWithBuilder = new
            PersonBuilder()
            .name("정채은")
            .age(24)
            .sex("female")
            .build();

    Person personWithFactoryMethod = Person.create("정채은", 24, "female");
}