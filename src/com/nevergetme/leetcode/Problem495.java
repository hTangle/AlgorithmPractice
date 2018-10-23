package com.nevergetme.leetcode;

public class Problem495 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        //在输入为数组的时候，需要判断数组的长度
        int outputTime=0;
        for(int i=0;i<timeSeries.length-1;i++){
            if(timeSeries[i+1]-timeSeries[i]>duration){
                outputTime+=duration;
            }else{
                outputTime+=(timeSeries[i+1]-timeSeries[i]);
            }
        }
        if(timeSeries.length>0){
            outputTime+=duration;
        }
        return outputTime;
    }
    public static void main(String[] args){
        System.out.println(findPoisonedDuration(new int[]{1,2},2));
    }
}
