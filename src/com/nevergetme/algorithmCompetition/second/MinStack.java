package com.nevergetme.algorithmCompetition.second;

import com.nevergetme.datastructure.stack.Stack;

public class MinStack {
    Stack<Integer> mainStack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    int min=Integer.MAX_VALUE;
    public void push(int node) {
        mainStack.push(node);
        if(node<min){
            minStack.push(node);
            min=node;
        }else{
            minStack.push(min);
        }
    }

    public void pop() {
        if(!mainStack.isEmpty()){
            mainStack.pop();
            minStack.pop();
            min=minStack.pop();
            minStack.push(min);
        }
    }

    public int top() {
        int k=mainStack.pop();
        mainStack.push(k);
        return k;
    }

    public int min() {
        return min;
    }
}
