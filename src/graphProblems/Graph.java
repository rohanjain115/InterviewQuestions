package graphProblems;

/**
 * Created by rohanrampuria on 4/24/17.
 */
import java.util.HashSet;

/* Here, our graph is implemented in a way not learned in CS225...
 * The edges themselves are saved in the GraphNodes as opposed to in their own structure.
 */

class Graph {
    public static int MAX_VERTICES = 6;
    private Node vertices[];
    public int count;
    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < vertices.length) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}