package com.nevergetme.designmode.prototype;

import com.nevergetme.designmode.prototype.framework.Product;

public class UnderlinePen implements Product {
    private char decochar;
    public UnderlinePen(char decochar){
        this.decochar=decochar;
    }
    @Override
    public void use(String s) {
        System.out.println(decochar+" "+s+" "+decochar);
    }

    @Override
    public Product createClone() {
        Product p=null;
        try {
            p=(Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}