package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that delegates price calculation to a PricingStrategy.
 * The strategy can be swapped at runtime without modifying this class.
 *
 * @author Ropafadzo Adele Mugadza
 */
public class PriceCalculator {

    private PricingStrategy strategy;

    /**
     * Constructs a PriceCalculator with the specified strategy.
     *
     * @param strategy the pricing strategy to use
     */
    public PriceCalculator(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets a new pricing strategy.
     *
     * @param strategy the new strategy to apply
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates the final price using the current strategy.
     *
     * @param price the original price
     * @return the final calculated price
     */
    public double calculatePrice(double price) {
        return strategy.calculatePrice(price);
    }
}
