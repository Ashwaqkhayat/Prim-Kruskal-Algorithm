
package PhoneNWDesignApp;

import GraphFramework.Vertex;

/**
 *
 * @author Ashwaq, Jetana, Hasna, Wajd
 */
public class Office extends Vertex{
    
    public Office (String label){
        super(label);
        this.label = label; 
    }
    
    public void SetLabel(){
         
    }
    
    @Override 
    public void displayInfo(){// the implementation of the method displayInfo from class vertex
        
        System.out.println("OfficeNo. " + label);
        
    }
    
}
