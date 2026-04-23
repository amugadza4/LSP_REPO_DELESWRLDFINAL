# AI Usage Report – Assignment 5

Below are selected prompts used during the development of the IntegerSet 
implementation.

---

## Prompt 1

"Can you explain step by step how to correctly follow my assignment rubric 
and create java code that aligns with the given Driver.java script."

### AI Suggestion

The AI suggested:

- Creating an `IntegerSet` class using an `ArrayList<Integer>` to store 
elements.
- Implementing all required methods (clear, length, equals, contains, 
largest, smallest, add, remove, union, intersect, diff, complement, 
isEmpty, toString).
- Ensuring no duplicate values are added to the set.
- Returning **new sets** for union, intersection, difference, and 
complement instead of modifying original sets.
- Sorting elements when generating the string output to meet formatting 
requirements.

### My Adaptation

I implemented the structure while ensuring:

- All methods matched the rubric exactly.
- Set operations did not modify the original sets.
- The `toString()` method returned values in ascending order in the format 
`[1, 2, 3]`.
- The implementation worked correctly with the provided `Driver.java`.

---

## Prompt 2

"Can you tell me what command to use in the Mac terminal since my eclipse 
crashed"

### AI Suggestion

The AI suggested:

- Using terminal commands to:
  - Navigate to the project directory using `cd`
  - Create required package folders using `mkdir -p`
  - Create Java files using `nano`
  - Compile using `javac`
  - Run the program using `java`
  - Use `git add`, `git commit`, and `git push` to upload to GitHub

### My Adaptation

I followed these steps to:

- Recreate my project structure manually in the terminal
- Place files in the correct package directory
- Prepare the assignment for GitHub submission despite not being able to 
use Eclipse

---

## External References

- ChatGPT (OpenAI) was used for guidance and troubleshooting
