package ar.com.erchamatur.employeemanager.model;

import java.io.Serializable;

@Entity
public class Employee implements Serializable{
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageURI;
    private String employeeCode;

}
