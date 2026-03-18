package com.kavish.tutorials.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "employee_email")
    private String email;
    @Column(name = "created_on")
    private Timestamp timeStamp;

    protected Employee() {
    }

    public Employee(Long employeeId, String employeeName, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.timeStamp = getCurrentTimeStamp();
    }

    private Timestamp getCurrentTimeStamp() {
        Date date = new Date();
        long time = date.getTime();
        return new Timestamp(time);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}
