package com.example.demo.model;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StringList {
	@NotEmpty(message="List cannot be null")
	private List<String> stringList;
	
	@Override
	public String toString() {
	    return "StringList: " + stringList.toString();
	}

}
