package com.kulabuha.alex;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Parser {
    static final int MAX_LENGTH_INT = 2;
    Map<String, String> mapNumbers = Map.of(
            "I", "1",
            "II", "2",
            "III", "3",
            "IV", "4",
            "V", "5",
            "VI", "6",
            "VII", "7",
            "VIII", "8",
            "IX", "9",
            "X", "10"
    );
    List<String> mapSigns = List.of("+", "-", "*", "/");
    String strForParse = "";

    Parser(String strForParse) {
        this.strForParse = strForParse.replaceAll("\\s+", "");
    }

    public String[] parse() throws Error, IOException {
        String[] prepareSet = new String[]{"", "", "", ""};
        boolean isArabic = false;
        boolean isRome = false;
        boolean isSign = false;
        String[] strings;
        strings = this.strForParse.split("");
        String var1 = "";
        String var2 = "";

        int indexSign = 0;
        String str = this.strForParse;
        for (int j = 1; j < strings.length - 1; j++) {
            if (mapSigns.contains(strings[j])) {
                prepareSet[0] = strings[j];
                indexSign = j;
                break;
            }
        }
        if (indexSign == 0)
            throw new Error("1");

        if (mapNumbers.containsKey(strings[0])) {
            prepareSet[3] = "r";
            for (int j = 0; j < strings.length; j++) {
                if (!(mapNumbers.containsKey(strings[j]) || mapNumbers.containsValue(strings[j]) || mapSigns.contains(strings[j])))
                    throw new Error("2");
                if (!(mapNumbers.containsKey(strings[j]) || mapSigns.contains(strings[j])))
                    throw new Error("3");
            }
            var1 = mapNumbers.get(str.substring(0, indexSign));
            var2 = mapNumbers.get(str.substring(indexSign + 1, strings.length));

        } else if (mapNumbers.containsValue(strings[0]) || strings[0].equals("0")) {
            for (int j = 0; j < strings.length; j++) {
                if (!(mapNumbers.containsKey(strings[j]) || mapNumbers.containsValue(strings[j]) || mapSigns.contains(strings[j]) || strings[j].equals("0")))
                    throw new Error("2");
                if (!(mapNumbers.containsValue(strings[j]) || mapSigns.contains(strings[j]) || strings[j].equals("0")))
                    throw new Error("3");
            }
            var1 = str.substring(0, indexSign);
            var2 = str.substring(indexSign + 1, strings.length);

        } else throw new Error("1");
        try {
            if (var1 == null || var2 == null || Integer.parseInt(var1) > 10 || Integer.parseInt(var1) < 1 || Integer.parseInt(var2) > 10 || Integer.parseInt(var2) < 1)
                throw new Error("5");
        }
        catch (NumberFormatException e) {
            new Error("1");
        }
        prepareSet[1] = var1;
        prepareSet[2] = var2;
        return prepareSet;
    }
}


