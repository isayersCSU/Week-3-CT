package grocerycost;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GroceryCost {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Prompt for coupon decimal
        System.out.print("Enter coupon decimal (between 0 and 1): ");
        boolean couponValidInput = false;       
// Set default value to 0.10. 
// If input is invalid, set couponDecimal to 0.10 and exit the loop. 
// If input is not a number, set couponDecimal to 0.10 and exit the loop.
        double couponDecimal = 0.10; 
        while (!couponValidInput) {
            try {
                couponDecimal = scanner.nextDouble();
                if (couponDecimal >= 0 && couponDecimal <= 1) {
                    couponValidInput = true;
                } else {
                    couponDecimal = 0.10;
                    couponValidInput = true;
                }
            } catch (InputMismatchException e) {
                couponDecimal = 0.10;
                couponValidInput = true;
            }
        }
// Create ArrayList for Values and Prompt User for Costs
        ArrayList<Double> costs = new ArrayList<>();
        System.out.println("Enter 4 Weeks of Grocery Costs:");
        for (int i = 0; i < 4; i++) {
            System.out.print("Week " + (i + 1) + ": ");
            boolean costValidInput = false;
            while (!costValidInput) {
                try {
                    double cost = scanner.nextDouble();
                    costs.add(cost);
                    costValidInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            }
        }
// Calculate the total cost
        double totalCost = 0;
        for (double cost : costs) {
            totalCost += cost;
        }
// Apply discount
        double discountAmount = totalCost * couponDecimal;
        totalCost -= discountAmount;
// Print the results
        System.out.println("Costs entered: " + costs);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Coupon applied: " + (couponDecimal * 100) + "% (" + String.format("$%.2f", discountAmount) + ")");
        System.out.println("Total cost for 4 weeks after coupon: $" + String.format("%.2f", totalCost));
    }
}