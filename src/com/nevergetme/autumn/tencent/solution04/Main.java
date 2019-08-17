package com.nevergetme.autumn.tencent.solution04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] height=new int[N];
        for(int i=0;i<N;i++){
            height[i]=sc.nextInt();
        }
        helper(height);

    }
    public static void helper(int[] height){
        int[] eyes=new int[height.length];
        for(int i=0;i<height.length;i++){
            if(i-1>=0){
                int leftMax=height[i-1];
                for(int j=i-2;j>=0;j--){
                    if(height[j]>leftMax){
                        eyes[i]++;
                        leftMax=height[j];
                    }
                }
                eyes[i]++;
            }
            if(i+1<height.length){
                int rightMax=height[i+1];
                for(int j=i+2;j<height.length;j++){
                    if(height[j]>rightMax){
                        eyes[i]++;
                        rightMax=height[j];
                    }
                }
                eyes[i]++;
            }
        }
        for(int i=0;i<height.length;i++){
            System.out.print((eyes[i]+1)+(i==height.length-1?"\n":" "));
        }
    }
}
