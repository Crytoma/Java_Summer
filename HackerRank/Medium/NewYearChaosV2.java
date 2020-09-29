package HackerRank.Medium;
// Kacper Rajchel :: 29/06/2020
public class NewYearChaosV2 
{
    public static void main(String[] args) 
    {
        int [] q = {2, 1, 5, 3, 4}; // 3
                          //  3 4 5
                          //  3 5 4
                          //  5 3 4

        int [] q2 = {2, 5, 1, 3, 4}; // too chaotic

       //Should be 4:     1 2 5 3 4 7 8 6

        int [] qError = {1, 2, 5, 3, 7, 8, 6, 4}; // should be 7

         minimumBribes(q);
    }

    // Calculate minimum number of queue bribes to get to the queue order.
    static void minimumBribes(int [] q)
    {
        boolean isQueueChaotic = false;
        int [] startingArray = copyArray(q.length);
        int [] positionalArray = positionArray(q.length);

        for (int i = 0; i < startingArray.length; i++) 
        {
            if (startingArray[i] != q[i])
            {
                for (int j = 0; j < startingArray.length; j++) 
                {
                    if (q[j] == startingArray[i])
                    {
                        positionalArray[i] = i-j;

                        if (i-j > 2)
                        {
                            isQueueChaotic = true;
                        }
                    }
                }
            }
        }
        if (isQueueChaotic == true)
        {
            System.out.println("Too chaotic");
        }
        else
        {
            calculateMinimumBribesV2(startingArray,q,  positionalArray);
        }
    } // end minimumBribes


    static void calculateMinimumBribesV2(int [] startingArray, int [] q, int [] positionalArray)
    {
        
    }

    
    //Calculate the minimum amount of bribes.
    static void calculateMinimumBribes(int [] startingArray,int [] currentQueue, int [] positionalArray)
    {
        int bribes = 0;
        int temp = 0;

        while (orderCheck(startingArray, currentQueue) == false)
        {
        for (int i = 0; i < startingArray.length; i++) 
        { 
            System.out.print("Starting Queue: "); printArray(startingArray);
            System.out.print("Pos Arr: "); printArray(positionalArray);

            if (positionalArray[i] == -2)
            {
                temp = startingArray[i+1];
                startingArray[i+1] = startingArray[i+2];
                startingArray[i+2] = temp;

                temp = startingArray[i];
                startingArray[i] = startingArray[i+1];
                startingArray[i+1] = temp;
                
                positionalArray = updatePositionalArray(startingArray, currentQueue);

                bribes += 1; 
            }

            else if (positionalArray[i] == 2)
            {
                temp = startingArray[i-1];
                startingArray[i-1] = startingArray[i-2];
                startingArray[i-2] = temp;

                temp = startingArray[i];
                startingArray[i] = startingArray[i-1];
                startingArray[i-1] = temp;
                
                positionalArray = updatePositionalArray(startingArray, currentQueue);

                bribes += 1;
            }
               
            else if (positionalArray[i] == -1)
            {
                temp = startingArray[i];
                startingArray[i] = startingArray[i+1];
                startingArray[i+1] = temp;

                positionalArray = updatePositionalArray(startingArray, currentQueue);
                
                bribes += 1;
            }
            else if (positionalArray[i] == 1)
            {
                temp = startingArray[i];
                startingArray[i] = startingArray[i-1];
                startingArray[i-1] = temp;

                positionalArray = updatePositionalArray(startingArray, currentQueue);

                bribes += 1;
            }
            else 
            {
                System.out.println("Found a 0");
            }

            System.out.println(bribes);

        }
    }
    //System.out.println(bribes);
    System.out.print("Ending Queue: "); printArray(startingArray);
    System.out.print("End Pos Arr: "); printArray(positionalArray);
}

    //Change positional array to update.
    static int [] updatePositionalArray(int [] startingArray, int [] currentQueue)
    {
        //System.out.print("Starting Queue: "); printArray(startingArray);

        int [] positionalArray = positionArray(startingArray.length);

        for (int i = 0; i < startingArray.length; i++) 
        {
            if (startingArray[i] != currentQueue[i])
            {
                for (int j = 0; j < startingArray.length; j++) 
                {
                    if (currentQueue[j] == startingArray[i])
                    {
                        positionalArray[i] = i-j;

                    }
                }
            }
        }
        //System.out.print("Positional Array: "); printArray(positionalArray);
        return positionalArray;
    }

    // Copy given array to a 1, 2, 3, 4... array.
    static int [] copyArray(int length)
    {
        int [] temp = new int [length];

        for (int i = 0; i < length; i++) 
        {
            temp[i] = i+1;
        }
        return temp;
    }

    // Return an empty array of 0's.
    static int [] positionArray(int length)
    {
        int [] temp = new int [length];

        for (int i = 0; i < length; i++) 
        {
            temp[i] = 0;
        }
        return temp;
    }

    static void printArray(int [] q)
    {
        for (int i = 0; i < q.length; i++) 
        {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

    // Check if arrays are equal.
    static boolean orderCheck(int [] startingArray, int [] currentQueue)
    {
        boolean ordered = true;

        for (int i = 0; i < currentQueue.length; i++) 
        {
            if (startingArray[i] != currentQueue[i])
            {
                ordered = false;
            }
        }
        return ordered;
    }

} // end NewYearChaosV2