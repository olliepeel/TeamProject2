import java.util.Stack;

public class InfixToPostfix {

    public static String convertToPostfix(String infixExp) {
        Stack<Character> stack = new Stack<>(); // Initializes stack for holding operators and parentheses
        StringBuilder postfixExp = new StringBuilder(); // Initializes StringBuilder for postfix expression

        for (int i = 0; i < infixExp.length(); i++) { char ch = infixExp
            char ch = infixExp.charAt(i); 

            if (Character.isWhitespace(ch)) {
                continue; // the white spaces are ignored 
            } else if (Character.isDigit(ch) || Character.isLetter(ch)) {
                postfixExp.append(ch).append(' '); // Operand is appended to postfix expression
            } else if (ch == '(') {
                stack.push(ch); 
            } else if (ch == ')') { 
            while (!stack.isEmpty() && stack.peek() != '(') {postfixExp.append(stack.pop()).append(' '); }
                stack.pop(); // Pop opening parenthesis from stack
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfixExp.append(stack.pop()).append(' '); // Operators of equal or greater precedence are popped 
                }
                stack.push(ch); 
            }
        }

       
        while (!stack.isEmpty()) {
            postfixExp.append(stack.pop()).append(' '); // Pop and append all operators 
        }

        return postfixExp.toString(); //return as a string
    }
    private static boolean isOperator(char ch) {
        // defined operators
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '>' || ch == '=' || ch == '&' || ch == '|' || ch == '%';}

    // Helper method to check operator precedences
    private static int precedence(char op) {
    
        switch (op) { //precedence levels of operators
            case '=':
                return 0; // Lowest precedence for equal sign
            case '>':
                return 1; // Precedence for greater-than 
            case '+':
            case '-':
                return 2; // Precedence for addition and subtraction
            case '*':
            case '/':
            case '%':
                return 3; // Precedence for multiplication, division, and modulus
            case '^':
                return 4; // exponent takes highest precedence
            case '&':
            case '|':
                return 5; // logical AND and OR
            default:
                return -1; // Invalid operator
        }
    }
    public static int evaluateTree(BTNode<String> root){
        if (root == null){ return 0; } //in case of empty tree
        if ((root.left == null) && (root.right == null)){ return Integer.valueOf(root.data); } //returns leaf node value

        int evalLeft = evaluateTree(root.left);
        int evalRight = evaluateTree(root.right); //left and right subtrees are recursively evaluated

        switch (root.data) { //operator at the root is read and used to evaluate the rest of the tree
            case "^":
                return ((int)Math.pow(evalLeft, evalRight)); //exponent evauation
            case "*":
                return (evalLeft * evalRight); //multiplication evaluation
            case "/":
                return (evalLeft / evalRight); //division evaluation
            case "%":
                return (evalLeft % evalRight); //modulus evaluation
            case "+":
                return (evalLeft + evalRight); //addition evaluation
            case "-":
                return (evalLeft - evalRight); //subtraction evaluation
            case ">":
                return (evalLeft > evalRight) ? 1 : 0; //greater-than evaluation
            case "<":
                return (evalLeft < evalRight) ? 1 : 0; //less-than evaluation
             case ">=":
                return (evalLeft >= evalRight) ? 1 : 0; //greater-than or equal-to evaluation
            case "<=":
                return (evalLeft <= evalRight) ? 1 : 0; //less-than or equal to evaluation
            case "==":
                return (evalLeft == evalRight) ? 1 : 0; // is-equal evaluation
            case "!=":
                return (evalLeft != evalRight) ? 1 : 0; // does-not-equal evaluation
            case "&&":
                return (((evalLeft != 0) ? true : false) && ((evalRight != 0) ? true : false)) ? 1 : 0; //logical AND
            case "||":
                return (((evalLeft != 0) ? true : false) || ((evalRight != 0) ? true : false)) ? 1 : 0; //logical OR
            default:
                throw new IllegalArgumentException("Invalid Operation: " + root.data); //any unsupported or invalid operators
        }
    }
}