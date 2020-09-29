package HackerRank.Easy;

public class Formatting {

    public static void main(String[] args) {

        System.out.println("================================");
        
        shit("java", 0);
        shit("cpp", 65);
        shit("python", 50);

        System.out.println("================================");
    }


    public static void shit(String s1, int x)
    {
        int length = String.valueOf(x).length();

        String v = "0" + x;

            if (length >= 3)
            {
                System.out.printf("%-15s%d\n", s1,x);
            }

            else if (length < 3)
            {
                while (v.length() != 3)
                {
                    v = "0" + v; 
                }
            System.out.printf("%-15s%s\n", s1, v);
            }


    }        
}