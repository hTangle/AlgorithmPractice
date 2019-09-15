package com.nevergetme.codeText.zsyh;

import java.util.*;

public class Main {
    static class Node {
        int val;
        int dp = 0;
        List<Node> son = new ArrayList<>();

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public boolean isEmpty() {
            return son.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer, Node> map = new TreeMap<>();
        map.put(1, new Node(0));
        for (int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            if (!map.containsKey(v)) {
                map.put(v, new Node(c));
            }
            if (!map.containsKey(u)) {
                map.put(u, new Node());
            }
            map.get(u).son.add(map.get(v));
        }
        helper(map);
        for(Node e:map.values()){
            System.out.print(e.dp+" ");
        }
        System.out.println();
    }

    public static void helper(TreeMap<Integer, Node> map) {
        helper(map, map.get(1));
    }

    public static void helper(TreeMap<Integer, Node> map, Node root) {
        if (root.isEmpty()) {
            //叶子节点
            root.dp=0;
            return;
        }

        for(Node n:root.son){
            helper(map,n);
            root.dp=Math.max(root.dp,n.dp+n.val);
        }
    }
}
//5
//        1 2 -3
//        1 3 2
//        2 4 6
//        2 5 -3
