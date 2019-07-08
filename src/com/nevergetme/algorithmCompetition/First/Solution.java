package com.nevergetme.algorithmCompetition.First;

import com.nevergetme.datastructure.stack.Stack;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
//        ListNode root=s.reverseBetween(l1,1,6);
//        s.testCanDivideBy();
        System.out.println(-5 % 4);
//        Thread
//        s.reorderList(l1);
//        System.out.println(s.RectCover(4));
    }

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null || pHead.next == null) return pHead;
        ListNode pMax = new ListNode(-1);
        ListNode pMin = new ListNode(-1);
        ListNode pMaxT = pMax;
        ListNode pMinT = pMin;
        ListNode p = pHead;
        while (p != null) {
            if (p.val >= x) {
                pMaxT.next = p;
                pMaxT = pMaxT.next;
            } else {
                pMinT.next = p;
                pMinT = pMinT.next;
            }
            p = p.next;
        }
        pMaxT.next=null;
        pMinT.next=pMax.next;
        return pMin.next;
    }

    public boolean removeNode(ListNode pNode) {
        // write code here
        if (pNode == null || pNode.next == null) {
            return false;
        }
        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return true;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        while (--k > 0 && p != null) {
            p = p.next;
        }
        ListNode temp = head;
        while (p != null) {
            p = p.next;
            temp = temp.next;
        }
    }

    public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        return (s1 + s1).contains(s2);
    }

    private void testCanDivideBy() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String dir = sc.next();
        int cur = 0;
        for (int i = 0; i < N; i++) {
            if (dir.charAt(i) == 'L') {
                cur++;
            } else {
                cur--;
            }
        }
        cur = cur % 4;
        char[] result = new char[]{'N', 'W', 'S', 'E'};
        System.out.println(result[cur < 0 ? cur + 4 : cur]);
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        for(int i=0;i<n;i++){
//            int m=sc.nextInt();
//            String s=sc.nextLine();
//            int count=0;
//            for(int j=0;j<s.length();j++){
//                if(s.charAt(j)=='.'){
//                    count++;
//                    j+=2;
//                }
//            }
//            System.out.println(count);
//        }
//        int l=sc.nextInt();
//        int r=sc.nextInt();
//        System.out.println(r-l+1-(r+2)/3+(l+1)/3);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        boolean isFirst = m == 1;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode before = head;
        ListNode cur = head.next;
        while (m > 1) {
            n--;
            m--;
            pre = before;
            before = before.next;
            cur = cur.next;
        }
        while (n > 1) {
            before.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = before.next;
            n--;
        }
        return isFirst ? pre.next : head;


//        ListNode begin=null,end=null;
//        ListNode root=head;
//        ListNode before=null;
//        int pos=1;
//        while (root!=null){
//            if(pos==m)begin=root;
//            if(pos==n)end=root;
//            if(begin==null)before=root;
//            root=root.next;
//            pos++;
//            if(begin!=null&&end!=null)break;
//        }
//        end.next=null;
//        begin=reverseList(begin);
//        if(before!=null)before.next=begin;
//        else head=begin;
//        end=head;
//        while (end.next!=null){
//            end=end.next;
//        }
//        end.next=root;
//        return head;

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pHead = reverseList(slow.next);
        slow.next = null;
        fast = head;
        while (pHead != null) {
            slow = fast.next;
            fast.next = pHead;
            pHead = pHead.next;
            fast.next.next = slow;
            fast = slow;
        }


    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode before = null;
        ListNode current = head;
        ListNode after = head.next;
        while (current != null) {
            current.next = before;
            before = current;
            current = after;
            after = after == null ? null : after.next;
        }
        return before;
    }

    public double Power(double base, int exponent) {
        double res = 1, curr = base;
        int exp;
        if (exponent > 0) {
            exp = exponent;
        } else if (exponent < 0) {
            if (base == 0) throw new RuntimeException("除0error");
            exp = -exponent;
        } else {
            return 1;
        }
        while (exp != 0) {
            if (exp % 2 == 1) res *= curr;
            curr *= curr;
            exp >>= 1;
        }
        return exponent >= 0 ? res : (1 / res);
    }

    public int RectCover(int target) {
        int f1 = 1;
        int f2 = 2;
        if (target <= 2) return target;
        while (--target > 1) {
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }

    int exchangeOddEven(int x) {
        // write code here
        int odd = ((x & 0x55555555) << 1);
        int even = ((x & 0xAAAAAAAA) >> 1) & 0x7fffffff;
        return even | odd;
    }

    public int calcCost(int A, int B) {
        // write code here
        A = A ^ B;
        int count = 0;
        while (A != 0) {
            count++;
            A = A & (A - 1);
        }
        return count;

    }

    public int binInsert(int n, int m, int j, int i) {

        // write code here
        m <<= j;
        return n | m;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        FindPath(root, target, results, result);
        Collections.sort(results, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        return results;
    }

    private void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null && target == root.val) {
            ArrayList<Integer> r = new ArrayList<>();
            for (int k : result) {
                r.add(k);
            }
            r.add(root.val);
            results.add(r);
            return;
        }
        result.add(root.val);
        FindPath(root.left, target - root.val, results, result);
        FindPath(root.right, target - root.val, results, result);
        result.remove(result.size() - 1);
    }

    public int getLCA(int a, int b) {
        // write code here
        while (a != b) {
            if (a > b) a >>= 1;
            else b >>= 1;
        }
        return a;
    }

    private int getLCAInterval(int a) {
        int begin = 1;
        while (a >= begin << 1) {
            begin = begin << 1;
        }
        return begin;
    }

    private int nextNode = -2;

    public int findSucc(TreeNode root, int p) {
        // write code here
        //如果有右子树，则是右子树的第一个节点
        //如果没有右子树
        //  如果是父节点的左子树，则为父节点
        //  如果为父节点的右子树，则需要递归判断父节点的父节点与父节点的关系
        findSucc(root, p, 0);
        return nextNode;
    }

    private void findSucc(TreeNode root, int p, int pos) {
        if (nextNode >= 0 || root == null) return;
        findSucc(root.left, p, 0);
        if (nextNode == -1) {
            nextNode = root.val;
            return;
        }
        if (root.val == p) {
            nextNode = -1;//下一个节点是需要寻找的节点
        }
        findSucc(root.right, p, 0);
    }

    private int isBSTLast = Integer.MIN_VALUE;

    public boolean checkBST(TreeNode root) {
        // write code here
        if (root == null) return true;
        if (!checkBST(root.left)) return false;
        if (root.val <= isBSTLast) return false;
        isBSTLast = root.val;
        if (!checkBST(root.right)) return false;
        return true;
    }

    ListNode head = new ListNode(-1);

    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        ListNode pHead = head;
        getTreeLevel(root, dep, 1);
        return pHead.next;
    }

    private void getTreeLevel(TreeNode root, int dep, int current) {
        if (current == dep) {
            head.next = new ListNode(root.val);
            head = head.next;
        } else if (current < dep) {
            getTreeLevel(root.left, dep, current + 1);
            getTreeLevel(root.right, dep, current + 1);
        }
    }

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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode l = this;
            while (l != null) {
                sb.append(l.val);
                if (l.next != null) sb.append(",");
                l = l.next;
            }
            return sb.toString();
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
