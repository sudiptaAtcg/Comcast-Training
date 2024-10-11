package com.sud.spring.service;

import java.util.List;
import java.util.Map;

import com.sud.spring.response.SumResult;

public interface StreamService {
	public SumResult sumofEvenNumberParallel(List<Integer> numberList);

	public SumResult sumofEvenNumberSequentil(List<Integer> numberList);

	public Map<Integer, List<String>> groupByLength(List<String> stringList);

	public Map<Boolean, List<Integer>> partitioningByEvenOdd(List<Integer> numberList);

	public String customCollector(List<String> stringList);

	public List<Integer> generateListOfMultiples(Integer digit, Integer count);

}
