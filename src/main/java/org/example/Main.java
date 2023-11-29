package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static double add(double a, double b) {
        logger.info("Attempt Operation Addition");
        double res = a+b;
        logger.info("Attempt Successful!");
        
        return res;
    }
    public static double subtract(double a, double b) {
        logger.info("Attempt Operation Subtraction");
        double res = a-b;
        logger.info("Attempt Successful!");
        
        return res;
    }
    public static double multiply(double a, double b) {
        logger.info("Attempt Operation Multiplication");
        double res = a*b;
        logger.info("Attempt Successful!");
        
        return res;
    }
    public static double divide(double a, double b) {
        logger.info("Attempt Operation Division");
        if (b == 0) {
            logger.warn("Division by zero is not allowed");
            throw new ArithmeticException("Division by zero");
        }

        double res = a / b;
        logger.info("Attempt Successful!");

        return res;
    }
    public static void main(String[] args) {
        logger.info("Start of execution");
        System.out.printf("Hello and welcome to Calculator v0.0.0!\n");
        
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Pick an operation:");
            System.out.println("0: Addition");
            System.out.println("1: Subtraction");
            System.out.println("2: Multiplication");
            System.out.println("3: Division");
            System.out.println("4: Exit the program");
            System.out.print("Enter your choice (0-4): ");

            int operation = scanner.nextInt();

            if(operation == 4) {
                logger.info("End of execution");
                System.out.println("Exitting Calculator");
                break;
            }

            System.out.print("Enter the first number: ");
            double firstNumber = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double secondNumber = scanner.nextDouble();

            double result = -1;

            switch (operation) {
                case 0: // Addition
                    result = add(firstNumber, secondNumber);
                    break;
                case 1: // Subtraction
                    result = subtract(firstNumber, secondNumber);
                    break;
                case 2: // Multiplication
                    result = multiply(firstNumber, secondNumber);
                    break;
                case 3: // Division
                    // Check for division by zero
                    if (secondNumber == 0) {
                        logger.warn("Division by zero is not allowed");
                        System.out.println("Cannot divide by zero.");
                        continue;
                    }
                    result = divide(firstNumber, secondNumber);
                    break;
                default:
                    logger.warn("Invalid Input");
                    System.out.println("Invalid operation. Please try again.");
                    continue;
            }

            System.out.printf("The result is: %.2f%n", result);
            System.out.println();
        }

        scanner.close();
    }
}