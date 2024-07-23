public class Converter {
    /*
    ----------------------------------------------------------------------------------------------------------
        Name:		Converter
        Authors:	Ollie Peel, Rawan Alhachami
        Language:	Java
        Date:		2024-07-23
        Purpose:	The purpose of this program is to convert a string of an expression into a usable
        expression by removing unnecessary whitespace.
    ----------------------------------------------------------------------------------------------------------
        Change Log
    ----------------------------------------------------------------------------------------------------------
        Who		Date		Reason
        OSP		2024-07-23	Original Version of Code
    ----------------------------------------------------------------------------------------------------------
    */
    /**
     * Removes space characters from a string of an expression
     * @param strOriginalExp A string of an expression
     * @return String of expression with no spaces
     */
    public static String toUsableExpression(String strOriginalExp){
        StringBuilder sbUsableExp = new StringBuilder();
        for (int i = 0; i < strOriginalExp.length(); i++){
            char charCurr = strOriginalExp.charAt(i);
            // Add char to string builder if not a space
            if (charCurr != ' '){
                sbUsableExp.append(charCurr);
            }
        }
        return sbUsableExp.toString();
    }
}
