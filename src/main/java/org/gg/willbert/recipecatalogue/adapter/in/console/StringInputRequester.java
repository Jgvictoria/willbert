package org.gg.willbert.recipecatalogue.adapter.in.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StringInputRequester {

    private final Scanner scanner;
    private final PrintStream printStream;

    public StringInputRequester(InputStream in, PrintStream printStream) {
        this.scanner = new Scanner(in);
        this.printStream = printStream;
    }


}
