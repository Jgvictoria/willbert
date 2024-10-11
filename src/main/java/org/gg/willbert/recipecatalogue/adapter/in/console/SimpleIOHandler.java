package org.gg.willbert.recipecatalogue.adapter.in.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SimpleIOHandler {

    private final Scanner scanner;
    private final PrintStream printStream;

    public SimpleIOHandler(InputStream in, PrintStream printStream) {
        this.scanner = new Scanner(in);
        this.printStream = printStream;
    }


    public String getInput() {
        return scanner.nextLine();
    }

    public void output(String s) {
        printStream.println(s);
    }

    public void close() {
        scanner.close();
    }
}
