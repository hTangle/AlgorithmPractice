package com.nevergetme.codeText.bytedance.questionFour;

import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] input=new int[n];
        double right=Integer.MIN_VALUE;
        double left=0;
        for(int i=0;i<n;i++){
            input[i]=in.nextInt();
            right=Math.max(right,input[i]);
        }
        if(n<m){
            System.out.println("0.00");
        }else{
            for(int i=0;i<100;i++){
                double mid=(left+right)/2;
                if(getTheMin(input,mid,m))left=mid;
                else right=mid;
            }
            DecimalFormat df=new DecimalFormat("0.00");
            System.out.println(df.format(right-0.00499));
        }

        //right=Math.floor(right*100)/100;
//        if(getTheMin(input,right,m))System.out.println(df.format(right));
//        else System.out.println("0.00");

    }
    public static boolean getTheMin(int[] input,double mid,int m){
        int begin=0;
        for(int i=0;i<input.length;i++){
            begin+=(int)(input[i]/mid);
        }
        if(begin>=m)return true;
        else return false;
    }
}