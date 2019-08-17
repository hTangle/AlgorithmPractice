package com.nevergetme.autumn.tencent.solution03;

import java.util.*;

public class Main {
    static class Points {
        int x, y;

        public Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        List<Points> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            points.add(new Points(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(points, new Comparator<Points>() {
            @Override
            public int compare(Points o1, Points o2) {
                return 0;
            }
        });
    }
}
