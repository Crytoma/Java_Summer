package HackerRank.Easy;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Anagrams 
{
   

    public static void Anagram(String a, String b)
    {
        char [] arrayA = a.toLowerCase().toCharArray();
        char [] arrayB = b.toLowerCase().toCharArray();

        HashMap <Character, Integer> stringA = new HashMap<>();
        HashMap <Character, Integer> stringB = new HashMap<>();

        for (char c : arrayA)
        {
            if (stringA.containsKey(c))
            {
                stringA.put(c, stringA.get(c) + 1);
            }
            else
            {
                stringA.put(c, 1);
            }
        }

        for (char c : arrayB)
        {
            if (stringB.containsKey(c))
            {
                stringB.put(c, stringB.get(c) + 1);
            }
            else
            {
                stringB.put(c, 1);
            }
        }

        stringA.forEach((k, v) -> System.out.println(k + " : " + (v)));
        System.out.println();
        stringB.forEach((k, v) -> System.out.println(k + " : " + (v)));
    
        boolean isAnagram = false;

        //IntStream.iterate(0, i -> i < stringA.size(), i -> i++)
        





        
            
    }




    public static void main(String[] args) 
    {
        String a  = "Hello";
        String b = "hello";

        Anagram(a, b);
    }







}