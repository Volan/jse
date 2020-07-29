package ru.mirsaitov.tm.dao;

import ru.mirsaitov.tm.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    private List<Project> projects = new ArrayList<>();

    /**
     * Create project by name
     *
     * @param name - name of project
     * @return created project
     */
    public Project create(final String name) {
        final Project project = new Project(name);
        projects.add(project);
        return project;
    }

    /**
     * Create project by name and description
     *
     * @param name - name of project
     * @param description - description of project
     * @return created project
     */
    public Project create(final String name, final String description) {
        final Project project = new Project(name, description);
        projects.add(project);
        return project;
    }

    /**
     * Clear projects
     */
    public void clear() {
        projects.clear();
    }

    /**
     * Return projects
     */
    public List<Project> findAll() {
        return new ArrayList<>(projects);
    }

}
