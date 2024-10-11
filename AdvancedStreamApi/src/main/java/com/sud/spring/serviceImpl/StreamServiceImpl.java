package com.sud.spring.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.sud.spring.response.SumResult;
import com.sud.spring.service.StreamService;

@Service
public class StreamServiceImpl implements StreamService {

	@Override
	public SumResult sumofEvenNumberParallel(List<Integer> numberList) {
		Long start = System.currentTimeMillis();
		Integer sum = numberList.parallelStream().filter(i -> i % 2 == 0).reduce(0, (a, b) -> (a + b));
		Long end = System.currentTimeMillis();

		return new SumResult(sum, (end - start));
	}

	@Override
	public SumResult sumofEvenNumberSequentil(List<Integer> numberList) {
		Long start = System.currentTimeMillis();
		Integer sum = numberList.stream().filter(i -> i % 2 == 0).reduce(0, (a, b) -> (a + b));
		Long end = System.currentTimeMillis();

		return new SumResult(sum, (end - start));
	}

	@Override
	public Map<Integer, List<String>> groupByLength(List<String> stringList) {
		return stringList.stream().collect(Collectors.groupingBy(String::length));
	}

	@Override
	public Map<Boolean, List<Integer>> partitioningByEvenOdd(List<Integer> numberList) {
		return numberList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
	}

	@Override
	public String customCollector(List<String> stringList) {
		return stringList.stream().collect(Collectors.joining(","));
	}

	@Override
	public List<Integer> generateListOfMultiples(Integer digit, Integer count) {
		return Stream.iterate(digit, i -> i + digit).limit(count).collect(Collectors.toList());
	}

}
