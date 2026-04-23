# Development Log – Question 3

## External Resources Used

### AI Tool: Claude (claude.ai)

#### Full Conversation Transcript:

**User:** I need help answering my midterm question, can you help me create the correct code, files and output to receive an 100/100 based on the rubric step by step.

**Claude:** Helped identify the following design issues in the PriceCalculator class:
- Open/Closed Principle violation requiring modification for every new customer type
- Growing if-statement chain making the code hard to read and maintain
- No use of polymorphism with string comparisons instead of objects
- Poor testability with all pricing rules locked inside one method
- Hard to extend for complex pricing combinations

Helped refactor using the Strategy Pattern with the following classes:
- PricingStrategy: interface defining calculatePrice() method
- RegularPricingStrategy: returns original price with no discount
- MemberPricingStrategy: applies 10% discount
- VIPPricingStrategy: applies 20% discount
- HolidayPricingStrategy: applies 15% discount
- PriceCalculator: context class that delegates to the strategy
- Driver: demonstrates all four strategies with base price of 100.0

Expected output verified:
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0
