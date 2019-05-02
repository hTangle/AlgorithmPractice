package com.nevergetme.codeText.MeiTuan;

import java.util.*;

public class Main {
    static class Node{
        ArrayList<Node> nodes=new ArrayList<>();
        boolean black;
        int val;
        public Node(boolean black,int val){
            this.val=val;
            this.black=black;
        }

    }
    public static boolean isInsert(Node f,boolean black,int val,int father){
        if(f.val==father){
            Node node=new Node(black,val);
            f.nodes.add(node);
            return true;
        }else{
            for(Node n:f.nodes){
                if(isInsert(n,black,val,father))return true;
            }
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] head=new int[N];
        head[0]=0;
        boolean[] isBlcak=new boolean[N];
        for(int i=1;i<N;i++){
            head[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++){
            isBlcak[i]=(sc.nextInt()==1?true:false);
        }
        Node root=new Node(isBlcak[0],0);
        for(int i=1;i<N;i++){
            isInsert(root,isBlcak[i],i,head[i]);
        }
        System.out.println();
    }
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int N=sc.nextInt();
//        int M=sc.nextInt();
//        Map<Integer,Integer> map01=new HashMap<>();
//        Map<Integer,Integer> map02=new HashMap<>();
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                int k=sc.nextInt();
//                if(i%2==0){
//                    if(j%2==0){
//                        map01.put(k,map01.getOrDefault(k,0)+1);
//                    }else{
//                        map02.put(k,map01.getOrDefault(k,0)+1);
//                    }
//                }else{
//                    if(j%2==1){
//                        map01.put(k,map01.getOrDefault(k,0)+1);
//                    }else{
//                        map02.put(k,map01.getOrDefault(k,0)+1);
//                    }
//                }
//            }
//        }
//        //需要把map01，map02里的数字改成一样的，但是不能相同
//        //找出map01和map02中数字最多的，如果最多的数字不同，把其他数字都变成最多的那个
//        //如果最多的数字相同，那就把
//        if(map01.size()==1&&map02.size()==1){
//            //说明这些点都相同
//            int m1=0,m2=0,m1l=0,m2l=0;
//            for(int k:map01.keySet()){
//                m1=k;
//                m1l=map01.get(k);
//            }
//            for(int k:map02.keySet()){
//                m2=k;
//                m2l=map02.get(k);
//            }
//            if(m1==m2){
//                System.out.println(M*N-Math.min(m1l,m2l));
//            }else{
//                System.out.println(0);
//            }
//        }else if(map01.size()==1){
//            helper(map01,map02,N,M,0);
//        }else if(map02.size()==1){
//            helper(map02,map01,N,M,1);
//        }else{
//            int m1Max=-1,m1Index=-1,m1Min=-1,m1MIndex=-1;
//            int m2Max=-1,m2Index=-1,m2Min=-1,m2MIndex=-1;
//            for(int k:map01.keySet()){
//                if(map01.get(k)>=m1Max){
//                    m1Min=m1Max;
//                    m1MIndex=m1Index;
//                    m1Index=k;
//                    m1Max=map01.get(k);
//                }else if(map01.get(k)>=m1Min){
//                    m1Min=map01.get(k);
//                }
//            }
//            for(int k:map02.keySet()){
//                if(map02.get(k)>=m2Max){
//                    m2Min=m2Max;
////                    m2MIndex=m2Index;
//                    m2Index=k;
//                    m2Max=map02.get(k);
//                }else if(map02.get(k)>=m2Min){
//                    m2Min=map02.get(k);
//                }
//            }
//            if(m1Index!=m2Index){
//                System.out.println(M*N-m1Max-m2Max);
//            }else{
//                if(m1Max>m2Max){
//                    System.out.println(M*N-m1Max-m2Min);
//                }else{
//                    System.out.println(M*N-m1Min-m2Max);
//                }
//            }
//        }
//
//    }
//    public static void helper(Map<Integer,Integer> map01,Map<Integer,Integer> map02,int N,int M,int diff){
//        int m1=0,m1l=0;
//        for(int k:map01.keySet()){
//            m1=k;
//            m1l=map01.get(k);
//        }
//        int mMax=0,mMin=0,mMaxIndex=0,mMinIndex=0;
//        for(int k:map02.keySet()){
//            if(map02.get(k)>=mMax){
//                mMinIndex=mMaxIndex;
//                mMin=mMax;
//                mMax=map02.get(k);
//                mMaxIndex=k;
//            }else if(map02.get(k)>=mMin){
//                mMin=map02.get(k);
//                mMinIndex=k;
//            }
//        }
//        if(m1==mMaxIndex){
//            System.out.println(M*N/2+diff-mMin);
//        }else{
//            System.out.println(M*N/2+diff-mMax);
//        }
//    }
}
