package com.nevergetme.designmode.proxy;

public class ProxyMain {
    public static void main(String[] args){
        Printable p=new PrinterProxy("Alice");
        System.out.println("current name is "+p.getPrinterName());
        p.setPrinterName("Bob");
        System.out.println("current name is "+p.getPrinterName());
        p.print("Hello Java");
    }
}
