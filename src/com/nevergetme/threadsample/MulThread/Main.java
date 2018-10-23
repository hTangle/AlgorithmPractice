package com.nevergetme.threadsample.MulThread;

public class Main {
    public static void main(String[] args){
        Account account=new Account("10001");
        new PrintCharThread(account).start();
        new PrintThread(account).start();
    }
}
