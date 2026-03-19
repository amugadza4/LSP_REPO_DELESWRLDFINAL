package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for member customers. Applies a 10% discount.
 *
 * @author Ropafadzo Adele Mugadza
 */
public class MemberPricingStrategy implements PricingStrategy {

    /**
     * Returns the price with a 10% member discount applied.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}
