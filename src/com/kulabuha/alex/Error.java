package com.kulabuha.alex;

public class Error extends Exception {
    public Error(String message) {
        super(message);
        switch (message) {
            case ("1"): System.out.println("формат математической операции или введеные символы не поддерживаются");break;
            case ("2"): System.out.println("Калькулятор может работать только с целыми арабскими или римскими числами");break;
            case ("3"): System.out.println("используются одновременно разные системы счисления");break;
            case ("5"): System.out.println("допускается ввод чисел не больше 10(X) и не меньше 1(I)");break;
            case ("6"): System.out.println("На ноль делить нельзя");break;
            case ("7"): System.out.println("В Римских числах нет чисел меньше I");break;
            default: System.out.println("Undefined error");
        }
        System.exit(0);
    }
}
