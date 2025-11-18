# S3.2-Patterns_2

## 📄 Description - Exercise Prompts

This project consists of implementing structural and behavioral design patterns to solve common software development problems. We will focus on writing clean, flexible, and maintainable code by applying the **Builder**, **Observer**, and **Decorator** patterns.

## Level 1: Builder Pattern 🧱

**💡Exercise: Implementation of a Restaurant Menu Builder**

**Objective:** Design and implement a system to build different types of restaurant menus applying the **Fluent Builder** pattern and utilizing a **Progressive Interface**. This ensures that the menu is constructed in the correct order and dependencies between steps are respected (e.g., you cannot add dessert before the main course).

**Description:**
Menus can be composed of: **Entrant**, **Main Course**, **Dessert**, and **Drink**.
* **Dishes:** Can be **Vegan** and/or **Gluten-Free**.
* **Main Course:** Can have a **Supplement** (e.g., extra garnish).
* **Variations:**
	* **Half Menu:** Only Main Course + Drink.
	* **Kids Menu:** Main Course + Drink + Dessert.
	* Menus can exist without a drink.
	* **Dessert:** Optional in all menus. Can be a Dessert OR Coffee (mutually exclusive).

**Requirements:**
* Model a flexible system to build menus step-by-step without concrete class dependencies.
* **Progressive Interface:** Enforce the correct order (e.g., Dessert cannot be added before Main Course).
* **Constraint:** If Dessert is chosen, Coffee cannot be added, and vice-versa. This must be guaranteed via interface design.
* Configure dish properties (vegan, celiac-friendly, supplement) using fluent, expressive methods (avoid boolean parameters).
* The implementation must be demonstrated using **unit tests** creating various menus.

**Example Usage:**
```java
Menu executiveMenu = new MenuBuilder()
    .withEntrant("Mediterranean Salad")
        .isVegan()
        .isGlutenFree()
    .withMainCourse("Beef Steak")
        .withSupplement("Extra Garnish")
    .withDessert("Chocolate Mousse")
    .withDrink("Red Wine")
    .build();

Menu kidsMenu = new MenuBuilder()
    .withMainCourse("Macaroni with Tomato")
    .withDessert("Vanilla Ice Cream")
    .withDrink("Orange Juice")
    .build();

Menu halfMenu = new MenuBuilder()
    .withMainCourse("Mushroom Risotto")
        .isVegan()
    .withCoffee("Espresso")
    .withDrink("Water")
    .build();
```
---
## Level 2: Observer Pattern 👀

**💡Exercise: Implementation of a Stock Market Notification System**

**Objective:** Build a system where a **Stock Agent** (Observable) automatically notifies several **Stock Broker Agencies** (Observers) whenever a change in the stock market state occurs (market up or down).

**Description:**
* **StockAgent:** Allows observers to subscribe and unsubscribe. It has methods to simulate market fluctuations.
* **Notification:** When the market rises or falls, the agent automatically notifies all observers with the change and the new stock value.
* **Observers:** Upon receiving notification, they print a message to the console indicating whether the market went up or down and the current value.

**Requirements:**
* The Observable must maintain references to its observers.
* Allow dynamic addition and removal of observers.
* Call `notifyObservers()` when the state changes.
* The implementation must be verified using **unit tests** covering:
    * Subscription of multiple agencies.
    * Simulation of market ups and downs.
    * Verification that observers receive the correct messages.

**Example Test Logic:**
```java
@Test
public void testStockAgentNotifications() {
   StockAgent agent = new StockAgent();

   Observer alphaBrokers = new StockBrokerAgency("Alpha Brokers");
   Observer zenithInvestments = new StockBrokerAgency("Zenith Investments");

   agent.addObserver(alphaBrokers);
   agent.addObserver(zenithInvestments);

   agent.stockMarketUp(150.75);
   // Expected console output:
   // Alpha Brokers received notification: Stock market went UP to 150.75
   // Zenith Investments received notification: Stock market went UP to 150.75

   agent.stockMarketDown(145.50);
   // Expected console output:
   // Alpha Brokers received notification: Stock market went DOWN to 145.50
   // Zenith Investments received notification: Stock market went DOWN to 145.50
}
```
---
## Level 3: Decorator Pattern 🎨

**💡Exercise: Implementation of a Bubble Tea Application**

**Objective:** Simulate the customization of a **Bubble Tea**, using the **Decorator** pattern to add ingredients like pearls, ice, sugar, etc., without creating subclasses for every possible combination.

**Description:**
You can start with a base drink:
* 🥛 **Latte** → 3.50 €
* 🍵 **Matcha** → 3.20 €
* 🌿 **Tea** → 3.00 €

Add decorations (toppings/modifiers):
* 🧊 **Ice** → +0.25 €
* 🍬 **Sugar** → +0.30 €
* 🥥 **Tapioca** → +0.50 €
* 🍓 **Flavor** → +0.60 € per added flavor.

*Note: Each addition modifies the cost and description of the drink. If two flavors are added, the total cost increases by +1.20€.*

**Requirements:**
* Create a `BubbleTea` interface with methods: `String getDescription()` and `double getCost()`.
* Implement base classes (`LatteBase`, `MatchaBase`, `TeaBase`).
* Create concrete decorators (e.g., `Ice`, `Sugar`, `Tapioca`, `Flavor`) inheriting from `BubbleTeaDecorator`.
* Each decorator must update both the cost and the description.
* The implementation must be demonstrated using **unit tests** showing various combinations.

**Example Usage:**
```java
BubbleTea tea = new LatteBase(); // Latte base
tea = new Tapioca(tea);
tea = new Sugar(tea);
tea = new Flavor(tea, "Strawberry");
tea = new Flavor(tea, "Mango");
// Calculate final cost and description
```
---
## 💻 Technologies Used

* Java (JDK 21)
* JUnit 5
* Maven

---
## 📋 Requirements

* Java JDK 21
* Maven 3.6.0+ (or compatible Gradle version)

---
## 🛠️ Installation

1.  Clone this repository:
	`git clone [URL_REPOSITORY]`
2.  Navigate to the project directory:
	`cd S3.3-Design-Patterns-2`
3.  Install dependencies:
	`mvn install`

---
## ▶️ Execution

This project is verified using unit tests. To run the tests:

1.  Ensure all dependencies are installed.
2.  Run the test suite from your IDE (e.g., IntelliJ, Eclipse) or via the command line:
	`mvn test`
