/*
----------------------------------------------------------------------------------------------------------
    Name:		Parser
    Authors:	Ollie Peel, Rawan Alhachami
    Language:	Java
    Date:		2024-07-22
    Purpose:	The purpose of this program is to use the toBinaryTree method to turn a valid string of an
    infix expression into a binary expression tree, use the build method to build up subtrees to create
    the binary expression tree, and use the precedence method to assign and check the precedence of
    operands when creating the tree.
----------------------------------------------------------------------------------------------------------
    Change Log
----------------------------------------------------------------------------------------------------------
    Who		Date		Reason
    OSP		2024-07-22	Created toBinaryTree, build, and precedence methods
----------------------------------------------------------------------------------------------------------
*/

import java.util.Stack;

public class ExpToBT {

    /**
     * Turns an infix expression into a binary expression tree. The data in each BTNode is type String
     * @param expression : The infix expression to be turned into a binary expression tree
     * @return : The root of the resulting binary tree
     */
    public static BTNode<String> toBinaryTree(String expression){
        // Create separatestacks for nodes and operators
        Stack<BTNode<String>> nodes = new Stack<>();
        Stack<String> operators = new Stack<>();

        // Traverse the infix expression character by character (no spaces)
        for (int i = 0; i < expression.length(); i++){
            char current = expression.charAt(i);
            // If current character is a number, first make sure all digits are accounted for
            if (Character.isDigit(current)){
                StringBuilder currNumStr = new StringBuilder();
                int j = i;
                // Get entire number, not just first digit (e.g. 23 instead of 2 and 3 separately)
                while (j < expression.length() && Character.isDigit(expression.charAt(j)) &&
                expression.charAt(j) != ' '){
                    currNumStr.append(expression.charAt(j));
                    i = j;
                    j++;
                }
                // After all digits are accounted for, create node and push into nodes stack
                nodes.push(new BTNode<String>(currNumStr.toString()));

            } else if (current == '('){
                // Push '('' to the operators stack
                operators.push(String.valueOf(current));

            } else if (current == ')'){
                // build and push nodes into nodes stack until '(' is encountered
                while (!operators.peek().equals("(")){
                    nodes.push(build(operators, nodes));
                }
                // remove the '(' from the operators stack
                operators.pop();

            } else {
                // Current char is an operator
                StringBuilder currOpStr = new StringBuilder();
                int j = i;
                // Same as before, make sure all elemests of operator are accounted for
                while ( j < expression.length() && !Character.isDigit(expression.charAt(j)) &&
                expression.charAt(j) != '('){
                    // Get entire operator, not just first element (e.g. >= instead of just >)
                    currOpStr.append(expression.charAt(j));
                    i = j;
                    j++;
                }
                // Build and push nodes with any current operators into operators stack
                while (!operators.isEmpty() && !operators.peek().equals("(") &&
                precedence(operators.peek()) >= precedence(String.valueOf(currOpStr))){
                    nodes.push(build(operators, nodes));
                }
                // Push current operator into operators stack
                operators.push(currOpStr.toString());
            }
        }
        // Build and push nodes into nodes stack using any operators/nodes remaining in the stacks
        while (!operators.isEmpty()){
            nodes.push(build(operators, nodes));
        }
        // Return the root of the tree
        return nodes.pop();
    }

    /**
     * Creates and returns a new Binary Tree Node (BTNode)
     * @param c : The data for a new BTNode
     * @param node1 : The left node of the new BTNode
     * @param node2 : The right node of the new BTNode
     * @return : The new BTNode
     */
    public static BTNode<String> build(Stack<String> operators, Stack<BTNode<String>> nodes){
        BTNode<String> root = new BTNode<>(operators.pop());
        root.right = nodes.pop();
        root.left = nodes.pop();
        return root;
    }

    /**
     * Finds and returns the percedence of an operator. 7 is highest precedence, 1 is lowest
     * @param operator : Operator to find precedence of
     * @return : Precedence of the operator
     * @throws IllegalArgumentException : Operator not supported
     */
    public static int precedence(String operator){
        if (operator.equals("^")){ return 7; }
        else if (operator.equals("*") || operator.equals("/") || operator.equals("%")){
            return 6;}
        else if (operator.equals("+") || operator.equals("-")){ return 4; }
        else if (operator.equals(">") || operator.equals(">=") || operator.equals("<") ||
        operator.equals("<=")){ return 3; }
        else if (operator.equals("==") || operator.equals("!=")){ return 2; }
        else if (operator.equals("&&")){ return 2; }
        else if (operator.equals("||")){ return 1; }
        else {throw new IllegalArgumentException("Operator not supported: '" + operator + "'");}
    }
}
