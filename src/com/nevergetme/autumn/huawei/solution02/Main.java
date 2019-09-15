package com.nevergetme.autumn.huawei.solution02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
//        ThreadPoolExecutor
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Long> map = new HashMap<>();
        Set<String> undefineMap = new HashSet<>();
        String last = "";
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            line=line.replace(" ", "").replace("\n", "");
            String[] lines = line.split("=");
            if (lines.length >= 2) {
                String[] adders = lines[1].split("\\+");
                long sum = 0;
                for (String a : adders) {
                    if (a.charAt(0) <= '9' && a.charAt(0) >= '0') {
                        int k = Integer.parseInt(a);
                        sum += k;
                    } else {
                        if (map.containsKey(a)) {
                            sum += map.get(a);
                        } else {
                            sum = -1;
                            break;
                        }
                    }
                }
                if (sum >= 0) {
                    map.put(lines[0], sum);
                } else {
                    undefineMap.add(lines[0]);
                }
            }
            last = lines[0];
        }
        if (map.containsKey(last)) {
            System.out.println(map.get(last));
        } else {
            System.out.println("NA");
        }
    }
}
