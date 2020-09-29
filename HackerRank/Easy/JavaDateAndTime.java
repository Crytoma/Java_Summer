//Kacper Rajchel : : 29/05/2020

package HackerRank.Easy;

import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.util.*;

public class JavaDateAndTime 
{
    
    public static void main(String [] args) 
    {
        int day = 5;
        int month = 8;
        int year = 2015;

      findDay(day, month, year);
    }


    public static void findDay(int day, int month, int year)
    {    
        Calendar calendar = new GregorianCalendar(year, month, day);
        String [] weekdays = new DateFormatSymbols().getWeekdays();
        System.out.println(weekdays[calendar.get(Calendar.DAY_OF_WEEK)]);
        List <String> crap = Arrays.asList(weekdays);

        for (String d : crap)
        {
            System.out.println(d);
        }
    }

}
