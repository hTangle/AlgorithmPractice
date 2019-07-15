package com.nevergetme.algorithmCompetition.second;

import java.util.*;

public class Sword {
    public static void main(String[] args) {
        Sword sword = new Sword();
        System.out.println(sword.printMatrix(new int[][]{{1}, {2}, {3}, {4}, {5}}));
//        ListNode l1=new ListNode(1);
//        ListNode l2=new ListNode(2);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(4);
//        ListNode l5=new ListNode(5);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        ListNode root=sword.ReverseList(l1);
//        System.out.println();
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        if (root != null)
            queue.offer(root);
        while (queue.size()!=0){
            TreeNode p=queue.poll();
            if(p!=null){
                results.add(p.val);
                if(p.left!=null)queue.offer(p.left);
                if(p.right!=null)queue.offer(p.right);
            }
        }
//        PrintFromTopToBottom(root, results, queue);
        return results;
    }

//    private void PrintFromTopToBottom(TreeNode root, ArrayList<Integer> results, Queue<TreeNode> queue) {
//        if(queue!=null){
//            TreeNode
//        }
//    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int indexPush = 0, indexPop = 0;
        Stack<Integer> stack = new Stack<>();
        while (indexPop < popA.length) {
            while (stack.isEmpty() || stack.peek() != popA[indexPop]) {
                if (indexPush >= pushA.length) {
                    return false;
                }
                stack.push(pushA[indexPush++]);
            }
            if (stack.peek() != popA[indexPop]) return false;
            stack.pop();
            indexPop++;
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) return null;
        ArrayList<Integer> results = new ArrayList<>();
        int m = matrix.length;
        int n = matrix.length > 0 ? matrix[0].length : 0;
        int begin = 0;
        while (begin << 1 < m && begin << 1 < n) {
            printMatrix(matrix, m, n, begin, results);
            begin++;
        }
        return results;
    }

    private void printMatrix(int[][] matrix, int m, int n, int begin, ArrayList<Integer> results) {
        int endX = n - begin;
        int endY = m - begin;
        //横向
        for (int i = begin; i < endX; i++) {
            results.add(matrix[begin][i]);
        }
        //纵向
        if (begin < endY - 1)
            for (int i = begin + 1; i < endY; i++)
                results.add(matrix[i][endX - 1]);

        //反向横向
        if (begin < endY - 1 && begin < endX - 1)
            for (int i = endX - 2; i >= begin; i--)
                results.add(matrix[endY - 1][i]);

        //反向纵向
        if (begin < endX - 1 && begin < endY - 1)
            for (int i = endY - 2; i >= begin + 1; i--)
                results.add(matrix[i][begin]);

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
        return HasSubTreeSub(root1, root2) || HasSubTreeSub(root1.left, root2) || HasSubTreeSub(root1.right, root2);
    }

    private boolean HasSubTreeSub(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null && root2 == null) return false;
        if (root1.val == root2.val)
            return HasSubTreeSub(root1.left, root2.left) && HasSubTreeSub(root1.right, root2.right);
        else
            return false;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode root = null;
        if (list1.val > list2.val) {
            root = list2;
            root.next = Merge(list1, list2.next);
        } else {
            root = list1;
            root.next = Merge(list1.next, list2);
        }
        return root;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            ListNode t = head.next;
            t.next = head;
            t.next.next = null;
            return t;
        }
        ListNode pre = null, cur = head, next = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur == null) break;
            next = next.next;
        }
        return pre;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode first = head;
        while (k > 1 && first != null) {
            first = first.next;
            k--;
        }
        if (first == null) return null;
        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public double Power(double base, int exponent) {
        double cur = base, res = 1;
        int exp;
        if (exponent > 0) exp = exponent;
        else if (exponent < 0) exp = -exponent;
        else return 1;
        while (exp != 0) {
            if (exp % 2 == 1) res *= cur;
            cur *= cur;
            exp = exp >> 1;
        }
        return exponent > 0 ? res : (1 / res);
    }

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int JumpFloor(int target) {
        if (target < 3) return target;
        int f1 = 1, f2 = 2;
        while (target-- > 2) {
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        return f2;
    }

    public int Fibonacci(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        while (n-- > 1) {
            second += first;
            first = second - first;
        }
        return second;
    }

    public int minNumberInRotateArray(int[] array) {
        int begin = 0, end = array.length - 1;
        while (array[begin] >= array[end]) {
            if (end - begin == 1) break;
            int mid = (begin + end) >> 1;
            if (array[begin] == array[mid] && array[end] == array[end]) {
                minNumberInRotateArray(array, begin, end);
            }
            if (array[mid] >= array[begin]) {
                begin = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }
        }
        return array[end];
    }

    private int minNumberInRotateArray(int[] array, int begin, int end) {
        int result = array[begin];
        for (int i = begin + 1; i <= end; i++) {
            result = Math.min(array[i], result);
        }
        return result;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int pBegin, int pEnd, int iBegin, int iEnd) {
        if (pBegin > pEnd || iBegin > iEnd) return null;
        if (pBegin == pEnd) return new TreeNode(pre[pBegin]);
        int target = pre[pBegin];
        int targetIndex = -1;
        for (int i = iBegin; i <= iEnd; i++) {
            if (in[i] == target) {
                targetIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(pre[pBegin]);
        root.left = reConstructBinaryTree(pre, in, pBegin + 1, targetIndex - iBegin + pBegin, iBegin, targetIndex - 1);
        root.right = reConstructBinaryTree(pre, in, targetIndex - iBegin + pBegin + 1, pEnd, targetIndex + 1, iEnd);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);
        return result;
    }

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public boolean Find(int target, int[][] array) {
        int m = 0, n = array.length > 0 ? array[0].length - 1 : 0;
        while (m < array.length && n >= 0) {
            if (array[m][n] == target) {
                return true;
            } else if (array[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
