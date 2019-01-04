package com.nevergetme.algorithmCompetition;

import java.util.*;

public class JianzhiOffer {
    public static void main(String[] args){
        JianzhiOffer jzo=new JianzhiOffer();
        //jzo.findFromMatrix(new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}},6);
        //jzo.rotateMinNumber(new int[]{3,4,5,1,2});
        //new JianzhiOffer().repeatNumbersInList(new int[]{2,3,1,0,2,5,3});
        //System.out.println(jzo.NumberOf1(7));
        System.out.println(jzo.moreThanHalfNumbers(new int[]{1,2,2,3,2,1,2,2,1,2,1}));
        Map<Integer,Integer> map=new HashMap<>();
        getCarentChildPairs( new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 10}
        });
    }
    public static void getCarentChildPairs(int[][] parentChildPairs){
        //output have two collections, but java's function return type have only one collections a time
        //should i have to use like below
        //List

        // so you can put two collections in a third one and then return right?
        Map<Integer,Integer> outcomeMap=new HashMap<>();
        Map<Integer,Integer> outcomeMapLeft=new HashMap<>();
        for(int i=0;i<parentChildPairs.length;i++){
            if(outcomeMapLeft.containsKey(parentChildPairs[i][0])){
                outcomeMapLeft.put(parentChildPairs[i][0],outcomeMapLeft.get(parentChildPairs[i][0])+1);
            }else{
                outcomeMapLeft.put(parentChildPairs[i][0],1);
            }

            if(outcomeMap.containsKey(parentChildPairs[i][1])){
                outcomeMap.put(parentChildPairs[i][1],outcomeMap.get(parentChildPairs[i][1])+1);
            }else{
                outcomeMap.put(parentChildPairs[i][1],1);
            }
        }
        List<Integer> zeroParent=new ArrayList<>();
        List<Integer> oneParent=new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = outcomeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if(entry.getValue()==1)
                oneParent.add(entry.getKey());
        }
        Iterator<Map.Entry<Integer, Integer>> iterator1 = outcomeMapLeft.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator1.next();
            if(entry.getValue()==1)
                zeroParent.add(entry.getKey());
        }
        List<List<Integer>> output=new ArrayList<>();
        output.add(zeroParent);
        output.add(oneParent);
        System.out.println();
        //get the value=1 &&value=0
    }
    public int moreThanHalfNumbers(int[] numbers){
        if(numbers.length<1)return 0;
        int currentNumbers=numbers[0];
        int currentTimes=1;
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]!=currentNumbers){
                if(currentTimes==0){
                    currentNumbers=numbers[i];
                    currentTimes=1;
                }else{
                    currentTimes-=1;
                }
            }else{
                currentTimes+=1;
            }
        }
        return currentNumbers;
    }
    public int NumberOf1(int n){
        int count=0;
        while (n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
    public int maxProductAfterCuttingSolutionTwo(int length){
        if(length<2)return 0;
        if(length==2)return 1;
        if(length==3)return 2;
        int timesOf3=length/3;
        if(length-timesOf3*3==1){
            timesOf3-=1;
        }
        int timesOf2=(length-timesOf3*3)/2;
        return (int)(Math.pow(3,timesOf3))*(int)(Math.pow(2,timesOf2));
    }
    public int maxProductAfterCuttingSolutionOne(int length){
        if(length<2)return 0;
        if(length==2)return 1;
        if(length==3)return 2;
        int[] products=new int[length+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        int max=0;
        for(int i=4;i<=length;i++){
            max=0;
            for(int j=1;j<=i/2;j++){
                int product=products[j]*products[i-j];
                if(max<product)
                    max=product;
                products[i]=max;
            }
        }
        max=products[length];
        return max;
    }
    public void rotateMinNumber(int[] numbers){
        int index1=0;
        int index2=numbers.length-1;
        int indexMid=index1;
        while (numbers[index1]>=numbers[index2]){
            if(index2-index1==1){
                indexMid=index2;
                break;
            }
            indexMid=(index1+index2)/2;
            if(numbers[index1]==numbers[index2]&&numbers[index1]==numbers[indexMid])
                rotateMinNumber(numbers,index1,index2);
            if(numbers[indexMid]>=numbers[index1]){
                index1=indexMid;
            }else if(numbers[indexMid]<=numbers[index2]){
                index2=indexMid;
            }
        }
        System.out.println(numbers[indexMid]);
    }
    public void rotateMinNumber(int[] numbers,int index1,int index2){
        int reslut=numbers[index1];
        for(int i=index1+1;i<=index2;i++){
            if(reslut>numbers[i])
                reslut=numbers[i];
        }
        System.out.println(reslut);
    }
    public void repeatNumbersInList(int[] input){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<input.length;i++){
            while(input[i]!=i){
                if(input[i]==input[input[i]]){
                    sb.append(input[i]);
                    break;
                }
                int temp=input[i];
                input[i]=input[input[i]];
                input[temp]=temp;
            }
        }
        System.out.println(sb.toString());
    }
    public void findFromMatrix(int[][] input,int target){
        //int[] output=new int[2];
        int i=0;
        int j=input[0].length-1;
        while(true){
            if(input[i][j]>target)
                j--;
            else if(input[i][j]<target){
                i++;
            }else{
                System.out.println(i+","+j);
                break;
            }
            if(i>=input.length||j<0) {
                System.out.println("error");
                break;
            }
        }
    }
}
