package ru.mirsaitov.tm.entity;

public class Project {

    private Long id = System.nanoTime();

    private String name;

    private String description;

    public Project() {
        this.name = "";
        this.description = "";
    }

    public Project(String name) {
        this.name = name;
        this.description = name;
    }

    public Project(String name, String description) {
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
