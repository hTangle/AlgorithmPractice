package com.nevergetme.codeText.neteast.p0317;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int H=sc.nextInt();
        int[] X=new int[N];
        int[] Y=new int[N];
        int[] Z=new int[N];
        int longestRunX=0;
        int curLenX=H;
        for(int i=0;i<N;i++){
            X[i]=sc.nextInt();
            Y[i]=sc.nextInt();
            Z[i]=sc.nextInt();
            if(curLenX>0)longestRunX=i;
            curLenX-=X[i];
        }
        if(longestRunX>=N-1){
            int sum=0;
            for(int k:X){
                sum+=k;
            }
            System.out.println(sum);
        }else{
            System.out.println(helper(X,Y,Z,0,H,0));
        }
    }
    public static int helper(int[] X,int[] Y,int[] Z,int index,int H,int curSum){
        if(H>0&&index<X.length){
            return Math.max(helper(X,Y,Z,index+1,H-X[index],curSum+Y[index]),helper(X,Y,Z,index+1,H-Z[index],curSum));
        }else{
            return curSum;
        }
    }
}
