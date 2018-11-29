package com.nevergetme.algorithm.sort;

public class HeapSort extends SortMain {
    private void sink(Comparable[] a, int k, int N) {
        k=1;
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a[j], a[j + 1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--)
            sink(a, k, N);
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
}
