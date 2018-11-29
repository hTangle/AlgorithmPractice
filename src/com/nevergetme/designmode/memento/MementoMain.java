package com.nevergetme.designmode.memento;

import com.nevergetme.designmode.memento.game.Gamer;
import com.nevergetme.designmode.memento.game.Memento;

public class MementoMain {
    public static void main(String[] args){
        Gamer gamer=new Gamer(100);
        Memento memento=gamer.createMemento();
        for(int i=0;i<100;i++){
            System.out.println("==="+i);
            System.out.println("current state "+gamer);
            gamer.bet();
            System.out.println("current money:"+gamer.getMoney());
            if(gamer.getMoney()>memento.getMoney()){
                System.out.println("Money added");
                memento=gamer.createMemento();
            }else if(gamer.getMoney()<memento.getMoney()/2){
                System.out.println("Money cut");
                gamer.restoreMemento(memento);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}
