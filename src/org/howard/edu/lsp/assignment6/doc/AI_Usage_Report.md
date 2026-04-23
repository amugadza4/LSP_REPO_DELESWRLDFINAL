AI Usage Report – Assignment 6

Below are selected prompts used during the development and testing of the 
IntegerSet implementation using JUnit 5.

---

Prompt 1
"Can you help me set up my Assignment 6 project structure and write JUnit 
test cases for my IntegerSet class?"

AI Suggestion
The AI suggested:

Creating the required package structure: 
src/org/howard/edu/lsp/assignment6
Copying the IntegerSet.java file from Assignment 5 into the new package
Creating a new IntegerSetTest.java file for JUnit testing
Writing JUnit 5 test cases for every method in the IntegerSet class
Including both normal cases and required edge cases such as duplicate 
values, empty sets, and missing elements
Using assertions such as assertEquals, assertTrue, assertFalse, and 
assertThrows

My Adaptation
I followed these suggestions to:

Set up the correct package structure required by the assignment
Create and organize the test file properly
Ensure each method had both normal and edge case tests
Verify that all tests aligned with the assignment rubric

---

Prompt 2
"My tests are failing for intersect, diff, and complement. Can you help 
fix my IntegerSet implementation?"

AI Suggestion
The AI suggested:

Using built-in Java ArrayList methods such as retainAll() for intersection
Using removeAll() for difference operations
Implementing complement by creating a new list and removing overlapping 
elements
Ensuring methods correctly modify the set as expected by the test cases

My Adaptation
I used these suggestions to:

Fix logical errors in my set operations
Ensure intersect(), diff(), and complement() returned correct results
Validate that all edge cases passed successfully

---

Prompt 3
"I am getting an error saying Java is not installed. How do I fix this and 
run my JUnit tests in terminal?"

AI Suggestion
The AI suggested:

Installing Java (JDK 17) using a direct installer
Verifying installation using java -version and javac -version
Compiling the project using javac with the JUnit standalone jar
Running tests using the JUnit platform console

My Adaptation
I followed these steps to:

Install and configure Java correctly on my Mac
Compile my project successfully using terminal commands
Run all JUnit tests and verify that they passed

---

External References
ChatGPT (OpenAI) was used for guidance in setting up the project, writing 
test cases, debugging code, and configuring the development environment.

