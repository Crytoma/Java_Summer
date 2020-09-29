package Princeton_Algorithms_Part1;

//Kacper Rajchel :: 17/06/2020

public class ModellingConnectionsMySolution
{
    public static void main(String[] args) 
    {
        //Own version to test brain.
        int [] [] nodes = new int [] []
        {{0}, 
        {1,4,5}, 
        {2,3,6,7}};
        System.out.println("Below is the set of nodes and respective sets you are working with:");
        printNodes(nodes);
        //Chekcing node 1 and 4 which ARE connected.
        connected(1, 5, nodes);
        //Create a union between existing nodes. Effectively changing the array
        nodes = union(2, 5, nodes);
        //Print out the sets to check union.
        printNodes(nodes);
        System.exit(0);
    }
    //Check if the nodes are connected 1 - 1
    public static boolean connected(int a, int b, int [] [] nodes)
    {
        System.out.println("Checking for connection between node " + a + " and node " + b + "\n...");

        boolean connected = false;
        for (int i = 0; i < nodes.length; i++)
        {//Iterate over 1st dimension of 2D array
            for (int j = 0; j < nodes[i].length; j++)
            { //Iterate over sub array contents and if a exists.
                if (nodes[i][j] == a)
                {//Iterate over sub array again.
                    for (int t = 0; t < nodes[i].length; t++)
                    {//Check if the node exists in the same set and if distance node a and node b is 1.
                        if (nodes[i][t] == b && j - t == 1)
                        {
                            connected = true;
                        }
                    }
                }
            }
        }
        if (connected == true)
        {
            System.out.println("Conclusion: Node " + a + " is connected with node " + b);
        }
        else
        {
            System.out.println("Conclusion: Connection between node " + a + " and node " + b + " does not exist");
        }
        return connected;
    }

    //Create a union between nodes a and b and return joined arrray.
    //Hassle due to "jagged array" problem.
    public static int [] [] union(int a, int b, int [] [] nodes)
    {
        int nodeASubArrayIndex = 0;
        int nodeBSubArrayIndex = 0;
        int sizeOfJoinedSubArrays = 0;

        for (int i = 0; i < nodes.length; i++)
        {
            for (int j = 0; j < nodes[i].length; j++)
            {
                if (nodes[i][j] == a)
                {
                    nodeASubArrayIndex = i;
                }
                if (nodes[i][j] == b)
                {
                    nodeBSubArrayIndex = i;
                }
            }
        }

        sizeOfJoinedSubArrays = nodes[nodeASubArrayIndex].length + nodes[nodeBSubArrayIndex].length;

        //Initialising due to "jagged array" problems.
        int [] [] newJoinedNodeArray = new int [2][];
        newJoinedNodeArray[0] = new int [nodes[0].length];
        newJoinedNodeArray[1] = new int [sizeOfJoinedSubArrays];

        int pos = 0;
        for (int i = 0; i < nodes.length; i++)
        {
            for (int j = 0; j < nodes[i].length; j++)
            {
                if (i == 0)
                {
                    newJoinedNodeArray[0][j] = nodes[0][j];
                }
                if (i == nodeASubArrayIndex)
                {
                    newJoinedNodeArray[1][pos] = nodes[nodeASubArrayIndex][j];
                    pos += 1;
                }
                if (i == nodeBSubArrayIndex)
                {
                    newJoinedNodeArray[1][pos] = nodes[nodeBSubArrayIndex][j];
                    pos += 1;
                }
            }
        }
        System.out.println("\nArray after union of node " + a + " node " + b);
        return newJoinedNodeArray;
    }
    
    //Print out the nodes and respective sets you are working with.
    public static void printNodes(int [] [] nodes)
    {
        for (int i = 0; i < nodes.length; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < nodes[i].length; j++)
            {
                System.out.print(" " + nodes[i][j] + " ");
            }
            System.out.print(" }   ");
        }
        System.out.println();
    }
}// End class.