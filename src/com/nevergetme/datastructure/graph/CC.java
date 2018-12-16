package com.nevergetme.datastructure.graph;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;
    public CC(Graph G){
        marked=new boolean[G.V()];
        id=new int[G.V()];
        for(int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }
    private void dfs(Graph G,int v){
        marked[v]=true;
        id[v]=count;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }
    public boolean connected(int v,int w){
        return id[v]==id[w];
    }
    public static void main(String[] args){
        Graph G=new Graph(6);
        G.addEdge(0,1);
        G.addEdge(1,3);
        G.addEdge(1,4);
        G.addEdge(2,5);
        CC cc=new CC(G);
        System.out.println(cc.connected(1,2));
        System.out.println(cc.connected(5,2));
    }
}
