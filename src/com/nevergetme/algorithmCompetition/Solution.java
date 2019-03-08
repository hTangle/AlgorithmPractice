package com.nevergetme.algorithmCompetition;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) {
//        TreeNode t1=new TreeNode(1);
//        TreeNode t2=new TreeNode(2);;
//        TreeNode t3=new TreeNode(5);
//        TreeNode t4=new TreeNode(3);
//        t1.left=t2;
//        t2.right=t3;
//        t1.right=t4;
//        System.out.println(new Solution().binaryTreePaths(t1));
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(5);
//
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(3);
//        l1.next = l3;
//        l3.next = l4;
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(4);
//        l2.next = l5;
//        l5.next = l6;
//        ListNode output = new Solution().addTwoNumbers(l1, l2);
//        System.out.println();
        Solution solution = new Solution();
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
//        List<List<Integer>> lists=new ArrayList<>();
//        List<Integer> list1=new ArrayList<>();
//        list1.add(1);
//        List<Integer> list2=new ArrayList<>();
//        list1.add(1);

        System.out.println(solution.longestPalindrome("cbbd"));

        //System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        //new Solution().PrintToMaxOfNDigits(2);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {

    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff  =Integer.MAX_VALUE;
        int closestSum = 0;
        for(int i=0;i<nums.length-2;i++){
            while (i>0&&(i<nums.length-2)&&nums[i]==nums[i-1])
                i++;
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int tempSum=nums[i]+nums[left]+nums[right];
                int tempDiff=Math.abs(target-tempSum);
                if(tempDiff<diff){
                    closestSum=tempSum;
                    diff=tempDiff;
                }
                if(tempSum<target)left++;
                else if(tempSum>target)right--;
                else
                    return tempSum;
            }
        }
        return closestSum;
    }
    public List<List<Integer>> threeSum(int[] nums,int sum,int beign,int end){
        List<List<Integer>> results=new ArrayList<>();
        for(int i=beign;i<end-2;i++){
            while (i>beign&&(i<end-2)&&nums[i]==nums[i-1])
                i++;
            //if(nums[i]>sum)break;
            int target=sum-nums[i];
            //choose second and third number
            int left=i+1;
            int right=end-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    List<Integer> result=new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    left++;
                    right--;
                    while(left<right&&nums[left]==nums[left-1])left++;
                    while (left<right&&nums[right]==nums[right+1])right--;
                }else if(nums[left]+nums[right]<target){
                    left++;
                    while(left<right&&nums[left]==nums[left-1])left++;
                }else{
                    right--;
                    while (left<right&&nums[right]==nums[right+1])right--;
                }

            }
        }
        return results;
    }
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums.length<3){
            List<List<Integer>> results=new ArrayList<>();
            return results;
        }
        Arrays.sort(nums);
        return threeSum(nums,0,0,nums.length);

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
