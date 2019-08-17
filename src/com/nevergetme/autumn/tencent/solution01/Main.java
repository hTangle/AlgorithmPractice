package com.nevergetme.autumn.tencent.solution01;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();

    }
    public static void helper(String input){
        Stack<String> stringStack=new Stack<>();
        Stack<Integer> integerStack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int flag=0;
        int len=0;
        StringBuilder stringBuilder=new StringBuilder();
        StringBuilder tempBuilder=new StringBuilder();
        for(char c:input.toCharArray()){
            if(flag==1){
                //表示接收数字
                if(c=='|'){
                    integerStack.push(len);
                    flag=2;
                    stringBuilder=new StringBuilder();
                }else{
                    len=len*10+(c-'0');
                }
            }else if(flag==2){
                //表示接收字符
                if(c=='['){
                    stringStack.push(stringBuilder.toString());
                    flag=1;
                    len=0;
                }else if(c==']'){
                    int k=integerStack.pop();
                    if(stringStack.isEmpty()){
                        String t=stringBuilder.toString();
                        for(int i=0;i<k;i++){
                            sb.append(t);
                        }
                        sb.append(tempBuilder.toString());
                        tempBuilder=new StringBuilder();
                        flag=0;
                    }else{
                        String t=stringStack.pop();
                        t=t+stringBuilder.toString();
                        stringStack.push(t);
                        tempBuilder=new StringBuilder();
                        flag=3;
                    }
                }
            }else if(flag==3){

            }
        }
    }
}
