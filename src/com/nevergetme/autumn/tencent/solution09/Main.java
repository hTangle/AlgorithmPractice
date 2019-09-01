package com.nevergetme.autumn.tencent.solution09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int maxSource = w[0] * w[0];
        int sourceBegin = maxSource;
        int minValue = w[0];
        int sumValue = w[0];
        for (int i = 1; i < n; i++) {
            minValue = Math.min(minValue, w[i]);
            int t = minValue * (sumValue + w[i]);
            if (t > w[i] * w[i] && sourceBegin <= t) {
                sourceBegin = t;
                sumValue += w[i];
                maxSource = Math.max(maxSource, sourceBegin);
            } else {
                minValue = w[i];
                sumValue = w[i];
                sourceBegin = w[i] * w[i];
                maxSource = Math.max(maxSource, sourceBegin);
            }
        }
        System.out.println(maxSource);

    }
}
