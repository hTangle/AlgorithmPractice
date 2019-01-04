package com.nevergetme.algorithmCompetition;

import java.util.Scanner;

public class NowCoder {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] data=line.split(" ");
        char[] A=data[0].toCharArray();
        int B=Integer.parseInt(data[1]);
        if(A.length==1){
            System.out.print((A[0]-'0')/B);
            System.out.println(" "+(A[0]-'0')%B);
        }else{
            int begin=0,As=0;
            if(A[0]-'0'<B){
                As=(A[0]-'0')*10+(A[1]-'0');
                begin=1;
            }else{
                begin=0;
                As=A[0]-'0';
            }
            StringBuilder sb=new StringBuilder();
            do{
                sb.append((int)As/B);
                //As=
            }while(begin<A.length);
        }
        //int M=sc.nextLine();
        //int N=sc.nextInt();

    }

}
