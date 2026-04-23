package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class demonstrating the Strategy Pattern for price calculation.
 *
 * @author Ropafadzo Adele Mugadza
 */
public class Driver {

    /**
     * Main method demonstrating all four pricing strategies at price 100.0.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator(new RegularPricingStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new MemberPricingStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new VIPPricingStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new HolidayPricingStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(100.0));
    }
}
