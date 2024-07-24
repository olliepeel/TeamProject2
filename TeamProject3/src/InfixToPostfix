import java.util.Stack;

public class InfixToPostfix {

    public static String convertToPostfix(String infixExp) {
        
        Stack<String> stack = new Stack<>();
        StringBuilder postfixExp = new StringBuilder();
        
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isDigit(token.charAt(0))) { 
                postfixExp.append(token).append(' ');//If the character is an operand, append it to the postfix expression
            } else if (ch == '(') {
                Stack.push(ch);
            } else if (ch == ')') { //Push opening parenthesis to stack, and pop operators and append to postfix until encounters close parenthesis
                while (!Stack.isEmpty() && Stack.peek() != '(') {
                    postfixExp.append(Stack.pop()).append(' ');
                }
                Stack.pop(); 
            } else if (isOperator(ch)) {
                while (!Stack.isEmpty() && precedence(Stack.peek()) >= precedence(ch)) {
                    postfixExp.append(Stack.pop()).append(' ');
                }
                Stack.push(ch);//
            }
        }

        while (!Stack.isEmpty()) {
            postfixExp.append(Stack.pop()).append(' ');
        }

        return postfixExp.toString().trim();
    }

    private static boolean isOperator(char ch) { //check if operator
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char op) { //checks operator precedence
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

}
