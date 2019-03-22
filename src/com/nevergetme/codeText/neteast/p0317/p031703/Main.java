package com.nevergetme.codeText.neteast.p0317.p031703;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Integer> results=new ArrayList<>();
        while (sc.hasNextLine()) {
             String t=sc.nextLine();
             if(t!=null&&t!=""){
                 String[] ts=t.split(" ");
                 int x=Integer.parseInt(ts[0]);
                 int y=Integer.parseInt(ts[1]);
                 if(x>=0&&y>=0){
                     if (x >= y) {
                         results.add(4 * x * x - 2 * x - (x - y));
                     } else {
                         results.add(4 * y * y - 2 * y + (y - x));
                     }
                 }else if(x>0&&y<0){
                     if(x>Math.abs(y)){
                         results.add(4*x*x-4*x+(x+y));
                     }else{
                         results.add(4*y*y-4*y+(x+y));
                     }
                 }else if(x<=0&&y>=0){
                     if(Math.abs(x)>=y){
                         results.add(4*x*x-(x+y));
                     }else{
                         results.add(4*y*y-(y+x));
                     }
                 }else if(x<=0&&y<=0){
                     if(x<y){
                         results.add(4*x*x-2*x+(x-y));
                     }else{
                         results.add(4*y*y-2*y+(x-y));
                     }
                 }else{
                     results.add(0);
                 }
             }else{
                 break;
             }
        }
        for(int result:results){
            System.out.println(result);
        }
    }
}
