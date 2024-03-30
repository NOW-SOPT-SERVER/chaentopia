package org.example.classes;

public class Person {
    private String name;
    private int age;
    private String  sex;

    public void walk() {
        System.out.println("사람이 걷습니다.");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
