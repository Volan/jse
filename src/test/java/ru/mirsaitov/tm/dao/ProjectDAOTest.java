package ru.mirsaitov.tm.dao;

import org.junit.Test;
import ru.mirsaitov.tm.entity.Project;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectDAOTest {

    private final ProjectDAO projectDAO = new ProjectDAO();

    @Test
    public void shouldCreate() {
        final String name = "name";
        final String description = "description";

        Project project = projectDAO.create(name);
        assertEquals(name, project.getName());
        assertEquals(name, project.getDescription());

        project = projectDAO.create(name, description);
        assertEquals(name, project.getName());
        assertEquals(description, project.getDescription());
    }

    @Test
    public void shoudlClear() {
        final String name = "name";

        Project project = projectDAO.create(name);
        assertTrue(!projectDAO.findAll().isEmpty());

        projectDAO.clear();
        assertTrue(projectDAO.findAll().isEmpty());
    }

    @Test
    public void shouldFindAll() {
        final String name = "name";
        final String description = "description";
        List<Project> projects = new ArrayList<>();

        projects.add(projectDAO.create(name));
        assertTrue(projects.equals(projectDAO.findAll()));

        projects.add(projectDAO.create(name, description));
        assertTrue(projects.equals(projectDAO.findAll()));
    }

}
