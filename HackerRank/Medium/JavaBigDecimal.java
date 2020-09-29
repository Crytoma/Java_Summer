package HackerRank.Medium;

import java.util.*;

public class JavaBigDecimal 
{
    public static void main(String[] args) 
    {
        System.out.println(bigDecimal(9, new int [] {10,20,20,10,10,30,50,10,20}));
    }

    private static int bigDecimal(int n, int [] ar)
    {
        int pairs = 0;
        int count = 0;

        int pos = 0;
        int value = ar[pos];

        int [] valuesTaken;
    
    for (int j = 0; j < 2; j ++)
    {
        for (int i = 0; i < ar.length; i++)
        {           
            if (ar[i] == value && i != pos)
            {
                count += 1;
            }
        }
        pos += 1;
    }
        return count;
    }  
}