# Design Evaluation – OrderProcessor

## Issue 1: Poor Encapsulation
All four fields (customerName, email, item, price) are declared public. Any external class can
read or modify them freely. Fields should be private with controlled access through getters
and setters, following Riel's heuristic that data should be hidden from the outside world.

## Issue 2: Single Responsibility Violation
The processOrder() method performs five unrelated responsibilities in one place: calculating
tax, printing a receipt, saving to a file, sending an email, and logging activity. Each of
these is a separate reason for the class to change, violating the principle that a class
should have only one responsibility.

## Issue 3: No Separation of Concerns
Business logic, file I/O, console output, and communication are all tangled together. This
makes it impossible to change one behavior (e.g., switch from file storage to a database)
without risking breaking the others.

## Issue 4: Logical Error — Discount Applied Too Late
The discount is calculated after the receipt has already been printed. This means the customer
receives a receipt showing the wrong total. This bug exists because responsibilities are not
properly organized or sequenced.

## Issue 5: Low Cohesion and High Coupling
The class tries to do everything, resulting in low cohesion. Any change to tax rules, file
format, email logic, or logging requires touching this single class, making it fragile and
hard to maintain or extend.
