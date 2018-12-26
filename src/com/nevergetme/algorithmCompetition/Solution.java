package com.nevergetme.algorithmCompetition;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().complexNumberMultiply("1+-1i","1+-1i"));
    }
    //Given two strings representing two complex numbers.
    //
    //You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
    public String complexNumberMultiply(String a, String b) {
        String[] as=a.split("\\+");
        String[] bs=b.split("\\+");
        int A=Integer.parseInt(as[0]);
        int B=Integer.parseInt(as[1].split("i")[0]);
        int C=Integer.parseInt(bs[0]);
        int D=Integer.parseInt(bs[1].split("i")[0]);
        return (A*C-B*D)+"+"+(A*D+B*C)+"i";
        //return as[0];
    }
    //Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
    public int[] countBits(int num) {
        int[] output=new int[num+1];
        for(int i=1;i<=num;i++){
            output[i]=output[i>>1]+(i&1);
        }
        return output;
    }
    public class TreeNode {
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
