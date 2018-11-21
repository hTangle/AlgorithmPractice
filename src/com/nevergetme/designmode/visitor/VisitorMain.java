package com.nevergetme.designmode.visitor;

import com.nevergetme.designmode.composite.FileTreatMentException;

public class VisitorMain {
    //将处理从数据结构中分离出来
    public static void main(String[] args){
        try {
            System.out.println("Making root entries...");
            Directory rootdir=new Directory("root");
            Directory bindir=new Directory("bin");
            Directory tmpdir=new Directory("tmp");
            Directory usrdir=new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi.html",10000));
            bindir.add(new File("latex",20000));
            rootdir.accept(new FileFindVisitor("html"));
        }catch (FileTreatMentException e){
            e.printStackTrace();
        }
    }
}
