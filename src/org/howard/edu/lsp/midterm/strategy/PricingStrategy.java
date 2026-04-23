package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for pricing calculations.
 * Each implementation defines a specific discount behavior.
 *
 * @author Ropafadzo Adele Mugadza
 */
public interface PricingStrategy {

    /**
     * Calculates the final price based on the strategy's discount rule.
     *
     * @param price the original price
     * @return the final price after discount
     */
    double calculatePrice(double price);
}
