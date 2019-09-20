package com.nevergetme.autumn.tencent.solution14;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        readKey(s1, n, sc);
        readKey(s2, n, sc);
        int result = 0;
        for (int k : s1) {
            for (int m : s2) {
                result ^= (k + m);
            }
        }
        System.out.println(result);

    }

    public static void readKey(HashSet<Integer> s, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (s.contains(k)) {
                s.remove(k);
            } else {
                s.add(k);
            }
        }
    }
}
