# Proposed Redesign Using CRC Cards

## Class: Order
Responsibilities:
- Store customer name, email, item, and price
- Provide access to order data via getters

Collaborators:
- None

---

## Class: TaxCalculator
Responsibilities:
- Calculate tax amount for a given price
- Calculate total price including tax

Collaborators:
- Order

---

## Class: DiscountCalculator
Responsibilities:
- Apply discount rules based on order price
- Return final discounted total

Collaborators:
- Order

---

## Class: ReceiptPrinter
Responsibilities:
- Format and display the order receipt

Collaborators:
- Order

---

## Class: OrderRepository
Responsibilities:
- Save completed order data to persistent storage

Collaborators:
- Order

---

## Class: EmailService
Responsibilities:
- Send confirmation email to the customer

Collaborators:
- Order

---

## Class: OrderLogger
Responsibilities:
- Log order activity with a timestamp

Collaborators:
- Order

---

## Class: OrderProcessor
Responsibilities:
- Coordinate the full order workflow in the correct sequence
- Delegate each task to the appropriate collaborator

Collaborators:
- Order, TaxCalculator, DiscountCalculator, ReceiptPrinter, OrderRepository, EmailService, OrderLogger
