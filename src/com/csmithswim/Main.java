package com.csmithswim;
import java.util.*;



public class Main {

    public static void main(String[] args) {
/*        Ask a user to enter a natural number.
        If the number is not natural, print an error message.
        Calculate and print the parity of the number.
        Check whether is the number is a Buzz number and print the explanation.
        Finish the program after printing the message.
*/
        boolean program = true;

        while (program) {
            System.out.println("Enter a natural number: ");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            boolean buzz = true;


            if (input <= 0) {
                System.out.println("This number is not natural!");
                break;
            }
            if (input % 2 == 0) {
                System.out.println("This number is Even.");
            } else {
                System.out.println("This number is Odd.");
            }

            if (input % 7 == 0 || (input - 7) % 10 == 0) {
                System.out.println("It is a Buzz number.");
            } else {
                System.out.println("It is not a Buzz number.");
                buzz = false;
            }

            if (buzz) {
                System.out.println("buzz");
                if (input % 7 == 0 && (input - 7) % 10 == 0) {
                    System.out.println(input + " is divisible by 7 and ends with 7.");
                    break;
                } else if (input % 7 == 0) {
                    System.out.println(input + " is divisible by 7.");
                    break;
                } else if ((input - 7) % 10 == 0) {
                    System.out.println(input + " ends with 7.");
                    break;
                }
            } else {
                System.out.println(input + " is neither divisible by 7 nor does it end with 7.");
            }
        }
    }
}
