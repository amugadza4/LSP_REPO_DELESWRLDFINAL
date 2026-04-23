package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class that defines the Template Method pattern for report 
generation.
 * The generateReport() method defines the fixed workflow; subclasses 
provide
 * the specific implementations for each step.
 */
public abstract class Report {

    /**
     * Template method that defines the fixed workflow for generating a 
report.
     * Subclasses must implement each individual step but cannot change 
the order.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        formatHeader();
        System.out.println("=== BODY ===");
        formatBody();
        System.out.println("=== FOOTER ===");
        formatFooter();
    }

    /**
     * Loads the data required by the report.
     * Must be implemented by subclasses to set their specific fields.
     */
    protected abstract void loadData();

    /**
     * Formats and prints the report header.
     */
    protected abstract void formatHeader();

    /**
     * Formats and prints the report body.
     */
    protected abstract void formatBody();

    /**
     * Formats and prints the report footer.
     */
    protected abstract void formatFooter();
}
