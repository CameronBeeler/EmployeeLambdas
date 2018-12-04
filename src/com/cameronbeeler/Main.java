package com.cameronbeeler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    private static List<Employee> employee = new ArrayList <>();

    public static void main(String[] args) {
        employee.add(new Employee("Cameron", 50));
        employee.add(new Employee("Kim", 48));
        employee.add(new Employee("Shiloh", 18));
        employee.add(new Employee("Wyatt", 14));
        employee.add(new Employee("Ani", 16));
        employee.add(new Employee("Steve", 37));
        employee.add(new Employee("Lisa", 28));
        employee.add(new Employee("Unawa", 22));
        employee.add(new Employee("Guido", 66));
        employee.add(new Employee("Elise", 19));

        printEmployeesByAge(employee, "Employee at or under 20", emp -> emp.getAge() <= 20);
        System.out.println();
        printEmployeesByAge(employee, "Employee over 30", emp -> emp.getAge() > 30);
    }

    private static void printEmployeesByAge(List<Employee> employee, String ageText, Predicate<Employee> ageCondition)
    {
        System.out.println(ageText);
        System.out.println("====================");
        for(Employee emp : employee)
        {
            if(ageCondition.test(emp))
            {
                System.out.println(emp.getName() + ", " + emp.getAge());
            }
        }
    }
}
