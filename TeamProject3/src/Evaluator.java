/*
----------------------------------------------------------------------------------------------------------
    Name:		Evaluator
    Authors:	Ollie Peel, Rawan Alhachami
    Language:	Java
    Date:		2024-07-22
    Purpose:	The purpose of this program is to handle expression evaluations with comparison and
    logic operators as well as the exponent symbol '^'. The comparison and logic operators return either
    1 or 0 as opposed to true or false.
----------------------------------------------------------------------------------------------------------
    Change Log
----------------------------------------------------------------------------------------------------------
    Who		Date		Reason
    OSP		2024-07-22	Original Version of Code
----------------------------------------------------------------------------------------------------------
*/
public class Evaluator {

    /**
     * Calculates num1 to the power of num2
     * @param num1 : The base number
     * @param num2 : The exponent
     * @return : num1 to the power of num2
     */
    public static int evalPower(int num1, int num2){
        double result = Math.pow(num1, num2);
        return (int)result;
    }

    /**
     * Evaluates whether num1 is greater than num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 > num2, 0 otherwise
     */
    public static int evalGreater(int num1, int num2){
        return (num1 > num2) ? 1 : 0;
    }

    /**
     * Evaluates whether num1 is greater than or equal to num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 >= num2, 0 otherwise
     */
    public static int evalGreaterEqual(int num1, int num2){
        return (num1 >= num2) ? 1 : 0;
    }

    /**
     * Evaluates whether num1 is less than num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 < num2, 0 otherwise
     */
    public static int evalLess(int num1, int num2){
        return (num1 < num2) ? 1 : 0;
    }

    /**
     * Evaluates whether num1 is less than or equal to num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 <= num2, 0 otherwise
     */
    public static int evalLessEqual(int num1, int num2){
        return (num1 <= num2) ? 1 : 0;
    }

    /**
     * Evaluates whether num1 is equal to num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 == num2, 0 otherwise
     */
    public static int evalEqual(int num1, int num2){
        return (num1 == num2) ? 1 : 0;
    }

    /**
     * Evaluates whether num1 is not equal to num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 != num2, 0 otherwise
     */
    public static int evalNotEqual(int num1, int num2){
        return (num1 != num2) ? 1 : 0;
    }
    
    /**
     * Evaluates the expression num1 && num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 && num2, 0 otherwise
     */
    public static int evalAnd(int num1, int num2){
        return (((num1 != 0) ? true : false) && ((num2 != 0) ? true : false)) ? 1 : 0;
    }

    /**
     * Evaluates the expression num1 || num2
     * @param num1 : The left number of the expression
     * @param num2 : The right number of the expression
     * @return : 1 if num 1 || num2, 0 otherwise
     */
    public static int evalOr(int num1, int num2){
        return (((num1 != 0) ? true : false) || ((num2 != 0) ? true : false)) ? 1 : 0;
    }
}
