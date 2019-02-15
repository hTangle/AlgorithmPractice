package com.nevergetme.algorithmCompetition;

import java.util.ArrayList;
import java.util.List;

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
        Solution solution=new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        //new Solution().PrintToMaxOfNDigits(2);
    }
    //Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right){
            maxArea=Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right])left++;
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
