package com.nevergetme.algorithmCompetition;

public class JianzhiOffer {
    public static void main(String[] args){
        JianzhiOffer jzo=new JianzhiOffer();
        jzo.findFromMatrix(new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}},6);
        //new JianzhiOffer().repeatNumbersInList(new int[]{2,3,1,0,2,5,3});
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
