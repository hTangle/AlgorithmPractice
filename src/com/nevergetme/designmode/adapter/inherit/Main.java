package com.nevergetme.designmode.adapter.inherit;

public class Main {
    public static void main(String[] args){
        Print p=new PrintBanner("Hello");
        p.printWeak();
        p.printString();
    }
}
