package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Handles transformation logic for Product objects.
 */
public class ProductTransformer {

    public Product transform(Product product) {

        String originalCategory = product.getCategory();

        // 1. Uppercase name
        product.setName(product.getName().toUpperCase());

        double price = product.getPrice();

        // 2. Apply discount if Electronics
        if (originalCategory.equals("Electronics")) {
            price = price * 0.9;
        }

        // 3. Round price (half-up)
        BigDecimal bd = new BigDecimal(price);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        price = bd.doubleValue();
        product.setPrice(price);

        // 4. Change category if needed
        if (originalCategory.equals("Electronics") && price > 500.00) {
            product.setCategory("Premium Electronics");
        }

        // 5. Determine PriceRange
        if (price <= 10.00) {
            product.setPriceRange("Low");
        } else if (price <= 100.00) {
            product.setPriceRange("Medium");
        } else if (price <= 500.00) {
            product.setPriceRange("High");
        } else {
            product.setPriceRange("Premium");
        }

        return product;
    }
}
