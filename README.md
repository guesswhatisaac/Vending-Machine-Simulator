Interactive Vending Machine Simulation in Java Swing
====================================================
A comprehensive Java application simulating various vending machine operations, from item dispensation to maintenance.

--------------------------------------------------------------------------------

🌟 PROJECT OVERVIEW
------------------

This Java project is a Vending Machine Simulator built using Java Swing for its Graphical User Interface (GUI). It aims to replicate the core functionalities of a vending machine, supporting both "Regular" and "Special" machine types. The simulation allows users to select products, insert money, and receive change. It also provides a comprehensive set of maintenance features for operators, including restocking items, setting prices, collecting money, replenishing change, and printing transaction summaries.


🎯 MOTIVATION
------------

The primary motivations behind developing this simulator include:

  * Object-Oriented Programming (OOP) Practice: Demonstrating robust OOP principles through class design, inheritance, and encapsulation.
  * GUI Development with Swing: Providing a practical application of Java Swing for building interactive and user-friendly graphical interfaces.
  * Event Handling: Implementing action listeners and other event mechanisms to manage user interactions within the GUI.
  * Simulation of Real-World Systems: Creating a tangible simulation that mirrors the complexities of a real-world vending process.


🛠️ TECHNOLOGIES USED
-------------------

  * Java: The primary programming language.
  * Java Swing: For building the graphical user interface.


🚀 GETTING STARTED
-----------------

To get a local copy of this project up and running, follow these simple steps.

### Prerequisites

  * Java Development Kit (JDK): Ensure you have JDK 8 or higher installed on your system.

### Project Structure

The project is structured using a Model-View-Controller (MVC) architecture to separate concerns:

  * 'Main.java': The application's entry point. Initializes the model, view, and controller.
  * 'ProgramView.java': Manages all GUI components and their layout, responsible for displaying the UI.
  * 'ProgramModel.java': Holds the application's data and business logic, managing the state of the vending machine.
  * 'ProgramController.java': Acts as the bridge between the 'ProgramView' and 'ProgramModel'.
  * 'VendingMachine.java': An abstract base class defining common properties for all vending machines.
  * 'RegularVM.java': A concrete class for a standard vending machine.
  * 'SpecialVM.java': A concrete class for a specialized vending machine.
  * 'Products.java': Represents individual products with attributes like name, calories, and price.
  * 'Denominations.java': Manages the various money denominations and their counts within the machine.


🛒 USAGE
-------

1.  Compile the Java files:
    Navigate to the root directory of your project in your terminal and compile all Java source files:

        javac *.java

2.  Run the Main class:

        java Main

3.  Interact with the GUI:
    Upon running, the main window will appear with several options:
    *   Create Vending Machine: Choose between "Regular" or "Special". This must be done first.
    *   Test Vending Machine: Access user-facing features (product selection, payment).
    *   Maintenance: Access operator-only features (restocking, price changes, etc.).
    *   Exit: Close the application.

    Follow the on-screen prompts and buttons to navigate through the different functionalities.
