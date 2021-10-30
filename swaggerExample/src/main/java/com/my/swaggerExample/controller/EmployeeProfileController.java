package com.my.swaggerExample.controller;

import com.my.swaggerExample.config.ErrorResponse;
import com.my.swaggerExample.model.Employee;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApiOperation(value = "/profiler/v1/employee", tags = "Employee Profile Controller")
@RestController
@RequestMapping("/profile/v1/employee")
public class EmployeeProfileController {

    List<Employee> employees = Arrays.asList(
            new Employee(12345L,"John", "Electrical", 2342341122L),
            new Employee(23456L, "Sam", "Computer", 2933922223L),
            new Employee(34567L, "Jack", "Electronics", 4312231125L),
            new Employee(45678L, "Mark", "Mechanical", 5543324412L)
    );

    @ApiOperation(value = "Fetch All Employees", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Employee.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND!", response = ErrorResponse.class)
    })
    @GetMapping(value = "/fetch/all")
    public List<Employee> fetchAllEmployees() {
        return employees;
    }

    @ApiOperation(value = "Fetch Employee by Name", response = Employee.class)
    @GetMapping(value = "/fetch/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee fetchEmployeeByName(@ApiParam(value = "Employee Name") @PathVariable(value = "name") String name) {
        return employees.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    @ApiOperation(value = "Get Employee By Department", response = Employee.class)
    @GetMapping(value = "/fetch/{department}")
    public List<Employee> fetchEmployeeByDepartment(@ApiParam(value = "Department Name", required = true) @PathVariable(value="department") String department) {
        return employees.stream().filter(x -> x.getDepartment().equalsIgnoreCase(department)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Insert Employee Record", response = Employee.class)
    @PostMapping
    public Employee insertEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return employee;
    }

    @ApiOperation(value = "Update Employee Details", response = Employee.class)
    @PutMapping
    public Employee updateEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return employee;
    }

    @ApiOperation(value = "Delete an Employee", response = Employee.class)
    @DeleteMapping
    public Employee deleteEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
        return employee;
    }

    @ApiOperation(value = "Partial Update Employee in the System", response = Employee.class)
    @PatchMapping
    public Object patchEmployee(@ApiParam(value = "Employee") @RequestBody Map<String, Object> partialUpdate) {
        return partialUpdate;
    }


}
