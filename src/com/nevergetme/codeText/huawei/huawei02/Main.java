package com.nevergetme.codeText.huawei.huawei02;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] x=new int[5];
        int[] y=new int[5];
        for(int i=0;i<5;i++){
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        System.out.println(new Main().getMinDistance(x,y));

    }
    public int getMinDistance(int[] x,int[] y){
        boolean[] isVisited=new boolean[5];
        for(int i=0;i<x.length;i++){
            isVisited[i]=true;
            getMinDistance(x,y,i,isVisited,getDistance(0,0,x[i],y[i]));
            isVisited[i]=false;
        }
        return (int)minDistance;
    }
    public double getDistance(int x1,int y1,int x2,int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public double minDistance=Double.MAX_VALUE;
    public void getMinDistance(int[] x,int[] y,int before,boolean[] isVisited,double distance){
        boolean isAllVisited=true;
        for(int i=0;i<5;i++){
            if(!isVisited[i]){
                isAllVisited=false;
                break;
            }
        }
        if(isAllVisited){
            minDistance=Math.min(minDistance,distance+getDistance(0,0,x[before],y[before]));
            return;
        }
        for(int i=0;i<5;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                getMinDistance(x,y,i,isVisited,getDistance(x[before],y[before],x[i],y[i])+distance);
                isVisited[i]=false;
            }
        }
    }
}