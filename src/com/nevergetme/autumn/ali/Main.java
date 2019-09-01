package com.nevergetme.autumn.ali;

public class Main {
    public static void main(String[] args) {
        helper(new int[]{0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1}, 3);
    }

    public static void helper(int[] num, int k) {
        int curOne = 0;
        int before = 0, last = 0;
        int maxLen = Integer.MIN_VALUE, maxIndex = -1;
        while (before < num.length && last < num.length) {
            while (curOne < k + 1 && last < num.length) {
                if (last - before - curOne > maxLen) {
                    maxIndex = before;
                    maxLen = last - before - curOne;
                }
                curOne += num[last];
                if (curOne < k + 1) last++;
            }
            while (curOne > k) {
                curOne -= num[before++];
                if (last - before - curOne + 1 > maxLen) {
                    maxIndex = before;
                    maxLen = last - before - curOne + 1;
                }
            }

        }
        System.out.println(maxIndex + "," + maxLen);

    }
}
