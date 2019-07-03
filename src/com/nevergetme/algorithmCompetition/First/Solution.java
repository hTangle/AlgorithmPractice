package com.nevergetme.algorithmCompetition.First;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nQueens(8));
    }
    public int getResult(int n, int m) {
        // write code here
        if(n<1||m<1)return -1;
        int last=0;
        for(int i=2;i<=n;i++)last=(last+m)%i;
        return last;
    }

    int count=0;
    public int nQueens(int n) {
        // write code here
        count=0;
        int[] a=new int[n+1];
        nQueens(a,1,n);
        return count;
    }
    private void nQueens(int[] a,int i,int n){
        if(i>n){
            count++;
            return;
        }
        for(int j=1;j<=n;j++){
            a[i]=j;
            if(hasQueen(a,i))nQueens(a,i+1,n);
        }
    }
    private boolean hasQueen(int[] a,int i){
        for(int j=1;j<i;j++){
            if(a[j]==a[i]||a[j]-a[i]==(j-i)||a[j]-a[i]==i-j){
                return false;
            }
        }
        return true;
    }

    public int countCoins(int n) {
        // write code here
        int[] v = new int[]{1, 5, 10, 25};
        int mod=1000000007;
        int[] dp=new int[100001];
        dp[0]=1;
        for(int i=0;i<4;i++){
            for(int j=v[i];j<=n;j++){
                dp[j]=(dp[j]+dp[j-v[i]])%mod;
            }
        }
        return dp[n];
    }

    public int countWays(int[][] map, int x, int y) {
        // write code here
        int mod = 1000000007;
        int[][] pos = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    pos[i][j] = map[i][j] == 0 ? 0 : 1;
                } else if (i == 0) {
                    pos[i][j] = map[i][j] == 0 ? 0 : pos[i][j - 1] % mod;
                } else if (j == 0) {
                    pos[i][j] = map[i][j] == 0 ? 0 : pos[i - 1][j] % mod;
                } else {
                    pos[i][j] = map[i][j] == 0 ? 0 : (pos[i - 1][j] + pos[i][j - 1]) % mod;
                }
            }
        }
        return pos[x - 1][y - 1];
    }

    public int countWays(int x, int y) {
        int[][] pos = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0) {
                    pos[i][j] = 1;
                } else {
                    pos[i][j] = pos[i - 1][j] + pos[i][j - 1];
                }
            }
        }
        return pos[x - 1][y - 1];

    }

    public int countWays(int n) {
        // write code here
        int f1 = 1, f2 = 2, f3 = 4;
        int mod = 1000000007;
        if (n == 1) return f1;
        if (n == 2) return f2;
        if (n == 3) return f3;
//        n-=3;
        while (--n >= 3) {
            int temp = ((f1 + f2) % mod + f3) % mod;
            f1 = f2;
            f2 = f3;
            f3 = temp;
        }
        return f3;
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            return findMedianSortedArrays(B, A);
        }
        int iMin = 0, iMax = m, halfLen = (n + m + 1) / 2;
        while (iMin < iMax) {
            int i = (iMin + iMax) >> 1;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(B[j - 1], A[i - 1]);
                }
                if ((n + m) % 2 == 1) return maxLeft;
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }
                return (minRight + maxLeft) / 2.0;
            }
        }
        return 0.0;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[256];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
