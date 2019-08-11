package com.nevergetme.autumn.bytedance.solution03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] year=new int[N];
        for(int i=0;i<N;i++){
            year[i]=sc.nextInt();
        }
        int[] money=new int[N];
        Arrays.fill(money,100);
        for(int i=1;i<N;i++){
            if(money[i]<=money[i-1]&&year[i]>year[i-1]){
                money[i]=money[i-1]+100;
            }
        }
        for(int i=N-2;i>=0;i--){
            if(money[i]<=money[i+1]&&year[i]>year[i+1]){
                money[i]=money[i+1]+100;
            }
        }
        int sum=0;
        for(int k:money){
            sum+=k;
        }
        System.out.println(sum);
    }
}
