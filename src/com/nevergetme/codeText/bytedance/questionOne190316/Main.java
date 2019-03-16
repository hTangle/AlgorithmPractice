package com.nevergetme.codeText.bytedance.questionOne190316;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int sum=1024-N;
        int s24=sum/64;
        int left=sum%64;
        int s16=left/16;
        left=left%16;
        int s4=left/4;
        System.out.println(s24+s16+s4+left%4);
    }
}
