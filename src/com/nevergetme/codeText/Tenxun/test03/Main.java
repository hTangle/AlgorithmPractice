package com.nevergetme.codeText.Tenxun.test03;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] D=new int[N];
        int[] P=new int[N];
        for(int i=0;i<N;i++){
            D[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++){
            P[i]=sc.nextInt();
        }
        System.out.println(helper(N,D,P));
    }
    public static int helper(int N,int[] D,int[] P){
        //性价比越高越好
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(N, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                double k=b[0]*1.0/b[1]-a[0]*1.0/b[1];
                if(k>0)return 1;
                else if(k<0)return -1;
                else
                    return b[0]-a[0];
            }
        });
        int cur=0;
        int cost=0;
        for(int i=0;i<N;i++){
            if(cur<D[i]){
                if(priorityQueue.isEmpty()) {
                    cur += D[i];
                    cost += P[i];
                }
                else{
                    priorityQueue.add(new int[]{D[i],P[i]});
                    while (!priorityQueue.isEmpty()&&cur<D[i]){
                        int[] b=priorityQueue.poll();
                        cur+=b[0];
                        cost+=b[1];
                    }
                }
            }else {
                priorityQueue.add(new int[]{D[i],P[i]});
            }
        }
        return cost;
    }

}
