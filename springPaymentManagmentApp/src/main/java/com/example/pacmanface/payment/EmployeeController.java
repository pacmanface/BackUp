package com.example.pacmanface.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private  EmployeeRepository repository;
    
    @GetMapping("/empls")
    List<Employee> all() {
        return repository.findAll();
    }

    @GetMapping("/empls/{id}")
    Employee one(@PathVariable int id) throws EmployeeNotFoundException {
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/empls/{id}")
    void deleteEmployee(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PostMapping("/empls")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @PutMapping("/empls/{id}")
    Employee replaceEmployee(@PathVariable int id, @RequestBody Employee newEmployee) {
        return repository.findById(id)
            .map(employee -> {
                employee.setName(newEmployee.getName());
                employee.setLastName(newEmployee.getLastName());
                return repository.save(employee);
            })
            .orElseGet(() -> {
                newEmployee.setId(id);
                return repository.save(newEmployee);
            });
    }

}



