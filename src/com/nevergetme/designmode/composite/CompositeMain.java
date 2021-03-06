package com.nevergetme.designmode.composite;

public class CompositeMain {
    //保持单个和多个的一致性
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
            bindir.add(new File("vi",10000));
            bindir.add(new File("latex",20000));
            rootdir.printList();
        }catch (FileTreatMentException e){
            e.printStackTrace();
        }
    }
}
