package com.nevergetme.algorithm.stack;

import com.nevergetme.datastructure.stack.Stack;

import java.util.Scanner;

public class DoubleStackDijkstra {
    public static void main(String[] args){
        Stack<String> ops=new Stack<>();
        Stack<Double> vals=new Stack<>();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String in=scanner.nextLine();
            if(in.equals("exit"))
                break;
            String out="";
            for(int i=0;i<in.length();i++){
                String t=in.substring(i,i+1);
                if(t.equals("(")){}
                else if(t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/")){
                    ops.push(t);
                    vals.push(Double.parseDouble(out));
                    out="";
                }
                else if(t.equals(")")){
                    if(out.length()>0)
                        vals.push(Double.parseDouble(out));
                    String op=ops.pop();
                    double v=vals.pop();
                    if(op.equals("+"))v=vals.pop()+v;
                    else if(op.equals("-"))v=vals.pop()-v;
                    else if(op.equals("*"))v=vals.pop()*v;
                    else if(op.equals("/"))v=vals.pop()/v;
                    vals.push(v);
                }else if(t.equals(" ")){}
                else {
                    out+=t;
                }
            }
            System.out.println(vals.pop());
        }
    }
}
