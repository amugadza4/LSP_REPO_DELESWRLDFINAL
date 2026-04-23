# Development Log – Question 1

## External Resources Used

### AI Tool: Claude (claude.ai)

#### Full Conversation Transcript:

**User:** I need help answering my midterm question, can you help me create the correct code, files and output to receive an 100/100 based on the rubric step by step.

**Claude:** Helped implement Task.java with the following design decisions:
- Private fields: taskId, description, status
- Default status set to "OPEN" in constructor
- setStatus() validates against OPEN, IN_PROGRESS, COMPLETE; sets UNKNOWN for invalid values
- toString() formats as: taskId description [status]

Helped implement TaskManager.java with the following design decisions:
- Used LinkedHashMap to prevent duplicate task IDs and maintain insertion order
- addTask() throws IllegalArgumentException on duplicate task ID
- findTask() returns null if task not found
- getTasksByStatus() iterates map values and filters by status

Driver.java was provided by the professor and was not modified.

All implementations were verified against the required expected output:
OPEN TASKS
T1 Write report [OPEN]
T3 Submit homework [OPEN]

TESTING DUPLICATE TASK ID
Duplicate task ID detected.

TESTING INVALID STATUS
T4 Invalid status test [UNKNOWN]

TESTING FIND TASK
T2 Study for exam [IN_PROGRESS]
Task not found.
