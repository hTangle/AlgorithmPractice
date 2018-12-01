package com.nevergetme.designmode.flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    private char charname;
    private String fontdata;
    public BigChar(char charname){
        this.charname=charname;
        try {
            BufferedReader reader=new BufferedReader(new FileReader("big"+charname+".txt"));
            String line=null;
            StringBuffer sb=new StringBuffer();
            while ((line=reader.readLine())!=null){
                sb.append(line);
                sb.append("\n");
            }
            reader.close();
            this.fontdata=sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            this.fontdata=charname+"?";
            e.printStackTrace();
        }
    }
    public void print(){
        System.out.println(fontdata);
    }
}
