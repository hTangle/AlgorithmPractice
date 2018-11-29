package com.nevergetme.algorithm.sort;

public class QuickSort extends SortMain{
    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
        show(a);
    }
    private void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)
            return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private int partition(Comparable[] a,int lo,int hi){
        int i=lo,j=hi+1;
        Comparable v=a[lo];
        while (true){
            while(less(a[++i],v))if(i==hi)break;
            while (less(v,a[--j]))if(j==lo)break;
            if(i>=j)
                break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    //利用排序算法中的切分找到数组中第k小的元素
    public Comparable select(Comparable[] a,int k){
        int lo=0,hi=a.length-1;
        while (hi>lo){
            int j=partition(a,lo,hi);
            if(j==k)return a[k];
            else if(j>k)hi=j-1;
            else if(j<k)lo=j+1;
        }
        return a[k];
    }
}
