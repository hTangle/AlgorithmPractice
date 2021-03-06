package com.nevergetme.datastructure.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST<Key extends Comparable<Key>,Value>{
    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;
        public Node(Key key,Value val,int N){
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }
    private Node root;
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null)
            return 0;
        else
            return x.N;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        if(x==null)return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0)return get(x.left,key);
        else if(cmp>0)return get(x.right,key);
        else return x.val;
    }
    public void put(Key key,Value val){
        root=put(root,key,val);
    }
    private Node put(Node x,Key key,Value val){
        if(x==null)return new Node(key,val,1);
        int cmp=key.compareTo(x.key);
        if(cmp<0)x.left=put(x.left,key,val);
        else if(cmp>0)x.right=put(x.right,key,val);
        else x.val=val;
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left==null)return x;
        return min(x.left);
    }
    public Key floor(Key key){
        Node x=floor(root,key);
        if(x==null)return null;
        return x.key;
    }
    private Node floor(Node x,Key key){
        if(x==null)return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0)return x;
        if(cmp<0)return floor(x.left,key);
        Node t=floor(x.right,key);
        if(t!=null)return t;
        else return x;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        toString(root,sb);
        return sb.toString();
    }
    public void toString(Node root,StringBuilder sb){
        if(root.left!=null){
            toString(root.left,sb);
        }
        sb.append(root.val);
        if(root.right!=null){
            toString(root.right,sb);
        }
    }

    //选择第几个数
    //很明显与左子树的大小有关
    public Key select(int k){
        return select(root,k).key;
    }
    private Node select(Node x,int k){
        if(x==null) return null;
        int t=size(x.left);
        if(t>k)return select(x.left,k);
        else if(t<k)return select(x.right,k-t-1);
        else return x;
    }

    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key,Node x){
        if(x==null)return 0;
        int cmp=key.compareTo(x.key);
        if(cmp<0)return rank(key,x.left);
        else if(cmp>0)return 1+size(x.left)+rank(key,x.right);
        else return size(x.left);
    }

    public void deleteMin(){
        root=deleteMin(root);
    }
    private Node deleteMin(Node x){
        if(x.left==null){
            return x.right;
        }
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }
    public void delete(Key key){
        root=delete(root,key);
    }
    private Node delete(Node x,Key key){
        if(x==null)return null;
        int cmp=key.compareTo(x.key);
        if(cmp<0)x.left=delete(x.left,key);
        else if(cmp>0)x.right=delete(x.right,key);
        else{
            if(x.right==null){
                return x.left;
            }
            if(x.left==null)return x.right;
            Node t=x;
            x=min(t.right);//用右子树的最小的节点来填充这个位置
            x.right=deleteMin(t.right);
            x.left=t.left;
        }
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public String print(Key min,Key max){
        StringBuilder sb=new StringBuilder();
        print(min,max,root,sb);
        return sb.toString();
    }
    private void print(Key min,Key max,Node x,StringBuilder sb){
        if(x==null)
            return;
        int comlo=min.compareTo(x.key);
        int comhi=max.compareTo(x.key);
        if(comlo<0)print(min,max,x.left,sb);
        if(comlo<=0&&comhi>=0)sb.append(x.val);
        if(comhi>0)print(min,max,x.right,sb);
    }

    public static void main(String[] args){
//        String s="12";
//        System.out.println(s.hashCode());
        BST<Integer,Integer> bst=new BST<>();
        List<Integer> list=new ArrayList<>();
        //int[] a=new int[100];
        for(int i=0;i<100;i++){
            list.add(i);
        }
        Collections.shuffle(list);
        for(int a:list){
            bst.put(a,a);
        }
        bst.deleteMin();
        System.out.println(bst);
        System.out.println(bst.print(30,40));
    }
}
