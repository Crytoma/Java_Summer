package HackerRank.Medium;

// Kacper Rajchel :: 26/06/2020

class NewYearChaos 
{
    static int bribes;

    public static void main(String[] args) 
    {
        // Normal and permissable q
        int q [] = {2, 1, 5, 3, 4};

        // q that is deeemed chaotic
        int queue2 [] = {2, 5, 1, 3, 4};


        int queueEasy [] = {2, 1, 3, 5, 4};


        // An element may bribe a neighbour and switch places.
        // Only 2 bribes are permissable or else the q is deemed
        // as chaotic. Else - return the minimum number of bribes possible
        // to form the q if not deemed chaotic.
        minimumBribes(q);
        System.exit(0);
    }

    static void minimumBribes(int [] q)
    {
        
        
        int highestIllegalBribe = 0;
        // Must check disalllocation span between elements. 
        // if span > 2 the bribe is illegal as amount of bribes is > 2 thus chaotic.
        // First check difference of 2 between starting q and given q.
        int [] startingQueue = {1, 2, 3, 4, 5};

        for (int i = 0; i < startingQueue.length; i++) 
        {
            for (int j = 0; j < startingQueue.length; j++) 
            {
                if (startingQueue[i] == q[j])
                {
                    if (Math.abs(i-j) > 2)
                    {
                        highestIllegalBribe = Math.abs(i-j);
                        System.out.println("Too chaotic");
                    }
                }  
            }
        }

        

        // I would suggest to start from the end of the q
        // and check disposition of each element in terms of movement.
        if (highestIllegalBribe < 3)
        {
            
            while (!checkEquality(startingQueue, q))
            {
                startingQueue = calculateBribeStep(startingQueue, q);

            }
            System.out.println(bribes);
        }
    }


    

    // Brute force first to try randomise movements in array.
    // If the element is out of position we should check the span of it.
    // Then add the span to number of swaps.

    // Perform a swap then simulate it to check for
    // minimum amount of swaps for validity.

    static boolean checkEquality(int [] startQueue, int [] q)
    {
        boolean equal = true;

        for (int i = 0; i < q.length; i++) 
        {
            if (startQueue[i] != q[i])
            {
                equal = false;
            } 
        }
        return equal;
    }

    static int [] calculateBribeStep(int [] startQueue, int [] q)
    {
        int posDif = 0;
       
        for (int i = 0; i < startQueue.length; i++) 
        {
            if (startQueue[i] != q[i])
            {
                for (int j = 0; j < q.length; j++) 
                {
                    // Encounter the elements and calculate difference in position
                    if (startQueue[i] == q[j])
                    {
                        posDif = i-j;
                        //Meaning the swap is from right to left.
                        if (posDif == -1)
                        {
                            int temp = startQueue[i];
                            startQueue[i] = startQueue[i+1];
                            startQueue[i + 1] = temp;
                            bribes += 1;
                        }
                        else if (posDif == -2)
                        {
                            int temp = startQueue[i];
                            startQueue[i] = startQueue[i+1];
                            startQueue[i + 1] = temp;

                            temp = startQueue[i];
                            startQueue[i] = startQueue[i-1];
                            startQueue[i-1] = temp;

                            bribes += 2; 
                        }
                        else if (posDif == 1)
                        {
                            int temp = startQueue[i];
                            startQueue[i] = startQueue[i-1];
                            startQueue[i - 1] = temp;

                            bribes += 1;
                        }

                        else if (posDif == 2)
                        {
                            int temp = startQueue[i];
                            startQueue[i] = startQueue[i-1];
                            startQueue[i -1] = temp;

                            temp = startQueue[i];
                            startQueue[i] = startQueue[i+1];
                            startQueue[i+1] = temp;

                            bribes += 2; 
                        }
                    }
                }
            }
        }
        return startQueue;
    }

} // end NewYearChaos