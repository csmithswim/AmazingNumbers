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
                long input = Long.parseLong(stringInput[0]);
                long loopNum = 0;
                String firstProperty = "";
                String secondProperty = "";


                if (input < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                if (input == 0) {
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
                        System.out.println(input + i + " is " + determineProperties(input + i));
                    }
                    System.out.println("");
                }

                if (stringInput.length == 3) {
                    loopNum = Long.parseLong(stringInput[1]);
                    firstProperty = (stringInput[2].toUpperCase());
                    boolean includesProperty = false;

                    //test selection
                    List<String> properties = Arrays.asList("DUCK", "EVEN", "ODD", "GAPFUL", "SPY", "PALINDROMIC", "BUZZ", "SQUARE", "SUNNY");
                    for (String e : properties) {
                        if (firstProperty.equals(e)) {
                            includesProperty = true;
                            break;
                        }
                    }
                    if (includesProperty == false) {
                        displayPropertyInputErrors(includesProperty, firstProperty);
                        continue;
                    }

                    switch (firstProperty) {
                        case "EVEN":
                            for (int i = 0; i < loopNum; i++) {
                                if (isEven(input + i) == true) {
                                    System.out.println((input + i)  + " is" +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "ODD":
                            for (int i = 0; i < loopNum; i++) {
                                if (isOdd(input + i) == true) {
                                    System.out.println((input + i)  + " is" +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SPY":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSpy(input + i) == true) {
                                    System.out.println((input + i)  + " is" +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "PALINDROMIC":
                            for (int i = 0; i < loopNum; i++) {
                                if (isPalindrome(input + i) == true) {
                                    System.out.println("\n" + (input + i)  + " is" +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "DUCK":
                            for (int i = 0; i < loopNum; i++) {
                                if (isDuck(input+i) == true) {
                                    System.out.println((input + i) + " is" +  determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "GAPFUL":
                            for (int i = 0; i < loopNum; i++) {
                                if (isGapFul(input + i) == true) {
                                    System.out.println((input + i) + " is" + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "BUZZ":
                            for (int i = 0; i < loopNum; i++) {
                                if (isBuzz(input + i) == true) {
                                    System.out.println((input + i) + " is" + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SQUARE":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSquare(input + i) == true) {
                                    System.out.println((input + i) + " is" + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                        case "SUNNY":
                            for (int i = 0; i < loopNum; i++) {
                                if (isSquare(input + i + 1) == true) {
                                    System.out.println((input + i) + " is" + determineProperties(input+i));
                                } else {
                                    i--;
                                    input++;
                                }
                            }
                            break;
                    }
                    System.out.println("");
                }

                if (stringInput.length == 4) {
                    loopNum = Long.parseLong(stringInput[1]);
                    firstProperty = stringInput[2].toUpperCase();
                    secondProperty = stringInput[3].toUpperCase();
                    boolean includesFirstProperty = false;
                    boolean includesSecondProperty = false;


                    //EVEN/ODD, DUCK/SPY, SUNNY/SQUARE verification


                    //test selection
                    List<String> properties = Arrays.asList("DUCK", "EVEN", "ODD", "GAPFUL", "SPY", "PALINDROMIC", "BUZZ", "SQUARE", "SUNNY");
                    for (String e : properties) {
                        if (firstProperty.equals(e)) {
                            includesFirstProperty = true;
                        }
                        if (secondProperty.equals(e)) {
                            includesSecondProperty = true;
                        }
                    }

                    displayPropertyInputErrors(includesFirstProperty, includesSecondProperty, firstProperty, secondProperty);

                    detectAndDisplayMutuallyExclusiveProperties(firstProperty, secondProperty);

                    //ODD/SPY, ODD/DUCK, ODD/SUNNY, ODD/SQUARE, ODD/BUZZ
                    //EVEN/DUCK, EVEN/SPY, EVEN/SUNNY, EVEN/SQUARE, EVEN/BUZZ
                    //DUCK/SUNNY, DUCK/SQUARE, DUCK/BUZZ
                    //SPY/SUNNY, SPY/SQUARE, SPY/BUZZ
                    //SQUARE/EVEN, SQUARE/ODD, SQUARE/DUCK, SQUARE/SPY, SQUARE/PALINDROMIC, SQUARE/BUZZ
                    //SUNNY/EVEN, SUNNY/ODD, SUNNY/DUCK, SUNNY/SPY, SUNNY/PALINDROMIC, SUNNY/BUZZ
                    //BUZZ/EVEN, BUZZ/ODD, BUZZ/DUCK, BUZZ/SPY, BUZZ/SQUARE, BUZZ/SUNNY
                    //GAPFUL/EVEN, GAPFUL/ODD, GAPFULL/DUCK, GAPFUL/SPY, GAPFUL/SQUARE, GAPFUL/SUNNY, GAPFUL/BUZZ
                    if (firstProperty.equals("GAP") && secondProperty.equals("EVEN")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isGapFul(input + i) == true && isEven(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("GAP") && secondProperty.equals("ODD")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isGapFul(input + i) == true && isOdd(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("GAP") && secondProperty.equals("DUCK")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isGapFul(input + i) == true && isEven(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("GAP") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isGapFul(input + i) == true && isSpy(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("GAP") && secondProperty.equals("SQUARE")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isGapFul(input + i) == true && isSquare(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("GAP") && secondProperty.equals("SUNNY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isGapFul(input + i) == true && isSquare(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("GAP") && secondProperty.equals("BUZZ")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isGapFul(input + i) == true && isBuzz(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }

                    if (firstProperty.equals("ODD") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isOdd(input + i) == true && isSpy(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("ODD") && secondProperty.equals("BUZZ")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isOdd(input + i) == true && isBuzz(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("ODD") && secondProperty.equals("PALINDROMIC")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isOdd(input + i) == true && isPalindrome(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("ODD") && secondProperty.equals("DUCK")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isOdd(input + i) == true && isDuck(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("ODD") && secondProperty.equals("SUNNY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isOdd(input + i) == true && isSquare(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("ODD") && secondProperty.equals("SQUARE")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isOdd(input + i) == true && isSquare(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("EVEN") && secondProperty.equals("DUCK")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isEven(input + i) == true && isDuck(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("EVEN") && secondProperty.equals("BUZZ")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isEven(input + i) == true && isDuck(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("EVEN") && secondProperty.equals("PALINDROMIC")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isEven(input + i) == true && isPalindrome(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("EVEN") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isEven(input + i) == true && isSpy(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("EVEN") && secondProperty.equals("SUNNY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isEven(input + i) == true && isSquare(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("EVEN") && secondProperty.equals("SQUARE")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isEven(input + i) == true && isSquare(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("DUCK") && secondProperty.equals("SUNNY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isDuck(input + i) == true && isSquare(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("DUCK") && secondProperty.equals("BUZZ")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isDuck(input + i) == true && isBuzz(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("DUCK") && secondProperty.equals("PALINDROMIC")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isDuck(input + i) == true && isPalindrome(input + i + 1) == true) {
                                System.out.println((input + i + 1) + " is" + determineProperties(input + i + 1));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("DUCK") && secondProperty.equals("SQUARE")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isDuck(input + i) == true && isSquare(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SPY") && secondProperty.equals("SUNNY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSpy(input + i) == true && isSquare(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SPY") && secondProperty.equals("BUZZ")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSpy(input + i) == true && isBuzz(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SPY") && secondProperty.equals("PALINDROMIC")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSpy(input + i) == true && isPalindrome(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SPY") && secondProperty.equals("SQUARE")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSpy(input + i) == true && isSquare(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }

                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("EVEN")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isEven(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("BUZZ")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isBuzz(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("ODD")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isOdd(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("SQUARE")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isSquare(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("SUNNY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isSquare(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("DUCK")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isDuck(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("GAPFUL")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isGapFul(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("PALINDROMIC") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isPalindrome(input + i) == true && isSpy(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SQUARE") && secondProperty.equals("EVEN")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i) == true && isEven(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SQUARE") && secondProperty.equals("BUZZ")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i) == true && isBuzz(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SQUARE") && secondProperty.equals("ODD")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i) == true && isOdd(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SQUARE") && secondProperty.equals("DUCK")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i) == true && isDuck(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SQUARE") && secondProperty.equals("GAPFUL")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i) == true && isGapFul(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SQUARE") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i) == true && isSpy(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SUNNY") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i + 1) == true && isSpy(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SUNNY") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i + 1) == true && isBuzz(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SUNNY") && secondProperty.equals("EVEN")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i + 1) == true && isEven(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SUNNY") && secondProperty.equals("ODD")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i + 1) == true && isOdd(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SUNNY") && secondProperty.equals("GAPFUL")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i + 1) == true && isGapFul(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SUNNY") && secondProperty.equals("DUCK")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i + 1) == true && isDuck(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("SUNNY") && secondProperty.equals("PALINDROMIC")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isSquare(input + i + 1) == true && isPalindrome(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("EVEN")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isEven(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("ODD")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isOdd(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("PALINDROMIC")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isPalindrome(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("GAPFUL")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isGapFul(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("DUCK")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isDuck(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("SPY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isSpy(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("SQUARE")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isSquare(input + i) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                    if (firstProperty.equals("BUZZ") && secondProperty.equals("SUNNY")) {
                        for (int i = 0; i < loopNum; i++) {
                            if (isBuzz(input + i) == true && isSquare(input + i + 1) == true) {
                                System.out.println((input + i) + " is" + determineProperties(input + i));
                            } else {
                                i--;
                                input++;
                            }
                        }
                    }
                }
                System.out.println("");

                if (loopNum == 0) {
                    System.out.println("\nProperties of " + input);
                    System.out.println("buzz: " + isBuzz(input));
                    System.out.println("duck: " + isDuck(input));
                    System.out.println("palindromic: " + isPalindrome(input));
                    System.out.println("gapful: " + isGapFul(input));
                    System.out.println("spy: " + isSpy(input));
                    System.out.println("even: " + isEven(input));
                    System.out.println("odd: " + isOdd(input));
                    System.out.println("square: " + isSquare(input));
                    System.out.println("sunny: " + isSquare(input+1) + "\n");
                }

            }   catch(InputMismatchException e){
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
    }

    public static void displayPropertyInputErrors(boolean includesProperty, String firstProperty) {
        StringBuilder message = new StringBuilder("\nThe property " + " is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]\n");
        if (includesProperty == false) {
            System.out.println(message.insert(14, firstProperty));
        }
    }

    public static void displayPropertyInputErrors(boolean includesFirstProperty, boolean includesSecondProperty, String firstProperty, String secondProperty) {
        StringBuilder message = new StringBuilder("\nThe property " + " is wrong.\n" +
                "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]\n");
        if (includesFirstProperty == false && includesSecondProperty == false) {
            System.out.println(message.replace(12, 17, "ies " + firstProperty + " " + secondProperty + " are"));
        }
        else if (includesFirstProperty == false) {
            System.out.println(message.insert(14, firstProperty));
        }
        else if (includesSecondProperty == false) {
            System.out.println(message.insert(14,  secondProperty));
        }
    }

    public static void detectAndDisplayMutuallyExclusiveProperties(String firstProperty, String secondProperty) {
        StringBuilder message = new StringBuilder("\nThe request contains mutually exclusive properties: " + "[" + firstProperty + ", " + secondProperty + "]\n" +
                "There are no numbers with these properties.\n");
        if (firstProperty.equals("SUNNY") && secondProperty.equals("SQUARE")) {
            System.out.println(message);
        }
        if (firstProperty.equals("SQUARE") && secondProperty.equals("SUNNY")) {
            System.out.println(message);
        }
        if (firstProperty.equals("EVEN") && secondProperty.equals("ODD")) {
            System.out.println(message);
        }
        if (firstProperty.equals("ODD") && secondProperty.equals("EVEN")) {
            System.out.println(message);
        }
        if (firstProperty.equals("DUCK") && secondProperty.equals("SPY")) {
            System.out.println(message);
        }
        if (firstProperty.equals("SPY") && secondProperty.equals("DUCK")) {
            System.out.println(message);
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



