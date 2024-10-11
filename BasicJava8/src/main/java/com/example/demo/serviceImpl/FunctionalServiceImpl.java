package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.NumberEntity;
import com.example.demo.service.Calculator;
import com.example.demo.service.FunctionalService;

@Service
public class FunctionalServiceImpl implements FunctionalService {

	@Override
	public Integer performCalculation(NumberEntity obj) {
		// TODO Auto-generated method stub
		Calculator add = (a, b) -> a + b;
		Calculator sub = (a, b) -> a - b;
		Calculator mul = (a, b) -> a * b;

		switch (obj.getOperation()) {
		case "add":
			return add.calculate(obj.getNum1(), obj.getNum2());
		case "sub":
			return sub.calculate(obj.getNum1(), obj.getNum2());
		case "mul":
			return mul.calculate(obj.getNum1(), obj.getNum2());
		default:
			return (Integer) null;
		}
	}

	@Override
	public List<Integer> filterEvenNumbers(List<Integer> numberList) {
		Predicate<Integer> isEven = i -> i % 2 == 0;
		return numberList.stream().filter(isEven).collect(Collectors.toList());
	}

	@Override
	public List<Integer> getStringLength(List<String> stringList) {

		Function<String, Integer> getLength = String::length;
		return stringList.stream().map(getLength).collect(Collectors.toList());

	}

	@Override
	public List<String> filterStringList(List<String> stringList) {

		Predicate<String> p1 = i -> !i.isEmpty();
		Predicate<String> p2 = i -> i.length() > 5;
		return stringList.stream().filter(p1.and(p2)).collect(Collectors.toList());
	}

	@Override
	public void doubleNumberList(List<Integer> numberList) {

		numberList.forEach(i -> System.out.println(i * 2)); 
		

	}

	@Override
	public List<Integer> getRandomIntegerList() {
		// TODO Auto-generated method stub
		Supplier<Integer> randomSupplier = () -> new Random().nextInt(100) + 1;
		List<Integer> randomList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			randomList.add(randomSupplier.get());
		}

		return randomList;
	}

	@Override
	public List<String> getSortedStringList(List<String> stringList) {
		return stringList.stream().sorted(String::compareTo).collect(Collectors.toList());

	}
	//////////////////////////////////////////////////

	@Override
	public List<Integer> getEvenNumbers(List<Integer> numberList) {

		return numberList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
	}

	@Override
	public Integer sumOfSquares(List<Integer> numberList) {
		return numberList.stream().map(n -> n * n).reduce(0, (a, b) -> (a + b));

	}

	@Override
	public Map<String, Integer> findMinAndMax(List<Integer> numbers) {

		Integer max = numbers.stream().max(Integer::compare).get();
		Integer min = numbers.stream().min(Integer::compare).get();
		Map<String, Integer> result = new HashMap<>();
		result.put("max", max);
		result.put("min", min);
		return result;
	}

	@Override
	public Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
	}

	@Override
	public Integer productOfElements(List<Integer> numberList) {
		return numberList.stream().reduce(1, (a, b) -> (a * b));

	}

	@Override
	public List<Integer> transformListofList(List<List<Integer>> listOfLists) {
		return listOfLists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
	}

	@Override
	public List<Employee> sortBySalaryDesc(List<Employee> employees) {
		return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public String findFirstStartingWithA(List<String> stringList) {

		return stringList.stream().filter(s -> s.startsWith("A")).findFirst().get();

	}

	@Override
	public List<String> getStreamsOfStrings(List<String> stringList) {
		String[] arr = stringList.toArray(new String[0]); 
		return Stream.of(arr).collect(Collectors.toList());
	}

	@Override
	public List<Integer> removeDuplicatesNumbers(List<Integer> numberList) {
		return numberList.stream().distinct().collect(Collectors.toList());
	}

}

