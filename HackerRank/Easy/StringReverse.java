package HackerRank.Easy;

import java.util.*;

public class StringReverse 
{

    public static void main(String [] args)
    {
    Palindrome("madam");
    }

    public static void Palindrome(String A)
    {
        String pp = new StringBuilder(A).reverse().toString();

        if (A.equals(pp)) {System.out.println("Yes");}
        else {System.out.println("No");}
    }
}
