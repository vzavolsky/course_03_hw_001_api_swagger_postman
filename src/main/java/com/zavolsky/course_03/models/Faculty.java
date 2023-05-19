package com.zavolsky.course_03.models;

public class Faculty {

    private static Long idInc = 0L;
    private Long id = ++idInc;
    private String name;
    String color;

    public Faculty(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
