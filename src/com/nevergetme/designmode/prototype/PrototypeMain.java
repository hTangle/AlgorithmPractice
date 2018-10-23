package com.nevergetme.designmode.prototype;

import com.nevergetme.designmode.prototype.framework.Manager;
import com.nevergetme.designmode.prototype.framework.Product;

public class PrototypeMain {
    public static void main(String[] args){
        Manager manager=new Manager();
        UnderlinePen upen=new UnderlinePen('-');
        MessageBox mbox=new MessageBox('*');
        MessageBox sbox=new MessageBox('/');
        manager.register("strong message",upen);
        manager.register("warning box",mbox);
        manager.register("slash box",sbox);
        Product p1=manager.create("strong message");
        p1.use("hello java");
        Product p2=manager.create("warning box");
        p2.use("hello java");
        Product p3=manager.create("slash box");
        p3.use("hello java");
    }
}
