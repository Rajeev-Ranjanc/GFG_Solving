//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])throws IOException
    {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
		 int t=Integer.parseInt(br.readLine());
		 while(t>0)
         {
            String S[] = br.readLine().split(" ");
			int N = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int n = Integer.parseInt(S[2]);
		
		    String S1[] = br.readLine().split(" ");
			insertion llist = new insertion(); 
			int a1=Integer.parseInt(S1[0]);
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) 
			{
				int a = Integer.parseInt(S1[i]);
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		Node newhead=ob.reverseBetween(llist.head, m, n);
		llist.printList(newhead);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node reverseBetween(Node head, int left, int right)
    {
        //code here
         if (head.next == null || left == right) {
            return head;
        }
        int n = 1;

        Node temp = head;

        Node a = null;
        Node b = null;
        Node c = null;
        Node d = null;

        while (temp != null) {
            if (n == left - 1) {
                a = temp;
            }
            if (n == left) {
                b = temp;
            }
            if (n == right) {
                c = temp;
                d = temp.next;
                break;
            }
            temp = temp.next;
            n++;
        }
        if(a!=null)
            a.next = null;
        if(c!=null)
            c.next = null;
        reverse(b);
        if(a!=null)
            a.next = c;
        b.next = d;

        if(a == null){
            return c;
        }

        return head;
//        I don't need to return head always in case of [3,5] When I will reverse head will point 3 and 5 will not return
//        because left is 1 and right 2 in that a will always be null in that case return C
    }
    
    private static void reverse(Node head) {

        if (head == null || head.next == null) {

            return;
        }

        Node prevnode = null;
        Node currnode = head;
        Node nextnode = head;

        while (nextnode != null) {

            nextnode = nextnode.next;

            currnode.next = prevnode;

            prevnode = currnode;

            currnode = nextnode;

        }

        head = prevnode;

    }
}