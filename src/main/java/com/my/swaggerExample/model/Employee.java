package com.my.swaggerExample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "Employee Model")
public class Employee implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ApiModelProperty(notes = "ID of the Employee", name = "id", required = true, value = "1234")
    private Long id;

    @ApiModelProperty(notes = "Name of Employee", name="name", required = true, value = "John")
    private String name;

    @ApiModelProperty(notes = "Department of employee", name = "department", required = true, value="Electrical")
    private String department;

    @ApiModelProperty(notes = "Phone number of employee", name = "phoneNumber", required = true, value = "1232343456")
    private Long phoneNumber;

    public Employee() {

    }

    public Employee(Long id, String name, String department, Long phoneNumber) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
