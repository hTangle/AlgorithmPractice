package com.nevergetme.algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create by Alden He on 2019/5/20
 */
public class Lucas {
    static class Node implements Comparable<Node>{
        int time,level;
        boolean isUsed=false;
        Node(int time,int level){
            this.time=time;
            this.level=level;
        }

        @Override
        public int compareTo(@NotNull Lucas.Node o) {
            if(this.time==o.time){
                if(this.level==o.level)return 0;
                else if(this.level>o.level)return -1;
                else return 1;
            }else if(this.time>o.time)
                return -1;
            else
                return 1;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        Node[] vm=new Node[N];
        Node[] tsk=new Node[M];
        for(int i=0;i<N;i++){
            vm[i]=new Node(sc.nextInt(),sc.nextInt());
        }
        for(int i=0;i<M;i++){
            tsk[i]=new Node(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(vm);
        Arrays.sort(tsk);
        int source=0;
        int[] dp=new int[101];
        int j=0,counts=0;
        for(int i=0;i<M;i++){
            while (j<N&&vm[j].time>=tsk[i].time){
                dp[vm[j].level]++;
                j++;
            }
            for(int k=tsk[i].level;k<101;k++){
                if(dp[k]!=0){
                    dp[k]--;
                    source+=200*tsk[i].time+3*tsk[i].level;
                    counts++;
                    break;
                }
            }
        }
//        for(Node t:tsk){
//            for(int i=0;i<N;i++){
//                if(!vm[i].isUsed&&vm[i].time>=t.time&&vm[i].level>=t.level){
//                    source+=(200*t.time+3*t.level);
//                    vm[i].isUsed=true;
//                    break;
//                }
//            }
//        }
        System.out.println(counts+" "+source);
    }
//    public int lucas(long n,long m,int p){
//
//    }
//    public long mul(long a,long b,long p){
//        long ret=0;
//        while (b!=0){
//
//        }
//    }
}
