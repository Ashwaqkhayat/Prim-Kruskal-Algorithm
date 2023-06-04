/*
Graph is a class defines the structure of a graph.
 */
package GraphFramework;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public abstract class Graph {

    // attributes
    public int verticesNo; // the total number of vertices in a graph
    public int edgeNo; // the total number of edges in a graph
    public boolean isDigraph;// if the graph is a directed graph true will assigned to isDigraph variable otherwise false will assigned to it
    public Vertex[] vertices; // array of type vertex to hold the vertices
    // we have used a vertices counter to count the actual number of vertices without counting the duplicate verts
    public int vertsCounter = 0;

    // constructor without parameters 
    public Graph() {

    }

    // constructor with parameters 
    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new Vertex[verticesNo];
    }

    /*
    makeGraph is a method which is responsible for creating a graph object with a specified parameters and randomly initializes the vertices’ labels, 
    creating edges that connects the created vertices randomly and assigning them random weights. 
     */
    public void makeGraph() {
        Random rand = new Random(); // generate a random number
        for (int i = 0; i < verticesNo; i++) { // this loop is responsible for randomly initializes the vertices’ labels
            int label = rand.nextInt(1000);
            Vertex v1 = createVertex(label + ""); // create a new vertex with a random label
            // Vertex ========================================================
            
            for (int j = 0; j < vertices.length; j++) { // this loop is responsible for checking whether there's a duplicate vetrices and eliminate them
                if (vertices[j] != null) {
                    if (vertices[j].label.equals(v1.label)) {
                        v1 = vertices[j];
                        break;
                    } else {
                        continue;
                    }
                }
                vertices[j] = v1;
                vertsCounter++;
                break;
            }
        }

        // Create edges
        for (int i = 0; i < vertsCounter - 1; i++) {
            addEdge(vertices[i], vertices[i + 1], rand.nextInt(50) + 1, isDigraph); // add edge between each vertex in the graph 
        }
        int remaining = edgeNo - (vertsCounter - 1); // this variable will store the number of the remaining edges which are not connect any vetrtices yet
        for (int i = 0; i < remaining; i++) {
            int index = rand.nextInt(vertsCounter - 1); // generate a random number to use it as an index to choose which vertex will connect another vertex
            int index2 = rand.nextInt(vertsCounter - 1);// generate a random number to use it as an index of the other vertex
            if (index != index2) { // no edge will connect the vertex itself, so if the random indices are not the same add a new edge 
                addEdge(vertices[index], vertices[index2], rand.nextInt(50) + 1, isDigraph);
            } else { // else go back to the same iteration and generate another random numbers... this else is to insure that there is no unused edge
                i--;
            }
        }

    }

    // the method readGraphFromFile will reads the edges and vertices from the text file and place the data in a Graph object
    public void readGraphFromFile(File fileName) throws FileNotFoundException {

        Scanner sc = new Scanner(fileName);

        sc.next(); //Reads the text "digraph" and ignore it
        isDigraph = (sc.nextInt() == 1);// if the scanner read 1 then set the value of isDigraph to true
        this.verticesNo = sc.nextInt(); // read the total nummber of vertices
        this.edgeNo = sc.nextInt();// read the total nummber of edges

        this.vertices = new Vertex[verticesNo];

        Vertex vert1, vert2;

        while (sc.hasNext()) { // while the file is not empty
            vert1 = createVertex(sc.next()); // read the label and create a vertex with that name
            vert2 = createVertex(sc.next()); // read the label and create a vertex with that name

            // Vertex 1 ========================================================
            for (int j = 0; j < vertices.length; j++) {
                if (vertices[j] != null) {
                    if (vertices[j].label.equals(vert1.label)) {
                        vert1 = vertices[j];
                        break;
                    } else {
                        continue;
                    }
                }
                vertices[j] = vert1;
                vertsCounter++;
                break;
            }
            // Vertex 2 ========================================================
            for (int j = 0; j < vertices.length; j++) {
                if (vertices[j] != null) {
                    if (vertices[j].label.equals(vert2.label)) {
                        vert2 = vertices[j];
                        break;
                    } else {
                        continue;
                    }
                }
                vertices[j] = vert2;
                vertsCounter++;
                break;
            }
            addEdge(vert1, vert2, sc.nextInt(), isDigraph);
        }

    }
    // this method will add the edges in graphs
    public void addEdge(Vertex v, Vertex u, int w, boolean isDigraph) {
        boolean flag = false; // the flag is to indicate that the edge is added successfully
        for (int i = 0; i < v.adjList.size(); i++) {
            if (v.adjList.get(i).target.label.equals(u.label)) { // go throught the adjList to check whether there is an edge between the vetetices v and u
                flag = true; // set the flag to true
                break;
            }
        }
        // if flag still false after the loop then
        if (flag == false) { // the edge is new ... create the edge between the vertex v and vertex u with the weight w
            Edge edge = createEdge(v, u, w);
            v.adjList.add(edge);
        }

        if (isDigraph == false) { // if the graph is undirected
            flag = false; // set the flag to false
            for (int i = 0; i < u.adjList.size(); i++) { // go throught the adjList to check whether there is an edge between the vetetices u and 
                if (u.adjList.get(i).target.label.equals(v.label)) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                Edge edge = createEdge(u, v, w);
                u.adjList.add(edge);
            }

        }
    }

    // the implementation of the abstract methods (createVertex and createEdge ) will be on the class BluePrintsGraph
    public abstract Vertex createVertex(String label);

    public abstract Edge createEdge(Vertex v, Vertex u, int w);

    

}
