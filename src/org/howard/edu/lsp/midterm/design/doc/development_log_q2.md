# Development Log – Question 2

## External Resources Used

### AI Tool: Claude (claude.ai)

#### Full Conversation Transcript:

**User:** I need help answering my midterm question, can you help me create the correct code, files and output to receive an 100/100 based on the rubric step by step.

**Claude:** Helped identify the following OO design issues in the OrderProcessor class:
- Poor encapsulation with public fields
- Single Responsibility Principle violation with five responsibilities in one method
- No separation of concerns between business logic, I/O, and communication
- Logical error with discount applied after receipt is printed
- Low cohesion and high coupling

Helped propose a redesigned architecture using CRC cards with the following classes:
- Order: stores customer data
- TaxCalculator: handles tax calculation
- DiscountCalculator: handles discount logic
- ReceiptPrinter: handles receipt display
- OrderRepository: handles file persistence
- EmailService: handles email communication
- OrderLogger: handles activity logging
- OrderProcessor: coordinates the full workflow
