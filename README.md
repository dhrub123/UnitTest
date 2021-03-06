### URLS :
#### Video :
```
https://app.pluralsight.com/library/courses/java-testing-introduction/table-of-contents                      
https://app.pluralsight.com/library/courses/junit-5-unit-testing-getting-started/table-of-contents          
https://app.pluralsight.com/library/courses/junit-5-fundamentals/table-of-contents                          
https://app.pluralsight.com/library/courses/test-driven-development-java/table-of-contents (This has mockito)
```

#### Junit :
```
https://www.vogella.com/tutorials/JUnit/article.html
http://tutorials.jenkov.com/java-unit-testing/index.html
https://www.journaldev.com/20834/junit5-tutorial
```

#### Mockito : 
```
https://www.vogella.com/tutorials/Mockito/article.html
https://www.baeldung.com/mockito-series
https://www.journaldev.com/21816/mockito-tutorial
```

#### TestNG : 
```
https://www.journaldev.com/21219/testng-tutorial
```
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

Junit :
-------
This is a java unit testing framework. It uses annotations and assert statements for unit tests. The tests are 
not executed in any particular order.

Maven Config : 
--------------

#### Junit4 and Hamcrest : 

```maven
	<dependency>
	    <groupId>junit</groupId>
	    <artifactId>junit</artifactId>
	    <version>4.12</version>
	</dependency>
    
    <dependency>
	    <groupId>org.hamcrest</groupId>
	    <artifactId>hamcrest-all</artifactId>
	    <version>${hamcrest.version}</version>
	    <scope>test</scope>
	</dependency>
```

### Important Annotations : 

|JUnit 4|Description|
|-------|-----------|
|import org.junit.* |Import statement for using the following annotations.|
|@Test|Identifies a method as a test method.|
|@Before|Executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class).|
|@After|Executed after each test. It is used to cleanup the test environment (e.g., delete temporary data, restore defaults). It can also save memory by cleaning up expensive memory structures.|
|@BeforeClass|Executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database. Methods marked with this annotation need to be defined as static to work with JUnit.|
|@AfterClass|Executed once, after all tests have been finished. It is used to perform clean-up activities, for example, to disconnect from a database. Methods annotated with this annotation need to be defined as static to work with JUnit.|
|@Ignore or @Ignore("Why disabled")|Marks that the test should be disabled. This is useful when the underlying code has been changed and the test case has not yet been adapted. Or if the execution time of this test is too long to be included. It is best practice to provide the optional description, why the test is disabled.|
|@Test (expected = Exception.class)|Fails if the method does not throw the named exception.|
|Test(timeout=100)|Fails if the method takes longer than 100 milliseconds.|

### Important Assertions :

|Statement|Description|
|-------|-----------|
|fail([message])|Let the method fail. Might be used to check that a certain part of the code is not reached or to have a failing test before the test code is implemented. The message parameter is optional.|
|assertTrue([message,] boolean condition)|Checks that the boolean condition is true.|
|assertFalse([message,] boolean condition)|Checks that the boolean condition is false.|
|assertEquals([message,] expected, actual)|Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.|
|assertEquals([message,] expected, actual, tolerance)|Test that float or double values match. The tolerance is the number of decimals which must be the same.|
|assertNull([message,] object)|Checks that the object is null.|
|assertNotNull([message,] object)|Checks that the object is not null.|
|assertSame([message,] expected, actual)|Checks that both variables refer to the same object.|
|assertNotSame([message,] expected, actual)|Checks that both variables refer to different objects.|

### Junit Tests from command line : 

#### Run Test

```java
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(MyClassTest.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
```

#### Run Suite

```java
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        MyClassTest.class,
        MySecondClassTest.class })

public class AllTests {
} 
```

#### Disable tests: 

We can use Assume.assumeFalse or Assume.assumeTrue to define a condition for the test. 
Assume.assumeFalse marks the test as invalid, if its condition evaluates to true. 
Assume.assumeTrue evaluates the test as invalid if its condition evaluates to false. 
The following disables a test on Linux:

```java
Assume.assumeFalse(System.getProperty("os.name").contains("Linux"));
```

#### Test for Exceptions:

The following test will be successful if aops.divide(1000, 5) throws an
IllegalArgumentException.

```java
@Test(expected = IllegalArgumentException.class)
public void testIfExceptionIsThrown() {
	ArithmeticOperations aops = new ArithmeticOperations();
	aops.divide(1000, 5);
}
```

### Hamcrest - Make Assertions readable

#### Core
|Matcher|Description|
|-------|-----------|
|any()|Matches anything|
|is()|checks if given objects are equal|
|describedAs()|Adds Description to matcher|

#### Logical
|Matcher|Description|
|-------|-----------|
|allOf()|Takes an array of matchers, all of which must match target object|
|anyOf()|Takes an array of matchers, any or at least one of which must match target object|
|not()|Must not match target object|

#### Object
|Matcher|Description|
|-------|-----------|
|equalTo()|Checks if given objects are equal|
|instanceOf()|checks if given object is of type x or is compatible to type x|
|notNullValue()|checks if given object is not null|
|nullValue()|checks if given object is null|
|sameInstance()|checks if given object is same instance as another|

Apart from these, there are also custom matchers.