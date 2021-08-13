package com.kulabuha.alex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDriver {
    public static void printLine(String line) {
        System.out.println(line);
    }
    public static String readLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
