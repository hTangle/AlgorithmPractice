package com.nevergetme.nowcoder;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
            int n = input.nextInt();
            int count = 0; //保存苹果总数,用于创建数组
            int[] apple = new int[n+1]; //用数组保存苹果
            for (int i = 1; i <= n; i++) {
                apple[i] = input.nextInt();
                count += apple[i];
            }

            int[] arr = new int[count+1];
            count = 0;
            for (int i = 1; i <= n; i++) {
                for(int j = count+1; j <= apple[i]+count; j++ ) {
                    arr[j] = i;
                }
                count += apple[i];
            }
            int m = input.nextInt();
            for (int i = 0; i < m; i++) {
                System.out.println(arr[input.nextInt()]);
            }
        }
    }
}
