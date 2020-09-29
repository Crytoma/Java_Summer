import java.util.*;

//Kacper Rajchel : : 31/05/2020

public class threading 
{
    public static void main(String[] args) 
    {
        List <Integer> numbers  = Arrays.asList(1,2,4,5,2,4,21421,3123,1312,312,321,31);
        
        IntSummaryStatistics nums =
        numbers
        .stream()
        .mapToInt((x) -> x)
        .summaryStatistics();
    }    
}