package com.nevergetme.autumn.huawei.soultion03;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = sc.nextLine()).equals("\n")) {
            sb.append(line.replace("\n", "").replace(" ", ""));
        }
        helper(line);
        System.out.println();
    }

    public static void helper(String line) {
        Stack<Character> stack = new Stack<>();
        boolean[] errorUsed = new boolean[5];
        char[] lineChar = line.toCharArray();
        if (lineChar[0] == '[') judgeList(lineChar, 1, errorUsed);
        else if (lineChar[0] == '{') judgeObject(lineChar, 1, errorUsed);
        else if (lineChar[lineChar.length - 1] == ']') {
            printError(errorUsed, 1);
            judgeList(lineChar, 1, errorUsed);
        } else if (lineChar[lineChar.length - 1] == '}') {
            printError(errorUsed, 2);
            judgeObject(lineChar, 1, errorUsed);
        } else {
            judgeObject(lineChar, 0, errorUsed);
        }
    }

    private static int judgeObject(char[] lineChar, int begin, boolean[] errorUsed) {
        //{"":"","":[]}
        int count = 0;
        int last = -1;
        for (int i = begin; i < lineChar.length; i++) {
            last = i;
            if (count % 4 == 0 && lineChar[i] != '}' && lineChar[i] != ',') {
                printError(errorUsed, 4);
            }
            if (lineChar[i] == '}') {
                if (count % 4 != 0) printError(errorUsed, 3);
                break;
            } else if (lineChar[i] == '"') count++;
            else if (lineChar[i] == '[') {
                i = judgeList(lineChar, i + 1, errorUsed) - 1;
                count += 2;
            } else if (lineChar[i] == ']') {
                printError(errorUsed, 1);
                count += 2;
            }
            if (count % 4 == 0 && lineChar[i] != ',') {
                printError(errorUsed, 4);
            }
        }
        if (count % 4 != 0) printError(errorUsed, 3);
        return last + 1;
    }

    private static int judgeList(char[] lineChar, int begin, boolean[] errorUsed) {
        int count = 0;
        int last = -1;
        for (int i = begin; i < lineChar.length; i++) {
            last = i;
            if (count % 2 == 0 && lineChar[i] != ']' && lineChar[i] != ',') {
                printError(errorUsed, 4);
            }
            if (lineChar[i] == ']') {
                if (count % 2 == 1) printError(errorUsed, 3);
                break;
            } else if (lineChar[i] == '"') {
                count++;
            } else if (lineChar[i] == '{') {
                i = judgeObject(lineChar, i + 1, errorUsed) - 1;
            } else if (lineChar[i] == ']') {
                printError(errorUsed, 1);
            }
        }
        if (count % 2 == 1) printError(errorUsed, 3);
        return last + 1;
    }

    private static void printError(boolean[] errorUsed, int key) {
        if (!errorUsed[key]) System.out.print(key);
        errorUsed[key] = true;
    }
}
//{"":[{"":"","":"",{"":"","":""]}