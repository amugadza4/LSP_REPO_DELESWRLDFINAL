package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        // Handle missing input file
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath))
        ) {
            // Always write header
            writer.println("ProductID,Name,Price,Category,PriceRange");

            String line = reader.readLine(); // read header
            if (line == null) {
                // empty file (no header even)
                System.out.println("Rows read: 0");
                System.out.println("Rows transformed: 0");
                System.out.println("Rows skipped: 0");
                System.out.println("Output written to: " + outputPath);
                return;
            }

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                line = line.trim();
                if (line.isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim().toUpperCase();
                    BigDecimal price = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();

                    String originalCategory = category;

                    // Electronics discount
                    if (category.equals("Electronics")) {
                        price = price.multiply(new BigDecimal("0.9"));
                    }

                    // Round price
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // Premium Electronics rule
                    if (price.compareTo(new BigDecimal("500.00")) > 0
                            && originalCategory.equals("Electronics")) {
                        category = "Premium Electronics";
                    }

                    // PriceRange
                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    writer.println(
                        productId + "," +
                        name + "," +
                        price.toString() + "," +
                        category + "," +
                        priceRange
                    );

                    rowsWritten++;

                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

            System.out.println("Rows read: " + rowsRead);
            System.out.println("Rows transformed: " + rowsWritten);
            System.out.println("Rows skipped: " + rowsSkipped);
            System.out.println("Output written to: " + outputPath);

        } catch (IOException e) {
            System.out.println("ERROR: Unable to process files.");
        }
    }
}

