/**
 * Created by Kelly on 4/14/2016.
 */
/**
 * The Vertex class is a public class used by the DFSGraph and
 * DFSDriver class to create graph vertices, create variables
 * for the finishing and discovery times, and create a label
 * or name for the vertices.
 *
 */

public class Vertex {

    Vertex ancestor;       // Holds the ancestor vertex
    int vertexStatus = 0;  // Sets the vertex status
    int vertexLabel;       // Name or label of the vertex (i.e. 1, 2, 3, etc.)
    int discoveryTime;     // Hold the discovery time
    int finishingTime;     // Holds the finishing time


    public Vertex(int v) {

        this.vertexLabel = v;
    }

    public String toString() {

        String a = "";
        a += Integer.toString(this.vertexLabel);

        return a;
    }
}
