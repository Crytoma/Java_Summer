package ChallengesJava15mins;

public class ReverseString 
{
    public static void main(String[] args) 
    {
        char [] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};

        reverseMe(s);
    }

    private static void reverseMe(char [] str)
    {
        char c = ' ';
        String word = "";
        int totalLength = 0;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ')
            {
                totalLength += 1;
            }
        }

        int pos = totalLength;
        String [] words = new String [totalLength+1];

        for (int i = 0; i < str.length; i++) 
        {
            c = str[i];
            
            if ( str[i] != ' ')
            {
                word += c;
            }

            else
            {
                words[pos] = word;
                pos -= 1;
                word = "";
            }
        }

        words[pos] = word;
        pos -= 1;
        word = "";

        for (int i = 0; i < words.length; i++) 
        {
            System.out.print(words[i] + " ");   
        }
    }
}