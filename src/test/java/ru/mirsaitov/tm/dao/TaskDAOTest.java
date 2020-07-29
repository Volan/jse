package ru.mirsaitov.tm.dao;

import org.junit.Test;
import ru.mirsaitov.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaskDAOTest {

    private final TaskDAO taskDAO = new TaskDAO();

    @Test
    public void shouldCreate() {
        final String name = "name";
        final String description = "description";

        Task task = taskDAO.create(name);
        assertEquals(name, task.getName());
        assertEquals(name, task.getDescription());

        task = taskDAO.create(name, description);
        assertEquals(name, task.getName());
        assertEquals(description, task.getDescription());
    }

    @Test
    public void shoudlClear() {
        final String name = "name";

        Task project = taskDAO.create(name);
        assertTrue(!taskDAO.findAll().isEmpty());

        taskDAO.clear();
        assertTrue(taskDAO.findAll().isEmpty());
    }

    @Test
    public void shouldFindAll() {
        final String name = "name";
        final String description = "description";
        List<Task> projects = new ArrayList<>();

        projects.add(taskDAO.create(name));
        assertTrue(projects.equals(taskDAO.findAll()));

        projects.add(taskDAO.create(name, description));
        assertTrue(projects.equals(taskDAO.findAll()));
    }

}
