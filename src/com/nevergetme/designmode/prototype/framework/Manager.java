package com.nevergetme.designmode.prototype.framework;

import java.util.HashMap;

public class Manager {
    private HashMap showcase=new HashMap();
    public void register(String name,Product prop){
        showcase.put(name,prop);
    }
    public Product create(String protoname){
        Product p=(Product)showcase.get(protoname);
        return p.createClone();
    }
}
