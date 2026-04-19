/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package module_5.project5_1;

import java.util.Scanner;

/**
 *
 * @author lotfey
 */
public class Project5_1 {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            double[] numbers = new double[5];
            // Prompt the user to enter five numbers.
            System.out.println("Enter 5 numbers:");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print("Number " + (i + 1) + ": ");
                numbers[i] = input.nextDouble();
            }
            // Calculate the product of the numbers using the recursive method.
            double product = findProduct(numbers, 0);
            System.out.println("The product of all five numbers is: " + product);
        }
    }

    public static double findProduct(double[] numbers, int index) {
        // Base case: when we reach the end of the array, return 1
        // (1 is the multiplicative identity).
        if (index == numbers.length) {
            return 1;
        }

        // Recursive case: multiply the current number by
        // the product of the remaining numbers.
        return numbers[index] * findProduct(numbers, index + 1);
    }
}
