package Princeton_Algorithms_Part1;

import java.util.Arrays;

//Kacper Rajchel :: 18/06/2020
//Node union api after course on algorithms implementing streams.

//Union find API
public class ModellingConnectionsWithHelp 
{
    public static void main(String[] args) 
    {
        //Quick-find:
        //Integer array id[] of length N.
        //Interpretation: p and q are connected iff (if and only if) they have the same id.
        //Find. Check if p and q have the same id.  (id[6] = 0; id[1] = 1)

        //Union
        //To merge components that contain p and q change all entries whose id = id[p] to id[q]
        //After union(6,1):

        //Imagine the array here only shows connections not the actual nodes.
        //As the nodes are the nodeArray[position]
        //Is 3 and 4 connected? Check pos 3 and 4. If not connect them by making 3 == 4.

        int [] nodeArray = createNodeArray(10);
        
        weightedQuickUnion(2, 4, nodeArray);
        printArray(nodeArray);

        System.out.println(connected(2, 4, nodeArray));

        printArray(nodeArray);

        System.exit(0);

    }

    public static int [] createNodeArray(int sizeOfArray)
    {
        int [] newNodeArray = new int [sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++)
        {
            newNodeArray[i] = i;
        } 
        return newNodeArray;
    }

    //Check if the nodes equal one another.
    public static boolean connected(int p, int q, int [] nodeArray)
    {
        {return nodeArray[p] == nodeArray[q];}
    }

    //Make A = B. Merging will regardlessly make element[a] == element[b]
    public static void union(int p, int q, int [] nodeArray)
    {
        int pID = nodeArray[p];
        int qID = nodeArray[q];

        for (int i = 0; i < nodeArray.length; i++)
        {
            if (nodeArray[i] == pID)
            {
                nodeArray[i] = qID;
            }
        }
    }

    //(Lazy approach) - collated methods aggregated.
    public static void quickUnion(int p, int q, int [] nodeArray)
    {
        //Make the root i is [id[id[id[i]]]] //if p and q root is the same they are connected else make //the root of q == root of p.
        boolean connected = false;

        //Finding roots of both nodes.
        //Follow parent pointer till p = nodeArray[at pos p]
        while (p != nodeArray[p] && q != nodeArray[q]) 
        {
            p = nodeArray[p]; 
            q = nodeArray[q];
        }

        //Setting the root values of p,q
        int rootOfP = p; 
        int rootOfQ = q;

        //Connection check between two node roots.
        if (rootOfP == rootOfQ) 
        {
            connected = true; 

            if (connected == false) 
            {
                nodeArray[rootOfP] = nodeArray[rootOfQ];
            }
        }
    }


    //Further improved 
    // - Modified to avoid tall trees.
    // - Keep track of size of each tree (number of objects)
    // - Balance by linking root of smaller tree to root of larger tree. (union by height or rank)
    public static void weightedQuickUnion(int p, int q, int[] nodeArray)
    {
        //Data structure:
        // - Same as quick union but an extra array is maintained to count number of objects in the tree rooted at i.

        //Find:
        //  - Identical to previous solution.

        //Union:
        //  - Link root of smaller tree to root of larger tree.
        //  - Update the size[] array.

        //Thus running time at FIND = time proportional to depth of p and q roots.
        //UNION time constant time given the roots.

        //Proposition: Depth of any node x is at most log N (base-2 logarithm) (N = 10, depth(x) = 3 <= logN)

        //IMPROVEMENT 2:
        //Path Compression.
        //  - Just after computing the root of p. set the ID of each examined node to point to that root.
         //Make the root i is [id[id[id[i]]]] //if p and q root is the same they are connected else make //the root of q == root of p.
         boolean connected = false;

         while (p != nodeArray[p] && q != nodeArray[q]) 
         {
             nodeArray[p] = nodeArray[nodeArray[p]]; //Make every other node in path point to its grandparent. Halving path length.
             nodeArray[q] = nodeArray[nodeArray[q]];
             p = nodeArray[p]; 
             q = nodeArray[q];
         }
 
         int rootOfP = p; 
         int rootOfQ = q;
 
         if (rootOfP == rootOfQ) 
         {
             connected = true; 
 
             if (connected == false) 
             {
                 nodeArray[rootOfP] = nodeArray[rootOfQ];
             }
         }


         //APPLICATIONS:
         // - Percolation, games etc. GO.
     }

    //Print out array.
    public static void printArray(int [] array)
    {
        Arrays
        .stream(array)
        .forEach(e -> System.out.print(e));
        System.out.println();
    }
}