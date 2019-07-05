package com.nevergetme.algorithmCompetition.First;

import com.nevergetme.datastructure.stack.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println(s.isPalindrome(l1));
    }

//    public ListNode getTreeLevel(TreeNode root, int dep) {
//        // write code here
//        ListNode head=new ListNode(-1);
//    }
//    private void getTreeLevel(TreeNode root,int dep,int current,ListNode head){
//        if(current==dep){
//            head.next
//        }
//    }
    private boolean balance = true;

    public boolean isBalance(TreeNode root) {
        // write code here
        isBalanceHelper(root);
        return balance;
    }

    private int isBalanceHelper(TreeNode root) {
        if (root == null) return 0;
        if (!balance) return -1;
        if (root.left == null && root.right == null) return 1;
        int left = isBalanceHelper(root.left);
        int right = isBalanceHelper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            balance = false;
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }


    public class UndirectedGraphNode {
        int label = 0;
        UndirectedGraphNode left = null;
        UndirectedGraphNode right = null;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null || pHead.next == null) return true;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = pHead;
        while (p != slow) {
            stack.push(p.val);
            p = p.next;
        }
        if (fast != null) {
            //说明长度为奇数
            slow = slow.next;
        }
        while (slow != null && !stack.isEmpty()) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public int countPairs(int[] A, int n, int sum) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int pair = 0;
        for (int a : A) {
            if (map.containsKey(a)) {
                if (a == sum - a) {
                    pair += (map.get(a) * (map.get(a) - 1) / 2);
                    map.remove(a);
                } else if (map.containsKey(sum - a)) {
                    pair += map.get(a) * map.get(sum - a);
                    map.remove(a);
                    map.remove(sum - a);
                }
            }
        }
        return pair;
    }

    public int getMaxSum(int[] A) {
        // write code here
        if (A.length < 1) return -1;
        if (A.length == 1) return A[0];
        int maxSum = A[0];
        int current = 0;
        for (int i = 0; i < A.length; i++) {
            current += A[i];
            if (current < 0) {
                maxSum = Math.max(current, maxSum);
                current = 0;
            } else {
                maxSum = Math.max(current, maxSum);
            }
        }
        return maxSum;
    }

    public int getResult(int n, int m) {
        // write code here
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) last = (last + m) % i;
        return last;
    }

    int count = 0;

    public int nQueens(int n) {
        // write code here
        count = 0;
        int[] a = new int[n + 1];
        nQueens(a, 1, n);
        return count;
    }

    private void nQueens(int[] a, int i, int n) {
        if (i > n) {
            count++;
            return;
        }
        for (int j = 1; j <= n; j++) {
            a[i] = j;
            if (hasQueen(a, i)) nQueens(a, i + 1, n);
        }
    }

    private boolean hasQueen(int[] a, int i) {
        for (int j = 1; j < i; j++) {
            if (a[j] == a[i] || a[j] - a[i] == (j - i) || a[j] - a[i] == i - j) {
                return false;
            }
        }
        return true;
    }

    public int countCoins(int n) {
        // write code here
        int[] v = new int[]{1, 5, 10, 25};
        int mod = 1000000007;
        int[] dp = new int[100001];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = v[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - v[i]]) % mod;
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
