package org.howard.edu.lsp.finalexam.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class that demonstrates polymorphism with the Template Method 
pattern.
 * Adds both report types to a list and calls generateReport() on each.
 */
public class Driver {

    /**
     * Main method — entry point for report generation demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<Report> reports = new ArrayList<>();
        reports.add(new StudentReport());
        reports.add(new CourseReport());

        for (Report report : reports) {
            report.generateReport();
            System.out.println();
        }
    }
}
