# Question 2 – Design Explanation

The Template Method pattern is used in the abstract `Report` class, which 
defines the `generateReport()` method as the template. This method calls 
`loadData()`, `formatHeader()`, `formatBody()`, and `formatFooter()` in a 
fixed sequence that subclasses cannot reorder because `generateReport()` 
is marked `final`. The abstract methods `loadData()`, `formatHeader()`, 
`formatBody()`, and `formatFooter()` act as the variable steps — each 
concrete subclass (`StudentReport`, `CourseReport`) overrides them to 
provide its own specific output. The `Driver` demonstrates polymorphism by 
storing both report types in a `List<Report>` and calling 
`generateReport()` on each through the common interface, with the correct 
subclass behavior dispatched at runtime.
