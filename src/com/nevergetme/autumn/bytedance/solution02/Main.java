package com.nevergetme.autumn.bytedance.solution02;


import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String secret = scanner.next();
        char[] result = new char[n];
        result[0] = secret.charAt(0);
        for (int i = 1; i < k; i++) {
            result[i] = xor(secret.charAt(i), secret.charAt(i - 1));
        }
        for (int i = k; i < n; i++) {
            result[i] = xor(xor(secret.charAt(i), secret.charAt(i - 1)), result[i - k]);
        }

        System.out.println(new String(result));
    }

    private static char xor(char a, char b) {
        return a == b ? '0' : '1';
    }

}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        String S = scanner.nextLine();
//        String[] t = line.split(" ");
//        int N = Integer.parseInt(t[0]);
//        int K = Integer.parseInt(t[1]);
//        getB(S, N, K);
//    }
//
//    public static void getB(String s, int N, int K) {
//        char[] temp = s.toCharArray();
//        int[] output = new int[N];
//        for (int i = 0; i < N; i++) {
//            output[i] = temp[i] - '0';
//            if(i>0)output[i]^=temp[i-1] - '0';
//
//            for(int j=i-1;j>=0&&j>i-K;j--){
//                output[i]^=output[j];
//            }
//        }
//        for(int k:output){
//            System.out.print(k);
//        }
//        System.out.println();
//    }
//}
