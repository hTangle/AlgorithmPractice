package com.nevergetme.datastructure.graph;

public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph G){
        marked=new boolean[G.V()];
        for(int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s,s);
            }
        }
    }
    private void dfs(Graph G,int v,int u){
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w,v);
            }
            else if(w!=u)//如果被标记过而且前一个节点与当前节点不相等，则就是存在环
                hasCycle=true;
        }
    }
    public boolean hasCycle(){return hasCycle;}
    public static void main(String[] args){
        Graph G=new Graph(6);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(1,3);
        G.addEdge(1,4);
        G.addEdge(4,5);
        G.addEdge(5,2);
        Cycle cycle=new Cycle(G);
        System.out.println(cycle.hasCycle);
    }
}
