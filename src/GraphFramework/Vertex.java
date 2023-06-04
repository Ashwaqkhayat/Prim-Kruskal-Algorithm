package GraphFramework;

import java.util.LinkedList;
/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public class Vertex {

    public String label; // label of the vertex
    public boolean isVisited; // if the vertex is visited, true will assign to isVisited otherwise false will assign to the variable

    public LinkedList<Edge> adjList; // the adjacency list 

    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        adjList = new LinkedList<Edge>();
    }

    public Vertex() {
        adjList = new LinkedList<Edge>();
    }
    
    public void displayInfo() {
        System.out.print(label);
    }

    public String getLabel() {
        return label;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

}
