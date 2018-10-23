package com.nevergetme.threadsample.MulThread;

public class Account {
    private String accountNo;
    private boolean printState = true;
    private int printNum = 1;
    private char printChar = 'A';

    public Account(String accountNo) {
        this.accountNo = accountNo;
    }

    public synchronized void printChars() {
        try {
            if (!printState)
                wait();
            System.out.print(printNum++);
            System.out.print(printNum++);
            printState = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printNumS() {
        try {
            if (printState)
                wait();
            System.out.print(printChar++);
            printState = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
