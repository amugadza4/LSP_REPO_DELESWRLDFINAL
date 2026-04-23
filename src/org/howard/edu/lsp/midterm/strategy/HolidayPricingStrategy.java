package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for holiday promotions. Applies a 15% discount.
 *
 * @author Ropafadzo Adele Mugadza
 */
public class HolidayPricingStrategy implements PricingStrategy {

    /**
     * Returns the price with a 15% holiday discount applied.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}
