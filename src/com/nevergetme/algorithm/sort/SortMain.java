package com.nevergetme.algorithm.sort;


import java.util.Arrays;

public abstract class SortMain {
    public abstract void sort(Comparable[] a);
    public boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        SortMain sortMain=new HeapSort();
        Integer[] a=new Integer[]{20,15,14,18,21,36,40,10};
        Arrays.sort(a);
        //sortMain.sort(a);
        System.out.println("");
    }
}
