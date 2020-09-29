package HackerRank.Easy;
//Kacper Rajchel :: 25/06/2020
class TwoDArrayDS 
{
    //Given a 6x6 2d array caluclate the max hour glass sum.

    public static void main(String[] args) 
    {

        int [][] arr = 
        {
        {-9, -9, -9, -9, -9, -9},
        {-9, -9, -9, -9, -9, -9},
        {-9, -9, -9, -9, -9, -9},
        {-9, -9, -9, -9, -9, -9},
        {-9, -9, -9, -9, -9, -9},
        {-9, -9, -9, -9, -9, -9}
        };

        System.out.println(hourglassSum(arr));

        System.exit(0);
    }

    static int hourglassSum(int [][] arr)
    {
        int largesthourglassSum = -63;

        for (int y = 0; y <= arr.length; y++) 
        {
            for (int x = 0; x <= arr.length; x++) 
            {
                if (checkHourGlassSum(arr, y, x) >= largesthourglassSum)
                {
                    largesthourglassSum = checkHourGlassSum(arr, y, x);
                }
            }
        }
        return largesthourglassSum;
    }

    static int checkHourGlassSum(int [] [] arr, int y, int x)
    {
        //-63 due to the lowest possible case being -63.
        int sum = -63;

        try 
        {
            sum = arr[y][x] + arr[y-1][x-1] + arr[y-1][x] + arr[y-1][x+1] + arr[y+1][x-1] + arr[y+1][x] + arr[y+1][x+1];

        } catch (Exception e) 
        {
            //Keep trying.
        }
        return sum;
    }
}