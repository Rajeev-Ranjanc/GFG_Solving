//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Driverclass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }

    public static void printList(Node head, PrintWriter out) {
        if (head == null) return;

        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public static int length(Node head) {
        
        Node temp = head;
        
        int c = 0;
        
        while (temp != null) {
            
            c++;
            
            temp = temp.next;
            
        }
        
        return c;
        
    }
    
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        
        
        int h = length(head);
        int zero = 0;
        int one = 1;
        Node temp = head;

        //finding no of occurrences of 0 1 2
        while (temp != null) {
            if (temp.data == 0) {
                zero++;

            } else if (temp.data == 1) {
                one++;
            }
            temp = temp.next;
        }

        int[] a = new int[h];

        for (int i = 0; i < h; i++) {
            if (i < zero) {
                a[i] = 0;
            } else if (i < zero + one - 1) {
                a[i] = 1;
            } else {
                a[i] = 2;
            }
        }
        temp = head;
        int index = 0;
        while (temp != null) {
            temp.data = a[index++];
            temp = temp.next;

        }
       return head;
        
    }
}
