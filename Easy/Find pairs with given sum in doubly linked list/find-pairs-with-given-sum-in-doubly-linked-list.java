//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next,prev;
    
    Node(int x)
    {
        data = x;
        next = null;
        prev = null;
    }
    
    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List
        
        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++){
            Node temp=new Node(Integer.parseInt(s[i]));
            tail.next = temp;
            tail.next.prev = tail;
            tail = tail.next;
        }
        return head;
    }
    
    public static void printList(Node node)
    {
        while (node != null)
        { 
    		System.out.print(node.data + " ");
    		node = node.next; 
    	}  
    	System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        if(m.size()==0){
            System.out.println("-1");
        }else{
            for(var a : m)
            {
                System.out.print("(" + a.get(0) + "," + a.get(1) + ")" + " ");
            }
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int target; 
            target = Integer.parseInt(br.readLine());
            
            
            Node head = Node.inputList(br);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findPairsWithGivenSum(target, head);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        
        //this is the corerct solution although it is in O(n^2) so it gives TLE
        
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Node temp = head;

        // while (temp != null) {

        //     Node nextNode = temp.next;

        //     while (nextNode != null && temp.data + nextNode.data < target) {

        //         int sum = temp.data + nextNode.data;

        //         if (sum == target) {

        //             ArrayList<Integer> ans = new ArrayList<>();

        //             ans.add(temp.data);

        //             ans.add(nextNode.data);

        //             list.add(ans);
        //         }

        //         nextNode = nextNode.next;
        //     }

        //     temp = temp.next;
        // }
        // // System.out.println(list.get(0));
        // // System.out.println(list.get(1));
        // return list;
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();


        Node left = head;
        
        Node right = findTail(head);
        
        while (left.data < right.data) {
            
            int sum = left.data + right.data;
            
            if (sum < target) {
                
                left = left.next;
                
            } else if (sum > target) {
                
                right = right.prev;
                
            } else {
                
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(left.data);
                ans.add(right.data);
                list.add(ans);
                left = left.next;
                right = right.prev;
                
            }
            
        }
        // System.out.println(list.get(0));
        // System.out.println(list.get(1));
        return list;
    }
    
    static Node findTail(Node head) {
        
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        return temp;

    }
}
        
