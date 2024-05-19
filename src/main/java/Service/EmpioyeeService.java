package Service;

import collection.Employee;

import java.util.Collection;

public interface EmpioyeeService {
    Employee add(String firstName, String lastName);
    Employee delete(String firstName, String lastName);
    Employee find (String firstName, String lastName);
    Collection<Employee> findAll();
}