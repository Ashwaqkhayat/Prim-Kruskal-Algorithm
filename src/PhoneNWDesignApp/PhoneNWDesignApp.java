package PhoneNWDesignApp;

import GraphFramework.KruskalAlg;
import GraphFramework.MHPrimAlg;
import java.io.File;
import java.util.Scanner;

public class PhoneNWDesignApp {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // Print welcoming statements
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("Welcome to our program to display MST using\ntwo Algorithms >> ");
        System.out.println("Kruskal Algorithm & Min-Heap Prim Algorithm");
        System.out.println("===============================================");
        System.out.println("===============================================");
        System.out.println("--> Requirement 1: Run Kruskal's & Prim's Algorithm on an input file" +
                "\n--> Requirement 2: Run Kruskal's & Prim's Algorithm on a randomly generated graph");
        System.out.print("\n>> Which requirement do you want to run (1|2)? ");
        BluePrintsGraph graph;
        int choice = sc.nextInt();
        if(choice==1){ //Read graph from file
            graph = new BluePrintsGraph();
            File f = new File("Graph.txt");
            graph.readGraphFromFile(f);
        }else{ // Generate random graph
            //The required test cases 
            graph = new BluePrintsGraph(1000, 10000, false);// 1st test case
            //BluePrintsGraph graph = new BluePrintsGraph(1000,15000,false);// 2nd test case
            //BluePrintsGraph graph = new BluePrintsGraph(1000,25000,false);// 3rd test case
            //BluePrintsGraph graph = new BluePrintsGraph(5000,15000,false);// 4th test case
            //BluePrintsGraph graph = new BluePrintsGraph(5000,25000,false);// 5th test case
            //BluePrintsGraph graph = new BluePrintsGraph(10000,15000,false);// 6th test case
            //BluePrintsGraph graph = new BluePrintsGraph(10000,25000,false);// 7th test case
            graph.makeGraph();
        }

        // Applying Kruskal's Algorithm
        KruskalAlg krus = new KruskalAlg(graph);
        long start = System.currentTimeMillis();//Start time
        krus.Kruskal();
        long end = System.currentTimeMillis();//End time      
        krus.displayResultingMST();
        System.out.println();
        System.out.println("The runing time in millisecond using Kruskal Algorithm");
        long time = end - start;
        
        System.out.println("Running Time: " + time + " mseconds");  
        System.out.println("\n===============================================\n");
        
        // Applying Prim's Algorithm
        MHPrimAlg prim = new MHPrimAlg(graph);
        start = System.currentTimeMillis();//Start time
        prim.Prim();
        end = System.currentTimeMillis();//End time      
        prim.displayResultingMST();
        System.out.println();
        System.out.println("The runing time in millisecond using Min-heap Prim Algorithm");
        time = end - start;
        System.out.println("Running Time: " + time + " mseconds");

    }

}
