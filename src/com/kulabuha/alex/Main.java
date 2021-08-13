package com.kulabuha.alex;

import java.io.IOException;

public class Main {
    static String[] sum; // массив с переменными полученными после парсинга введеной строки
    static String answer; // ответ для вывода в консоль

    private static void startApp() {
        ConsoleDriver.printLine("Программа \"Консольный калькулятор\"");
        ConsoleDriver.printLine("Введите выражение:");
    }

    static void readSum() throws IOException, Error {
        sum = new Parser(ConsoleDriver.readLine()).parse();
    }

    private static void calc() throws Error {
        answer = Calculator.calc(sum);
    }

    private static void printAnswer() {
        ConsoleDriver.printLine("Ответ: " + answer);
    }

    public static void main(String[] args) throws IOException, Error {

        startApp();
        while (true) {
            readSum();
            calc();
            printAnswer();
        }
    }
}
