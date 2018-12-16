package com.nevergetme.datastructure.graph;


import com.nevergetme.datastructure.queue.Queue;
import com.nevergetme.designmode.iterator.Iterator;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    public BreadthFirstPaths(Graph G,int s){
        this.s=s;
        edgeTo=new int[G.V()];
        marked=new boolean[G.V()];
        bfs(G,s);
    }
    private void bfs(Graph G,int s){
        Queue<Integer> queue=new Queue();
        marked[s]=true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            System.out.println(v);
            for(int w:G.adj(v)){
                if(!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
            }
        }
        //((LinkedList<Integer>) queue).push();
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
//    public Iterable<Integer> pathTo(int v){
//
//    }

//    public static void main(String[] args){
//        Graph g=new Graph(5);
//        g.addEdge(0,1);
//        g.addEdge(1,2);
//        g.addEdge(1,3);
//        g.addEdge(2,4);
//        BreadthFirstPaths dfs=new BreadthFirstPaths(g,0);
//    }
}
