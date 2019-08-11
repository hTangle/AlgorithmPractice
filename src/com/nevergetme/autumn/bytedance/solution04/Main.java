package com.nevergetme.autumn.bytedance.solution04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class TreeNode {
        int val;
        List<TreeNode> nodes = new ArrayList<>();

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeNode root = null;
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (!map.containsKey(u)) {
                TreeNode t = new TreeNode(u);
                if (root == null) root = t;
                map.put(u, t);
            }
            if (!map.containsKey(v)) {
                TreeNode t1 = new TreeNode(v);
                map.put(v, t1);
            }
            map.get(u).nodes.add(map.get(v));
        }
        int[] len=getLength(root);
        System.out.println();

    }

    public static int[] getLength(TreeNode root) {
        int[] len = new int[3];
        for (TreeNode r : root.nodes) {
            int[] temp = getLength(r);
            len[1] += temp[0] % 10000007;
            len[2] += temp[1] % 10000007;
            len[0] += temp[2] % 10000007;
        }
        return len;

    }
}
