# Question 5 – Arthur Riel's OO Design Heuristics

## Heuristic 1:

**Name:**
All data should be hidden within its class.

**Explanation:**
This heuristic improves maintainability by preventing external classes 
from directly accessing or modifying an object's internal state. In 
lecture, this was illustrated by making instance variables private and 
providing controlled access through getter and setter methods. By hiding 
data, changes to the internal representation of a class do not break other 
classes that depend on it, since those classes only interact through the 
public interface.

---

## Heuristic 2:

**Name:**
The public interface of a class should minimize the number of methods it 
exposes.

**Explanation:**
Keeping the public interface small improves readability because users of a 
class only see what they need to interact with, reducing cognitive 
overhead. In lecture, this was discussed in the context of marking helper 
methods as private rather than public. A bloated public interface signals 
poor design because it exposes implementation details that the caller 
should not depend on, making the class harder to change without breaking 
external code.

---

## Heuristic 3:

**Name:**
A class should capture one and only one key abstraction.

**Explanation:**
This heuristic improves both readability and maintainability by ensuring 
each class has a single, clear responsibility. In lecture, this was 
connected to the idea that a class doing too many things becomes difficult 
to understand and test. When a class captures exactly one abstraction, 
changes to that concern are localized within the class, and the class 
itself serves as a self-documenting unit that clearly communicates its 
purpose.
