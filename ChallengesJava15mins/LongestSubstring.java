package ChallengesJava15mins;

public class LongestSubstring 
{
    public static void main(String[] args) 
    {
        String str = "abcabcbb";

        String word = "";

        for (int i = 0; i < args.length; i++) 
        {
            try {
                if (str.charAt(+1) != str.charAt(i))
                {
                    word += str.charAt(i);
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        System.out.println(word);
    }
}