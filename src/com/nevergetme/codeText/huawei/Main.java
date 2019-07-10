package com.nevergetme.codeText.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String[] zero=new String[]{"0000000","000000","00000","0000","000","00","0"};
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        List<String> output=new ArrayList<>();
        while (N-->0){
            String s=sc.next();
            if(s.length()>0){
                for(int i=0;i<s.length();i+=8){
                    String cur=s.substring(i,Math.min(i+8,s.length()));
                    if(cur.length()<8){
                        cur+=zero[cur.length()-1];
                    }
                    output.add(cur);
                }
            }
        }
        Collections.sort(output);
        for(int i=0;i<output.size();i++){
            System.out.print(output.get(i));
            if(i==output.size()-1){
                System.out.println();
            }else{
                System.out.print(" ");
            }
        }
    }
}
