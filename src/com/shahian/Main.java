package com.shahian;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 50000));
        employees.add(new Employee("Jane", 60000));
        employees.add(new Employee("Bob", 40000));
        employees.add(new Employee("Jack", 55000));
        Predicate<String> startsWithJ = name -> name.startsWith("J");
        ToDoubleFunction<Employee> getSalary = employee -> employee.getSalary();
        Supplier<Double> randomSalary = () -> new Random().nextDouble() * 100000;
        double newEmployeeSalary = randomSalary.get();
        Employee newEmployee = new Employee("Jill", newEmployeeSalary);
        employees.add(newEmployee);

        double totalSalary = employees.stream()
                .filter(employee -> startsWithJ.test(employee.getName()))
                .mapToDouble(getSalary)
                .sum();
        double averageSalary = employees.stream()
                .filter(employee -> startsWithJ.test(employee.getName()))
                .mapToDouble(getSalary)
                .average()
                .orElse(0);
        System.out.println("Total salary of employees whose names start with 'J': " + totalSalary);
        System.out.println("Average salary of employees whose names start with 'J': " + averageSalary);
    }
}
