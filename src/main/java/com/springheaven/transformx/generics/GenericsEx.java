package com.springheaven.transformx.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class GenericsEx {


    //let create a method that accepts any types of array and convert it to a list

    public static <T> List<T> toList(T[] arr) {
        List<T> list = new ArrayList<T>();
        for (T t : arr) {
            list.add(t);
        }

        return list;
    }

    //lets try the same above using the varargs

    public static <T> List<T> toListVar(T... arr) {

        List<T> list = new ArrayList<T>();
        for (T t : arr) {
            list.add(t);
        }

        return list;
    }


    public static void main(String[] args) {
        List<String> StringList = Arrays.asList("PraveenRaj", "MohanRaj", "VasanthiraDevi");
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Employee> employeeList = Arrays.asList(new Employee(1, "Praveen", "Raj"), new Employee(2, "Mohan", "Rah"));

        int sum = 0;
        for (Iterator it = integerList.iterator(); it.hasNext(); ) {
            int total = (int) it.next();
            sum += total;
        }
        System.out.println("total sum is " + sum);

        Integer[] list = new Integer[3];
        list[0] = 1;
        list[1] = 2;
        List<Integer> integerList1 = toList(list);

        Employee[] employeeArray = new Employee[3];
        employeeArray[0] = new Employee(1, "Praveen", "Raj");
        employeeArray[1] = new Employee(2, "Mohan", "Raj");
        employeeArray[2] = new Employee(3, "Vasanthira", "Devi");
        //  employeeArray[3]=new Employee(1, "Praveen", "Raj");
        List<Employee> employeeList1 = toListVar(employeeArray);
        Consumer<Employee> employeeConsumer = employee -> System.out.println(employee);
        employeeList1.forEach(
                employeeConsumer);


    }

    private static class Employee {
        int id;
        String name;
        String lastName;

        public Employee(int id, String name, String lastname) {
            this.id = id;
            this.name = name;
            this.lastName = lastname;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
