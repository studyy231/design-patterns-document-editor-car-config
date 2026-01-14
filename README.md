# Software Architecture Assignment – Document Editor & Car Configuration

## Student
Lea Akkaoui

## Assignment 1 – Document Editor

### Requirement
> Develop a document editor that supports multiple file formats (PDF, Word, HTML).  
> Each format must handle saving and displaying differently, and the editor’s core logic must not be tightly coupled to specific formats.  
> New formats must be addable without modifying the editor code.

### Solution
- The editor core is implemented independently of any concrete document format.
- A **Factory-based architecture combined with Java ServiceLoader (SPI)** is used to dynamically load document handlers.
- The editor selects the correct document handler at runtime based on the user’s chosen format key.
- Adding a new document format requires:
  1. Implementing a new `DocumentHandler`
  2. Registering it via `META-INF/services`
  3. No modification to the editor core

### Supported Formats
- HTML
- PDF
- Word

### Result
The document editor satisfies the requirement of being **open for extension and closed for modification**, as requested.

---

## Assignment 2 – Car Configuration

### Requirement
> Design a car configuration system allowing step-by-step customization.  
> Some options are optional, some mandatory, and not all cars share the same features.  
> The final car object must always be valid and ready for ordering.

### Solution
- The **Builder Pattern** is used to support step-by-step car configuration.
- Mandatory fields (model, engine type, transmission) are validated before construction.
- Optional features (interior, exterior, safety) can be freely added.
- Invalid or incomplete configurations result in clear runtime exceptions.

### Configurable Options
- Engine type (V6, V8)
- Transmission (Manual, Automatic)
- Interior features (e.g., leather seats, GPS)
- Exterior options (e.g., color)
- Safety features (e.g., airbags)

### Result
The car configuration system is flexible, safe, and enforces correctness before object creation.

---

## Bonus Task – Unit Tests and Code Coverage

### Requirement
> Add unit tests ensuring at least 85% code coverage.

### Implementation
- Unit tests are written using **JUnit 5**.
- Code coverage is measured using **JaCoCo**.
- A minimum coverage threshold of **85%** is enforced during the Maven build.
- Demo / entry-point classes are excluded from coverage checks to focus on core logic.

### Verification
- Running `mvn test` results in **BUILD SUCCESS**.
- The build fails automatically if coverage drops below the required threshold.

---

## Bonus Task – Combining Both Exercises

### Requirement
> Combine both exercises into a more complex solution.

### Implementation
- The application entry point demonstrates:
  - Creating and configuring a car using the Builder pattern
  - Creating and previewing documents using the document editor
- Both systems coexist in the same project while remaining cleanly separated by package structure.

---

## Project Structure
src
├─ main
│ └─ java
│ └─ com.Akkaoui.cms
│ ├─ document (Assignment 1 – Document Editor)
│ ├─ car (Assignment 2 – Car Configuration)
│ └─ app (Application entry point / integration demo)
└─ test
└─ java
└─ com.Akkaoui.cms
