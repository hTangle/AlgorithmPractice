package com.nevergetme.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private final int V;
    private int E;
    private HashSet<Integer>[] adj;
    public Graph(int V){
        this.V=V;
        this.E=0;
        adj=(HashSet<Integer>[])new HashSet[V];
        for(int i=0;i<V;i++){
            adj[i]=new HashSet<Integer>();
        }
    }
    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
