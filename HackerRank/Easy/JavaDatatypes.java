package HackerRank.Easy;
public class JavaDatatypes 
{
    public static void main(String[] args) 
    {
        checkFit(2147483648l);
    }
        public static void checkFit(long x)
        {
            try
            {
                System.out.println(x + " can be fitted in:");
                if (x >=-128 && x <= 127)System.out.println("* byte");
                if (x >= -32768 && x <= 32767)System.out.println("* short");
                if (x >= -2147483648 && x <= 2147483647) System.out.println("* int");
                if (x >= -(Math.pow(2, 63)) && x <= Math.pow(2, 63)-1)System.out.println("* long");
            }

            catch(Exception e)
            {
                System.out.println(x + " can't be fitted anywhere.");
            }
    }
}