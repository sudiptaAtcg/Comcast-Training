package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	private String name;
	private String department;
	private Integer salary;
	@Override
    public String toString() {
        return "Name:"+name+" "+"Salary:"+salary;
    }

}
