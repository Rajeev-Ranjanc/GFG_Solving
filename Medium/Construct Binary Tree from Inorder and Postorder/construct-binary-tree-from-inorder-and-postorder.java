//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    public int findPosition2(int[] in, int ele, int n) {
        for (int i = 0; i < n; i++) {
            if (in[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    public Node solveSecond(int[] inorder, int[] post, int[] index, int inOrderStart, int inOrderEnd, int n) {
        //base condition will change partially
        if (index[0] < 0 || inOrderStart > inOrderEnd) {
            return null;
        }
        //creation of a new node
        int ele = post[index[0]];
        Node root = new Node(ele);

        //find index of element in Inorder array
        int position = findPosition2(inorder , ele , n);
        index[0]--;

//        recursive calls
        root.right = solveSecond(inorder, post, index, position + 1, inOrderEnd, n);
        root.left = solveSecond(inorder, post, index, inOrderStart, position - 1, n);


        return root;
    }

    Node buildTree(int in[], int post[], int n) {
        // Your code here
        int[] postOrderIndex = {n - 1};
//
//        int postOrderIndex =

        Node ans = solveSecond(in, post, postOrderIndex, 0, n - 1, n);

        return ans;

    }

}
