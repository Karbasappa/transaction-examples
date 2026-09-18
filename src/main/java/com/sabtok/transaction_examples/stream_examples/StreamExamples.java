package com.sabtok.transaction_examples.stream_examples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", 75000.0, "HR"));
        employees.add(new Employee(102, "Bob", 92000.0, "IT"));
        employees.add(new Employee(103, "Charlie", 68000.0, "HR"));
        employees.add(new Employee(104, "David", 115000.0, "IT"));

        Map<String, Optional<Employee>> collect1 = employees.stream().collect((Collectors.groupingBy(
                Employee::getDepId, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))
        )));

        System.out.println(collect1);

        Map<String, Double> collect = employees.stream().collect(
                Collectors.groupingBy(Employee::getDepId,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
                        opt -> opt.map(Employee::getSalary).orElse(0.0)))
                );
        //System.out.println(collect);
    }
}

@AllArgsConstructor
@RequiredArgsConstructor
@Data
class Employee {
    private long id;
    private String name;
    private double salary;
    private String depId;
}
