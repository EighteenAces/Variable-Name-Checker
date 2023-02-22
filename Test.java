import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String str = "null";
        do{

            System.out.println("This program checks the properness of a proposed Java variable name");
            System.out.println("Enter a variable name or 'q' to quit :");
            str = scan.nextLine();
            str = str.trim();
            char firstLetter = str.charAt(0);

            Pattern alphaRegex = Pattern.compile(".*[A-Z].*", Pattern.CASE_INSENSITIVE);
            String numRegex = ".*[0-9].*";
            Boolean isValidAlpha = alphaRegex.matcher(str).find();           

            if(!str.equalsIgnoreCase("q")){
                if(Character.isDigit(firstLetter) || str.contains(" ")){
                    System.out.println("Illegal");
                }
                else if(Character.isUpperCase(firstLetter) || str.contains("$")){
                    System.out.println("Legal, but uses poor style.");
                }
                else if(isValidAlpha && str.matches(numRegex)){
                    System.out.println("Good");
                }
            }
            else{
                System.exit(0);
                System.out.println("Exit program");
            }
            scan.close();
        }
        while(true);
        
    }
}
