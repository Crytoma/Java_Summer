package ChallengesJava15mins;

// Kacper Rajchel :: 16/07/2020
// Leet Code

 // Definition for singly-linked list.
class ListNode 
{
    int val;
    ListNode next;

    ListNode() 
    {

    }

    ListNode(int val) 
    {
        this.val = val; 
    }

    ListNode(int val, ListNode next) 
    {
        this.val = val; 
        this.next = next; 
    }
 }
 
public class AddTwoLinkedLists 
{
    public static void main(String[] args) 
    {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        new ListNode(2);
        new ListNode(4, l1);
        new ListNode(3, l1);

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        System.out.println(l1.val);

        
        l1.next = l1;

        System.out.println(l1.val);
    
       ListNode sum = new ListNode();

       return sum;        
    }
}