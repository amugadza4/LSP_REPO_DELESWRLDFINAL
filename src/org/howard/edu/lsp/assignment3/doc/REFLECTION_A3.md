# Assignment 3 Reflection – Object-Oriented Redesign

## Overview

In Assignment 2, I implemented a CSV ETL pipeline using a single class (ETLPipeline) that handled extraction, transformation, and loading in one procedural structure. While the program met the functional requirements, the design placed all responsibilities in one file, making it less modular and harder to maintain.

In Assignment 3, I redesigned the solution using object-oriented principles. The behavior of the program remains identical to Assignment 2 (same inputs, outputs, transformations, skipping rules, and error handling), but the internal structure has been significantly improved.

---

## Design Differences Between Assignment 2 and Assignment 3

### Assignment 2 Design
- Single class: `ETLPipeline`
- All logic inside `main()`
- Data parsing, transformation, and writing handled in one place
- Procedural design

### Assignment 3 Design
The solution was decomposed into four classes:

1. `Product`
2. `ProductTransformer`
3. `ETLProcessor`
4. `Assignment3Driver`

Each class now has a clear responsibility.

---

## How Assignment 3 Is More Object-Oriented

### 1. Class and Object Usage

A `Product` class was introduced to represent a product as an object. Instead of passing around raw variables, product data is now encapsulated inside a Product object.

This improves readability and models real-world data more naturally.

---

### 2. Encapsulation

The `Product` class uses private fields with getters and setters. This protects internal state and ensures controlled modification of product attributes.

---

### 3. Separation of Concerns

Responsibilities are divided clearly:

- `ETLProcessor` → Handles file reading, skipping rules, writing, and run summary.
- `ProductTransformer` → Applies transformation logic in the required order.
- `Product` → Stores product data and formats CSV output.
- `Assignment3Driver` → Contains only the main method and starts the program.

This separation makes the program more modular and maintainable.

---

### 4. Polymorphism / Extensibility

While inheritance was not necessary for this assignment, the design now allows future extension. For example, additional transformers could be implemented without modifying the core ETL processing logic.

---

## Use of Generative AI

I used a generative AI assistant to help brainstorm how to decompose the original Assignment 2 procedural implementation into multiple object-oriented classes. The AI suggested introducing:

- A Product class
- A separate transformer class
- A driver class
- Moving transformation logic out of main

I reviewed all suggestions and ensured:
- The transformation order remained exactly as specified
- All skipping rules were preserved
- The output matched Assignment 2 exactly

All AI suggestions were manually verified and adapted to meet assignment requirements.

---

## Testing Strategy

To confirm Assignment 3 behaves identically to Assignment 2, I:

1. Ran the robust sample input provided in the assignment.
2. Verified:
   - Rows read: 11
   - Rows transformed: 7
   - Rows skipped: 4
3. Compared the generated `transformed_products.csv` file to the expected output.
4. Tested the empty input case (header only).
5. Tested the missing input file case.

The outputs and behavior matched Assignment 2 exactly.

---

## Conclusion

Assignment 3 improves the internal structure of the ETL pipeline without changing its behavior. By applying object-oriented principles such as encapsulation and separation of responsibilities, the program is now more modular, readable, and maintainable while preserving correctness.