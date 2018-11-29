package com.nevergetme.designmode.memento.game;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List fruits=new ArrayList();
    private Random random=new Random();
    private static String[] fruitsName={"apple","grape","banana","orange"};
    public Gamer(int money){
        this.money=money;
    }
    public int getMoney(){return money;}
    public void bet(){
        int dice=random.nextInt(6)+1;
        if(dice==1){
            money+=100;
            System.out.println("Money added");
        }else if(dice==2){
            money/=2;
            System.out.println("Money half");
        }else if(dice==6){
            String f=getFurit();
            System.out.println("get fruit:"+f);
            fruits.add(f);
        }else {
            System.out.println("Nothing changed");
        }
    }
    public Memento createMemento(){
        Memento m=new Memento(money);
        Iterator it=fruits.iterator();
        while(it.hasNext()){
            String f=(String)it.next();
            if(f.startsWith("deliciously"))
                m.addFruit(f);
        }
        return m;
    }
    public void restoreMemento(Memento memento){
        this.money=memento.money;
        this.fruits=memento.getFruit();
    }

    @Override
    public String toString(){
        return "[money="+money+",fruits="+fruits+"]";
    }
    private String getFurit(){
        String prefix="";
        if(random.nextBoolean()){
            prefix="deliciously";
        }
        return prefix+fruitsName[random.nextInt(fruitsName.length)];
    }
}
