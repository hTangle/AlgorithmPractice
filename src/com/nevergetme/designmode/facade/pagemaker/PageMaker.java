package com.nevergetme.designmode.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker(){}
    public static void makeWelcomePage(String mailaddr,String filename){
        try{
            Properties mailprop=Database.getProperties("maildata");
            String username=mailprop.getProperty(mailaddr);
            HtmlWriter writer=new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to "+username+"'s page!");
            writer.paragraph(username+" welcome"+username+"'s main page");
            writer.paragraph("Waiting for your email");
            writer.mailto(mailaddr,username);
            writer.close();
            System.out.println(filename+" is create for "+mailaddr+"("+username+")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
