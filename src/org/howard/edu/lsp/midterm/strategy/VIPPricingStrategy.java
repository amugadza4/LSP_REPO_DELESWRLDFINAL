package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for VIP customers. Applies a 20% discount.
 *
 * @author Ropafadzo Adele Mugadza
 */
public class VIPPricingStrategy implements PricingStrategy {

    /**
     * Returns the price with a 20% VIP discount applied.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
