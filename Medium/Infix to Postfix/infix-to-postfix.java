//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        String ans = "";

        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {

            if (isOperand(ch)) {

                ans += ch;

            } else if (ch == '(') {

                stack.push(ch);

            } else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {

                    ans += stack.pop();

                }

                stack.pop(); // for opening bracket ' ( '

            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    ans += stack.pop();
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty())
            ans+=stack.pop();
        return ans;
    }

    private static boolean isOperand(char ch) {

        return Character.isLetterOrDigit(ch);
    }

    private static int precedence(char ch) {
         switch (ch) {
            case '+':
            case '-':

                return 1;

            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }
}