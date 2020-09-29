public class snail 
{
    public static void main(String[] args) 
    {   
        //Flag for reaching top of pole.
        boolean reachedTopOfPole = false;
        //Current snail height in meters.
        int currentHeight = 0;
        //current day of climb.
        int currentDay = 1;
        //Height of pole.
        int h = 10;
        //Ascend during day.
        int a = 3;
        //Descend during night.
        int b = 2;

        //While we have not reached the top.
        while (reachedTopOfPole != true)
        {
            if (currentHeight + a >= h)
            {
                System.out.println("Ladies and gentlemen. The snail has reached the summit.");
                reachedTopOfPole = true;
            }
            else
            {
                currentHeight += (a - b);
                System.out.println("Day " + currentDay + " height is " + currentHeight + " meters");
                currentDay += 1;
            }
        }
        System.out.println("The snail has reached the top of the pole on day " + currentDay);
    }
}