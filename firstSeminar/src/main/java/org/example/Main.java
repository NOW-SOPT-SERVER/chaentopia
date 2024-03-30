package org.example;

import org.example.classes.Person;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


    Person person = new Person("정채은", 24, "Female");
    		person.walk();
            System.out.println(person.getName());
            person.setName("아요파이팅");
            System.out.println(person.getName());

    }
}