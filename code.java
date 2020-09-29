import java.util.concurrent.ThreadLocalRandom;

public class code 
{
    public static void main(String[] args) {
        int rand = 0;

        for (int i = 0; i <= 64; i++)
        {   
            for (int j = 0; j <= 200; j++)
            {
                rand = ThreadLocalRandom.current().nextInt(0,3);
                if (rand == 0) {System.out.print("0");}
                else if (rand == 1) {System.out.print("1");}
                else if (rand == 2) {System.out.print(" ");}
            }
            rand = ThreadLocalRandom.current().nextInt(0,3);
            if (rand == 0) {System.out.println("0");}
            else if (rand == 1) {System.out.println("1");}
            else if (rand == 2) {System.out.println(" ");}
        }
    }
}