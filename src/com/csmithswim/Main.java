package com.csmithswim;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        amazingNumbers();
    }

    public static void amazingNumbers() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests: \n-enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be printed;\n" +
                " - two natural numbers and a property to search for;\n"+
                "- two natural numbers and two properties to search for;" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");

        boolean program = true;
        while (program) {
            System.out.print("Enter a request: ");
            Scanner scanner = new Scanner(System.in);
            try {
                String[] stringInput = scanner.nextLine().split(" ");
                long amazingNumber = Long.parseLong(stringInput[0]);
                long loopNum = 0;



                if (amazingNumber < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                if (amazingNumber == 0) {
                    System.out.println("Goodbye!");
                    program = false;
                    break;
                }


                if (stringInput.length == 2) {
                    loopNum = Long.parseLong(stringInput[1]);
                    System.out.println("");
                    if (loopNum < 0) {
                        System.out.println("The second parameter should be a natural number.");
                    }
                    for (int i = 0; i < loopNum; i++) {
                        System.out.println(amazingNumber + i + " is " + determineProperties(amazingNumber + i));
                    }
                    System.out.println("");
                }

                if (stringInput.length >= 3) {
                    loopNum = Long.parseLong(stringInput[1]);
                    String[] userInputProperties = new String[stringInput.length - 2];
                    for (int i = 0; i < userInputProperties.length; i++) {
                        userInputProperties[i] = stringInput[i + 2].toUpperCase();
                    }

                    Boolean correctProperty = false;
                    StringBuilder incorrectProperties = new StringBuilder();
                    String[] availableProperties = new String[] {"DUCK", "EVEN", "ODD", "GAPFUL", "SPY", "PALINDROMIC", "BUZZ", "SQUARE", "SUNNY", "JUMPING"};
                    for (int i = 0; i < userInputProperties.length; i++) {
                    correctProperty = false;
                        for (int j = 0; j < availableProperties.length; j++) {
                            if (userInputProperties[i].equalsIgnoreCase(availableProperties[j])) {
                                correctProperty = true;
                            }
                        }
                        if (correctProperty == false) {
                            incorrectProperties.append(userInputProperties[i] + " ");
                        }
                    }

                    if (incorrectProperties.length() > 1) {
                    displayPropertyInputErrors(incorrectProperties.toString().split(" "));
                    continue;
                    }
                    if (detectAndDisplayMutuallyExclusiveProperties(userInputProperties) == false) {
                        continue;
                    }

                    int propertyLength = userInputProperties.length;

                    int counter = 0;
                    for (int i = 0; i < loopNum; i++) {
                        int containsUserProperty = 0;

                        String[] arrayToTest = determineProperties(amazingNumber + i).split(", ");
                        for (int j = 0; j < propertyLength; j++) {
                            for (int k = 0; k < arrayToTest.length; k++) {
                                if (userInputProperties[j].equalsIgnoreCase(arrayToTest[k])) {
                                    containsUserProperty++;
                                    break;
                                }
                            }

                            if (containsUserProperty == propertyLength) {
                                System.out.println((amazingNumber + i) + " is " + determineProperties(amazingNumber + i));
                                counter++;
                                continue;
                            }
                        }
                        if (counter == loopNum) {
                            break;
                        }
                        if (counter < loopNum) {
                            i--;
                            amazingNumber++;
                        }
                }
                System.out.println("");

                }
                if (loopNum == 0) {
                    System.out.println("\nProperties of " + amazingNumber);
                    System.out.println("buzz: " + isBuzz(amazingNumber));
                    System.out.println("duck: " + isDuck(amazingNumber));
                    System.out.println("palindromic: " + isPalindrome(amazingNumber));
                    System.out.println("gapful: " + isGapFul(amazingNumber));
                    System.out.println("spy: " + isSpy(amazingNumber));
                    System.out.println("even: " + isEven(amazingNumber));
                    System.out.println("odd: " + isOdd(amazingNumber));
                    System.out.println("square: " + isSquare(amazingNumber));
                    System.out.println("jumping: " + isJumping(amazingNumber));
                    System.out.println("sunny: " + isSquare(amazingNumber +1));
                    System.out.println("jumping: " + isJumping(amazingNumber));
                }


            }   catch(InputMismatchException e){
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }
    public static String determineProperties(long x) {

        StringBuilder output = new StringBuilder("");
        if (isBuzz(x)) {
            output.append("buzz, ");
        }
        if (isDuck(x)) {
            output.append("duck, ");
        }
        if (isPalindrome(x)) {
            output.append("palindromic, ");
        }
        if (isGapFul(x)) {
            output.append("gapful, ");
        }
        if (isSpy(x)) {
            output.append("spy, ");
        }
        if (isEven(x)) {
            output.append("even, ");
        }
        if (isOdd(x)) {
            output.append("odd, ");
        }
        if (isSquare(x)) {
            output.append("square, ");
        }
        if (isSquare(x+1)) {
            output.append("sunny, ");
        }
        if (isJumping(x)) {
            output.append("jumping, ");
        }
        return output.substring(0, output.length()-2);

    }

    public static void displayPropertyInputErrors(String[] input) {
        StringBuilder output = new StringBuilder();
        if (input.length == 1) {
            output.append("The property " + Arrays.toString(input) + " is wrong.\n");
        } else {
            output.append("The properties " + Arrays.toString(input) + " are wrong.\n");
        }
        System.out.println(output + "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]");
    }

    public static boolean detectAndDisplayMutuallyExclusiveProperties(String[] input) {
        StringBuilder message = new StringBuilder("\nThe request contains mutually exclusive properties: " +
                "There are no numbers with these properties.\n");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++){
                if (input[i].equalsIgnoreCase("SUNNY") && input[j].equalsIgnoreCase("SQUARE") || input[i].equalsIgnoreCase("SQUARE")
                        && input[j].equalsIgnoreCase("sunny")) {
                    System.out.println(message.replace(53, 53, "[SQUARE, SUNNY].\n"));
                    return false;
                }
                if (input[i].equalsIgnoreCase("EVEN") && input[j].equalsIgnoreCase("ODD") ||
                        input[i].equalsIgnoreCase("ODD") && input[j].equalsIgnoreCase("EVEN")) {
                    System.out.println(message.replace(53, 53 ,"[ODD, EVEN].\n"));
                    return false;
                }
                if (input[i].equalsIgnoreCase("DUCK") && input[j].equalsIgnoreCase("SPY") ||
                        input[i].equalsIgnoreCase("SPY") && input[j].equalsIgnoreCase("DUCK")) {
                    System.out.println(message.replace(53, 53, "[DUCK, SPY].\n"));
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSquare(long x) {
        boolean result = false;
        long square = (long)Math.sqrt(x);
        if (square * square == x) {
            result = true;
        }
        return result;
    }

    public static boolean isSpy(long x) {
        String[] xString = String.valueOf(x).split("");
        long sum = 0;
        long product = 1;

        for (String e : xString) {
            sum += Integer.parseInt(e);
            product *= Integer.parseInt(e);
        }
        if (sum == product) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isGapFul(long x) {
        //contains at least three digits.
        //divisible by the concatenation of first and last digit without a remainder
        String divisor = String.valueOf(x).substring(0,1) + String.valueOf(x).substring(String.valueOf(x).length()-1);
        if (x >= 100 && x % Long.parseLong(divisor) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEven(long x) {
        return (x % 2 == 0);
    }

    public static boolean isOdd(long x) {
        return ((x - 1) % 2 == 0);
    }

    public static boolean isBuzz(long x) {
        return (x % 7 == 0 || (x - 7) % 10 == 0);
    }

    public static boolean isDuck(long x) {
        boolean duck = false;
        String duckString = Long.toString(x);
        for (int i = 1; i < duckString.length(); i++) {
            char testString = duckString.charAt(i);
            if (testString == '0') {
                duck =  true;
            }
        }
        return duck;
    }

    public static boolean isPalindrome(long x) {
        boolean palindrome = true;
        for (int i = 0, j = String.valueOf(x).length() - 1; i < String.valueOf(x).length() && j > 0; i++, j--) {
            if (String.valueOf(x).charAt(i) != String.valueOf(x).charAt(j)) {
                palindrome = false;
            }
        }
        return palindrome;
    }

    public static boolean isJumping(long x) {
        boolean jumping = true;
        if (x < 10) {
            return jumping;
        }

        for (int i = 0; i < String.valueOf(x).length() - 1; i++) {

            if (Math.abs(String.valueOf(x).charAt(i) - String.valueOf(x).charAt(i + 1)) != 1) {
                jumping = false;
                break;
            }
        }
        return jumping;
    }
}









