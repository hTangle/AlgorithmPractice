package com.nevergetme.autumn.tencent.solution12;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T << 1];
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                int k = sc.nextInt();
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            helper(map, result, i << 1);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(result[i << 1] + " " + result[(i << 1) + 1]);
        }
    }

    public static void helper(TreeMap<Integer, Integer> map, int[] result, int index) {
        int a = 0, b = 0;
        int first = 0, last = 0;
        int firstVal = 0, lastVal = 0;
        while (!map.isEmpty()) {
            int curVal=map.firstKey();
            int cur=map.get(curVal);
            if(cur%2==0){
                a+=(curVal*(cur>>1));
                b+=(cur>>1)*curVal;
            }else{

            }
            if (first == 0) {
                firstVal = map.firstKey();
                first = map.get(firstVal);
                map.remove(firstVal);
            }
            if (map.isEmpty()) {
                if (first % 2 == 0) {
                    a += (first >> 1) * firstVal;
                    b += (first >> 1) * firstVal;
                } else {
                    if (a < b) {
                        a += (first >> 1 + 1) * firstVal;
                        b += (first >> 1) * firstVal;
                    } else {
                        b += (first >> 1 + 1) * firstVal;
                        a += (first >> 1) * firstVal;
                    }
                }
                break;
            }
            if (last == 0) {
                lastVal = map.firstKey();
                last = map.get(lastVal);
                map.remove(lastVal);
            }
            //去最小值，然后取一半
            int addSum = 0;
            if (first > last) {
                addSum = getSum(first, last, firstVal, lastVal);
                if (last % 2 != 0) {
                    if (a < b) {
                        a += Math.max(firstVal, lastVal);
                        b += Math.min(firstVal, lastVal);
                    } else {
                        b += Math.max(firstVal, lastVal);
                        a += Math.min(firstVal, lastVal);
                    }
                }
                first -= last;
                last = 0;
            } else {
                addSum = getSum(last, first, lastVal, firstVal);
                if (first % 2 != 0) {
                    if (a < b) {
                        a += Math.max(firstVal, lastVal);
                        b += Math.min(firstVal, lastVal);
                    } else {
                        b += Math.max(firstVal, lastVal);
                        a += Math.min(firstVal, lastVal);
                    }
                }
                last -= first;
                first = 0;
            }
            a += addSum;
            b += addSum;
        }
        result[index] = Math.min(a, b);
        result[index + 1] = Math.max(a, b);
    }

    public static int getSum(int first, int last, int firstVal, int lastVal) {
        //first>last
        return firstVal * (last >> 1) + lastVal * (last >> 1);
    }
}
