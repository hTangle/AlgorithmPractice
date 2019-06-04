package com.nevergetme.algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by Alden He on 2019/5/20
 */
public class Lucas {
    long pow(long a,long b,long p){
        long ans=1;
        a%=p;
        while (b!=0){
            if(b%2==1){
                ans=(ans%p)*(a%p)%p;
            }
            b=b>>1;
            a=(a%p)*(a%p)%p;
        }
        return ans%p;
    }
    long inv(long x,long p){
        return pow(x,p-2,p);
    }
    long C(long n,long m,long p){
        if(m>n)return 0;
        long up=1,down=1;
        for(long i=n-m+1;i<=n;i++)up=up*i%p;
        for(long i=1;i<=m;i++)down=down*i%p;
        return up*inv(down,p)%p;
    }
    long Lucas(long n,long m,long p){
        if(m==0)return 1;
        return C(n%p,m%p,p)*Lucas(n/p,m/p,p)%p;
    }
    public static void main(String[] args){
        Lucas l=new Lucas();
        System.out.println(l.Lucas(9,2,1_000_000_000+7));
    }
}
