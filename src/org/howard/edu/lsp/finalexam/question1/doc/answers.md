# Question 1 Answers

## Part 1:

**Shared Resource #1:**
`nextId` – the integer counter used to generate unique request IDs. It is 
an instance variable accessed and modified by multiple threads.

**Shared Resource #2:**
`requests` – the `ArrayList<String>` that stores all submitted requests. 
Multiple threads may read from or write to this list simultaneously.

**Concurrency Problem:**
A race condition may occur. If two threads call `addRequest()` at the same 
time, they may both read the same value of `nextId` before either 
increments it, resulting in duplicate IDs being assigned. Similarly, 
simultaneous writes to the `ArrayList` can corrupt the list.

**Why addRequest() is unsafe:**
`addRequest()` is unsafe because it calls `getNextId()` and 
`requests.add()` as separate, non-atomic operations. Between these two 
steps, another thread can interleave and execute the same sequence, 
causing two requests to receive the same ID or the list to be updated in 
an inconsistent order. There is no synchronization guarding the 
combination of ID generation and list insertion as a single atomic unit.

---

## Part 2:

**Fix A:** `public synchronized int getNextId() { ... }`

**Incorrect.** Synchronizing only `getNextId()` ensures that ID generation 
is thread-safe in isolation, but it does not protect the full sequence 
inside `addRequest()`. Two threads can still interleave between the call 
to `getNextId()` and the call to `requests.add()`, leading to race 
conditions on the list and non-atomic request creation. The problem is not 
fully solved.

**Fix B:** `public synchronized void addRequest(String studentName) { ... 
}`

**Correct.** Synchronizing `addRequest()` makes the entire method — 
including the call to `getNextId()` and the insertion into `requests` — 
execute as one atomic operation. Only one thread can execute 
`addRequest()` at a time, which prevents duplicate IDs and list 
corruption. This correctly solves the concurrency problem.

**Fix C:** `public synchronized List<String> getRequests() { ... }`

**Incorrect.** Synchronizing `getRequests()` only protects the act of 
returning the list reference. It does nothing to prevent race conditions 
during `addRequest()`, where ID generation and list insertion can still be 
interleaved by multiple threads. The root concurrency problem remains 
completely unaddressed.

---

## Part 3:

**Answer + Explanation:**

No, `getNextId()` should not be public.

According to Arthur Riel's heuristics, a class should hide its 
implementation details and expose only what is necessary for external use 
— this is the principle of minimizing the public interface. `getNextId()` 
is an internal helper that supports the logic of `addRequest()`. It is an 
implementation detail of how requests are created, not a service that 
external callers need to use directly. Making it public violates 
encapsulation by exposing internal state management, which could allow 
outside code to consume IDs incorrectly or out of sequence. It should be 
private so that only `addRequest()` can invoke it in the correct context.

---

## Part 4:

**Description:**

The alternative approach discussed in lecture is using 
`java.util.concurrent` utilities — specifically `AtomicInteger` for 
thread-safe ID generation and `CopyOnWriteArrayList` for thread-safe list 
access. `AtomicInteger` provides atomic increment-and-get operations 
without requiring explicit `synchronized` blocks. This approach avoids the 
overhead of broad method-level locking and leverages purpose-built 
concurrency classes from the Java standard library.

**Code Snippet:**

```java
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new CopyOnWriteArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement();
        String request = "Request-" + id + " from " + studentName;
        requests.add(request);
    }
}
```
