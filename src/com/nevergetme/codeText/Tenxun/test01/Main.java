package com.nevergetme.codeText.Tenxun.test01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] money=new int[n];
        boolean isHave=false;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            money[i]=sc.nextInt();
            set.add(money[i]);
            if(money[i]==1)isHave=true;
        }

        Arrays.sort(money);
        int lastIndex=0;
        for(int i=0;i<n;i++){
            if(money[i]<m){
                lastIndex=i;
            }else{
                break;
            }
        }
        int[] counts=new int[lastIndex+1];
        counts[0]=1;
        int leave=m;
        if(isHave){
            //从最大到最小，然后取余数
            helper(money,lastIndex,m,counts,set);
            int def=1;
            boolean canOut=false;
            while (!canOut){
                for(int i=0;i<10&&!canOut;i++){
                    if(i*def>m)
                        canOut=true;
                    else
                        helpers(money,i*def,counts,set);
                }
                def*=10;
            }
            for(int i=lastIndex;i>=0;i--){
                if(money[i]-1>0){
                    helper(money,i,money[i]-1,counts,set);
                }
            }
            int sum=0;
            for(int k:counts){
                sum+=k;
            }
            System.out.println(sum);
        }else{
            System.out.println(-1);
        }
    }
    public static void helpers(int[] money,int leave,int[] counts,Set<Integer> set){
        int lastIndex=0;
        for(int i=0;i<money.length;i++){
            if(money[i]<leave){
                lastIndex=i;
            }
        }
        while (lastIndex>=0){
            if(leave%money[lastIndex]==0){
                counts[lastIndex]=Math.max(leave/money[lastIndex],counts[lastIndex]);
                leave=money[lastIndex];
            }else{
                counts[lastIndex]=Math.max(leave/money[lastIndex],counts[lastIndex]);
                leave=leave%money[lastIndex];
            }
            lastIndex--;
        }
    }
    public static void helper(int[] money,int lastIndex,int leave,int[] counts,Set<Integer> set){
        while (lastIndex>=0){
            if(leave%money[lastIndex]==0){
                counts[lastIndex]=Math.max(leave/money[lastIndex],counts[lastIndex]);
                leave=money[lastIndex];
            }else{
                counts[lastIndex]=Math.max(leave/money[lastIndex],counts[lastIndex]);
                leave=leave%money[lastIndex];
            }
            lastIndex--;
        }
//        StringBuilder
    }
}
