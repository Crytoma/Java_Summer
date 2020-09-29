package HackerRank.Medium;

/*
DATE: 20/05/2020
Purpose: Calculate and return the two largest valid pliuses that can be drawn on good cells in the newGrid + 
return an integer denoting the maximum product of the areas of the pluses. 
Author: Kacper M Rajchel
*/

public class EmmasSuperComputer
{
    public static void main(String [] arguments) 
    {
        String [] grid2 = new String [] 
        {
        "6",  
        "6",
        "BGBBGB", //2
        "GGGGGG", //3
        "BGBBGB", //4
        "GGGGGG", //5
        "BGBBGB", //6
        "BGBBGB"
                };

        String [] grid1 = new String [] 
        {
        "5", 
        "6",
        "GGGGGG",
        "GBBBGB",
        "GGGGGG",
        "GGBBGB",
        "GGGGGG"
                };
    
        //System.out.println(twoPluses(newGrid));
        System.out.println(plusesV2(grid2));
        System.exit(0);
    }

    private static int plusesV2(String [] grid)
    {

     int expansion = 0;
    int largestPlus = 0;
     int largestPlusX = 0;
     int largestPlusY = 0;
     int secondLargestPlus= 0;
     int sPlusX = 0;
     int sPlusY = 0;




        for (int y = 2; y < Integer.parseInt(grid[0]) + 2; y++) 
        {
            for (int x = 0; x < Integer.parseInt(grid[1]); x++) 
            {
                if (grid[y].charAt(x) == 'G')
                {   expansion = 0;
                    while (expandable(y, x, grid, expansion) == true)
                    {
                        //System.out.println("A " + (4*expansion + 1) + " size plus is possible at: " + "y: " + y + " , " + "x: " + x); 
                        if (expansion*4+1 >= largestPlus) {largestPlus=expansion*4+1; largestPlusX = x; largestPlusY = y;}
                        if (largestPlusX != x && largestPlusY != y && expansion*4+1 < largestPlus) {secondLargestPlus = expansion*4+1; sPlusX = x; sPlusY = y;}
                        expansion += 1;
                    }
                }
            }
            //System.out.println();
        }
        //System.out.println("Largest plus is of size: " + largestPlus + " at position: y: " + largestPlusY + " x: " + largestPlusX);
        //System.out.println("Second largest plus is of size: " + secondLargestPlus + " at position: y: " + sPlusY + " x: " + sPlusX);
        return largestPlus * secondLargestPlus;
    }

    private static boolean expandable(int y, int x, String [] grid, int expansion)
    {
        boolean canExpand = false;

        try {
            if (grid[y].charAt(x - expansion) == 'G' && grid[y].charAt(x + expansion) == 'G' && grid[y - expansion].charAt(x) == 'G' && grid[y + expansion].charAt(x) == 'G')
            {
                canExpand = true;
            }
        } catch (Exception e) {
            canExpand = false;
        }

        return canExpand;
    }









    private static void pluses(String [] grid)
    {
        int gridHeight = Integer.parseInt(grid[0]);
        int gridWidth = Integer.parseInt(grid[1]);

        String [] startingGrid2 = new String [] 
        {
        "6",  
        "6",
        "BGBBGB", //2
        "GGGGGG", //3
        "BGBBGB", //4
        "GGGGGG", //5
        "BGBBGB", //6
        "BGBBGB"
                };


        int largestPlus = 0;
        int expansion = 0;
        int secondLargestPlus = 0;


        //Find pluses in grid array.
        for (int i = 2; i < gridHeight; i++)
        {
            for (int j = 0; j < gridWidth; j++)
            {
                if (grid[i].charAt(j) == 'G')
                {
                    try 
                    {
                        expansion = 0;

                        while (expansion != 5)
                        {
                            if (grid[i].charAt(j-expansion) == 'G' && grid[i].charAt(j+expansion) == 'G' && grid[i-expansion].charAt(j) == 'G' && grid[i+expansion].charAt(j) == 'G')
                            {
                                //A 5 size plus is possible thus we go further.
                                System.out.println("A " + (4*expansion + 1) + " size plus is possible at: " + "y: " + i + " , " + "x: " + j); 
                            }
                            expansion += 1;
                        }

                    } catch (Exception e) 
                    { 
                        System.out.println("Expansion of size " + ((expansion * 4) + 1) + " from center point failed at " + "y: " + i + " , " + "x: " + j);
                        System.out.println();
                    }
                }
            }
        }
        System.out.println(largestPlus);
    }

   


}





/*
NOTES::

    Grid size = n * m
    Valid Plus = "Crossing of two segments h, v of equal lengths with odd lengths."
    AKA: Built a program that justifies an expanding net from the center square in 4 sides good or bad.

                    +
    Good = +++
                    +

                    +
    Bad = ++++
                    +

    Goal: Find the two largest "pluses" and return an integer denoting the maximum product of their areas. 
    Eg.. Largest pluses may be of area 5 (example Good above) and 9 being bigger...
    Product  = 5x9 = 45.
    If char[i] == g its good else bad.
    NOTE: Two pluses cannot overlap and their product areas should be maximal.

*/
/*

    private static int pluses(String [] grid)
    {
            //New grid without numbers.
        String [] newGrid = Arrays.copyOfRange(grid, 2, grid.length);
        
        int height  = Integer.parseInt(grid[0]);
        int width  = Integer.parseInt(grid[1]);


        char [] [] newCharGrid = new char [height] [width]; 

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                newCharGrid[i][j] = newGrid[i].charAt(j);
                System.out.print(newGrid[i].charAt(j));
            }   
            System.out.println(); 
        }
        System.out.println();

        */

 /*       int plusSpan = 0;
        int plusArea = 0;
        int largestPlus = 1;
        int secondLargestPlus = 0;
        int x = 0;
        int y = 0;


        for (int i = 0 + plusSpan; i < height - plusSpan; i++)
        {
            for (int j = 0 + plusSpan; j < width - plusSpan; j++)
            {
                if (newCharGrid[i][j] == 'G')
                {
                    if (newCharGrid[i-plusSpan][j] == 'G' && newCharGrid[i+plusSpan][j] == 'G' && newCharGrid[i][j-plusSpan] == 'G' && newCharGrid[i][j+plusSpan] == 'G')
                    {
                        plusArea = ((plusSpan) * 4  + 1);
                        System.out.println("We found a 'good' plus of area: " + plusArea + " at y: " + i + " x: " + j);

                      
                                boolean succeed = true;

                                while (succeed)
                                {
                                    int forceSpan = 0;

                                    if (newCharGrid[i-forceSpan][j] == 'G' && newCharGrid[i+forceSpan][j] == 'G' && newCharGrid[i][j-forceSpan] == 'G' && newCharGrid[i][j+forceSpan] == 'G')
                                    {
                                        plusArea = ((plusSpan) * 4  + 1);
                                        System.out.println("We found a 'good' plus of area: " + plusArea + " at y: " + i + " x: " + j);
                                        forceSpan += 1;
                                    }
                                    else
                                    {
                                        succeed = false;
                                    }
                                }
                                
                     
                        if (plusArea > largestPlus)
                        {
                            largestPlus = plusArea;
                            x = j;
                            y = i;
                        }
                    }
                }
            }
        }


int plusSpan = 0;
int plusArea = 0;
int largestPlus = 1;
int secondLargestPlus = 0;
int x = 0;
int y = 0;


        
        for (int i = 0 + plusSpan; i < height - plusSpan; i++)
        {
            for (int j = 0 + plusSpan; j < width - plusSpan; j++)
            {
                if (newCharGrid[i][j] == 'G')
                {

                   

                    while (plusSpan != 15)
                    {
                                        
                                    if (newCharGrid[i-plusSpan][j] == 'G' && newCharGrid[i+plusSpan][j] == 'G' && newCharGrid[i][j-plusSpan] == 'G' && newCharGrid[i][j+plusSpan] == 'G')
                                    {
                                        plusArea = ((plusSpan) * 4  + 1);
                                        System.out.println("We found a 'good' plus of area: " + plusArea + " at y: " + i + " x: " + j);
                                        
                                    }

                                    plusSpan += 1;
                                
                                
                    }  
                     

                        if (plusArea > largestPlus)
                        {
                            largestPlus = plusArea;
                            x = j;
                            y = i;
                        }
                    }
                }
            }

        System.out.println();
        
        return 0;
    }    
}//End of EmmasSuperComputer class.



*/
