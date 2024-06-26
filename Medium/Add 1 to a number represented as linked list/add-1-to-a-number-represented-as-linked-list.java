//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverse(Node head){
        
        Node prev = null;
        
        Node current = head;
        
        Node nextNode = head;
        
        while(nextNode != null){
            
            nextNode = nextNode.next;
            
            current.next = prev;
            
            prev =  current;
            
            current = nextNode;
        }
        
        head = prev;
        
        return head;
    }
    
    public static Node addOne(Node head) 
    { 
        //code here.
        
        if(head == null){
            return head;
        }
        
        if(head.next == null){
            int h = head.data +1;
            head.data = h;
            return head;
        }
        
        
        head = reverse(head);
         
        Node temp = head;
        
    
        
        int carry = 1;

        while (temp != null) {

            int bata = temp.data + carry;

            carry = bata / 10;

            bata %= 10;

            temp.data = bata;
            
            if (carry == 0) {
                break;
            }
            temp = temp.next;
        }
        
        

      head = reverse(head);
      
      if(carry > 0){

         Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;

        }
        
        return head;
        
    }
}
