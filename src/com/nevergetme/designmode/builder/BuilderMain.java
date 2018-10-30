package com.nevergetme.designmode.builder;

public class BuilderMain {
    /***
     * 可替换性
     * @param args
     */
    public static void main(String[] args){
        HtmlBuilder builder=new HtmlBuilder();
        Director director=new Director(builder);
        director.construct();
        String filename=builder.getResult();
        System.out.println(filename);

    }
}
