package com.nevergetme.algorithmCompetition.second;

import com.nevergetme.datastructure.stack.Stack;

public class DoubleStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty())return -1;
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int target=stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return target;
    }
    public static void main(String[] args){
        DoubleStack d=new DoubleStack();
        for(int i=0;i<10;i++)d.push(i);
        for(int i=0;i<10;i++)System.out.println(d.pop());
    }
}
