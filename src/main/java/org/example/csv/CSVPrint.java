package org.example.csv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CSVPrint {
    public void csvPrint(double number, double answer, String path) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(path, true));
        printStream.printf("%s, %s \n", number, answer);
    }

    public void csvPrint(double number, double base, double answer, String path) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(path, true));
        printStream.printf("%s, %s, %s \n", number, base, answer);
    }

    public void csvPrint(String string, String path) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(path, true));
        printStream.printf("%s \n", string);
    }
}