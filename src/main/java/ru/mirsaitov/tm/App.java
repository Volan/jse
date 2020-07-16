package ru.mirsaitov.tm;

import java.util.ResourceBundle;
import java.util.Scanner;

import ru.mirsaitov.tm.constant.TerminalConst;

/**
 * task-manager application
 */
public class App {

    /**
     * PSVM
     */
    public static void main(String[] args) {
        displayWelcome();
        run();
    }

    /**
     * Main loop of program
     */
    public static void run() {
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
     * @command parameter
     * @return true - wait next parameter, false - exit programm
     */
    public static boolean process(String command) {
        if (command == null || command.isEmpty()) {
            return true;
        }

        if (TerminalConst.CMD_EXIT.equals(command)) {
            return false;
        }

        displayArgument(command);
        return true;
    }

    /**
     * Print to System.out result of parameter
     * @arg parameter
     */
    public static void displayArgument(final String arg) {
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle");
        switch (arg) {
            case TerminalConst.CMD_VERSION:
                System.out.println(bundle.getString("version"));
                break;
            case TerminalConst.CMD_ABOUT:
                System.out.println(bundle.getString("about"));
                break;
            case TerminalConst.CMD_HELP:
                System.out.println(bundle.getString("help"));
                break;
            default:
                System.out.println(String.format(bundle.getString("stub"), arg));
                break;
        }
    }

    /**
     * Welcome information
     */
    public static void displayWelcome() {
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle");
        System.out.println(bundle.getString("welcome"));
    }

}