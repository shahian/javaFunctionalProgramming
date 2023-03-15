# javaFunctionalProgramming

  ## Table of Contents
1. [Functional Programming](#functionalProgramming)
2. [Functional Interfaces](#functionalInterfaces)
3. [Explanation of code](#explanation)

### functionalProgramming
***
Functional programming is a programming paradigm that emphasizes the use of functions to solve problems. In Java, functional programming can be achieved through the use of lambda expressions and streams.

Lambda expressions are anonymous functions that can be used to pass behavior as a parameter. They can be used to simplify code and make it more readable. Here is an example of a lambda expression in Java:
```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.forEach(n -> System.out.println(n));
```
Streams are another key feature of functional programming in Java. Streams are a sequence of elements that can be processed in parallel or sequentially. They are similar to collections, but they provide a more functional approach to data processing.

Here is an example of using streams in Java:
```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
System.out.println(sum);
```
### functionalInterfaces
***
 Java provides several functional interfaces that can be used to write functional-style code. 
 
 <span style="color:red;">Predicate</span>, Consumer, Supplier, and Function - are among the most commonly used functional interfaces in Java.

Here is a brief overview of each interface:

1. Predicate: This interface represents a function that takes an input and returns a boolean value. It can be used to test a condition or filter a collection.
```
Predicate<Integer> isEven = n -> n % 2 == 0;
boolean result = isEven.test(4); // true
```
2. Consumer: This interface represents a function that takes an input and performs some side effect, such as printing a message or updating a database.
```
Consumer<String> printMessage = message -> System.out.println(message);
printMessage.accept("Hello, world!"); // prints "Hello, world!"
```
3. Supplier: This interface represents a function that takes no input and returns a value. It can be used to generate values on demand.
```
Supplier<Double> random = () -> Math.random();
double value = random.get(); // returns a random number between 0 and 1
```
4. Function: This interface represents a function that takes an input and returns a value. It can be used to transform data.
```
Function<Integer, String> toString = n -> Integer.toString(n);
String result = toString.apply(42); // "42"
```
### explanation:
***
1. we define a Predicate that tests whether a given string starts with the letter "J", a Function that returns the salary of an Employee object, and a Supplier that generates a random salary between 0 and 100000 for a new employee.
 ```
  Predicate<String> startsWithJ = name -> name.startsWith("J");
        Function<Employee, Double> getSalary = employee -> employee.getSalary();
        Supplier<Double> randomSalary = () -> new Random().nextDouble() * 100000;
  ```     
2. Next, we define a Predicate that tests whether a given string starts with the letter "J", a Function that returns the salary of an Employee object, and a Supplier that generates a random salary between 0 and 100000 for a new employee.
        
        
 ```  
  double newEmployeeSalary = randomSalary.get();
        Employee newEmployee = new Employee("Jill", newEmployeeSalary);
        employees.add(newEmployee);
 ```
       
3. We generate a new random salary for a new employee using the randomSalary supplier and create a new Employee object with the name "Jill" and the generated salary. We then add this new employee to the list of employees.
 ```
  double totalSalary = employees.stream()
        .filter(employee -> startsWithJ.test(employee.getName()))
        .mapToDouble(getSalary)
        .sum();
```     
4. We create a stream of the employees and filter for those whose names start with "J" using the startsWithJ predicate. We then map each of these employees to their salary using the getSalary function and convert the resulting stream of Double objects to a DoubleStream using the mapToDouble() method. We then calculate the sum of the salaries using the sum() method.
```
  double averageSalary = employees.stream()
        .filter(employee -> startsWithJ.test(employee.getName()))
        .mapToDouble(getSalary)
        .average()
        .orElse(0);
```   
5. We create a second stream of the employees and filter for those whose names start with "J" using the startsWithJ predicate. We then map each of these employees to their salary using the getSalary function and convert the resulting stream of Double objects to a DoubleStream using the mapToDouble() method. We then calculate the average of the salaries using the average() method, which returns an OptionalDouble. If there are no employees whose names start with "J", we provide a default value of 0 using the orElse() method.
            
            
 
