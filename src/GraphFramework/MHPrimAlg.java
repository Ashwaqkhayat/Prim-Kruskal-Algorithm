//Min-Heap Prim Algorithm
package GraphFramework;
import java.util.*;
/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public class MHPrimAlg extends MSTAlgorithm {
    
    public MHPrimAlg(Graph G){
        graph = G;
    }
    
    public void Prim() {
        MSTresultList = new ArrayList<>(graph.verticesNo-1);// this array list to display the results of the prim algorithm
        ArrayList<Vertex> Vt = new ArrayList<>(); //array list of vertex
        PriorityQueue <Edge> Edges = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight)); // order the edges depending on the weight attribute
        
        Vertex source = graph.vertices[0]; // set the first vertex as a source
        Vt.add(source); //Add source vert
        source.setIsVisited(true);// since the source vertex has been visited then set the attribute isVisited to true
        
        addToQueue(Edges, source); // Add all edges of starting vert to the queue
        
        int minEdgesCounter = 0;// to count the total number of edges with the smallest value 
        while (minEdgesCounter < graph.verticesNo-1 && !Edges.isEmpty()) {
            Edge minEdge = Edges.remove();// hold the value as a minEdge
            
            if(minEdge.target.isIsVisited()){ // if the edge is visited before then do not do anything and continue looping
                continue;
            }
            Vt.add(minEdge.target); // add the target vertex with the min edge to the array list
            minEdge.target.setIsVisited(true); // since the vertex is added to the array list then set the value of the is visited to true
            MSTresultList.add(minEdge);// add the min edge to the array list to display the result
            
            addToQueue(Edges, minEdge.target); // add the min edge to the edges
            minEdgesCounter++; // increment the counter
        }
        
    }
    // this method will add the edge of the specific vertex of a current edge to the PriorityQueue
    public void addToQueue(PriorityQueue q, Vertex v){
        for (int i = 0; i < v.adjList.size(); i++) {
            Edge currEdge = v.adjList.get(i);
            if(currEdge.target.isVisited==false){
                q.add(currEdge);
            }
        }
    }
    
    @Override
    // this method will display the result of the MST using Min-Heap based prim algorithm
    public void displayResultingMST(){
        int cost = 0;
        System.out.println("The phone network (minimum spanning tree) generated \nby min-heap based Prim algorithm is as follows:\n");
        for (int i = 0; i < MSTresultList.size(); i++) {
            String src = MSTresultList.get(i).source.label;
            String trgt = MSTresultList.get(i).target.label;
            int weight = MSTresultList.get(i).weight;
            int length = weight*5;
            cost += weight;
            System.out.println("Office No. " + src + " - Office No. " + trgt + " : Line length: " + weight + "\n");
        }
        System.out.println("The cost of designed phone network: " + cost);
    }
}
