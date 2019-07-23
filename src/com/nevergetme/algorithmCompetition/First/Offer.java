package com.nevergetme.algorithmCompetition.First;

import java.util.ArrayList;


/**
 * Create by Alden He on 2019/6/25
 */
public class Offer {
    public static void main(String[] args) {
//        TreeNode root = new Offer().reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        System.out.println(new Offer().canPartition(new int[]{1, 5, 11, 5}));
    }

    //    public int minNumberInRotateArray(int [] array) {
//        int begin=0,end=array.length-1;
//        while (begin<=end){
//            int mid=(begin+end)>>1;
//            if(array[begin]<array[mid]){
//                begin=mid+1;
//            }else if()
//        }
//    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int z : nums) sum += z;
        if (sum % k != 0) return false;
        boolean[] isVisited=new boolean[nums.length];
        return canPartitionKSubsets(nums,k,sum/k,0,0,isVisited);
    }
    public boolean canPartitionKSubsets(int[] nums,int k,int target,int start,int curSum,boolean[] isVisited){
        if(k==1)return true;
        if(curSum==target)return canPartitionKSubsets(nums,k-1,target,0,0,isVisited);
        if(curSum>target)return false;
        for(int i=start;i<nums.length;i++){
            if(isVisited[i])continue;
            isVisited[i]=true;
            if(canPartitionKSubsets(nums,k,target,i+1,curSum+nums[i],isVisited))return true;
            isVisited[i]=false;
        }
        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int k : nums) sum += k;
        if (sum % 2 == 1) return false;
        sum = sum >> 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) pNode = pNode.left;
            return pNode;
        } else {
            while (pNode.next != null) {
                //如果为父节点的左节点，则下一个节点为父节点
                if (pNode.next.left == pNode) {
                    return pNode.next;
                }
                pNode = pNode.next;
            }
            return pNode.next;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //首先取pre的第一个节点，然后找到第一个节点在in中的位置，然后切分即可
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int preBegin, int preEnd, int inBegin, int inEnd) {
        TreeNode root = new TreeNode(pre[preBegin]);
        int rootIndex = -1;
        for (int i = inBegin; i <= inEnd; i++) {
            if (in[i] == pre[preBegin]) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex > inBegin) {
            root.left = reConstructBinaryTree(pre, in, preBegin + 1, rootIndex - inBegin + preBegin, inBegin, rootIndex - 1);
        }
        if (rootIndex < inEnd) {
            root.right = reConstructBinaryTree(pre, in, rootIndex - inBegin + preBegin + 1, preEnd, rootIndex + 1, inEnd);
        }
        return root;
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        int begin = 1, end = length - 1;
        while (end >= begin) {
            int mid = (begin + end) >> 1;
            int count = 0;
            for (int k : numbers) {
                if (k <= mid && k >= begin) {
                    count++;
                }
            }
            if (end == begin) {
                if (count > 1) {
                    duplication[0] = begin;
                    return true;
                } else {
                    return false;
                }
            }
            if (count > (mid - begin + 1)) end = mid;
            else begin = mid + 1;
        }
        return false;
//        for(int i=0;i<length;i++){
//            if(numbers[i]!=i){
//                if(numbers[numbers[i]]==numbers[i]){
//                    duplication[0]=numbers[i];
//                    return true;
//                }else{
//                    int temp=numbers[numbers[i]];
//                    numbers[numbers[i]]=numbers[i];
//                    numbers[i]=temp;
//                }
//            }
//        }
//        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
