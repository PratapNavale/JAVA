package com.calculator;

public class Calculator {

    // Method for addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method for division
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return Double.NaN; // Return Not-a-Number for division by zero
        }
        return a / b;
    }

    // Method to calculate modulus
    public double modulus(double a, double b) {
        return a % b;
    }
}
