package com.nevergetme.designmode.abstractfactory.listfactory;

import com.nevergetme.designmode.abstractfactory.factory.Factory;
import com.nevergetme.designmode.abstractfactory.factory.Link;
import com.nevergetme.designmode.abstractfactory.factory.Page;
import com.nevergetme.designmode.abstractfactory.factory.Tray;

public class ListFactory extends Factory{
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}
