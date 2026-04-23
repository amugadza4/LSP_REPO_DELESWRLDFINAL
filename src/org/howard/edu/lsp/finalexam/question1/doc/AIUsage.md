# AI Usage Report – Question 1

## AI Tools Used:
ChatGPT (OpenAI)

## Prompts Used:

1. "Can you explain what shared resources are in a multithreaded Java 
program and how race conditions occur?"

2. "For the RequestManager class, which synchronized fix correctly solves 
the concurrency problem and why?"

3. "According to Arthur Riel's heuristics, should a helper method like 
getNextId() be public or private?"

4. "Can you show me how to use AtomicInteger and CopyOnWriteArrayList to 
make addRequest() thread-safe without using synchronized?"

## How AI Helped:
The AI helped clarify why synchronizing only part of a compound action 
does not solve a race condition. It also reinforced the concept that 
Riel's heuristics favor hiding internal helper methods from the public 
interface. The AtomicInteger code snippet was used as a reference for the 
alternative synchronization section.

## Reflection:
I learned that thread safety requires protecting the entire sequence of 
dependent operations, not just individual method calls. Using atomic 
classes from java.util.concurrent is a cleaner and more scalable approach 
than broad synchronized blocks.
