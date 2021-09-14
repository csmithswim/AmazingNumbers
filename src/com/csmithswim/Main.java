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
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                " - two natural numbers and a property to search for;\n"+
                "- two natural numbers and two properties to search for" +
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


//                    for (String e : properties) {
//                        if (firstProperty.equals(e)) {
//                            includesProperty = true;
//                            break;
//                        }
//                    }
//                    if (includesProperty == false) {
//                        displayPropertyInputErrors(includesProperty, firstProperty);
//                        continue;
//                    }
//
                    int countHasProperty = 0;
                    for (int i = 0; i < loopNum; i++) {
                        String[] arrayToTest = determineProperties(amazingNumber + i).split(", ");
                        for (int j = 0; j < arrayToTest.length; j++) {
                            if (userInputProperties[0].equalsIgnoreCase(arrayToTest[j])) {
                                countHasProperty++;
                                System.out.println((amazingNumber + i) + " is " + determineProperties(amazingNumber + i));
                                break;
                            }
                        }
                        if (countHasProperty == loopNum) {
                            break;
                        }
                        if (countHasProperty < loopNum) {
                            i--;
                            amazingNumber++;
                        }
                    }
                    System.out.println("");


//                }
//
//                if (stringInput.length == 4) {
//                    loopNum = Long.parseLong(stringInput[1]);
//                    firstProperty = stringInput[2];
//                    secondProperty = stringInput[3];
//
//                    boolean includesFirstProperty = false;
//                    boolean includesSecondProperty = false;
//                    loopNum = Long.parseLong(stringInput[1]);
//
//                    firstProperty = stringInput[2];
//                    secondProperty = stringInput[3];
//
//                    List<String> properties = Arrays.asList("DUCK", "EVEN", "ODD", "GAPFUL", "SPY", "PALINDROMIC", "BUZZ", "SQUARE", "SUNNY", "JUMPING");
//                    for (String e : properties) {
//                        if (firstProperty.equalsIgnoreCase(e)) {
//                            includesFirstProperty = true;
//                        }
//                        if (secondProperty.equalsIgnoreCase(e)) {
//                            includesSecondProperty = true;
//                        }
//                    }
//
//                    if (includesFirstProperty == false) {
//                        displayPropertyInputErrors(includesFirstProperty, includesSecondProperty, firstProperty, secondProperty);
//                        continue;
//                    }
//                    if (includesSecondProperty == false) {
//                        displayPropertyInputErrors(includesFirstProperty, includesSecondProperty, firstProperty, secondProperty);
//                        continue;
//                    }
//
//                    if (detectAndDisplayMutuallyExclusiveProperties(firstProperty, secondProperty) == false) {
//                        continue;
//                    }
//
//                    int countHasProperty = 0;
//                    for (int i = 0; i < loopNum; i++) {
//                        boolean containsFirst = false;
//                        boolean containsSecond = false;
//                        String[] arrayToTest = determineProperties(amazingNumber + i).split(", ");
//                        for (int j = 0; j < arrayToTest.length; j++) {
//                            if (firstProperty.equalsIgnoreCase(arrayToTest[j])) {
//                                containsFirst = true;
//                            }
//                            if (secondProperty.equalsIgnoreCase(arrayToTest[j])) {
//                                containsSecond = true;
//                            }
//                            if (containsFirst == true && containsSecond == true) {
//                                countHasProperty++;
//                                System.out.println((amazingNumber + i) + " is " + determineProperties(amazingNumber + i));
//                                break;
//                            }
//                        }
//                        if (countHasProperty == loopNum) {
//                            break;
//                        }
//                        if (countHasProperty < loopNum) {
//                            i--;
//                            amazingNumber++;
//                        }
//                    }
//                    System.out.println("");
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

    public static void displayPropertyInputErrors(boolean includesProperty, String firstProperty) {
        StringBuilder message = new StringBuilder("\nThe property " + " is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE, JUMPING]\n");
        if (includesProperty == false) {
            System.out.println(message.insert(14, firstProperty));
        }
    }

    //String[] input, boolean
    public static void displayPropertyInputErrors(String[] input) {
        StringBuilder output = new StringBuilder();
        if (input.length == 1) {
            output.append("The property " + Arrays.toString(input) + " is wrong.\n");
        } else {
            output.append("The properties " + Arrays.toString(input) + " are wrong.\n");
        }
        System.out.println(output);
    }

    public static boolean detectAndDisplayMutuallyExclusiveProperties(String firstProperty, String secondProperty) {
        StringBuilder message = new StringBuilder("\nThe request contains mutually exclusive properties: " + "[" + firstProperty + ", " + secondProperty + "]\n" +
                "There are no numbers with these properties.\n");
        if (firstProperty.equalsIgnoreCase("SUNNY") && secondProperty.equalsIgnoreCase("SQUARE") || firstProperty.equalsIgnoreCase("SQUARE")
                && secondProperty.equalsIgnoreCase("sunny")) {
            System.out.println(message);
            return false;
        }
        if (firstProperty.equalsIgnoreCase("EVEN") && secondProperty.equalsIgnoreCase("ODD") ||
        firstProperty.equalsIgnoreCase("ODD") && secondProperty.equalsIgnoreCase("EVEN")) {
            System.out.println(message);
            return false;
        }
        if (firstProperty.equalsIgnoreCase("DUCK") && secondProperty.equalsIgnoreCase("SPY") ||
        firstProperty.equalsIgnoreCase("SPY") && secondProperty.equalsIgnoreCase("DUCK")) {
            System.out.println(message);
            return false;
        }
        return true;
    }

    public static void calculateProperties(long number, long repeatNum, String[] properties) {
        //2d for loop. Loop over properties,
            //IF property switch statement returns true -> increment inner loop variable and call determine properties method
            //ELSE decrement inner loop variable and increment outer loop variable
        //PRINT output variable

        int counter = 0;
        for (int i = (int)number; counter < repeatNum; i++) {
            for (int j = 0; j < properties.length; j++) {
                switch (properties[j]) {
                    case "EVEN":
                        if (isEven(number)) {
                            determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "ODD":
                        if (isOdd(number)) {
                            determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "BUZZ":
                        if (isBuzz(number)) {
                            determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "DUCK":
                        if (isDuck(number)) {
                            determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "PALINDROMIC":
                        if (isPalindrome(number)) {
                            determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "GAPFUL":
                        if (isGapFul(number)) {
                            determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "SPY":
                        if (isSpy(number)) {
                        determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "SQUARE":
                        if (isSquare(number)) {
                        determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "SUNNY":
                        if (isSquare(number + 1)) {
                        determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                    case "JUMPING":
                        if (isJumping(number)) {
                        determineProperties(i);
                            counter++;
                        } else {
                            j--;
                            i++;
                        }
                        break;
                }
                System.out.println("test");
            }
        }
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



