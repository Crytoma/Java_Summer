package HackerRank.Easy;


abstract class Book
{
    String title;

    abstract void setTitle(String s);
    
    String getTitle()
    {
        return title;
    }
}

class MyBook extends Book
{
    void setTitle(String title)
    {
        this.title = title;
    }
}

public class JavaAbstractClass {
    public static void main(String[] args) {
        String title = "Swag";
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: " + new_novel.getTitle());
    }
    
}