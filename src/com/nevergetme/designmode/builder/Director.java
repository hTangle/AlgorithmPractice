package com.nevergetme.designmode.builder;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder=builder;
    }
    public void construct(){
        builder.makeTitle("Greeting");
        builder.makeString("from morning to afternoon");
        builder.makeItem(new String[]{"Good Morning","Good Afternoon"});
        builder.makeString("Evening");
        builder.makeItem(new String[]{"Good Evening","Good Night","ByeBye"});
        builder.close();
    }
}
