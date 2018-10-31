package com.nevergetme.algorithm.sort;

public class MergeSort extends SortMain{
    private static Comparable[] aux;
    @Override
    public void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
        show(a);
    }
    public void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    public void merge(Comparable[] a,int lo,int mid,int hi){
        if(less(a[mid],a[mid+1]))
            return;
        int i=lo,j=mid+1;

        for(int k=lo;k<=hi;k++){
            aux[k]=a[k];
        }
        for(int k=lo;k<=hi;k++){

            if(i>mid)a[k]=aux[j++];//如果左边没有了，取右边的
            else if(j>hi) a[k]=aux[i++];//如果右边没有了，取左边的
            else if(less(aux[j],aux[i]))a[k]=aux[j++];//取两者中较小的部分
            else a[k]=aux[i++];
        }
    }
}
