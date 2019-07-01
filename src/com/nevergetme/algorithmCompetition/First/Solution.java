package com.nevergetme.algorithmCompetition.First;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Solution s=new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbbb"));
    }
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            return findMedianSortedArrays(B,A);
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(),ans=0;
        int[] index=new int[256];
        for(int i=0,j=0;j<n;j++){
            i=Math.max(i,index[s.charAt(j)]);
            ans=Math.max(ans,j-i+1);
            index[s.charAt(j)]=j+1;
        }
        return ans;
    }
}
