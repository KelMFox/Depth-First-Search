/**
 * Created by Kelly on 4/14/2016.
 */
import java.util.ArrayList;

/**
 * The DFSGraph class creates a graph that will be traversed or searched
 * using the depth first search algorithm. The class contains methods for adding
 * vertices and edges, methods for searching/visiting the vertices in the
 * graph, and a method for displaying the search order and discovery/finishing
 * times.
 *
 */

public class DFSGraph {

    // Holds the starting point for the graph search
    public Vertex startingVertex;

    // An array list to hold vertices
    public ArrayList<Vertex> vertices = new ArrayList();

    // An array list to hold the visited vertices
    public ArrayList<Vertex> visitedVertices = new ArrayList();

    // Adjacency matrix to hold the graph's edges
    public int[][] edges;

    // Hold the array list size
    public int size;

    // Global variable for tracking the time
    public int time;

    /**
     * The setStartingVertex method sets the point or vertex
     * at which the search will begin
     * @param v
     */
    public void setStartingVertex(Vertex v) {

        this.startingVertex = v;
    }

    /**
     * The getStartingVertex method returns the
     * starting vertex
     * @return
     */
    public Vertex getStartingVertex() {

        return this.startingVertex;
    }

    /**
     * The addVertex method is used for
     * adding a vertex to the graph
     * @param v
     */
    public void addVertex(Vertex v) {

        vertices.add(v);
    }

    /**
     * The addEdges method is used for adding edges to
     * the graph
     * @param fromVertex
     * @param toVertex
     */
    public void addEdges(Vertex fromVertex, Vertex toVertex) {

        if (edges == null) {

            size = vertices.size();

            edges = new int[size][size];
        }
        // Get 'origin' and 'destination' vertices
        int start = vertices.indexOf(fromVertex);
        int end = vertices.indexOf(toVertex);

        // origin and destination vertices are added to the
        // adjacency matrix
        edges[start][end] = 1;
    }

    /**
     * The DFSVist method is a private recursive method that tracks
     * the discovery and finishing times, tracks which vertices have
     * been visited and adds them to the visited vertex array list.
     * @param u
     */
    private void DFSVisit(Vertex u) {

        // Add vertex to the visited vertex array list
        visitedVertices.add(u);

        time = time + 1;         // Increment time
        u.vertexStatus = 1;      // Set status
        u.discoveryTime = time;  // Mark discovery time

        int index = vertices.indexOf(u);

        int i = 0;

        while (i < size) {

            // Walk through the graph recursively calling DFSVisit
            if ((edges[index][i] == 1) && (vertices.get(i).vertexStatus == 0)) {

                vertices.get(i).ancestor = u; // Set ancestor

                // Recursive call to visit all vertices in the graph
                DFSVisit(vertices.get(i));
            }
            i++;
        }
        u.vertexStatus = 2;     // Set status
        time = time + 1;        // Increment time
        u.finishingTime = time; // Mark finishing time
    }

    /**
     * The DFS method uses the private method DFSVisit to search
     * through the graph and then displays the results
     */
    public void DFS() {

        for (int i = 0; i < vertices.size(); i++) {

            Vertex v = vertices.get(i);

            if (v.vertexStatus == 0) {

                // Call to the private recursive method
                DFSVisit(v);
            }
        }
        // Show results of the search
        displayGraph();
    }

    /**
     * The private displayGraph method is used by the DFS method to
     * show the results of the depth first search. It displays the
     * vertex search order and the discovery and finishing times
     */
    private void displayGraph() {

        System.out.println("***************** Depth First Search *****************\n");
        System.out.println("The graph will be traversed starting from vertex 1\n");
        System.out.println("Depth First Search of Graph: \n");

        for (int i = 0; i < visitedVertices.size(); i++) {

            Vertex v = visitedVertices.get(i);

            System.out.println("Vertex: " + v.vertexLabel + "  Discovery Time: " + v.discoveryTime +
                    "  Finishing Time: " + v.finishingTime + "  Parent Node: " + v.ancestor);

        } System.out.println("\n************** End of Depth First Search **************");
    }
}