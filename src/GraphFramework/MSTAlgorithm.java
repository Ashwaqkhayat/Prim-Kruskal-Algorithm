
package GraphFramework;

import java.util.ArrayList;
/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public abstract class MSTAlgorithm {
    
    Graph graph;
    ArrayList<Edge> MSTresultList;

    public MSTAlgorithm() {
    }
    // the implementation of the abstract method displayResultingMST will be at kruskal class and MHprim class
    abstract void displayResultingMST();
    
}
