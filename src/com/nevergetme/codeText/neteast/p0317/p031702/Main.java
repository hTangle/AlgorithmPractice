package com.nevergetme.codeText.neteast.p0317.p031702;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static class Rect{
        int W,H;
        double WH;
        int area;
        public Rect(int W,int H){
            this.W=W;
            this.H=H;
            WH=Math.min(W*1.0/H,H*1.0/W);
            area=W*H;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        Rect[] rects=new Rect[N];
        for(int i=0;i<N;i++){
            rects[i]=new Rect(sc.nextInt(),sc.nextInt());
        }
        Arrays.sort(rects, new Comparator<Rect>() {
            @Override
            public int compare(Rect o1, Rect o2) {
                if(o1.area>o2.area){
                    return 1;
                }else if(o1.area==o2.area){
                    if(o1.WH>o2.WH){
                        return 1;
                    }else if(o1.WH==o2.WH){
                        if(o1.W>o2.W){
                            return 1;
                        }else if(o1.W==o2.W){
                            return 0;
                        }else{
                            return -1;
                        }
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
        });
        for(int i=0;i<rects.length;i++){
            System.out.print(rects[i].W+" "+rects[i].H);
            if(i<rects.length-1)
                System.out.print(" ");
        }
        System.out.println();
    }
}
