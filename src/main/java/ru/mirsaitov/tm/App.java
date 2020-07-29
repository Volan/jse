package ru.mirsaitov.tm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

import ru.mirsaitov.tm.constant.TerminalConst;
import ru.mirsaitov.tm.dao.ProjectDAO;
import ru.mirsaitov.tm.dao.TaskDAO;

/**
 * Task-manager application
 */
public class App {

    private final ProjectDAO projectDAO = new ProjectDAO();

    private final TaskDAO taskDAO = new TaskDAO();

    private  final ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle");

    /**
     * Main loop of program
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command;
        while (scanner.hasNextLine()) {
            command = scanner.nextLine();
            if (!process(command)) {
                break;
            }
        }
    }

    /**
     * Process of input parameter
     *
     * @param line - command for execute
     * @return true - wait next parameter, false - exit programm
     */
    public boolean process(String line) {
        if (line == null || line.isEmpty()) {
            return true;
        }

        if (TerminalConst.CMD_EXIT.equals(line)) {
            return false;
        }

        processCommand(line);
        return true;
    }

    /**
     * Print to System.out result of parameter
     *
     * @param line - command and parameter
     */
    public void processCommand(final String line) {
        final String parts[] = line.split(TerminalConst.SPLIT);
        final String command = parts[0];
        final String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);
        switch (command) {
            case TerminalConst.CMD_VERSION:
                System.out.println(bundle.getString("version"));
                break;
            case TerminalConst.CMD_ABOUT:
                System.out.println(bundle.getString("about"));
                break;
            case TerminalConst.CMD_HELP:
                System.out.println(bundle.getString("help"));
                break;
            case TerminalConst.PROJECT_CREATE:
                createProject(arguments);
                break;
            case TerminalConst.PROJECT_CLEAR:
                clearProject();
                break;
            case TerminalConst.PROJECT_LIST:
                listProject();
                break;
            case TerminalConst.TASK_CREATE:
                createTask(arguments);
                break;
            case TerminalConst.TASK_CLEAR:
                clearTask();
                break;
            case TerminalConst.TASK_LIST:
                listTask();
                break;
            default:
                System.out.println(String.format(bundle.getString("stub"), line));
                break;
        }
    }

    /**
     * Welcome information
     */
    public void displayWelcome() {
        System.out.println(bundle.getString("welcome"));
    }

    /**
     * Create projects
     *
     * @param arguments - arguments of command
     */
    public void createProject(final String[] arguments) {
        final String name = arguments.length > 0 ? arguments[0] : "";
        final String description = arguments.length > 1 ? arguments[1] : "";
        projectDAO.create(name, description);
        System.out.println(bundle.getString("projectCreate"));
    }

    /**
     * Clear projects
     */
    public void clearProject() {
        projectDAO.clear();
        System.out.println(bundle.getString("projectClear"));
    }

    /**
     * List projects
     */
    public void listProject() {
        System.out.println(projectDAO.findAll());
    }

    /**
     * Create task
     *
     * @param arguments - arguments of command
     */
    public void createTask(final String[] arguments) {
        final String name = arguments.length > 0 ? arguments[0] : "";
        final String description = arguments.length > 1 ? arguments[1] : "";
        taskDAO.create(name, description);
        System.out.println(bundle.getString("taskCreate"));
    }

    /**
     * Clear tasks
     */
    public void clearTask() {
        taskDAO.clear();
        System.out.println(bundle.getString("taskClear"));
    }

    /**
     * List tasks
     */
    public void listTask() {
        System.out.println(taskDAO.findAll());
    }

}