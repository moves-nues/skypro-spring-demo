package collection;

import Service.EmpioyeeService;
import exception.GetMapping;
import exception.RequestParam;

import java.util.Collection;

@RestController
@RequestParam()
class EmployeeController {
    private final EmpioyeeService service;

    public EmployeeController(EmpioyeeService service) {
        this.service = service;
    }

    @GetMapping("")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.add(firstName, lastName);
    }

    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.delete(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}