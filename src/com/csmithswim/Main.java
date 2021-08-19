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
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");

        boolean program = true;
        while (program) {
            System.out.println("Enter a request: ");
            Scanner scanner = new Scanner(System.in);
            try {
                String[] stringInput = scanner.nextLine().split(" ");
                long input = Long.parseLong(stringInput[0]);
                long loopNum = 0;
                StringBuilder chooseProperty = new StringBuilder();
                StringBuilder secondProperty = new StringBuilder();

                if (stringInput.length == 2) {
                    loopNum = Long.parseLong(stringInput[1]);
                    for (int i = 0; i < loopNum; i++) {
                        System.out.println(input + i + " is " + determineProperties(input + i));
                    }
                }

                if (stringInput.length == 3) {
                    loopNum = Long.parseLong(stringInput[1]);
                    chooseProperty.append(stringInput[2]);
                    boolean includesProperty = false;

                    //test selection
                    List<String> properties = Arrays.asList("DUCK", "EVEN", "ODD", "GAPFUL", "SPY", "PALINDROMIC", "BUZZ", "SQUARE", "SUNNY");
                    for (String e : properties) {
                        if (chooseProperty.equals(e)) {
                            includesProperty = true;
                            break;
                        }
                    }
                    if (includesProperty == false) {
                        System.out.println("The property "  + " is " +  chooseProperty + " is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
                        continue;
                    }
                    switch (new String(chooseProperty)) {
                        case "EVEN":
                            for (int i = 0; i < loopNum; i++) {
                                if (isEven(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "ODD":
                            for (int i = 0; i < loopNum; i++) {
                                if (isOdd(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SPY":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSpy(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "PALINDROMIC":
                            for (int i = 0; i < loopNum; i++) {
                                if (isPalindrome(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "DUCK":
                            for (int i = 0; i < loopNum; i++) {
                                if (isDuck(input+i) == true) {
                                    System.out.println((input + i) + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "GAPFUL":
                            for (int i = 0; i < loopNum; i++) {
                                if (isGapFul(input + i) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "BUZZ":
                            for (int i = 0; i < loopNum; i++) {
                                if (isBuzz(input + i) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SQUARE":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSquare(input + i) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SUNNY":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSquare(input + i + 1) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                    }
                }

                if (stringInput.length == 4) {
                    loopNum = Long.parseLong(stringInput[1]);
                    chooseProperty.append(stringInput[2]);
                    secondProperty.append(stringInput[3]);
                    boolean includesProperty = false;
                    boolean includesSecondProperty = false;

                    //EVEN/ODD, DUCK/SPY, SUNNY/SQUARE verification
                    if (chooseProperty.equals("SUNNY") && secondProperty.equals("SQUARE")) {
                        System.out.println("The request contains mutually exclusive properties: " + " [" + chooseProperty + secondProperty + "]");
                        continue;
                    }
                    if (chooseProperty.equals("SQUARE") && secondProperty.equals("SUNNY")) {
                        System.out.println("The request contains mutually exclusive properties: " + " [" + chooseProperty + ", " + secondProperty + "]");
                        continue;
                    }
                    if (chooseProperty.equals("EVEN") && secondProperty.equals("ODD")) {
                        System.out.println("The request contains mutually exclusive properties: " + " [" + chooseProperty + secondProperty + "]");
                        continue;
                    }
                    if (chooseProperty.equals("ODD") && secondProperty.equals("EVEN")) {
                        System.out.println("The request contains mutually exclusive properties: " + " [" + chooseProperty + secondProperty + "]");
                        continue;
                    }
                    if (chooseProperty.equals("DUCK") && secondProperty.equals("SPY")) {
                        System.out.println("The request contains mutually exclusive properties: " + " [" + chooseProperty + secondProperty + "]");
                        continue;
                    }
                    if (chooseProperty.equals("SPY") && secondProperty.equals("DUCK")) {
                        System.out.println("The request contains mutually exclusive properties: " + " [" + chooseProperty + secondProperty + "]");
                        continue;
                    }

                    //test selection
                    List<String> properties = Arrays.asList("DUCK", "EVEN", "ODD", "GAPFUL", "SPY", "PALINDROMIC", "BUZZ", "SQUARE", "SUNNY");
                    for (String e : properties) {
                        if (chooseProperty.equals(e) && secondProperty.equals((e))) {
                            includesProperty = true;
                            includesSecondProperty = true;
                            break;
                        }
                    }
                    if (includesSecondProperty == false) {
                        System.out.println("The property "  + " is " + secondProperty + " is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]");
                        continue;
                    }
                    if (includesProperty == false) {
                        System.out.println("The property "  + " is " +  chooseProperty + " is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]");
                        continue;
                    }
                    if (includesProperty == false && includesSecondProperty == false) {
                        System.out.println("The property "  + " is " +  chooseProperty + secondProperty + " is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]");
                        continue;
                    }

                    switch (new String(chooseProperty)) {
                        case "EVEN":
                            for (int i = 0; i < loopNum; i++) {
                                if (isEven(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "ODD":
                            for (int i = 0; i < loopNum; i++) {
                                if (isOdd(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SPY":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSpy(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "PALINDROMIC":
                            for (int i = 0; i < loopNum; i++) {
                                if (isPalindrome(input + i) == true) {
                                    System.out.println((input + i)  + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "DUCK":
                            for (int i = 0; i < loopNum; i++) {
                                if (isDuck(input+i) == true) {
                                    System.out.println((input + i) + " is " +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "GAPFUL":
                            for (int i = 0; i < loopNum; i++) {
                                if (isGapFul(input + i) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "BUZZ":
                            for (int i = 0; i < loopNum; i++) {
                                if (isBuzz(input + i) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SQUARE":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSquare(input + i) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SUNNY":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSquare(input + i + 1) == true) {
                                    System.out.println((input + i) + " is " + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                    }
                }

                if (input < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                if (loopNum < 0) {
                    System.out.println("The second parameter should be a natural number.");
                }
                if (input == 0) {
                    System.out.println("Goodbye!");
                    program = false;
                    break;
                }

                if (loopNum == 0) {
                    System.out.println("Properties of " + input);
                    System.out.println("buzz: " + isBuzz(input));
                    System.out.println("duck: " + isDuck(input));
                    System.out.println("palindromic: " + isPalindrome(input));
                    System.out.println("gapful: " + isGapFul(input));
                    System.out.println("spy: " + isSpy(input));
                    System.out.println("even: " + isEven(input));
                    System.out.println("odd: " + isOdd(input));
                    System.out.println("square: " + isSquare(input));
                    System.out.println("sunny: " + isSquare(input+1));
                }

            }   catch(InputMismatchException e){
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }

    public static boolean isSquare(long x) {
        boolean result = false;
        for (int i = 1; i <= x ; i++) {
            if (i * i == x) {
                result = true;
            }
        }
        return result;
    }

//    public static boolean isSunny(long x) {
//
//    }

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

    public static String determineProperties(long x) {
        String output = "";
        if (isBuzz(x)) {
            output += " buzz,";
        }
        if (isDuck(x)) {
            output += " duck,";
        }
        if (isPalindrome(x)) {
            output += " palndromic,";
        }
        if (isGapFul(x)) {
            output += " gapful,";
        }
        if (isSpy(x)) {
            output += " spy,";
        }
        if (isEven(x)) {
            output += " even,";
        }
        if (isOdd(x)) {
            output += " odd,";
        }
        if (isSquare(x)) {
            output += " square,";
        }
        if (isSquare(x+1)) {
            output += " sunny,";
        }
        return output.substring(0, output.length()-1);
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
        for (int i = 0, j = String.valueOf(x).length()-1; i < x && j > 0; i++, j--) {
            if (String.valueOf(x).charAt(i) != String.valueOf(x).charAt(j)) {
                palindrome = false;
            }
        }
        return palindrome;
    }
}



