package com.kulabuha.alex;

import java.util.TreeMap;

public class Calculator {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public final static String toRoman(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number - l);
    }

    public static String calc(String[] sum) throws Error {
        int answer = 0;
        int a = Integer.parseInt(sum[1]);
        int b = Integer.parseInt(sum[2]);
        switch (sum[0]) {
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
            case "/":
                if (b == 0) throw new Error("6");
                answer = a / b;
                break;
            default:
                break;
        }

        if (sum[3].equals("r")) {
            if (answer <= 0) throw new Error("7");
            return toRoman(answer);
        }
        return String.valueOf(answer);
    }
}
