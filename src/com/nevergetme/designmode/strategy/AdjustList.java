package com.nevergetme.designmode.strategy;

public abstract class AdjustList<Key extends Comparable<Key>> {
    public abstract boolean isCutFlag(Key key);
    public void RecordAdjustList(Key[] key){
        int begin=0,end=key.length-1;
        if(key.length==0)
            return;
        while(begin<end){
            while (begin<end&&isCutFlag(key[begin]))
                begin++;
            while (begin<end&&!isCutFlag(key[end]))
                end--;
            if(begin<end){
                Key temp=key[begin];
                key[begin]=key[end];
                key[end]=temp;
            }
        }
        for(Key k:key){
            System.out.print(k+" ");
        }
        System.out.println();
    }
}
