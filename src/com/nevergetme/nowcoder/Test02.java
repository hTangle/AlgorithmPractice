package com.nevergetme.nowcoder;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        System.out.println(Math.max(a+b+c,Math.max(a*(b+c),Math.max(a*b*c,(a+b)*c))));
    }
}
