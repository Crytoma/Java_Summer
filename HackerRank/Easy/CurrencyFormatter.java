package HackerRank.Easy;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyFormatter
{
    public static void main(String[] args) 
    {
        formatter(12324.134);

    }

    public static void formatter(double payment)
    {
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        Locale lcl = new Locale("en", "IN");
        String india = NumberFormat.getCurrencyInstance(lcl).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);


        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    }
}