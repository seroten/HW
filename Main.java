import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(1,9);
        graph.addEdge(9,10);
        graph.addEdge(10,7);
        graph.addEdge(7,5);
        graph.addEdge(5,6);
        graph.addEdge(6,4);
        graph.addEdge(4,8);
        graph.addEdge(8,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(2,5);

//        System.out.println(graph.getAdjList(8));

//        DepthFirstPaths dfp = new DepthFirstPaths(graph, 2);
//        System.out.println(dfp.hasPathTo(0));
//        System.out.println(dfp.pathTo(0));


        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 1);
        System.out.println(bfp.hasPathTo(5));
        System.out.println(bfp.pathTo(5));

    }
}
