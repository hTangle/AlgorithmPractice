package com.nevergetme.algorithmCompetition.First;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Solution s=new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{2},new int[]{1,3}));
    }
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            return findMedianSortedArrays(B,A);
        }
        int iMin=0,iMax=m,halfLen=(n+m+1)/2;
        while (iMin<iMax){
            int i=(iMin+iMax)>>1;
            int j=halfLen-i;
            if(i<iMax&&B[j-1]>A[i]){
                iMin=i+1;
            }else if(i>iMin&&A[i-1]>B[j]){
                iMax=i-1;
            }else{
                int maxLeft=0;
                if(i==0){
                    maxLeft=B[j-1];
                }else if(j==0){
                    maxLeft=A[i-1];
                }else{
                    maxLeft=Math.max(B[j-1],A[i-1]);
                }
                if((n+m)%2==1)return maxLeft;
                int minRight=0;
                if(i==m){
                    minRight=B[j];
                }else if(j==n){
                    minRight=A[i];
                }else{
                    minRight=Math.min(A[i],B[j]);
                }
                return (minRight+maxLeft)/2.0;
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
