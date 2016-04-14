/**
 * Created by Kelly on 4/14/2016.
 */
/**
 * The DFSDriver class used the methods in the DFSGraph class and
 * the Vertex class to add vertices and edges to a graph and
 * then search the graph using the DFS algorithm.
 *
 */
public class DFSDriver {

    public static void main (String[] args) {

        // Create instance of the DFSGraph class
        DFSGraph graph = new DFSGraph();

        // Create names for the vertices
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

        // Add the vertices to the graph
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);

        // Set the starting vertex
        graph.setStartingVertex(v1);

        // Create and add edges to the graph
        graph.addEdges(v1, v2);
        graph.addEdges(v1, v4);
        graph.addEdges(v2, v4);
        graph.addEdges(v2, v3);
        graph.addEdges(v4, v5);
        graph.addEdges(v5, v2);
        graph.addEdges(v5, v6);
        graph.addEdges(v6, v3);

        // Show the graph search
        graph.DFS();
    }
}