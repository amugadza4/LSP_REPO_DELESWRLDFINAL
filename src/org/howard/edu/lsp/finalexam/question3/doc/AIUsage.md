# AI Usage Report – Question 3

## AI Tools Used:
ChatGPT (OpenAI)

## Prompts Used:

1. "Can you explain how to write JUnit 5 test cases using assertThrows() 
for exception testing?"

2. "What are good boundary values to test for a grade calculator that 
accepts scores between 0 and 100?"

3. "How do I use @BeforeEach in JUnit 5 to set up a fresh object before 
each test?"

## How AI Helped:
The AI clarified the correct syntax for `assertThrows()` with a lambda 
expression and helped identify meaningful boundary values such as exactly 
60 and exactly 90. It also reinforced the purpose of `@BeforeEach` to 
ensure test isolation. I wrote all test cases myself using these concepts 
as a guide.

## Reflection:
I learned that boundary-value testing is most effective when targeting the 
exact threshold values in conditional logic, since those are the points 
most likely to reveal off-by-one errors.
