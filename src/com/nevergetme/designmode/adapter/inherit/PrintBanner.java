package com.nevergetme.designmode.adapter.inherit;

public class PrintBanner extends Banner implements Print{
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithAster();
    }

    @Override
    public void printString() {
        showWithParen();
    }
}
