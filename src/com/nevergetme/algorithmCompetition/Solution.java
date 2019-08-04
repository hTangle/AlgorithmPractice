package com.nevergetme.algorithmCompetition;

import java.io.BufferedOutputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        BufferedOutputStream
        //Object
//        TreeNode t1=new TreeNode(1);
//        TreeNode t2=new TreeNode(2);;
//        TreeNode t3=new TreeNode(5);
//        TreeNode t4=new TreeNode(3);
//        t1.left=t2;
//        t2.right=t3;
//        t1.right=t4;
//        System.out.println(new Solution().binaryTreePaths(t1));
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        ListNode l=solution.rotateRight(l1,2);
//        ReentrantLock
//        l1.next = l3;
//        l3.next = l4;
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(4);
//        l2.next = l5;
//        l5.next = l6;
//        ListNode output = new Solution().addTwoNumbers(l1, l2);
//        System.out.println();

        //for(int i=1;i<20;i++)
        //System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
//        List<String> word=new ArrayList<>();
//        word.add("cat");
//        word.add("cats");
//        word.add("and");
//        word.add("sand");
//        word.add("dog");
//        System.out.println(solution.wordBreak("catsanddog",word));
        //ConcurrentHashMap

        //System.out.println(solution.longestPalindrome("cbbd"));
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<String> list2 = new ArrayList<>();
//        System.out.print(list1.getClass() == list2.getClass());
        //LinkedList

        //System.out.println(solution.canConcat("abcabcabc"));
//        StringBuffer
        //solution.isValid("()");
        //System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        //new Solution().PrintToMaxOfNDigits(2);
        //Queue<>
        //System.out.println(solution.candy(new int[]{1, 2, 2}));
        //System.out.println(solution.cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
//        System.out.println(solution.findMin(new int[]{3,5,1}));
        System.out.println(solution.removeKdigits("112",1));
//        solution.textTreeMap();
//        Thread
//        System.out.println(matcher.toString());
//        ArrayList
    }//77260018937180

    public String removeKdigits(String num, int k) {
        if(num.length()==0||num.length()==k)return "0";
        List<Character> list=new ArrayList<>();
        int n=k,len=num.length(),cnt=0;
        for(char c:num.toCharArray()){
            while (list.size()!=0&&n>0&&c<list.get(list.size()-1)){
                n--;
                list.remove(list.size()-1);
            }
            list.add(c);
        }
        if(list.size()>0){
            while (cnt<list.size()&&list.get(cnt)=='0'){
                cnt++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(;cnt<list.size()&&cnt<len-k;cnt++){
            sb.append(list.get(cnt));
        }
        return list.size()==0?"0":(sb.length()==0?"0":sb.toString());
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else return left == null ? right : left;
    }

    class Money {
        int notUse = 0;
        int use = 0;
    }

    public int rob(TreeNode root) {
        Money rootMoney = getMoney(root);
        return Math.max(rootMoney.notUse, rootMoney.use);
    }

    private Money getMoney(TreeNode root) {
        if (root == null) return new Money();
        Money left = getMoney(root.left);
        Money right = getMoney(root.right);
        Money rootMoney = new Money();
        rootMoney.use = root.val + left.notUse + right.notUse;
        rootMoney.notUse = Math.max(left.notUse, left.use) + Math.max(right.use, right.notUse);
        return rootMoney;
    }

    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int begin, int end) {
        if (end - begin == 2) return Math.max(nums[begin], nums[begin + 1]);
        int[] dp = new int[end - begin];
        dp[0] = nums[begin];
        dp[1] = Math.max(nums[begin], nums[begin + 1]);
        for (int i = 2; i < end - begin; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[begin + i], dp[i - 1]);
        }
        return dp[end - begin - 1];
    }

//    public int rob(int[] nums) {
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return Math.max(nums[0], nums[1]);
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//        return Math.max(dp[nums.length - 1],dp[nums.length-2]);
//    }

    public int superEggDrop(int K, int N) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; ++i)
            dp[i] = i;

        for (int k = 2; k <= K; ++k) {
            // Now, we will develop dp2[i] = dp(k, i)
            int[] dp2 = new int[N + 1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x - 1], dp2[n - x]) > Math.max(dp[x], dp2[n - x - 1]))
                    x++;

                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x - 1], dp2[n - x]);
            }

            dp = dp2;
        }

        return dp[N];
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        boolean[] used = new boolean[maxChoosableInteger + 1];
        int[] f = new int[1 << maxChoosableInteger];
        //数字序列是否被选过了
        Arrays.fill(f, -1);
        return canIWin(used, f, desiredTotal);
    }

    private boolean canIWin(boolean[] used, int[] f, int n) {
        if (n <= 0) return false;
        int idx = canIWinFormat(used);
        if (f[idx] == -1) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!canIWin(used, f, n - i)) {
                        f[idx] = 1;
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            f[idx] = 0;
        }
        return f[idx] == 1;//只有等于1的时候说明是能够成功的
    }

    private int canIWinFormat(boolean[] used) {
        int idx = 0;
        for (boolean b : used) {
            idx <<= 1;
            if (b) {
                idx |= 1;
            }
        }
        return idx;
    }

    public void textTreeMap() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "2");
        map.put(1, "1");
        map.put(3, "3");
        map.forEach((Integer i, String s) ->
                System.out.println(i + "---" + s)
        );
    }

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W + 1];
        // dp[x] = the answer when Alice has x points
        for (int k = K; k <= N; ++k)
            dp[k] = 1.0;

        double S = Math.min(N - K + 1, W);
        // S = dp[k+1] + dp[k+2] + ... + dp[k+W]
        for (int k = K - 1; k >= 0; --k) {
            dp[k] = S / W;
            S += dp[k] - dp[k + W];
        }
        return dp[0];
    }

    int[][][] dp = null;
    //    Object
    int P = 1_000_000_000 + 7;

    public int findPaths(int m, int n, int N, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) return 0;
        if (N == 0) return 0;
        if (dp == null) {
            dp = new int[m][n][N + 1];
            for (int[][] arr : dp) {
                for (int[] a : arr) {
                    Arrays.fill(a, -1);
                }
            }
        }
        if (dp[x][y][N] != -1) return dp[x][y][N];
        long num = 0;
        if (x < 1) num += 1;
        else num = (num + findPaths(m, n, N - 1, x - 1, y)) % P;

        if (y < 1) num += 1;
        else num = (num + findPaths(m, n, N - 1, x, y - 1)) % P;

        if (x >= m - 1) num += 1;
        else num = (num + findPaths(m, n, N - 1, x + 1, y)) % P;
        if (y >= n - 1) num += 1;
        else num = (num + findPaths(m, n, N - 1, x, y + 1)) % P;

        dp[x][y][N] = (int) num % P;
        return (int) num % P;

//        int M=1_000_000_000+7;
//        int[][] dp=new int[m][n];
//        dp[x][y]=1;
//        int count=0;
//        for(int moves=1;moves<=N;moves++){
//            int[][] temp=new int[m][n];
//            for(int i=0;i<m;i++){
//                for(int j=0;j<n;j++){
//                    if(i==m-1)count=(count+dp[i][j])%M;
//                    if(j==n-1)count=(count+dp[i][j])%M;
//                    if(i==0)count=(count+dp[i][j])%M;
//                    if(j==0)count=(count+dp[i][j])%M;
//                    temp[i][j]=(((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M + ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M) % M;
//                }
//            }
//            dp=temp;
//        }
//        return count;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, remain = 0, debt = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                debt += remain;
                start = i + 1;
                remain = 0;
            }
        }
        return remain + debt >= 0 ? start : -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        if (row == 0 || col == 0) return false;
        int up = 0, down = row - 1;
        int mid = -1;
        while (up < down) {
            mid = (up + down) >> 1;
            if (matrix[mid][0] <= target && matrix[mid][col - 1] >= target) {
                break;
            } else if (matrix[mid][0] > target) {
                down = mid - 1;
            } else if (matrix[mid][col - 1] < target) {
                up = mid + 1;
            }
        }
        if (up == down && (matrix[up][0] > target || matrix[up][col - 1] < target)) {
            return false;
        } else if (up == down)
            mid = (up + down) >> 1;
        int left = 0, right = col - 1;
        if (left == right) return target == matrix[mid][left];
        while (left <= right) {
            int m = (left + right) >> 1;
            if (matrix[mid][m] == target) return true;
            else if (matrix[mid][m] > target) right = m - 1;
            else left = m + 1;
        }
        return false;

    }

    public List<Integer> majorityElement(int[] nums) {
        int cn1 = 0, cn2 = 0, ans1 = 0, ans2 = 1;
        for (int n : nums) {
            if (n == ans1) {
                cn1++;
            } else if (n == ans2) {
                cn2++;
            } else if (cn1 == 0) {
                ans1 = n;
                cn1++;
            } else if (cn2 == 0) {
                ans2 = n;
                cn2++;
            } else {
                cn1--;
                cn2--;
            }
        }
        cn1 = cn2 = 0;
        for (int n : nums) {
            if (n == ans1) {
                cn1++;
            } else if (n == ans2) {
                cn2++;
            }
        }
        List<Integer> l = new ArrayList<>();
        if (cn1 > nums.length / 3) l.add(ans1);
        if (cn2 > nums.length / 3) l.add(ans2);
        return l;
    }
    // select A.tagid, count(*) count,T.value from ArticleTags A left join tags T on T.id=A.tagid group by A.tagid;

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Stack<Integer> s1 = new Stack<>();
//        Stack<Integer> s2 = new Stack<>();
//        while (l1 != null) {
//            s1.push(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            s2.push(l2.val);
//            l2 = l2.next;
//        }
//        int carry = 0;
//        int sum = 0;
//        ListNode head = new ListNode(-1);
//        while (!s1.empty() || !s2.empty()) {
//            if (s1.empty()) sum = carry + s2.pop();
//            else if (s2.empty()) sum = carry + s1.pop();
//            else sum = carry + s1.pop() + s2.pop();
//            carry = sum / 10;
//            head.val = sum % 10;
//            ListNode res = new ListNode(carry);
//            res.next = head;
//            head = res;
//        }
//        return head.val == 0 ? head.next : head;
//    }

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return -1;
                else if (o1.length() == o2.length()) return 0;
                else return 1;
            }
        });
        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i]) == 1) {
                boolean isSub = true;
                for (int j = 0; j < i && isSub; j++) {
                    isSub = isSub && (!isSubSequence(strs[j], strs[i]));
                }
                if (isSub) {
                    return strs[i].length();
                }
            }
        }
        return -1;
    }

    private boolean isSubSequence(String s, String p) {
        if (s.equals(p)) return true;
        if (s.length() == p.length()) return false;
        int i = 0;
        for (int j = 0; j < s.length() && i < p.length(); j++) {
            if (s.charAt(j) == p.charAt(i)) {
                i++;
            }
        }
        return i == p.length();
    }

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        else return Math.max(a.length(), b.length());
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        int N = nums.length;
        int[] dp = new int[sum + 1];
        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[sum] == sum;
    }

    public int lastStoneWeightII(int[] stones) {
        int[] basket = new int[101];
        for (int i = 0; i < stones.length; i++) {
            if (basket[stones[i]] == 0)
                basket[stones[i]]++;
            else
                basket[stones[i]] = 0;
        }
        return 1;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = M > 0 ? obstacleGrid[0].length : 0;
        int[][] dp = new int[M + 1][N + 1];
        dp[1][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = obstacleGrid[i - 1][j - 1] == 0 ? (dp[i - 1][j] + dp[i][j - 1]) : 0;
            }
        }
        return dp[M][N];
    }

    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1, mid = begin;
        while (nums[begin] >= nums[end]) {
            if (end - begin == 1) {
                mid = end;
                break;
            }
            mid = (begin + end) >> 1;
            if (nums[begin] == nums[end] && nums[mid] == nums[begin]) {
                return MinOrder(nums, begin, end);
            }
            if (nums[mid] >= nums[begin]) begin = mid;
            else if (nums[mid] <= nums[end]) end = mid;
        }
        return nums[mid];
    }

    private int MinOrder(int[] nums, int begin, int end) {
        int result = nums[begin];
        for (begin = begin + 1; begin <= end; begin++) {
            result = Math.min(result, nums[begin]);
        }
        return result;
    }

    public boolean search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) >> 1;
            if (mid == begin) {
                if (nums[mid] == target) return true;
                if (nums[end] == target) return true;
                return false;
            }
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[begin]) begin++;
            else if (nums[mid] == nums[end]) end--;
            else if (nums[mid] > nums[begin]) {
                //左边有序
                if (target < nums[mid] && target >= nums[begin]) end = mid - 1;
                else begin = mid + 1;
            } else {
                //右边有序
                if (target <= nums[end] && target > nums[mid]) begin = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }

    public int search(int[] nums, int target, boolean isM) {
        int begin = 0, end = nums.length - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end) >> 1;
            if (mid == begin) {
                if (nums[mid] == target) return mid;
                if (nums[end] == target) return end;
                return -1;
            }
            if (nums[mid] == target) return mid;
            if (nums[mid] > nums[end]) {
                //说明左半边有序,判断是否在左半边
                if (target >= nums[begin] && target < nums[mid]) {
                    //说明在左半边
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                //说明右半边有序
                if (target <= nums[end] && target > nums[mid]) {
                    //说明在右半边
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int maximalSquare(char[][] matrix) {
        int M = matrix.length, N = M > 0 ? matrix[0].length : 0;
        int[][] dp = new int[M + 1][N + 1];
        int maxSquareLen = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxSquareLen = Math.max(dp[i][j], maxSquareLen);
                }
            }
        }
        return maxSquareLen;
    }

    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x : dp) ans += x;
        return (int) (ans % MOD);
    }

    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;//最小公倍数
        int M = L / A + L / B - 1;//小于等于最小公倍数的Magical数的数量
        int q = N / M, r = N % M;//N=M*q+r

        long ans = (long) q * L % MOD;
        if (r == 0)
            return (int) ans;

        int[] heads = new int[]{A, B};
        for (int i = 0; i < r - 1; ++i) {
            if (heads[0] <= heads[1])
                heads[0] += A;
            else
                heads[1] += B;
        }

        ans += Math.min(heads[0], heads[1]);
        return (int) (ans % MOD);
    }

    public int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int top = rectangles[0][2];
        int right = rectangles[0][3];
        int left = rectangles[0][1];
        int bottom = rectangles[0][0];
        HashSet<String> set = new HashSet<String>();
        int area = 0;
        for (int[] rectangle : rectangles) {
            top = Math.max(top, rectangle[2]);
            right = Math.max(right, rectangle[3]);
            left = Math.min(left, rectangle[1]);
            bottom = Math.min(bottom, rectangle[0]);
            String s1 = rectangle[0] + " " + rectangle[1];
            String s2 = rectangle[0] + " " + rectangle[3];
            String s3 = rectangle[2] + " " + rectangle[3];
            String s4 = rectangle[2] + " " + rectangle[1];
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);

        }
        if (!set.contains(bottom + " " + left) || !set.contains(bottom + " " + right) || !set.contains(top + " " + left) || !set.contains(top + " " + right) || set.size() != 4)
            return false;
        return area == (top - bottom) * (right - left);
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx > ty) tx %= ty;
            else ty %= tx;
        }
        return sx == tx && sy <= ty && (ty - sy) % sx == 0 ||
                sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }

    //dp(t, x1, x2) = grid(x1, t - x1)
    //                  + (x1 == x2 ? 0 : grid(x2, t - x2))
    //                  + max(dp(t-1, x1, x2), dp(t - 1, x1, x2 - 1), dp(t - 1, x1 - 1, x2), dp(t - 1, x1 - 1, x2 - 1))
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = grid[0][0];
        for (int k = 1; k < (n << 1) - 1; k++) {//从(0,0)-(n-1,n-1)需要移动的次数
            for (int i = Math.min(n - 1, k); i >= 0 && i >= k - n + 1; i--) {
                for (int j = Math.min(n - 1, k); j >= 0 && j >= k - n + 1; j--) {
                    int p = k - i, q = k - j;
                    //如果为-1则是不可达的
                    if (grid[i][p] == -1 || grid[j][q] == -1) {
                        dp[i][j] = -1;
                        continue;
                    }
                    if (p > 0 && j > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                    }
                    if (i > 0) {
                        if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                        if (q > 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    }
                    if (dp[i][j] == -1)
                        continue;
                    if (i == j) dp[i][j] += grid[i][p];
                    else dp[i][j] += grid[i][p] + grid[j][q];
                }
            }
        }
        return Math.max(dp[n - 1][n - 1], 0);
    }

    public int candy(int[] ratings) {
        int[] counts = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            counts[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1] && counts[i] <= counts[i - 1]) {
                counts[i] = counts[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && counts[i] <= counts[i + 1]) {
                counts[i] = counts[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int k : counts) {
            sum += k;
        }
        return sum;
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int len = popA.length;
        int x = 0, y = 0;
        while (y <= len && x < len) {
            if (stack.isEmpty() || stack.peek() != popA[x]) {
                if (y == len) return false;
                stack.add(pushA[y]);
                y++;
            } else {
                stack.pop();
                x++;
            }
        }
        return true;
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return HasSubtreeSub(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean HasSubtreeSub(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1.val == root2.val) {
            return HasSubtreeSub(root1.left, root2.left) && HasSubtreeSub(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = null;
        if (list1.val > list2.val) {
            head = list2;
            head.next = Merge(list1, list2.next);
        } else {
            head = list1;
            head.next = Merge(list1.next, list2);
        }
        return head;
    }

    public String canConcat(String s) {
        int len = s.length();
        int begin = s.length() / 2;
        boolean isFind = false;
        for (int i = begin; i >= 1; i--) {
            isFind = false;
            if (len % i == 0) {
                isFind = true;
                for (int j = 0; j < len / i - 1; j++) {
                    isFind = isFind && s.substring(j, j + i).equals(s.substring(j + i, j + 2 * i));
                }
            }
            if (isFind) {
                return s.substring(0, 0 + i);
            }
        }
        return "false";
    }

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        if (A.length() != B.length()) return -1;
        StringBuffer sbA = new StringBuffer();
        StringBuffer sbB = new StringBuffer();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) continue;
            sbA.append(A.charAt(i));
            sbB.append(B.charAt(i));
        }
        kSimilarity(sbA, sbB, 0);
        return kSimLen;
    }

    private static int kSimLen = -1;

    public void kSimilarity(StringBuffer A, StringBuffer B, int count) {
        //如果A[i]==B[j] && A[j]==B[i]，可以去除这两个点
        if (kSimLen != -1) return;
        int begin = 0, end = 0;
        boolean isFind = false;
        for (int i = 0; i < A.length() && !isFind; i++) {
            for (int j = i + 1; j < B.length() && !isFind; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    begin = i;
                    end = j;
                }
                if (A.charAt(i) == B.charAt(j) && A.charAt(j) == B.charAt(i)) {
                    isFind = true;
                    break;
                }
            }
        }
        if (isFind) {
            //去掉begin,end
            if (A.length() == 4 || A.length() == 2) {
                kSimLen = count + A.length() / 2;
                return;
            }
            A.deleteCharAt(begin);
            A.deleteCharAt(end - 1);
            B.deleteCharAt(begin);
            B.deleteCharAt(end - 1);
            kSimilarity(A, B, count + 1);
        } else {
            if (A.length() == 3) {
                kSimLen = count + 2;
                return;
            }
            A.replace(begin, begin + 1, A.charAt(end) + "");
            A.deleteCharAt(end);
            B.deleteCharAt(end);
            kSimilarity(A, B, count + 1);
        }
    }

    public String kSimilaritySwap(String A, int begin, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < A.length(); i++) {
            if (i == begin) {
                sb.append(A.charAt(end));
            } else if (i == end) {
                sb.append(A.charAt(begin));
            } else {
                sb.append(A.charAt(i));
            }
        }
        return sb.toString();

    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
        Arrays.sort(nums);
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            k = Math.max(nums[i + 1] - nums[i], k);
        }
        return k;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Integer> maxHead = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<int[]> build = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            build.add(new int[]{buildings[i][0], buildings[i][2]});//设置起点高度大于0
            build.add(new int[]{buildings[i][1], -buildings[i][2]});//设置终点高度小于0
        }
        Collections.sort(build, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {//x越小越靠前，高度越大越靠前
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];//如果起点和终点在同一个位置同一高度，这样起点会在终点前
            }
        });
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < build.size(); i++) {
            int[] b = build.get(i);
            if (b[1] > 0) {//如果高度大于0，起点
                maxHead.add(b[1]);//添加高度
                cur = maxHead.peek();//获取当前高度
            } else {//如果是终点
                maxHead.remove(-b[1]);//需要移除高度
                cur = (maxHead.peek() == null) ? 0 : maxHead.peek();//更新高度信息
            }
            if (cur != pre) {//如果当前高度不等于之前高度，则添加结果
                res.add(new int[]{b[0], cur});
                pre = cur;
            }
        }
        return res;
    }

    public double sqrt(double n) {
        double k = 1.0;
        while (Math.abs(k * k - n) > 1e-9) {
            k = (k + n / k) / 2;
        }
        return k;
    }

    //    public int maxPathSum(TreeNode root) {
//        //if(root!=null)
//    }
//    private int maxPathSum(TreeNode root,int sum){
//        if(root==null)return sum;
//        int current
//        int left=maxPathSum()
//        // return
//    }
    public boolean isFullNumber(int number) {
        int sum = 1;
        if (number <= 1) return false;
        int large = number >> 1;
        int k = 1;
        for (int i = 2; i < large; i++) {
            if (number % i == 0) {
                sum += i;
                if ((k = number / i) != i) {
                    sum += k;
                    large = k;
                }
            }
        }
        return sum == number;
    }

    public boolean canArrange(String[] arr) {
        boolean[] isVisited = new boolean[arr.length];
        canArrange(arr, isVisited, 0);
        return arrangeState;
    }

    private boolean arrangeState = false;

    private void canArrange(String[] arr, boolean[] isVisited, int index) {
        if (arrangeState) return;
        boolean isFinish = true;
        isVisited[index] = true;
        for (boolean visit : isVisited) isFinish = isFinish && visit;
        if (isFinish) {
            arrangeState = true;
            return;
        }
        char c = arr[index].charAt(arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            if (isVisited[i] || arr[i].charAt(0) != c) continue;
            canArrange(arr, isVisited, i);
        }
        isVisited[index] = false;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxSum = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            maxSum = Math.max(cur, maxSum);
        }
        return Math.max(cur, maxSum);
    }

    public int jump(int[] nums) {
        int ret = 0;//当前跳数
        int last = 0;//上一跳达到的最远距离
        int cur = 0;//当前能够达到的最远距离
        for (int i = 0; i < nums.length; i++) {
            if (i > cur) return -1;//达不到终点
            if (i > last) {//进行下一次跳跃
                last = cur;
                ret++;
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return ret;
    }

    public int lengthOfLastWord(String s) {
        boolean isHave = false;
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isHave) {
                if (s.charAt(i) == ' ') {
                    return len;
                } else {
                    len++;
                }
            } else {
                if (s.charAt(i) != ' ') {
                    isHave = true;
                    len = 1;
                }
            }
        }
        return len;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateMatrix(matrix, 1, 0, n, 0, n, 0);
        return matrix;
    }

    public void generateMatrix(int[][] matrix, int begin, int top, int bottom, int left, int right, int dir) {
        if (top == bottom || left == right) return;
        dir %= 4;
        if (dir == 0) {
            for (int i = left; i < right; i++) matrix[top][i] = begin++;
            top++;
        } else if (dir == 1) {
            for (int i = top; i < bottom; i++) matrix[i][right - 1] = begin++;
            right--;
        } else if (dir == 2) {
            for (int i = right - 1; i >= left; i--) matrix[bottom - 1][i] = begin++;
            bottom--;
        } else {
            for (int i = bottom - 1; i >= top; i--) matrix[i][left] = begin++;
            left++;
        }
        generateMatrix(matrix, begin, top, bottom, left, right, dir + 1);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        spiralOrder(matrix, result, 0, matrix.length, 0, matrix[0].length, 0);
        return result;
    }

    private void spiralOrder(int[][] matrix, List<Integer> result, int top, int bottom, int left, int right, int dir) {
        if (top == bottom || left == right) return;
        dir %= 4;
        if (dir == 0) {
            for (int i = left; i < right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
        } else if (dir == 1) {
            for (int i = top; i < bottom; i++) result.add(matrix[i][right - 1]);
            right--;
        } else if (dir == 2) {
            for (int i = right - 1; i >= left; i--) result.add(matrix[bottom - 1][i]);
            bottom--;
        } else {
            for (int i = bottom - 1; i >= top; i--) result.add(matrix[i][left]);
            left++;
        }
        spiralOrder(matrix, result, top, bottom, left, right, dir + 1);
    }

    public String getPermutation(int n, int k) {
        //计算n-1的阶乘
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        int nF = getFactorial(n);
        StringBuilder sb = new StringBuilder();
        getPermutation(n, k, nF, sb, numbers);
        return sb.toString();
    }

    public void getPermutation(int n, int k, int nF, StringBuilder sb, List<Integer> numbers) {
        if (numbers.size() == 0) return;
        if (n == 1) {
            sb.append(numbers.get(0));
            return;
        }
        nF = nF / n;
        int index = (k - 1) / nF;
        int nextK = k - index * nF;
        sb.append(numbers.get(index));
        numbers.remove(index);
        getPermutation(n - 1, nextK, nF, sb, numbers);
    }

    private int getFactorial(int n) {
        int nF = 1;
        while (n > 0) {
            nF *= n;
            n--;
        }
        return nF;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int len = 1;
        ListNode h = head;
        while (h.next != null) {
            h = h.next;
            len++;
        }
        h.next = head;
        int m = k % len;
        for (int i = 0; i < len - m; i++) {
            h = h.next;
        }
        head = h.next;
        h.next = null;
        return head;
    }

    public void recoverTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

    }

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;//前i天做第一笔交易买入剩下最多的钱
        int buy2 = Integer.MIN_VALUE;//前i天做第二笔交易买入股票后剩下最多的钱
        int sell1 = 0;//前i天做第一笔交易卖出股票剩下最多的钱
        int sell2 = 0;//
        for (int i = 0; i < prices.length; i++) {
            sell2 = Math.max(sell2, buy2 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy1 = Math.max(buy1, -prices[i]);
        }
        return sell2;
//        int m=prices.length;
//        if(m==0)return 0;
//        int curMin=prices[0];
//        int ret=0;
//        for(int i=0;i<m;i++){
//            curMin=Math.min(curMin,prices[i]);
//            ret=Math.max(ret,prices[i]-curMin);
//        }
//        return ret;
    }

    public int trap(int[] height) {
        if (height.length < 2) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            left[i] = Math.max(leftMax, height[i]);
            leftMax = left[i];
        }
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(rightMax, height[i]);
            rightMax = right[i];
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            sum += (Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }

    private boolean findSubstring(String s, Map<String, Integer> dict, int len) {
        Map<String, Integer> fullMap = new HashMap<>();
        for (Iterator<Map.Entry<String, Integer>> it = dict.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            fullMap.put(entry.getKey(), 0);
        }
        for (int i = 0; i < s.length(); i += len) {
            String cur = s.substring(i, i + len);
            if (dict.containsKey(cur)) {
                if (dict.get(cur) >= fullMap.get(cur) + 1) {
                    fullMap.put(cur, fullMap.get(cur) + 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        int len = 0;

        for (String word : words) {
            len = word.length();
            if (dict.containsKey(word)) {
                dict.put(word, dict.get(word) + 1);
            } else
                dict.put(word, 1);
        }
        int strLen = len * words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= s.length() - strLen; j += len) {
                if (findSubstring(s.substring(j, j + strLen), dict, len)) {
                    result.add(j);
                }
            }
        }
//        Map<String,Integer> fullMap=new HashMap<>();
//
//        int beginIndex=0;
//        for(int i=0;i<len;i++){
//            beginIndex=i;
//            for(int j=i;j<s.length();j+=len){
//                String cur=s.substring(j,Math.min(j+len,s.length()));
//                if(cur.length()==len){
//                    if(dict.containsKey(cur)){
//                        if(fullMap.size()==0){
//                            beginIndex=j;
//                        }
//                        if(fullMap.containsKey(cur)){
//                            //更新map
//                            int curId=fullMap.get(cur);
//                            for(Iterator<Map.Entry<String,Integer>> it=fullMap.entrySet().iterator();it.hasNext();){
//                                Map.Entry<String,Integer> entry=it.next();
//                                int value=entry.getValue();
//                                if(value<=curId){
//                                    it.remove();
//                                }
//                            }
//                            //应该更新起始值
//                            beginIndex=curId+len;
//                        }
//                        fullMap.put(cur,j);
//                        if(fullMap.size()==dict.size()){
//                            result.add(beginIndex);
//                            for(Iterator<Map.Entry<String,Integer>> it=fullMap.entrySet().iterator();it.hasNext();){
//                                Map.Entry<String,Integer> entry=it.next();
//                                int value=entry.getValue();
//                                if(value==beginIndex){
//                                    it.remove();
//                                    break;
//                                }
//                            }
//                            beginIndex=beginIndex+len;
//                            //fullMap.clear();
//                            //移除第一个
//                        }
//                    }else{
//                        fullMap.clear();
//                    }
//                }
//            }
//        }
        Collections.sort(result);
        return result;
    }


    public int removeElement(int[] nums, int val) {
        if (nums.length < 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 0) return 0;
        if (nums.length == 1) return 1;
        int first = 0, second = 1;
        while (second < nums.length) {
            if (nums[first] == nums[second]) {
                second++;
            } else {
                nums[first + 1] = nums[second];
                first++;
                second++;
            }
        }
        return first + 1;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(-1);
        ListNode pHead = first;
        first.next = head;
        ListNode second = head;
        while (second != null && second.next != null) {
            first.next = second.next;
            second.next = first.next.next;
            first.next.next = second;
            first = second;
            second = second.next;
        }
        return pHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];
        int mid = (start + end) / 2;
        return mergeTwoLists(mergeLists(lists, start, mid), mergeLists(lists, mid + 1, end));
    }

    private ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p1 == null) return p2;
        if (p2 == null) return p1;
        ListNode pHead = null;
        if (p1.val < p2.val) {
            pHead = p1;
            pHead.next = mergeTwoLists(p1.next, p2);
        } else {
            pHead = p2;
            pHead.next = mergeTwoLists(p1, p2.next);
        }
        return pHead;
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrace("", result, n, n);
        return result;
    }

    public void backTrace(String sub, List<String> result, int left, int right) {
        if (left == right && left == 0) {
            result.add(sub);
        }
        if (left > right)
            return;
        if (left > 0)
            backTrace(sub + "(", result, left - 1, right);
        if (right > 0)
            backTrace(sub + ")", result, left, right - 1);
    }

    public boolean isValid(String s) {
        if (s == "") return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            System.out.println(c);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if (c == ')' && t != '(') return false;
                if (c == '}' && t != '{') return false;
                if (c == ']' && t != '[') return false;

            }
        }
        return stack.isEmpty();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        while (n > 0 && first.next != null) {
            first = first.next;
            n--;
        }
        if (n == 0) {
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
        } else if (n == 1) {
            return head.next;
        }
        return head;
    }

    public List<String> letterCombinations(String digits) {
        char[][] dict = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            result.add("");
            return result;
        }
        for (char c : digits.toCharArray()) {
            int size = result.size();
            int index = c - '2';
            if (index < 0) return result;
            if (size == 0) {
                for (int i = 0; i < dict[index].length; i++) {
                    result.add(dict[index][i] + "");
                }
            } else {
                for (int i = 0; i < size; i++) {
                    String current = result.remove(0);
                    for (int j = 0; j < dict[index].length; j++) {
                        result.add(current + dict[index][j]);
                    }
                }
            }
        }
        return result;
    }

    //    public List<List<Integer>> fourSum(int[] nums, int target) {
//
//    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && (i < nums.length - 2) && nums[i] == nums[i - 1])
                i++;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                int tempDiff = Math.abs(target - tempSum);
                if (tempDiff < diff) {
                    closestSum = tempSum;
                    diff = tempDiff;
                }
                if (tempSum < target) left++;
                else if (tempSum > target) right--;
                else
                    return tempSum;
            }
        }
        return closestSum;
    }

    public List<List<Integer>> threeSum(int[] nums, int sum, int beign, int end) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = beign; i < end - 2; i++) {
            while (i > beign && (i < end - 2) && nums[i] == nums[i - 1])
                i++;
            //if(nums[i]>sum)break;
            int target = sum - nums[i];
            //choose second and third number
            int left = i + 1;
            int right = end - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }

            }
        }
        return results;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            List<List<Integer>> results = new ArrayList<>();
            return results;
        }
        Arrays.sort(nums);
        return threeSum(nums, 0, 0, nums.length);

    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public int myAtoi(String str) {
        boolean isFind = false;
        boolean isNegative = false;
        long result = 0;
        for (char c : str.toCharArray()) {
            if (!isFind) {
                if (c == '-') {
                    isFind = true;
                    isNegative = true;
                } else if (c == '+') {
                    isFind = true;
                    isNegative = false;
                } else if (c <= '9' && c >= '0') {
                    isFind = true;
                    result += (c - '0');
                } else if (c == ' ') {

                } else {
                    return 0;
                }
            } else {
                if (c <= '9' && c >= '0') {
                    result = result * 10 + (c - '0');
                    if (result > Integer.MAX_VALUE) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else return (int) result * (isNegative ? -1 : 1);
            }
        }
        return (int) result * (isNegative ? -1 : 1);
    }

    public String convert(String s, int nRows) {
        char[] charSet = s.toCharArray();
        if (nRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < nRows; row++) {
            int current = row;
            for (; current - 2 * row < charSet.length; ) {
                if (row != 0 && row != nRows - 1 && current - 2 * row > 0)
                    stringBuilder.append(charSet[current - 2 * row]);
                if (current < charSet.length) stringBuilder.append(charSet[current]);
                current += 2 * nRows - 2;
            }
        }

        return stringBuilder.toString();
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int[][] dp = new int[s.length()][s.length()];
        int maxLen = 0, begin = 0, end = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    if (j - i > maxLen) {
                        begin = i;
                        end = j;
                        maxLen = j - i;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
//        StringBuilder sb=new StringBuilder();
//        for(char c:s.toCharArray()){
//            sb.append("#");
//            sb.append(c);
//        }
//        sb.append("#");
//        String T=sb.toString();
//        int length=T.length();
//        int[] p=new int[length];
//        int C=0,R=0;
//        for(int i=0;i<length;i++){
//            int i_mirror=C-(i-C);
//            int diff=R-i;
//            if(diff>=0){
//                if(p[i_mirror]<diff)p[i]=p[i_mirror];
//                else{
//                    p[i]=diff;
//                    while (T.charAt(i+p[i]+1)==T.charAt(i-p[i]-1)){
//                        p[i]++;
//                    }
//                    C=i;
//                    R=i+p[i];
//                }
//            }
//        }

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int currentLen = 0;
        int maxLen = 0;
        int[] position = new int[255];
        for (int i = 0; i < 255; i++) position[i] = -1;
        for (int i = 0; i < s.length(); i++) {
            int prevIndex = position[s.charAt(i)];
            if (prevIndex < 0 || i - prevIndex > currentLen) {
                currentLen++;
            } else {
                if (currentLen > maxLen) maxLen = currentLen;
                currentLen = i - prevIndex;
            }
            position[s.charAt(i)] = i;
        }
        return Math.max(currentLen, maxLen);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (sum == root.val)
                return true;
            else
                return false;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    List<List<Integer>> results = new ArrayList<List<Integer>>();

    private void find(List<Integer> path, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(path);
            temp.add(root.val);
            results.add(temp);
            return;
        }
        path.add(root.val);
        find(path, root.left, sum - root.val);
        find(path, root.right, sum - root.val);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        find(new ArrayList<>(), root, sum);
        return results;
    }

    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int[] cut = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            cut[i] = Integer.MAX_VALUE;//第i个字符到最后一个字符所构成的子串的最小分割次数
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    cut[i] = Math.min(1 + cut[j + 1], cut[i]);
                }
            }
        }
        return cut[0] - 1;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }

        Set<String> wordSet = new HashSet<>();
        int maxLen = 0;
        //去重以及获取字符串的最大长度
        for (String word : wordDict) {
            wordSet.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        Map<Integer, List<String>> memo = new HashMap<>();
        List<String> res = helper(s, wordSet, memo, 0, maxLen);
        return res;
    }

    private List<String> helper(String s, Set<String> wordSet, Map<Integer, List<String>> memo, int startIdx, int maxLen) {

        if (memo.containsKey(startIdx)) {
            return memo.get(startIdx);
        }

        List<String> result = new ArrayList<>();
        //字串长度小于最大长度
        for (int i = startIdx; i < s.length() && i + 1 - startIdx <= maxLen; i++) {
            String pref = s.substring(startIdx, i + 1);//获取字串
            if (wordSet.contains(pref)) {//字串在字典中
                if (i == s.length() - 1) {
                    result.add(pref);//如果当前index到了字符串的最后，则可以直接退出
                    return result;
                }
                List<String> tmp = helper(s, wordSet, memo, i + 1, maxLen);
                for (String suff : tmp) {
                    result.add(pref + " " + suff);
                }
            }
        }
        memo.put(startIdx, result);
        return result;
    }

    //    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> result=new ArrayList<>();
//        int n=s.length();
//        List<Integer>[] pointer=new List[n];
//        for(int i=0;i<n;i++)pointer[i]=new ArrayList<Integer>();
//        for(int i=0;i<n;i++){
//            for(int j=0;j<=i;j++){
//                if(wordDict.contains(s.substring(j,i+1))&&(j==0||pointer[j-1].size()>0))
//                    pointer[i].add(j);
//            }
//        }
//        helper(pointer,s,n-1,"",result);
//        System.out.println();
//        return result;
//    }
//    public void helper(List<Integer>[] pointer,String s,int i,String pattern,List<String> result){
//        if(i<0){
//            result.add(pattern);
//            return;
//        }
//        for(Integer item:pointer[i]){
//            String nextPattern=pattern.length()==0?s.substring(item,i+1):s.substring(item,i+1)+" "+pattern;
//            helper(pointer,s,item-1,nextPattern,result);
//        }
//    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        preorderTraversal(root, preOrder);
        return preOrder;
    }

    public void preorderTraversal(TreeNode root, List<Integer> preOrder) {
        if (root != null) {
            preOrder.add(root.val);
            preorderTraversal(root.left, preOrder);
            preorderTraversal(root.right, preOrder);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        postorderTraversal(root, postOrder);
        return postOrder;
    }

    public void postorderTraversal(TreeNode root, List<Integer> postOrder) {
        if (root != null) {
            postorderTraversal(root.left, postOrder);
            postorderTraversal(root.right, postOrder);
            postOrder.add(root.val);

        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        int minIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            minIndex = strs[i].length() < strs[minIndex].length() ? i : minIndex;
        }
        String prefix = strs[minIndex];
        int lastIndex = 0;
        for (int i = 0; i < prefix.length(); i++) {
            char t = prefix.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != t) {
                    return lastIndex == 0 ? "" : prefix.substring(0, lastIndex);
                }
            }
            lastIndex++;
        }
        return prefix;
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[][] roman = new String[][]{{"X", "V", "I"}, {"C", "L", "X"}, {"M", "D", "C"}, {"M", "M", "M"}};
        int count = 0;
        int digital = 0;
        while (num != 0) {
            digital = num % 10;
            num = num / 10;
            if (digital <= 3) {
                for (int i = 0; i < digital; i++) {
                    sb.append(roman[count][2]);
                }
            } else if (digital == 4) {
                sb.append(roman[count][1]);
                sb.append(roman[count][2]);
            } else if (digital < 9) {
                for (int i = 0; i < digital - 5; i++) {
                    sb.append(roman[count][2]);
                }
                sb.append(roman[count][1]);
            } else {
                sb.append(roman[count][0]);
                sb.append(roman[count][2]);
            }
            count++;
        }
        return sb.reverse().toString();
    }

    //Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, nums2, 0, n - 1, 0, m - 1, left) + getKth(nums1, nums2, 0, n - 1, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2, nums1, start2, end2, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, nums2, start1, end1, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, nums2, i + 1, end1, start2, end2, k - (i - start1 + 1));
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        sum = l1.val + l2.val;
        ListNode first = new ListNode(sum % 10);
        ListNode second = first;
        carry = sum / 10;
        while (l1.next != null && l2.next != null) {
            sum = carry + l1.next.val + l2.next.val;
            second.next = new ListNode(sum % 10);
            carry = sum / 10;
            second = second.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1.next != null) {
            sum = carry + l1.next.val;
            second.next = new ListNode(sum % 10);
            carry = sum / 10;
            second = second.next;
            l1 = l1.next;
        }
        while (l2.next != null) {
            sum = carry + l2.next.val;
            second.next = new ListNode(sum % 10);
            carry = sum / 10;
            second = second.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            second.next = new ListNode(carry);
        }
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getTreeHeight(root) != -1;
    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return 1 + Math.max(leftHeight, rightHeight);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<>();
        if (root == null) return output;
        if (root.left == null && root.right == null) {
            output.add(root.val + "");
            return output;
        }
        binaryTreePaths(root.left, root.val + "", output);
        binaryTreePaths(root.right, root.val + "", output);
        return output;
    }

    public void binaryTreePaths(TreeNode root, String before, List<String> output) {
        if (root == null) return;
        String after = before + "->" + root.val;
        if (root.left == null && root.right == null) {
            output.add(after);
        } else {
            binaryTreePaths(root.left, after, output);
            binaryTreePaths(root.right, after, output);
        }
    }

    public void PrintToMaxOfNDigits(int n) {
        if (n <= 0) return;
        int[] numbers = new int[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = i;
            PrintToMaxOfNDigits(numbers, 1);
        }
    }

    public void PrintToMaxOfNDigits(int[] numbers, int index) {
        if (index == numbers.length) {
            printNumbers(numbers);
        } else {
            for (int i = 0; i < 10; i++) {
                numbers[index] = i;
                PrintToMaxOfNDigits(numbers, index + 1);
            }
        }
    }

    public void printNumbers(int[] numbers) {
        boolean isFirst = false;
        for (int number : numbers) {
            if (!isFirst && number != 0) {
                isFirst = true;
            }
            if (isFirst) {
                System.out.print(number);
            }
        }
        if (isFirst)
            System.out.println();
    }

    //Given an array of integers nums, write a method that returns the "pivot" index of this array.
    //
    //We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
    //
    //If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
    public int pivotIndex(int[] nums) {
        if (nums.length <= 0) return -1;
        int first = 0, last = nums.length - 1;
        int leftSum = nums[first], rightSum = nums[last];
        while (first < last) {
            if (leftSum <= rightSum) {
                leftSum += nums[++first];
            } else {
                rightSum += nums[--last];
            }
        }
        if (leftSum == rightSum)
            return first;
        else
            return -1;
    }

    //Given two strings representing two complex numbers.
    //
    //You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
    public String complexNumberMultiply(String a, String b) {
        String[] as = a.split("\\+");
        String[] bs = b.split("\\+");
        int A = Integer.parseInt(as[0]);
        int B = Integer.parseInt(as[1].split("i")[0]);
        int C = Integer.parseInt(bs[0]);
        int D = Integer.parseInt(bs[1].split("i")[0]);
        return (A * C - B * D) + "+" + (A * D + B * C) + "i";
        //return as[0];
    }

    //Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
    public int[] countBits(int num) {
        int[] output = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            output[i] = output[i >> 1] + (i & 1);
        }
        return output;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
    //
    //Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
    //
    //(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
    public TreeNode pruneTree(TreeNode root) {
        sum(root);
        remove(root);
        return root;
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        node.val = node.val + 2 * sum(node.left) + 2 * sum(node.right);
        return node.val;
    }

    private TreeNode remove(TreeNode node) {
        if (node == null) return null;
        if (node.val == 0) return null;
        node.val = node.val % 2;
        node.right = remove(node.right);
        node.left = remove(node.left);
        return node;
    }

    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int counts = 0;
        int deltaBefore = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i > 0) {
                    if (nums[i - 1] > nums[i + 1])
                        return false;
                }
                counts++;
                if (counts >= 2)
                    return false;
            }
        }
        return true;
    }

    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        int result = Math.abs(x);
        long output = 0;
        while (result != 0) {
            output = output * 10 + result % 10;
            result /= 10;
        }
        if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE) return 0;
        return x > 0 ? (int) output : (int) (-output);
    }
}
