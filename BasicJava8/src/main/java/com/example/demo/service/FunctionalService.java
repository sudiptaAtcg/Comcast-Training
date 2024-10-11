package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Employee;
import com.example.demo.model.NumberEntity;

public interface FunctionalService {
	public Integer performCalculation(NumberEntity obj);
	public List<Integer> filterEvenNumbers(List<Integer> numberList);
	public List<Integer> getStringLength(List<String> stringList);
	public List<String> filterStringList(List<String> stringList);
	public void doubleNumberList(List<Integer> numberList);
	public List<Integer> getRandomIntegerList();
	public List<String> getSortedStringList(List<String> stringList);
	/////////////////////////////
	public List<Integer> getEvenNumbers(List<Integer> numberList);
	public Integer sumOfSquares(List<Integer> numberList);
	public Map<String, Integer> findMinAndMax(List<Integer> numbers);
	Map<String, List<Employee>> groupByDepartment(List<Employee> employees);
	public Integer productOfElements(List<Integer> numberList);
	public List<Integer> transformListofList(List<List<Integer>> listOfNumberLists);
	List<Employee> sortBySalaryDesc(List<Employee> employees);
	public String findFirstStartingWithA(List<String> stringList);
	public List<String> getStreamsOfStrings(List<String> stringList);
	public List<Integer> removeDuplicatesNumbers(List<Integer> numberList);
	

}

