package com.dsbigdata;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

    @Test
    public void mainPrintsExpectedOutput() {
        PrintStream original = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(captured, true, "UTF-8"));
            Main.main(new String[0]);
        } catch (Exception e) {
            throw new AssertionError("Main.main threw", e);
        } finally {
            System.setOut(original);
        }

        String output = captured.toString();
        assertTrue("should greet", output.contains("Hello and welcome!"));
        assertTrue("should count 1..5", output.contains("i = 1") && output.contains("i = 5"));
    }
}
