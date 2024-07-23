/*
----------------------------------------------------------------------------------------------------------
    Name:		Driver
    Authors:	Ollie Peel, Rawan Alhachami
    Language:	Java
    Date:		2024-07-22
    Purpose:	The purpose of this program is to create a driver class that can read data from the input
    file and output the results to the console. To do this, it implements methods in the Converter,
    ExpToBT, and *EXPRESSION PARSER* classes in order to turn a series of infix expressions into binary
    expression trees and then parse those trees. 
----------------------------------------------------------------------------------------------------------
    Change Log
----------------------------------------------------------------------------------------------------------
    Who		Date		Reason
    OSP		2024-07-22	Original Version of Code
    OSP     2024-07-23  Moved code from Converter class, which removes spaces from a string, into driver
    class since the Converter class only had one method. Deleted Converter class, added clarifying
    comments to this class.
----------------------------------------------------------------------------------------------------------
*/

/* main method is currently set up to test the results of the toBinaryTree method in the ExpToBT class. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrInput = new ArrayList<String>();
            // File path is to a copy of the Expressions.txt file on my personal computer
        File fileInput = new File("C:\\Users\\5555l\\OneDrive\\Desktop\\Expressions.txt");
        BufferedReader bufRead = new BufferedReader(new FileReader(fileInput));
        String strTemp;

        // Reads the input file and adds each line as a different element of an ArrayList
        while ((strTemp = bufRead.readLine()) != null){
            arrInput.add(strTemp);
        }
        for (int i = 0; i < arrInput.size(); i++){
            String currExp = arrInput.get(i);
            // Converts the current expression string into an ArrayList
            System.out.println("\nExpression " + (i+ 1) + ": " + currExp);
            // Prints the result of the parsed expression to the console
            // Currently only prints the resulting binary tree nodes to ensure the data is correct
            System.out.print("\tResult: ");

            // Remove spaces from current expression
            StringBuilder sbUsableExp = new StringBuilder();
            for (int j = 0; j < currExp.length(); j++){
                char charCurr = currExp.charAt(j);
                // Add char to string builder if not a space
                if (charCurr != ' '){
                    sbUsableExp.append(charCurr);
                }
            }
            currExp = sbUsableExp.toString();
           
            // Create binary expression tree from current expression
            BTNode<String> root = ExpToBT.toBinaryTree(currExp);
            /* FIXME expresson parser gets implemented here, result is printed to console */
        }
        bufRead.close();
    }
}
