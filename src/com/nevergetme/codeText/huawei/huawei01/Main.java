package com.nevergetme.codeText.huawei.huawei01;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        String input=in.nextLine();
        String[] output=new String[N];
        for(int i=0;i<N;i++){
            if(input.charAt(i*9)=='1'){
                output[i]=input.substring(i*9+1,i*9+9);
            }else{
                output[i]="";
                for(int j=8;j>0;j--){
                    output[i]+=input.charAt(i*9+j);
                }
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(output[i]);
            if(i==N-1){
                System.out.println();
            }else{
                System.out.print(" ");
            }
        }
    }
}