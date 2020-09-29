package HackerRank.Easy;

import java.util.stream.IntStream;

interface AdvancedArithmetic
{
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic
{
    public int divisor_sum(int n) 
    {
        int sum = 0;

        for (int i = 1; i <= n; i ++)
        {
            if (n % i == 0)
            {
                sum += i;
            }
        }
        
        return sum;
/*

        IntStream.iterate(0, i -> i <= 6, i -> i+=1)
        .takeWhile(e -> e %  == 0)
        .forEach(System.out :: println);*/
    }
}

public class JavaInterface 
{
    public static void main(String[] args) 
    {
        
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        int n = 6;
        System.out.print(my_calculator.divisor_sum(n) + "\n");
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class [] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}