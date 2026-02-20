# AI Prompts – Assignment 3

Below are selected prompts used during the redesign process.

---

## Prompt 1
"How can I redesign my Assignment 2 ETL pipeline to be more object-oriented while keeping the same behavior?"

### AI Suggestion
The AI suggested:
- Creating a Product class to represent product data.
- Creating a ProductTransformer class to handle transformation logic.
- Creating an ETLProcessor class for file handling.
- Moving main() into a driver class.

### My Adaptation
I implemented this structure while ensuring:
- Transformation order remained exactly as specified.
- Skipping rules were unchanged.
- Output formatting remained identical.

---

## Prompt 2
"How should I separate transformation logic from file processing logic?"

### AI Suggestion
Move transformation logic into a separate class and pass Product objects to it.

### My Adaptation
I created ProductTransformer with a transform(Product) method and updated ETLProcessor to use it.

---

## Prompt 3
"How can I ensure Assignment 3 produces the exact same output as Assignment 2?"

### AI Suggestion
Run identical test inputs and compare output files line-by-line.

### My Adaptation
I verified:
- Row counts
- Skipped rows
- Decimal rounding
- Category changes
- Final CSV format

The outputs matched exactly.