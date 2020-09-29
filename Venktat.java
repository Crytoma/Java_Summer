//Kacper Rajchel : : 01/06/2020

import java.util.*;
import java.util.stream.IntStream;

public class Venktat 
{
    public static void main(String[] args) 
    {
        //Shared mutability is bad. Evil.
        List <Integer> numbers = Arrays.asList(2,435,2,324,21,321,4216,768,5);
        

        /*A man is giving a long speech to a company about Java functional programming
        A man raises his hand and asks. Sir. You have been talking to us for 90 minutes is there a break.
        The man replies "There is no breaks in functional progarmming"
        */

        //Java 9 fixes this lack of break. Like Haskell (Gold standard functional programming)

        //Haskell has take(number) and break(number) AND takeWhile(Predicate) and dropWhile(Predicate)

        //Java uses limit(number) and skip(number) instead. Java also has takeWhile(Predicate) and dropWhile(predicate)

        //Imperative style uses - break
        //Functional style uses - takeWhile


        numbers.stream()
        .filter(e -> e % 2 == 0) //filter conditions 
        .skip(4) //Skips 4 elements
        .limit(1) //Limits to 1 iteration
        .forEach(System.out :: println);

        System.out.println();

        numbers.stream()
        .mapToInt(x -> x*2)
        .takeWhile(e -> e < 100) //Take element while it meets a condition (becomes false)
        //.dropWhile(x -> x > 500) //Skip until element meets condion (becomes true)
        .forEach(System.out :: println);



        //Java 8 example:
        //Functional looping
        //Equivalent to < value (0 to 4)
        IntStream.range(0,5)
        //.takeWhile(e -> e > 3)
        .forEach(System.out :: println);
        
            
        //Equivalent to <= value (0 to 10)
        IntStream.rangeClosed(0,10)
        .forEach(System.out :: println);


        
            //for (int i = 0; i <=55; i = i +5)
            //for (seed; Predicate; Function)


            //Java 9 imperitive style functional loop
            //Notice how it works too.
            IntStream.iterate(0, i -> i <=55, i -> i +5)
            .forEach(System.out :: println);


            System.out.println();


            //Q: How do we do this functionally without a predicate?
            for (int i = 0; ; i= i +5)
            {
                if (i > 20)
                {
                    break;
                }
                System.out.println(i);
            }

            System.out.println();

            //A: Java 9 iterate does not need a predicate!
            //iterate(seed, [predicate,], function)
            IntStream.iterate(0, i -> i + 5)
            .takeWhile(e -> e <= 20) //Eqv to break if 
            .forEach(System.out :: println);

System.out.println();


            process(numbers.stream()
            .filter(e -> e > 5)
            .findFirst());
            System.out.println("------");

    }

    public static void process(Optional <Integer> result)
    {
           //Optional object or reference check.
           List <Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

           //Don't use Optional <T> only an override of empty or not empty
           //Don't use get() function is the same as orElseThrow() or orElse("Not found!")

           //Imperative style exists function check
  /*         if (result.isPresent())
           {
               System.out.println("The value is " + result.OrElse(0));
           }
           else
           {
               System.out.println("No value found.");
           }
           */

           //Functional style check. Where is the else??
           result.ifPresent(value -> System.out.println("The value is " + value));

           result.ifPresentOrElse(
               value -> System.out.println("Value is " + value),
               () -> System.out.println("No value"));

               //Mapping is morally wrong.
               

    }

}