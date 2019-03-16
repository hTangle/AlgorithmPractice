package com.nevergetme.codeText.bytedance.questionThird190316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int m=in.nextInt();
            int[] input=new int[m];
            for(int j=0;j<m;j++){
                input[j]=in.nextInt();
            }
            list.add(getMin(input));
        }
        for(int i:list){
            System.out.println(i);
        }
    }
    public static int getMin(int[] input){
        int[] res=new int[input.length];
        int maxIndex=0;
        for(int i=0;i<input.length;i++){
            res[i]=1;

        }
        int value=input[0];
        for(int i=1;i<input.length;i++){
            if(input[i]>value){
                value=input[i];
                maxIndex=i;
            }
        }
        int len=input.length;
        //for(int i=0;i<)
//        if(input[len-1]<input[0]&&res[len-1]>=res[0])
//            res[0]=res[len-1]+1;
        for(int i=1;i<input.length;i++){
            if(input[i-1]<input[i]&&res[i-1]>=res[i]){
                res[i]=res[i-1]+1;
            }
        }
//        if(input[len-1]>input[0]&&res[0]<=res[len-1]){
//            res[len-1]=res[0]+1;
//        }
        for(int i=input.length-2;i>=0;i--){
            if(input[i+1]<input[i]&&res[i+1]>=res[i]){
                res[i]=res[i+1]+1;
            }
        }
        //if()
        int sum=0;
        for(int s:res){
            sum+=s;
        }
        return sum;
    }
}
