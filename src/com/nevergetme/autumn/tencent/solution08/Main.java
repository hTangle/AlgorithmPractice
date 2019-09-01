package com.nevergetme.autumn.tencent.solution08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] pos = new int[n];
        pos[0] = m;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        int time = 1;
        int maxpos = 0;
        while (sum > 0) {
            for (int i = Math.min(maxpos, n - 1); i >= 0; i--) {
                if (a[i] >= pos[i]) {
                    a[i] -= pos[i];
                    sum -= pos[i];
                } else {
                    if (i + 1 < n) {
                        pos[i + 1] += (pos[i] - a[i]);
                    }
                    pos[i] = a[i];
                    sum -= a[i];
                    a[i] = 0;
                    maxpos = Math.max(i + 1, maxpos);
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
