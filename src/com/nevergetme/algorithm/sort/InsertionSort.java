package com.nevergetme.algorithm.sort;

public class InsertionSort extends SortMain{
    @Override
    public void sort(Comparable[] a) {
        int N=a.length;
        for(int i=1;i<N;i++){
            int cur=i;
            for(int j=i-1;j>=0;j--){
                if(less(a[cur],a[j])){
                    exch(a,cur,j);
                    cur=j;
                }else{
                    break;
                }
            }
        }
        show(a);
    }
}
