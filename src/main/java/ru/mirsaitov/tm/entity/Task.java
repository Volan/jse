package ru.mirsaitov.tm.entity;

public class Task {

    private Long id = System.nanoTime();

    private String name;

    private String description;

    public Task() {
        this.name = "";
        this.description = "";
    }

    public Task(String name) {
        this.name = name;
        this.description = name;
    }

    public Task(String name, String description) {
        this(name);
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

}
