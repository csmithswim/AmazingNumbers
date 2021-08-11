package com.csmithswim;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        boolean program = true;
        while (program) {
            System.out.println("Enter a natural number: ");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            if (input < 0) {
                System.out.println("This number is not natural!");
                break;
            }
            boolean even = (input % 2 == 0);
            boolean buzz = (input % 7 == 0 || (input - 7) % 10 == 0);
            boolean duck = false;

            String duckString = Integer.toString(input);
            for (int i = 1; i < duckString.length(); i++) {
                char testString = duckString.charAt(i);
                if (testString == '0') {
                    duck = true;
                }
            }

            System.out.println("Properties of " + input);
            System.out.println("even: " + even);
            System.out.println("odd: " + !even);
            System.out.println("buzz: " + buzz);
            System.out.println("duck: " + duck);
        }
    }
}
