package com.csmithswim;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        amazingNumbers();






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

    public static void amazingNumbers() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests: \n-enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");

        boolean program = true;
        while (program) {
            System.out.println("Enter a request: ");
            Scanner scanner = new Scanner(System.in);
            try {
               String[] stringInput = scanner.nextLine().split(" ");
               long input = Long.parseLong(stringInput[0]);
               long inputNum = 0;
               if (stringInput.length > 1) {
               inputNum = Long.parseLong(stringInput[1]);
               }

                if (input < 0 || inputNum < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                if (input == 0) {
                    System.out.println("Goodbye!");
                    program = false;
                    break;
                }

                if (inputNum > 0) {

                    for (int i = 0; i < inputNum; i++) {
                        System.out.println(input + i + " is " + determineProperties(input + i));
                    }
                }
                if (inputNum == 0) {
                    System.out.println("Properties of " + input);
                    System.out.println("buzz: " + isBuzz(input));
                    System.out.println("duck: " + isDuck(input));
                    System.out.println("palindromic: " + isPalindrome(input));
                    System.out.println("gapful: " + isGapFul(input));
                    System.out.println("even: " + isEven(input));
                    System.out.println("odd: " + !isEven(input));
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
        if (isEven(x)) {
            output += " even,";
        }
        if (!isEven(x)) {
            output += " odd,";
        }
        return output.substring(0, output.length()-1);
    }

    public static boolean isEven(long x) {
        return (x % 2 == 0);
    }

    public static boolean isBuzz(long x) {
        return (x % 7 == 0 || (x - 7) % 10 == 0);
    }

    //Method to test for duck numbers
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

    //Method to test for palindrome numbers
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




