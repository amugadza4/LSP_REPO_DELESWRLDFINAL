package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;

public class ETLProcessor {

    public void run() {

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
                System.out.println("Rows read: 0");
                System.out.println("Rows transformed: 0");
                System.out.println("Rows skipped: 0");
                System.out.println("Output written to: " + outputPath);
                return;
            }

            ProductTransformer transformer = new ProductTransformer();

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
                    String name = parts[1].trim();
                    BigDecimal priceBD = new BigDecimal(parts[2].trim());
                    String category = parts[3].trim();

                    double price = priceBD.doubleValue();

                    // Create Product object
                    Product product = new Product(productId, name, price, category);

                    // Transform using transformer class
                    product = transformer.transform(product);

                    // Write transformed row
                    writer.println(product.toCsvRow());

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