package com.example.commerce.controller;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(String username) {
        super("Could not find employee " + username);
    }
}
