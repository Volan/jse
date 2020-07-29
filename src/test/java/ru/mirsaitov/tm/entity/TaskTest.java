package ru.mirsaitov.tm.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void shouldCreate() {
        final String name = "name";
        final String description = "description";
        Task task = new Task(name);
        assertEquals(name, task.getName());
        assertEquals(name, task.getDescription());

        task = new Task(name, description);
        assertEquals(name, task.getName());
        assertEquals(description, task.getDescription());
    }

}
