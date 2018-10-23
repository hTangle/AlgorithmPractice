package com.nevergetme.designmode.adapter.entrust;

import com.nevergetme.designmode.adapter.inherit.Banner;

public class PrintBanner extends Print{
    private Banner banner;
    public PrintBanner(String string){
        this.banner=new Banner(string);
    }
    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
