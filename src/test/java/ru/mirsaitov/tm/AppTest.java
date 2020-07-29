package ru.mirsaitov.tm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.Scanner;
import ru.mirsaitov.tm.constant.TerminalConst;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldExecute() {
        App app = new App();
        assertTrue(app.process(TerminalConst.CMD_ABOUT));
        assertTrue(app.process(TerminalConst.CMD_HELP));
        assertTrue(app.process(TerminalConst.CMD_VERSION));
        assertTrue(app.process("TEST"));
        assertTrue(app.process(null));
        assertTrue(app.process(new String()));
    }

    @Test
    public void shouldNotExecute() {
        App app = new App();
        assertFalse(app.process(TerminalConst.CMD_EXIT));
    }

    @Test
    public void shouldWriteStringSystemOut() {
        Scanner scanner;
        ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle");
        InputStream stdin = System.in;

        try {
            //about test
            System.setIn(new ByteArrayInputStream((TerminalConst.CMD_ABOUT).getBytes()));
            new App().run();
            assertEquals(outContent.toString(), bundle.getString("about") + System.lineSeparator());

            //help test
            outContent.reset();
            System.setIn(new ByteArrayInputStream((TerminalConst.CMD_HELP).getBytes()));
            new App().run();
            assertEquals(outContent.toString(), bundle.getString("help") + System.lineSeparator());

            //version test
            outContent.reset();
            System.setIn(new ByteArrayInputStream((TerminalConst.CMD_VERSION).getBytes()));
            new App().run();
            assertEquals(outContent.toString(), bundle.getString("version") + System.lineSeparator());
        } finally {
            System.setIn(stdin);
        }
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
