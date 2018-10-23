package com.nevergetme.threadsample.MulThread;

public class PrintCharThread extends Thread{
    private Account account;
    public PrintCharThread(Account account){
        this.account=account;
    }

    @Override
    public void run(){
        for(int i=0;i<26;i++){
            account.printChars();
        }
    }
}
