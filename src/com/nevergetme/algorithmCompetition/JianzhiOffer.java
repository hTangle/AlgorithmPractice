package com.nevergetme.algorithmCompetition;

public class JianzhiOffer {
    public static void main(String[] args){
        JianzhiOffer jzo=new JianzhiOffer();
        //jzo.findFromMatrix(new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}},6);
        //jzo.rotateMinNumber(new int[]{3,4,5,1,2});
        //new JianzhiOffer().repeatNumbersInList(new int[]{2,3,1,0,2,5,3});
        System.out.println(jzo.NumberOf1(7));
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
