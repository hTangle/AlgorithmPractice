package com.nevergetme.designmode.visitor;

import java.util.Iterator;

public class FileFindVisitor extends Visitor{
    private String type;
    public FileFindVisitor(String type){
        this.type=type;
    }
    @Override
    public void visit(File file) {
        if(file.getName().contains(type)){
            System.out.println(file.getName());
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator it=directory.iterator();
        while (it.hasNext()){
            Entry entry=(Entry)it.next();
            entry.accept(this);
        }
    }
}
