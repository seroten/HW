import java.util.LinkedList;

public class DepthFirstPaths extends GraphPaths{

    public DepthFirstPaths(Graph g, int source) {
        super(g, source);
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
}