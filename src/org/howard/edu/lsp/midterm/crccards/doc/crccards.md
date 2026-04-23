# CRC Card Delegation Explanation

| Class | Responsibilities | Collaborators |
|-------|-----------------|---------------|
| Task | Store own data (taskId, description, status), manage own status | None |
| TaskManager | Store tasks, find tasks by ID, retrieve tasks by status | Task |

TaskManager collaborates with Task because its responsibilities — storing tasks, finding tasks
by ID, and retrieving tasks by status — require it to directly create and interact with Task
objects. Task does not collaborate with TaskManager because its only responsibilities are storing
its own data and managing its own status; it has no need to know about the collection that holds
it. This one-way relationship reflects good object-oriented design, where Task is a self-contained
data object and TaskManager acts as the coordinator.
