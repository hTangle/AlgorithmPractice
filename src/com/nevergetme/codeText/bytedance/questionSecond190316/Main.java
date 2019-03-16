package com.nevergetme.codeText.bytedance.questionSecond190316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    List<String> result=new ArrayList<>();
    public static void main(String[] args) {
        Main main=new Main();
        Scanner in = new Scanner(System.in);
        int N=Integer.parseInt(in.nextLine());
        for(int i=0;i<N;i++){
            String s=in.nextLine();
            main.handleString(s);
        }
        for(String ss:main.result){
            System.out.println(ss);
        }
    }
    public void handleString(String s){
        for(int i=0;i<s.length();i++){
            while(i+2<s.length()&&s.charAt(i+1)==s.charAt(i)&&s.charAt(i+2)==s.charAt(i)){
                String t=s.substring(i+3);
                s=s.substring(0,i+2)+t;
            }
        }
        for(int i=0;i<s.length()-3;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                if(s.charAt(i+2)==s.charAt(i+3)){
                    s=s.substring(0,i+2)+s.substring(i+3);
                }
            }
        }
        result.add(s);
//        if(s.length()<=2){
//            result.add(s);
//            //System.out.println(s);
//            return;
//        }
//        char begin=s.charAt(0);
//        StringBuilder sb=new StringBuilder();
//        int len=s.length();
//        for(int i=0;i<len;){
//            if(i+1<s.length()){
//                if(s.charAt(i+1)!=begin)
//                {
//                    sb.append(begin);
//                    begin=s.charAt(i+1);
//                    i++;
//                }else{
//                    //AA
//                    if(i+2<len){
//                        if(s.charAt(i+2)==begin){
//                            //AAA*
//                            int b=i+2;
//                            while (b<len&&s.charAt(b)==begin){
//                                b++;
//                            }
//                            if(b==len){
//                                sb.append(begin);
//                                sb.append(begin);
//                                i=b;
//                            }else{
//                                i=b-2;
//                            }
//                            //begin=s.charAt(b);
//
//                        }else{
//                            //AAB
//                            if(i+3<len){
//                                if(s.charAt(i+3)==s.charAt(i+2)){
//                                    //AABB
//                                    //if AABBBBB->AAB
//                                    int b=i+3;
//                                    char ct=s.charAt(i+2);
//                                    while(b<len&&s.charAt(b)==ct){
//                                        b++;
//                                    }
//                                    sb.append(begin);
//                                    sb.append(begin);
//                                    sb.append(ct);
//                                    i=b;
//                                    if(b!=len)
//                                        begin=s.charAt(i);
//                                }else{
//                                    sb.append(begin);
//                                    sb.append(begin);
//                                    sb.append(s.charAt(i+2));
//                                    i=i+3;
//                                }
//                            }else{
//                                sb.append(begin);
//                                sb.append(begin);
//                                sb.append(s.charAt(i+2));
//                                i=i+3;
//                            }
//                        }
//                    }else{
//                        sb.append(begin);
//                        sb.append(begin);
//                        i+=2;
//                    }
//                }
//            }else{
//                sb.append(begin);
//                i++;
//            }
//        }
//        result.add(sb.toString());
        //System.out.println(sb.toString());
    }
}
