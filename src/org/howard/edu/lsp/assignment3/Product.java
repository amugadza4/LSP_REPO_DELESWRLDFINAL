package org.howard.edu.lsp.assignment3;

/**
 * Represents a product in the ETL pipeline.
 * Encapsulates product data and provides access methods.
 */
public class Product {

    private int productId;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Returns the CSV representation of the product.
     */
    public String toCsvRow() {
        return String.format("%d,%s,%.2f,%s,%s",
                productId, name, price, category, priceRange);
    }
}
