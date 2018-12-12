package com.nevergetme.datastructure.graph;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        System.out.print(v);
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]){
                //System.out.print(w);
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
    public static void main(String[] args){
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        DepthFirstSearch dfs=new DepthFirstSearch(g,0);
    }
}
