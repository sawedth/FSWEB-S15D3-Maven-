package org.example.entity;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1, "Samet" , "Refik"));
        employeeList.add(new Employee(2, "Malve", "Enayi"));
        employeeList.add(new Employee(2, "Malve", "Enayi"));
        employeeList.add(new Employee(3, "ben", "malım"));
        employeeList.add(new Employee(4, "zart", "zort"));
        employeeList.add(new Employee(4, "zart", "zort"));

        System.out.println(findDuplicates(employeeList));
        System.out.println(findUniques(employeeList));
        System.out.println(removeDuplicates(employeeList));


    }

    public static List<Employee> findDuplicates(List<Employee> employeeList){
        List<Employee> uniqueEmployee = new LinkedList<>();
        Map<Employee, Integer> empMap= new LinkedHashMap<>();
        for(Employee employee:employeeList){
            if(empMap.containsKey(employee) && employee != null){
                empMap.put(employee,empMap.get(employee)+1);
            }else if(employee != null){
                empMap.put(employee,1);
            }
        }
        for(Map.Entry emp:empMap.entrySet()){
            if((Integer) emp.getValue() > 1 ){
                uniqueEmployee.add((Employee) emp.getKey());
            }
        }
        System.out.println(empMap);
        return uniqueEmployee;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employeeList){
        Map<Integer, Employee> empMap= new HashMap<>();
        for(Employee employee:employeeList){
            if(!empMap.containsValue(employee) && employee != null){
                empMap.put(employee.getId(), employee);
            }
        }
        return empMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employeeList){
        List<Employee> uniqueEmployee = new LinkedList<>();
        Map<Employee, Integer> empMap= new HashMap<>();
        for(Employee employee:employeeList){
            if(empMap.containsKey(employee)){
                empMap.put(employee,empMap.get(employee)+1);
            }else{
                empMap.put(employee,1);
            }
        }
        for(Map.Entry emp:empMap.entrySet()){
            if((Integer) emp.getValue() == 1 && emp.getKey() != null){
                uniqueEmployee.add((Employee) emp.getKey());
            }
        }
        System.out.println(empMap);
        return uniqueEmployee;
    }
}