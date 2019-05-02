package com.nevergetme.codeText.safe360;

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int string2int(String str) {
//        int result = 0;
//        boolean negative = false;
//        int i = 0, len = s.length();
//        int limit = -Integer.MAX_VALUE;
//        int multmin;
//        int digit;
//
//        if (len > 0) {
//            char firstChar = s.charAt(0);
//            if (firstChar < '0') { // Possible leading "+" or "-"
//                if (firstChar == '-') {
//                    negative = true;
//                    limit = Integer.MIN_VALUE;
//                } else if (firstChar != '+')
//                    return 0;
//
//                if (len == 1) // Cannot have lone "+" or "-"
//                    return 0;
//                i++;
//            }
//            multmin = limit / 10;
//            while (i < len) {
//                // Accumulating negatively avoids surprises near MAX_VALUE
//                if (s.charAt(i) > '9' || s.charAt(i) < '0') {
//                    if(s.charAt(i)!='.')return 0;
//                    break;
//                }
//                digit = s.charAt(i++) - '0';
//                if (digit < 0) {
//                    return 0;
//                }
//                if (result < multmin) {
//                    return 0;
//                }
//                result *= 10;
//                if (result < limit + digit) {
//                    return 0;
//                }
//                result -= digit;
//            }
//            for(i+=1;i<len;i++){
//                if(s.charAt(i)>'9'||s.charAt(i)<'0'){
//                    return 0;
//                }
//            }
//        } else {
//            return 0;
//        }
//        return negative ? result : -result;
        boolean isFirst=true;

        double begin=0;
        int currentIndex=-1;
        char[] cc=str.toCharArray();
        boolean isPositive=true;
        for(int i=0;i<cc.length;i++){
            char c=cc[i];
            if(isFirst){
                if(c!='0'){
                    if(c=='-'&&i==0){
                        isPositive=false;
                        continue;
                    }else if(c=='-'){
                        return 0;
                    }
                    if(c=='.'){
                        return 0;
                    }if(c>='1'&&c<='9'){
                        begin=(c-'0');
                    }else{
                        return 0;
                    }
                    isFirst=false;
                }
            }else{
                if(c=='.'){
                    currentIndex=i;
                    break;
                }
                if(c>='0'&&c<='9')begin=begin*10+(c-'0');
                else
                    return 0;
            }
        }
        if(currentIndex!=-1){
            for(int i=currentIndex+1;i<cc.length;i++){
                if(cc[i]<'0'||cc[i]>'9'){
                    return 0;
                }
            }
        }
        return isPositive?(int)begin:(int)(-begin);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
//        getMinBoll();
//        Scanner in = new Scanner(System.in);
//        System.out.println(string2int(in.nextLine()));
        long a=Long.MAX_VALUE-1000;
        System.out.println((int)a);
//        System.out.println(string2int(""));
    }

    public static void getMinBoll(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            int k=in.nextInt();
            map.put(k,map.getOrDefault(k,0)+1);
        }
        int sum=0;
        List<Integer> list=new ArrayList<>();
        int minValue=Integer.MAX_VALUE;
        for(int k:map.keySet()){
            int t=map.get(k);
            minValue=Math.min(t,minValue);
            if(minValue<2){
                System.out.println(0);
                return;
            }
            list.add(map.get(k));
        }
        int mean=getDivide(list,minValue);
        if(mean==0){
            System.out.println(0);
        }else{
            System.out.println(N/mean);
        }
        //System.out.println(sum);
    }
    public static int getDivide(List<Integer> list,int minValue){
        for(int i=2;i<=minValue;i++){
            boolean isFind=true;
            for(int k:list){
                if(isFind&&k%i!=0){
                    isFind=false;
                    break;
                }
            }
            if(isFind){
                return i;
            }
        }
        return 0;
    }
}