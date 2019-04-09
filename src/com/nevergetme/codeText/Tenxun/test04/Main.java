package com.nevergetme.codeText.Tenxun.test04;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static boolean changeState;
    public static DecimalFormat df= new DecimalFormat("0.0000");
    public static void helper(int N,int M,int B,int E,double[] power,Map<Integer, List<Integer>> map){
        double[] costTime=new double[N];
        for(int i=0;i<N;i++){
            costTime[i]=-1;
        }
        for(int i=1;;i++){
            changeState=false;
            putPower(power,costTime,B,map,E,i);
            if(!changeState)break;
        }
        for(int i=0;i<N;i++){
            if(costTime[i]<-0.5){
                System.out.print(-1.0000);
            }else{
                System.out.print(df.format(costTime[i]));
            }
            if(i==N-1){
                System.out.println();
            }else{
                System.out.print(" ");
            }
        }
    }
    public static void putPower(double[] power,double[] costTime,int index,Map<Integer, List<Integer>> map,double inputPower,double timeStamp){
        if(power[index]>inputPower){
            changeState=true;
            power[index]-=inputPower;
            return;
        }else if(power[index]==inputPower){
            power[index]=0;
            costTime[index]=timeStamp;
            changeState=true;
            return;
        }
        int size=0;
        if(power[index]==0&&!map.containsKey(index)){
            return;
        }else if(power[index]==0&&(size=map.get(index).size())!=0){
            double newPower=inputPower/size;
            for(int k:map.get(index)){
                putPower(power,costTime,k,map,newPower,timeStamp);
            }

            return;
        }
        if(power[index]!=0){
            double remain=inputPower-power[index];
            double cost=1-remain/inputPower;
            power[index]=0;
            costTime[index]=timeStamp+cost;
            double newPower=remain/size;
            for(int k:map.get(index)){
                putPower(power,costTime,k,map,newPower,timeStamp+cost);
            }
            changeState=true;
        }
        //如果没有输出，直接不处理
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int N=in.nextInt();
            int M=in.nextInt();
            int B=in.nextInt()-1;
            int E=in.nextInt();
            double[] power=new double[N];
            for(int j=0;j<N;j++){
                power[j]=in.nextInt();
            }
            Map<Integer, List<Integer>> map=new HashMap<>();
            for(int j=0;j<M;j++){
                int begin=in.nextInt()-1;
                if(map.containsKey(begin)){
                    map.get(begin).add(in.nextInt()-1);
                }else{
                    List<Integer> list=new ArrayList<>();
                    list.add(in.nextInt()-1);
                    map.put(begin,list);
                }
            }
            helper(N,M,B,E,power,map);
        }
    }
}
//1 6 6 1 2 4 2 4 2 2 20 1 2 1 3 2 4 3 5 4 6 5 6