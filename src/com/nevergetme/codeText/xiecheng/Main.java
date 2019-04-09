package com.nevergetme.codeText.xiecheng;

import java.util.*;

public class Main {
    public static int getNumbers(String s){
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='/'&&i!=s.length()-1){
                num++;
            }
        }
        return num;
    }
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] lists = input.substring(1, input.length() - 1).split(",");
        int K = in.nextInt();
        int len = lists.length;
        K = K % len;
        if (K == 0 || K == 1) {
            System.out.println(input);
        } else {
            System.out.print("[");
            int times = (int) Math.ceil((int) (len / K));
            int last=len%K==0?K*(times-1):K*(times);
            for (int i = 0; i <= times; i++) {
                for (int j = Math.min(len - 1, (i + 1) * K-1); j >= i * K; j--) {
                    System.out.print(lists[j]);
                    if(j==last){
                        System.out.println("]");
                    }else{
                        System.out.print(",");
                    }
                }
            }
        }
//        Scanner scanner=new Scanner(System.in);
//        int K=scanner.nextInt();
//        String[] s=scanner.nextLine().substring(1).split(" ");
//        Map<String,Integer> map=new HashMap<>();
//        for(int z=0;z<s.length;z++){
//            String t=s[z];
//            if(t.endsWith("//")){
//                t=t.substring(0,t.length()-1);
//            }
//            if(map.containsKey(t)){
//                int count=map.get(t);
//                int len=getNumbers(t);
//                if(len<3){
//                    String i="";
//                    for(int j=0;j<len;j++){
//                        i+="1";
//                    }
//                    System.out.print(i);
//                }else{
//                    String i="1";
//                    for(int j=1;j<len-1;j++){
//                        i+=""+count;
//                    }
//                    i+="1";
//                    System.out.print(i);
//                }
//                map.put(t,count+1);
//                //if(t.)
//            }else{
//                map.put(t,2);
//                int len=getNumbers(t);
//                String ss="";
//                for(int i=0;i<len;i++){
//                    ss+="1";
//                }
//                System.out.print(ss);
//            }
//            if(z==s.length-1){
//                System.out.println();
//            }else{
//                if(t=="")
//                    continue;
//                System.out.print(" ");
//            }
//        }

    }
}
   // Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
//        String[] lists = input.substring(1, input.length() - 1).split(",");
//        int K = in.nextInt();
//        int len = lists.length;
//        K = K % len;
//        if (K == 0 || K == 1) {
//            System.out.println(input);
//        } else {
//            System.out.print("[");
//            int times = (int) Math.ceil((int) (len / K));
//            int last=len%K==0?K*(times-1):K*(times);
//            for (int i = 0; i <= times; i++) {
//                for (int j = Math.min(len - 1, (i + 1) * K-1); j >= i * K; j--) {
//                    System.out.print(lists[j]);
//                    if(j==last){
//                        System.out.println("]");
//                    }else{
//                        System.out.print(",");
//                    }
//                }
//            }
//        }