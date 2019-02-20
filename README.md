
| URLs                                                                                                        |
| ----------------------------------------------------------------------------------------------------------- |
| https://app.pluralsight.com/library/courses/java-testing-introduction/table-of-contents                     |
| https://app.pluralsight.com/library/courses/junit-5-unit-testing-getting-started/table-of-contents          | 
| https://app.pluralsight.com/library/courses/junit-5-fundamentals/table-of-contents                          |
| https://app.pluralsight.com/library/courses/test-driven-development-java/table-of-contents(This has mockito)|

Testing
----------
This repo is a knowledge base for Junit and mockito and can be further extended to automation tests in future - Cucumber

Behaviour testing vs State testing : 
------------------------------------

This tests are concerned with behaviour, not result. They test whether a certain method is called at a 
certain point with correct parameters. They do not check what output the method produces.

State testing on the other hand checks for sanity of result, whether the result is valid and correct.

Unit vs Integration vs Performance testing :
--------------------------------------------

Unit testing involves testing a small unit of code, typically a method or a class. A common practice is to test 
logic. Classes which act as data objects, getters and setters are usually not tested. The percentage of code tested
is called test coverage.

Integration tests also known as functional tests are used to test how the whole system is behaving when a new piece
of code is integrated in the system

Performance testing involves repeated testing of code to get benchmark data. They are performed to ensure that 
the system performs well even under high load. Frameworks like gattling are used for functional testing.
