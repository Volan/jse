package ru.mirsaitov.tm;

import java.util.ResourceBundle;
import ru.mirsaitov.tm.constant.TerminalConst;

public class Main {

    public static void main(String[] args) {
        displayWelcome();
        run(args);
    }

    public static void run(String[] args) {
        if (args == null || args.length < 1) {
            return;
        }
        displayArgument(args[0]);
    }

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

    public static void displayWelcome() {
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle");
        System.out.println(bundle.getString("welcome"));
    }
    
}
