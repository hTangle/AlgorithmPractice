package com.nevergetme.datastructure.graph;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable=true;
    public TwoColor(Graph G){
        marked=new boolean[G.V()];
        color=new boolean[G.V()];
        for(int s=0;s<G.V();s++){
            dfs(G,s);
        }
    }
    private void dfs(Graph G,int v){
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                color[w]=!color[v];
                dfs(G,w);
            }
            else if(color[w]==color[v])isTwoColorable=false;
        }
    }
    public static void main(String[] args){
        Graph G=new Graph(6);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(1,3);
        G.addEdge(1,4);
        G.addEdge(4,5);
        //G.addEdge(5,2);
        TwoColor twoColor=new TwoColor(G);
         //cycle=new Cycle(G);
        System.out.println(twoColor.isTwoColorable);
    }
}
