package lesson_7;
public class Program {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
//        graph.addEdge(0, 5);//
        graph.addEdge(0, 6);
        graph.addEdge(1, 6);
//        graph.addEdge(1, 2);//
        graph.addEdge(2, 3);
        graph.addEdge(2, 7);
        graph.addEdge(3, 4);
//        graph.addEdge(3, 7);//
        graph.addEdge(4, 5);
        graph.addEdge(4, 8);
        graph.addEdge(5, 8);
//        graph.addEdge(6, 7);//
//        graph.addEdge(7, 8);//
        graph.addEdge(8, 6);
//        graph.addEdge(6, 9);//
        graph.addEdge(7, 9);
//        graph.addEdge(8, 9);//

        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 0);
        System.out.println(bfs.hasPathTo(9));
        System.out.println(bfs.pathTo(9));
        System.out.println(bfs.distTo(9));
        System.out.println(graph.toString());
    }
}
