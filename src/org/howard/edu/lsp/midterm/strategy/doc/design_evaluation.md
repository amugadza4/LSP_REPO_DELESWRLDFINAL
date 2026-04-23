# Design Evaluation – PriceCalculator

## Issue 1: Open/Closed Principle Violation
The class must be directly modified every time a new customer type is added. A well-designed
system should be open for extension but closed for modification — meaning new behavior should
be added by writing new code, not editing existing code.

## Issue 2: Growing If-Statement Chain
Every new customer type adds another if-block to calculatePrice(). Over time this method
becomes long, hard to read, and difficult to maintain.

## Issue 3: No Use of Polymorphism
Each pricing rule is a distinct behavior that maps naturally to its own class. Using string
comparisons instead of polymorphism is a missed opportunity and goes against OO design principles.

## Issue 4: Poor Testability
All pricing rules are locked inside one method, making it impossible to test a single rule
in isolation. The Strategy Pattern fixes this by putting each rule in its own testable class.

## Issue 5: Hard to Extend
Adding complex pricing (e.g., VIP + holiday combined) would require messy nested conditions.
Separate strategy classes make this kind of extension clean and safe.
