//{ Driver Code Starts
import java.util.*;

class StackNode {
    int data;
    StackNode next;
    StackNode(int a) {
        data = a;
        next = null;
    }
}

class GfG {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            MyStack obj = new MyStack();
            int Q = sc.nextInt();
            while (Q > 0) {
                int QueryType = 0;
                QueryType = sc.nextInt();
                if (QueryType == 1) {
                    int a = sc.nextInt();
                    obj.push(a);
                } else if (QueryType == 2) {
                    System.out.print(obj.pop() + " ");
                }
                Q--;
            }
            System.out.println("");
            t--;
        }
    }
}

// } Driver Code Ends


class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    int length;
    
    MyStack(){
        top = null;
        length = 0;
    }
    
    
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        StackNode temp = new StackNode(a);
        temp.next = top;
        top = temp;
        length++;
        
        // Add your code here
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
       if(length == 0){
           return -1;
       }
       StackNode temp = top;
       top = top.next;
       length--;
       temp.next = null;
       return temp.data;
       
        // Add your code here
    }
}
