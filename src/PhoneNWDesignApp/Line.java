
package PhoneNWDesignApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;
/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public class Line extends Edge{
    
    private int ILength;

    public Line(Vertex source, Vertex target, int weight) {
        super(weight, source, target);
        this.ILength = weight * 5;
    }
    
    
    @Override
    public void displayInfo(){// the implementation of the method displayInfo from class edge
        System.out.println("Line Length: " + ILength);
    }

    public int getILength() {
        return ILength;
    }

    public void setILength(int ILength) {
        this.ILength = ILength;
    }
    
    
    
}
