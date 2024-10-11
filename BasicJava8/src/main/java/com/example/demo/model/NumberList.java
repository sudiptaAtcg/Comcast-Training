package com.example.demo.model;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
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
public class NumberList {
	@NotEmpty(message="List cannot be null")
    private List<Integer> numbers;
    
}