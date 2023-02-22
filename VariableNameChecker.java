
/**************************************************
 * Jave Course 1, Module 3
 * 
 * Checking the properness of a given variable name
 * 
 * @author: Jellie Mae Ortiz
 * Date Created: May 13, 2022
 **************************************************/

import java.util.Scanner;
import java.util.regex.Pattern;

public class VariableNameChecker {

    public static void main(String[] args) {

        Scanner inputObj = new Scanner(System.in);
        // output prompt to enter the variable name
        String inputStr = "";

        do {
            System.out.println("\nThis program checks the properness of a proposed Java variable name\n");
            System.out.printf("Enter a variable name (q to quit):\n");

            // get the input from Scanner object
            inputStr = inputObj.nextLine();

            char firstChar = inputStr.charAt(0);

            // checking the first character of the given variable name
            if (Character.isLetter(firstChar)) {
                if ((Character.isUpperCase(firstChar))) {
                    System.out.println("\nLegal, but uses poor style.\n");
                } 
                
                else {
                    System.out.println(stringCharChecker(inputStr));
                }
            } 
            
            else {
                System.out.println("Illegal");
            }

        } while (!inputStr.equals("q"));

        inputObj.close();

    } // end of main()

    
    // create a method to declare a parameter - string variable
    public static String stringCharChecker(String anyStr) {

        String outputMsg = ""; // displaying the output message
        Pattern specialCaseRegex = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Pattern alphaRegex = Pattern.compile(".*[A-Z].*");
        String numRegex = ".*[0-90].*";

        Boolean isSpecialChar = specialCaseRegex.matcher(anyStr).find();
        Boolean isValidAlpha = alphaRegex.matcher(anyStr).find();

        if (anyStr.equals("q")) {
            System.exit(0);
            System.out.println("Goodbye");
        }
        else if (anyStr.contains(" ")) {
            outputMsg = "\nIllegal\n";
        } 
        
        else if (anyStr.matches(numRegex) && (isValidAlpha) && (!isSpecialChar)) {
            outputMsg = "\nGood\n";
        } 
        
        else {
            outputMsg = "\nLegal, but uses poor style\n";
        }
        return outputMsg;
    }
    // end of the stringCharChecker method()
}
// end of the program