package org.example.classes;

public enum Part {

    SERVER("SERVER"),
    WEB("WEB"),
    ANDROID("ANDROID"),
    iOS("iOS"),
    DESIGN("DESIGN"),
    PLAN("PLAN"),
    ;
    public String part;

    Part(String part) {
        this.part = part;
    }

    public String getPart() {
        return this.part;
    }
}