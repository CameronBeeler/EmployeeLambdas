package com.cameronbeeler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    private static List<Employee> employee = new ArrayList <>();

    public static void main(String[] args)
    {
        employee.add(new Employee("Cameron Beeler", 50));
        employee.add(new Employee("Kim Beeler", 48));
        employee.add(new Employee("Shiloh Beeler", 18));
        employee.add(new Employee("Wyatt Beeler", 14));
        employee.add(new Employee("Ani Beeler", 16));
        employee.add(new Employee("Steve Johnson", 37));
        employee.add(new Employee("Lisa Duda", 28));
        employee.add(new Employee("Ungwa Mkata", 22));
        employee.add(new Employee("Guido Luigi", 66));
        employee.add(new Employee("Elise Dorondo", 19));

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' ')  );
        };

        for(int i=0; i< employee.size(); i++){
            String lastName = getLastName.apply(employee.get(i));
            String firstName = getFirstName.apply(employee.get(i));
            System.out.println(i + ": " + lastName + ", " + firstName);}

//      CHAINING lambda functions together
        Function<Employee, String> upperCase = employee1 -> employee1.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employee.get(0)));

        Consumer<String> c1 = s-> System.out.println(s.toUpperCase());
        Consumer<String> c2 = s-> System.out.println(s);
        c1.accept("This is the test of uppercase");
//        c1.andThen(c2).accept("Howdy Doody");
        c1.andThen(c2).accept("uppercase?");

/*
        printEmployeesByAge(employee, "Employee at or under 20", emp -> emp.getAge() <= 20);
        System.out.println();
        printEmployeesByAge(employee, "Employee over 30", emp -> emp.getAge() > 30);
        // we can utilize lambdas or we can explicitly code the anonymous class to accomplish the same...
        printEmployeesByAge(employee, "Employees younger than 25", new Predicate<Employee>()
        {
            @Override
            public
            boolean test(Employee employee)
            {
                return employee.getAge() < 25;
            }
        });


        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan30    = i -> i < 30;
        int          a             = 16;
        System.out.println(greaterThan15.and(lessThan30).test(a));
        System.out.println((greaterThan15.test(a) && lessThan30.test(a)));

        Random             random         = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(10);
        for (int i = 0; i<10; i++)
        {
            System.out.println(randomSupplier.get());
        }

        employee.forEach(employee1 -> {
            String lastName = employee1.getName().substring(employee1.getName().indexOf(' ') + 1);
            System.out.println("Last name is " + lastName);
        });
        */
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
