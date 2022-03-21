package com.example.pacmanface.payment;

public class EmployeeNotFoundException extends Exception {
    EmployeeNotFoundException(int id) {
        super("ooops"+id);
    }
}
