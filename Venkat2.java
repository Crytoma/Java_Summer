//import java.util.Set;
import java.util.List;
import java.util.Arrays;

public class Venkat2 
{
    public static void main(String[] args) 
    {
        //Livelock (waiting for a piece of code that does not complete (may not))
        //Time outs in Java 9.
        List <Integer> numbers = Arrays.asList(1,2,3);

        //Cannot perform this
       // numbers.add(6); 

       //Only this 
       //numbers.add(0, 6);

        //Instead we do this.
        List <Integer> numbers2 = List.of(1,2,3);

        //Works.


        //First list is immutable
        System.out.println(numbers.getClass());
        System.out.println(numbers2.getClass());

        //Cannot gaurantee order thus flips. sometimes.
       // Set <String> testSet = Set.of("First", "Second");
       // System.out.println(testSet);

        

        //JShell
        

        //Java 10.
        

    }

    
}