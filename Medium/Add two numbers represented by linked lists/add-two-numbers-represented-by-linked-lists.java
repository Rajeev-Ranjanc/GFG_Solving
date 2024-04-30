//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverse(Node head) {
    if (head == null || head.next == null) {
        return head;
    }

    Node prev = null;
    Node temp = head;
    Node next = head.next;
    while (next != null) {
        temp.next = prev;
        prev = temp;
        temp = next;
        next = temp.next;
    }
    temp.next = prev;

    return temp;
}

    static Node addTwoNumbers(Node l1, Node l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    Node head = l1;
    Node tail = null;

    int carry = 0;
    while (l1 != null && l2 != null) {
        l1.data += carry + l2.data;
        carry = l1.data / 10;
        l1.data %= 10;

        tail = l1;

        l1 = l1.next;
        l2 = l2.next;
    }

    if (l2 != null) {
        tail.next = l2;
        l1 = l2;
    }

    while (l1 != null) {
        l1.data += carry;
        carry = l1.data / 10;
        l1.data %= 10;
        tail = l1;
        l1 = l1.next;
    }

    l1 = tail;
    while (carry != 0) {
        l1.next = new Node(carry);
        carry = l1.next.data / 10;
        l1.next.data %= 10;
        l1 = l1.next;
    }

    return head;
}
static Node addTwoLists(Node num1, Node num2) {
    while (num1.next != null && num1.data == 0) {
        num1 = num1.next;
    }
    while (num2.next != null && num2.data == 0) {
        num2 = num2.next;
    }

    num1 = reverse(num1);
    num2 = reverse(num2);

    return reverse(addTwoNumbers(num1, num2));
}

}