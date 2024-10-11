package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Component
public class NumberEntity {
	@NotNull(message="Number1 cannot be null")
	private Integer num1;
	@NotNull(message="Number2 cannot be null")
	private Integer num2;
	@NotBlank(message="Operation cannot be null")
	private String operation;

}

