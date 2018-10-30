package com.nevergetme.algorithm.sort;

public class ShellSort extends SortMain{
    @Override
    public void sort(Comparable[] a) {
        show(a);
        int N=a.length;
        int h=1;
        while(h<N/3)h=3*h+1;
        while (h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h=h/3;
            show(a);
        }

    }
}
