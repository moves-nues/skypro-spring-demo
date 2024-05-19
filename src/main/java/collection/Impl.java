package collection;

import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
class EmployeeServiceImpl implements EmpioyeeService {
    private static final int MAX_SIZE = 50;
    private final List<Employee> employees = new ArrayList<>();
    private String firstName;
    private String lastName;

    @Override
    public Employee add(String firstName, String lastName){
        Employee employee = new Employee(firstName,lastName);
        if (employees.size()> MAX_SIZE){
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee delete(String firstName, String lastName){
        Employee employee = new Employee(firstName,lastName);
        if(employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }
        throw  new EmployeeNotFoundException();
    }
    @Override
    public Employee find(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        Employee employee = new Employee(firstName,lastName);
        if(employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    public Collection<Employee> findAll() {
        return employees;
    }
}
