package com.nevergetme.codeText.Tenxun.test02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String line=sc.nextLine();
        int zero=0;
        int one=0;
        for(int i=0;i<n;i++){
            if(line.charAt(i)=='1'){
                one++;
            }else{
                zero++;
            }
        }
        System.out.println(Math.abs(one-zero));
    }
}
