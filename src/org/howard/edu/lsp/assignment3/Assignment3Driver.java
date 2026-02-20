package org.howard.edu.lsp.assignment3;

/**
 * Entry point for Assignment 3 ETL Pipeline.
 */
public class Assignment3Driver {

    public static void main(String[] args) {
        ETLProcessor processor = new ETLProcessor();
        processor.run();
    }
}