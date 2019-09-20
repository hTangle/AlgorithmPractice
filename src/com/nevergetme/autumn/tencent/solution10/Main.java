package com.nevergetme.autumn.tencent.solution10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String[] lines = new String[t];
        int[] ns = new int[t];
        for (int i = 0; i < t; i++) {
            ns[i] = Integer.parseInt(sc.nextLine());
            lines[i] = sc.nextLine();
        }
        for(int i=0;i<t;i++){
            helper(lines[i],ns[i]);
        }
    }

    public static void helper(String line, int n) {
        if (n < 11) {
            System.out.println("NO");
            return;
        }
        for (int i = n - 11; i >= 0; i--) {
            if (line.charAt(i) == '8') {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
