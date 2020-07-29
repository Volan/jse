package ru.mirsaitov.tm.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectTest {

    @Test
    public void shouldCreate() {
        final String name = "name";
        final String description = "description";
        Project project = new Project(name);
        assertEquals(name, project.getName());
        assertEquals(name, project.getDescription());

        project = new Project(name, description);
        assertEquals(name, project.getName());
        assertEquals(description, project.getDescription());
    }

}
