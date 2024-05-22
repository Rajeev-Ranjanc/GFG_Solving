//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

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

class Solution{
    Node divide(int N, Node head){
        
        // code here
        ArrayList<Integer> even = new ArrayList<>();
        
        ArrayList<Integer> odd = new ArrayList<>();
        
        Node temp = head;
        
        int first = 0;
        
        int second = N - 1;

        while (temp != null) {
            
            int t = temp.data;
            if (t % 2 == 0) {
                even.add(t);
            } else {
                odd.add(t);
            }
            temp = temp.next;
            
        }

        //Now Operation
        int[] arr = new int[N];
        int index = 0;
        int i = 0;
        while (true) {
            if (i < even.size()) {
                arr[index++] = even.get(i++);
            } else {
                break;
            }
        }
        i = 0;
        while (index < N) {
            arr[index++] = odd.get(i++);
        }

        // System.out.println(even+" "+odd);
        //Now operation in linked list
        temp = head;
        index = 0;
        while (temp != null) {
            temp.data = arr[index++];
            temp = temp.next;
        }
        return head;
    }
}