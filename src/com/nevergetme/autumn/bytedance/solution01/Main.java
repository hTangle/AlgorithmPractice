package com.nevergetme.autumn.bytedance.solution01;

import java.util.*;

public class Main {
    static class Time {
        int h, m;

        public Time(int h, int m) {
            this.h = h;
            this.m = m;
        }

        @Override
        public String toString() {
            return h%24 + " " + m;
        }
        public int getTime(){
            return h*60+m;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Time> time = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            time.add(new Time(h, m));
            time.add(new Time(h + 24, m));
        }
        int X = sc.nextInt();
        int A = sc.nextInt() * 60 + sc.nextInt();
        int MinTime = A - X + 60 * 24;
        Collections.sort(time, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.h>o2.h)return -1;
                else if(o1.h<o2.h)return 1;
                else{
                    if(o1.m>o2.m)return -1;
                    else if(o1.m==o2.m)return 0;
                    else return 1;
                }
            }
        });
        for(Time t:time){
            if(t.getTime()<=MinTime){
                System.out.println(t);
                break;
            }
        }
    }
}
