package com.nevergetme.codeText.huawei.huawei04;


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] input=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                input[i][j]=in.nextInt();
            }
        }
        System.out.println(getMinValue(input,n,m));
    }
    public static int getMinValue(int[][] input,int n,int m){
        int[][] dp=new int[n][m];
        int[][] dir=new int[n][m];
        dp[0][0]=input[0][0];
        for(int i=1;i<m;i++){
            dp[0][i]=dp[0][i-1]+input[0][i];
            dir[0][i]=0;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+input[i][j];
                    dir[i][j]=1;
                }else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        dp[i][j]=dp[i-1][j]+input[i][j];
                        dir[i][j]=1;
                    }else{
                        dp[i][j]=dp[i][j-1]+input[i][j];
                        dir[i][j]=0;
                    }
                }
            }
        }
        int[] tDir=new int[n-1+m-1];
        int x=n-1,y=m-1;
        for(int i=n+m-3;i>=0;i--){
            if(dir[x][y]==1){
                tDir[i]=1;
                x--;
            }else{
                tDir[i]=0;
                y--;
            }
        }
        int value=0;
        int minValue=0;
        for(int i=0;i<n+m-2;i++){
            if(value<0){
                minValue=Math.min(minValue,value);
            }
            value+=input[x][y];
            if(tDir[i]==1){
                x++;
            }else{
                y++;
            }
        }
        return 1-minValue;
    }
}
