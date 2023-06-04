
package PhoneNWDesignApp;

import GraphFramework.Graph;
import GraphFramework.Vertex;
/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public class BluePrintsGraph extends Graph {
    
    public BluePrintsGraph(){
        
    }
    // to make an object of graph using BluePrintsGraph
    public BluePrintsGraph(int verticesNo, int edgeNo, boolean isDigraph) {
        super(verticesNo, edgeNo, isDigraph);
    }

    @Override
    public Office createVertex(String label) {
        return new Office(label);
    }

    @Override
    public Line createEdge(Vertex v, Vertex u, int w) {
        return new Line(v,u,w);
    }
}
