package HackerRank.Easy;

import java.util.*;

//Kacper Rajchel :: 25/06/2020
class ArraysLeftRotation 
{
    public static void main(String[] args) 
    {
        //Rotate a given array d amount of places to the left.
        int [] a = {1, 2, 3, 4, 5};
        int d = 2;

        int [] returned = rotLeft(a, d);

        for (int i = 0; i < returned.length; i++) {
            System.out.print(returned[i] + " ");
        }

        System.exit(0);
    }

    static int [] rotLeft(int [] array, int d)
    {
        for (int i = 0; i < d; i++) 
        {
            array = rotateOnce(array);
        }
        return array;
    }

    static int [] rotateOnce(int [] array)
    {
        int head = array[0];
        
        for (int i = 0; i < array.length; i++)
        {
            if (i+1 >= array.length)
            {
                array[array.length-1] = head;
            }
            else
            {
                array[i] = array[i+1];
            }
        }
        return array;
    }
}


