package com.nevergetme.autumn.tencent.solution11;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.put(y, map.getOrDefault(y, 0) + x);
        }
        int ax = 0, ay = 0, bx = 0, by = 0;
        int maxSum = Integer.MIN_VALUE;
        while (!map.isEmpty()) {
            if (ax == 0) {
                ay = map.firstKey();
                ax = map.get(map.firstKey());
                map.remove(ay);
            }
            if(map.isEmpty()){
                maxSum = Math.max(maxSum, ay + ay);
                break;
            }
            if (bx == 0) {
                by = map.lastKey();
                bx = map.get(map.lastKey());
                map.remove(by);
            }
            if (ax > bx) {
                ax -= bx;
                bx = 0;
            } else {
                bx -= ax;
                ax = 0;
            }
            maxSum = Math.max(maxSum, ay + by);
        }
        System.out.println(maxSum);
    }
}
