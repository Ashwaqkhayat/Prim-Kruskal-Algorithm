// Kruskal Algorithm
package GraphFramework;

import java.util.ArrayList;
import java.util.Comparator;
/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public class KruskalAlg extends MSTAlgorithm {
    
    // Array of ArrayLists to illustrate subsets of vertices
    static ArrayList[] subsets;
    
    // Constructor that recieves a constructed graph
    public KruskalAlg (Graph G){
        graph = G;
    }
    
    public ArrayList<Edge> Kruskal() {
        // ArrayList that stores Edges
        ArrayList <Edge> increasingEdge = new ArrayList <>();
        
        // Loop through all graph vertices to store all their edges in the increasingEdge ArrayList
        for (int i = 0; i < graph.vertsCounter; i++) {
            for (int j = 0; j < graph.vertices[i].adjList.size(); j++) {
                Edge currentEdge = graph.vertices[i].adjList.get(j);
                increasingEdge.add(currentEdge);
            }
        }
        
        // Sort the increasingEdge based on Edges' Weight
        increasingEdge.sort(Comparator.comparingInt(o -> o.weight));
        // Create the ArrayList of Resulting MST
        MSTresultList = new ArrayList<>(graph.verticesNo-1);
        
        // An index tracker to iterate among sorted edges
        int k = 0;
        // Acceped edges counter
        int eCounter = 0;
        // MakeSet() is used to put each vertex of the graph in a seperated set
        MakeSet(graph.vertices, graph);
        
        // Loop until all |V|-1 Edges are found (Edges of MST)
        while (eCounter < graph.verticesNo - 1 && k<increasingEdge.size()) { //max 3
            Edge currentEdge = increasingEdge.get(k);  // Hold the current edge in variable currentEdge
            k++;                                            // Increment the Edge index tracker 
            // Check if the source & target of the current edge are in the same sets
            if (find(currentEdge.source) != find(currentEdge.target)) {
                MSTresultList.add(currentEdge);           // Add the edge to the results list
                eCounter++;                                 // Increment the eCounter
                // Union the two subsets into one set containing source & target vertices
                union(currentEdge.source, currentEdge.target);
            }
        }
        return MSTresultList;

    }

    @Override
    public void displayResultingMST() {
        int cost = 0;   // cost variable to sum the path cost
        System.out.println("The phone network (minimum spanning tree) generated \nby Kruskal algorithm is as follows:\n");
        // Loop through the resulting list 
        for (int i = 0; i < MSTresultList.size(); i++) {
            String src = MSTresultList.get(i).source.label;     // Get the source label
            String trgt = MSTresultList.get(i).target.label;    // Get the target label
            int weight = MSTresultList.get(i).weight;           // Get the edge weight
            cost += weight;                                          // Sum the weight to the total cost
            System.out.println("Office No. " + src + " - Office No. " + trgt + " : Line length: " + weight*5 + "\n");
        }
        System.out.println("The cost of designed phone network: " + cost);
    }

    // MakeSet() method is used to make a set for each vertex in a graph
    public void MakeSet(Vertex[] vertices, Graph G) {
        // Create an array of subsets to treat its indexes as representatives
        subsets = new ArrayList[G.verticesNo];
        // Loop through array of subsets to put a single vertex in each subset
        for (int i = 0; i <subsets.length ; i++) {
            // Create a new ArrayList to represent a set in each index
            subsets[i] = new ArrayList <>();
            // Add a single vertex in each set
            subsets[i].add(G.vertices[i]);
        }
    }

    // Find() method is used to find where a given vertex is among all subsets
    public int find(Vertex vert) {
        // Loop through the subsets array 
        for (int i = 0; i < subsets.length; i++) {
            // check if the current subset contains the given vertex
            if(subsets[i] != null && subsets[i].contains(vert))
                // If the given vertex is found, return its set's representative
                return i;
        }
        // if the given vertex isn't found, return -1
        return -1;
    }

    // Union() method is used to union the passed two vertices into one set
    public void union(Vertex src, Vertex trgt) {
        // Find the set of the source vertex
        int source = find(src);
        // Find the set of the target vertex
        int target = find(trgt);
        // Merge all elements of both subsets into one set
        subsets[source].addAll(subsets[target]);
        // Set the merged subset to null 
        subsets[target] = null;
    }

}
