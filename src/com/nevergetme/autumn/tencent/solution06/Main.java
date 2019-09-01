package com.nevergetme.autumn.tencent.solution06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int odd1 = 0, even1 = 0, odd2 = 0, even2 = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() % 2 == 0) {
                even1++;
            } else {
                odd1++;
            }
        }
        for (int i = 0; i < m; i++) {
            if (sc.nextInt() % 2 == 0) {
                even2++;
            } else {
                odd2++;
            }
        }
        System.out.println(Math.min(odd1, even2) + Math.min(odd2, even1));
    }
}
