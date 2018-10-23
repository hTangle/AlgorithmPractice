package com.nevergetme.threadsample.MulThread;

public class PrintThread extends Thread{
    private Account account;
    public PrintThread(Account account){
        this.account=account;
    }

    @Override
    public void run(){
        for(int i=0;i<26;i++){
            account.printNumS();
        }
    }
}
