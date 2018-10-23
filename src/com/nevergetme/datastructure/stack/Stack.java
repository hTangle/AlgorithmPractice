package com.nevergetme.datastructure.stack;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
    private Node first;//指向栈顶
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){return N==0;}
    public int size(){return N;}
    public void push(Item item){
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public Item pop(){
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<Item>{
        private Node current=first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }
        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
