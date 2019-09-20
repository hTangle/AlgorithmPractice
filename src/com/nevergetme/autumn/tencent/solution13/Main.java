package com.nevergetme.autumn.tencent.solution13;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            if (set.isEmpty()) {
                System.out.println(0);
            } else {
                int T = set.first();
                System.out.println(T - curSum);
                curSum = T;
                set.remove(T);
            }
        }
    }
}
