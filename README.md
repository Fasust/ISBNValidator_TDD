# ISBNValidator_TDD
ISBN Validator, built this to practice Test Driven Development (TDD)

I followed the Lynda Course ["Practical Test-Driven Development for Java Programmers"](https://www.lynda.com/Software-Development-tutorials/Practical-Test-Driven-Development-Java-Programmers/777389-2.html) by Matt Greencroft.

This is only a tiny test project, but it did help me understand the benefits and the workflow of TDD.

## Workflow

- *Red* -> *Green* -> *Refactor*
- Start with *Red* to make sure that the new test executes as expected
- To get to *Green*: Only write the minimum amount of code to make all tests pass (even if you know it’s wrong in the long run)
- Refactor to remove redundancy

## Best Practice
- Each Test must check one **single** peace of logic
    - Only more then one *assert()* in a test when the same logic is tested with multiple values 
- Test Business-Logic, not methods
- Tests must be repeatable

## What Tests to write? Ask these Questions:
1. What should the Logic be? (Whats a 10 Digit ISBN?)
2. What is the opposite of that Logic? (Which Numbers are not Valid ISBN?)
3. Are there Edge-Cases? (What about ISBN that end in X?)
4. ERROR Conditions? (When are we throwing ERRORs?)


![Work Flow](https://github.com/Fasust/ISBNValidator_TDD/blob/master/assets/tdd_flow.gif)

