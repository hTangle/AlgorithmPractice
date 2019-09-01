package com.nevergetme.autumn.tencent.solution07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static class WaitLine {
        int a, b;

        public WaitLine(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getSource(int pos, int n) {
            return a * pos + b * (n - pos - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        WaitLine[] w = new WaitLine[n];
        for (int i = 0; i < n; i++) {
            w[i] = new WaitLine(sc.nextInt(), sc.nextInt());
        }
        helper(w, n);
//        Arrays.sort(w, new Comparator<WaitLine>() {
//            @Override
//            public int compare(WaitLine o1, WaitLine o2) {
//                if (o1.a == o2.a) {
//                    return o1.b - o2.b;
//                } else {
//                    return o2.a - o1.a;
//                }
//            }
//        });
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (w[i].a * i + w[i].b * (n - i - 1));
        }
        System.out.println(sum);
    }

    public static void helper(WaitLine[] w, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (w[j].getSource(j, n) + w[j + 1].getSource(j + 1, n) < w[j].getSource(j + 1, n) + w[j + 1].getSource(j, n)) {
                    WaitLine t = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = t;
                }
            }
        }
    }
}
