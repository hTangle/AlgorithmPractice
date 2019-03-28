package com.nevergetme.codeText.huawei.huawei03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int[] X=new int[N];
        int[] Y=new int[N];
        for(int i=0;i<N;i++){
            X[i]=in.nextInt();
            Y[i]=in.nextInt();
        }
        System.out.println(new Main().getMinCutTimes(X,Y));

    }
    public int getMinCutTimes(int[] X,int[] Y)
    {
        boolean[] isVisited=new boolean[X.length];
        getMinCutTimes(X,Y,isVisited,0);
        return minCutTimes;
    }
    public void getMinCutTimes(int[] X,int[] Y,boolean[] isVisited,int cutTimes){
        //每次减少的点最多
        //boolean[] isVisited=new boolean[X.length];
        boolean isFinish = true;
        for (boolean b : isVisited) {
            if (!b) {
                isFinish = false;
                break;
            }
        }
        if (isFinish) {
            minCutTimes = cutTimes;
            return;
        }
        List<Integer> list;
        List<Integer> output=null;
        int maxLen=-1;
        int nodeIndex=0;
        for(int i=0;i<X.length;i++){
            if(isVisited[i])continue;
            isVisited[i]=true;
            list=getMinCut(X,Y,i,isVisited);
            if(list!=null&&maxLen<list.size()){
                output=list;
                nodeIndex=i;
            }else{
                list=new ArrayList<>();
                list.add(i);
                if(list.size()>maxLen){
                    maxLen=list.size();
                    output=list;
                    nodeIndex=i;
                }
            }
            isVisited[i]=false;
        }
        isVisited[nodeIndex]=true;
        for(int k:output){
            isVisited[k]=true;
        }
        getMinCutTimes(X,Y,isVisited,cutTimes+1);
    }
    public List<Integer> getMinCut(int[] X,int[] Y,int beginIndex,boolean[] isVisited){
        List<Integer>[] position=new List[5];
        for(int i=0;i<5;i++){
            position[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<X.length;i++){
            if(i!=beginIndex&&!isVisited[i]){
                position[getPosition(X[beginIndex],Y[beginIndex],X[i],Y[i])].add(i);
            }
        }
        int maxLen=0;
        int maxIndex=0;
        for(int i=0;i<4;i++){
            if(position[i].size()>maxLen){
                maxLen=position[i].size();
                maxIndex=i;
            }
        }
        if(maxLen==0){
            return null;
        }else{
            return position[maxIndex];
        }
    }
    public int minCutTimes=Integer.MAX_VALUE;

    public int getPosition(int x1,int y1,int x2,int y2){
        if(x1==x2)
            return 0;
        else if(y1==y2){
            return 1;
        }
        if(x1-y1==x2-y2){
            return 2;
        }else if(x1+y1==x2+y2){
            return 3;
        }
        return 4;
    }
}