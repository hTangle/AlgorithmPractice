package com.nevergetme.datastructure.graph;

import com.nevergetme.datastructure.queue.Queue;

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
    public void dfs(int s){
        boolean[] isMarked=new boolean[V];
        dfs(isMarked,s);
    }
    private void dfs(boolean[] isMarked,int s){
        isMarked[s]=true;
        System.out.print(s);
        for(int w:adj(s)){
            if(!isMarked[w]){
                dfs(isMarked,w);
            }
        }
    }
    public void bfs(int s){
        boolean[] isMarked=new boolean[V];
        isMarked[s]=true;
        Queue<Integer> queue=new Queue();
        queue.enqueue(s);
        //System.out.print(s);
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            System.out.print(v);
            for(int w:adj(v)){
                if(!isMarked[w]) {
                    isMarked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
        System.out.println();
    }
//    public boolean isCycle(){
//        boolean[] isMarked=new boolean[V];
//        for(int s=0;s<V;s++){
//            if(!isMarked[s]){
//                isMarked[s]=true;
//                int beforwW=s;
//                for(int w:adj(s)){
//
//                }
//            }
//        }
//    }
//    public String dfsSearch(int from,int to){
//        boolean[] isMarked=new boolean[V];
//    }
    public static void main(String[] args){
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.bfs(0);
        g.dfs(0);
        //DepthFirstSearch dfs=new DepthFirstSearch(g,0);
    }
}
