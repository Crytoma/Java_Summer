package Princeton_Algorithms_Part1;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

//Kacper Rajchel :: 18/06/2020

public class Percolation 
{
    public static void main(String[] args) 
    {
        /*Percolation can be modelled to a physical system. N by N grid of sites.
        ###0#
        #000#
        ##0##
        Percolation is possible above. Open site at bottom and top traversable aka can percolate.*/
        int openOrClosed = 0;
        int [] [] grid = new int [5] [5];

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                openOrClosed = ThreadLocalRandom.current().nextInt(0,3);
                if (openOrClosed == 0 || openOrClosed == 2) {grid[i][j] = 0;}
                else if (openOrClosed == 1) {grid[i][j] = 1;}
            }
        }


        printGridAltered(grid);

       
        System.exit(0);
    }

/*

    private static void percolationV1(int [] [] nodeArray)
    {
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

    }
*/




















    






    private static void printGridRaw(int [][] grid)
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        } 

        System.out.println();
        printGridAltered(grid);
    }

    private static void printGridAltered(int [][] grid)
    {
        int count = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                grid[i][j] = count;
                System.out.print(grid[i][j]);
                count += 1;
            }
            System.out.println();
        } 
        System.out.println();
    }


} // End of Percolation class.